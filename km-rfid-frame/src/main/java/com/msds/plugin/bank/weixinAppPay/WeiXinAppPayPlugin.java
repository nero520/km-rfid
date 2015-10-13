package com.msds.plugin.bank.weixinAppPay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.springframework.stereotype.Component;

import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;
import com.msds.util.XMLUtils;

/**
 * 微信支付
 * 
 * @ClassName WeiXinAppPayPlugin
 * @Description TODO
 * @author LiLong
 * @date 2015年07月16日 下午13:17:27
 * 
 */
@Component("weiXinAppPayPlugin")
public class WeiXinAppPayPlugin extends PaymentPlugin {

	/** 统一下单 */
	private static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	@Override
	public String getName() {
		return "微信支付";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getAuthor() {
		return "km";
	}

	@Override
	public String getSiteUrl() {
		return "";
	}

	@Override
	public String getInstallUrl() {
		return "";
	}

	@Override
	public String getUninstallUrl() {
		return "";
	}

	@Override
	public String getSettingUrl() {
		return "";
	}

	@Override
	public String getRequestUrl() {
		return "";
	}

	@Override
	public RequestMethod getRequestMethod() {
		return RequestMethod.get;
	}

	@Override
	public String getRequestCharset() {
		return "UTF-8";
	}

	@Override
	public Map<String, Object> getParameterMap(String sn, BigDecimal amountfee,
			String description, HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();

		// 统一支付
		String prepayId = this.unifiedOrder(sn, amountfee, description,
				pluginConfig);
		return prepayId != null ? this.getParameters(pluginConfig, prepayId)
				: null;
	}

	@Override
	public boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		String xml = null;
		try {
			xml = readStreamParameter(request.getInputStream());
			logger.info("支付回调报文:{}", xml);
		} catch (IOException e) {
			logger.error("支付回调报文获取错误,{}", sn);
			e.printStackTrace();
		}
		if (StringUtils.isNotBlank(xml)) {
			Map<String, String> map = XMLUtils.toObject(xml, Map.class);
			if (map != null && generateSign(map).equals(map.get("sign"))) {
				request.setAttribute("transaction_id",
						map.get("transaction_id"));
				return true;
			}
		}
		return false;
	}

	public String readStreamParameter(ServletInputStream in) {
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}

	@Override
	public String getNotifyMessage(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		if (notifyMethod == NotifyMethod.async) {
			return "success";
		}
		return null;
	}

	@Override
	public Integer getTimeout() {
		return 21600;
	}

	/**
	 * 生成签名
	 * 
	 * @param parameterMap
	 *            参数
	 * @return 签名
	 */
	private String generateSign(Map<String, ?> parameterMap) {
		PluginConfig pluginConfig = getPluginConfig();
		String str = DigestUtils.md5Hex(
				joinKeyValue(new TreeMap<String, Object>(parameterMap), null,
						"&key=" + pluginConfig.getAttribute("key"), "&", true,
						"sign_type", "sign")).toUpperCase();
		return str;
	}

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		return (String) request.getAttribute("transaction_id");
	}

	/**
	 * 解析远程提交后返回的信息，获得prepayId
	 * 
	 * @param text
	 *            要解析的字符串
	 * @return 解析结果
	 * @throws Exception
	 */
	private String getPrepayId(String text) throws Exception {
		String prepayId = null;
		if (text != null) {
			Document document = DocumentHelper.parseText(text);
			Node node = document.selectSingleNode("//xml/prepay_id");
			if (node != null) {
				prepayId = node.getText();
			}
		}
		return prepayId;
	}

	private String unifiedOrder(String sn, BigDecimal amountfee,
			String description, PluginConfig pluginConfig) {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("appid", pluginConfig.getAttribute("appid"));
		parameterMap.put("mch_id", pluginConfig.getAttribute("mch_id"));
		// parameterMap.put("spbill_create_ip", "14.23.150.211");
		parameterMap.put("nonce_str", createNoncestr());

		// parameterMap.put("openid", openid);
		parameterMap
				.put("body", StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 32));
		parameterMap.put("out_trade_no", sn);// 商户订单号
		parameterMap.put("total_fee", amountfee.multiply(new BigDecimal(100))
				.setScale(0, BigDecimal.ROUND_HALF_UP).toString());// 总金额
		parameterMap.put("notify_url",
				getNotifyUrl(sn, NotifyMethod.async, ".itf"));// 通知地址
		parameterMap.put("trade_type", "APP");// 交易类型

		parameterMap.put("sign", generateSign(parameterMap));
		String prepayId = null;
		try {
			String xml = mapToXml(parameterMap);
			logger.info("统一下单发送报文:{}", xml);
			String ret = post(UNIFIED_ORDER_URL, xml);
			logger.info("统一下单返回报文:{}", ret);
			prepayId = this.getPrepayId(ret);
		} catch (Exception e) {
			logger.error("微信统一下单失败,sn:{}", sn);
			e.printStackTrace();
		}
		return prepayId;
	}

	/**
	 * 作用：map转xml
	 */
	private String mapToXml(Map<String, String> map) {
		StringBuffer sb = new StringBuffer(512);
		sb.append("<xml>");
		for (Entry<String, String> entry : map.entrySet()) {
			if (true) {// TODO 偷个懒，先这样
				sb.append("<");
				sb.append(entry.getKey());
				sb.append(">");
				sb.append(entry.getValue());
				sb.append("</");
				sb.append(entry.getKey());
				sb.append(">");

			} else {
				// $xml.="<".$key."><![CDATA[".$val."]]></".$key.">";
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 作用：设置jsapi的参数
	 */
	public Map<String, Object> getParameters(PluginConfig pluginConfig,
			String prepayId) {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("appid", pluginConfig.getAttribute("appid"));
		parameterMap.put("noncestr", this.createNoncestr());
		parameterMap.put("package", "Sign=WXPay");
		parameterMap.put("partnerid", pluginConfig.getAttribute("mch_id"));
		parameterMap.put("prepayid", prepayId);
		// parameterMap.put("timestamp", String.valueOf(new Date().getTime()));
		parameterMap.put("timestamp", System.currentTimeMillis() / 1000);
		parameterMap.put("sign", generateSign(parameterMap));
		return parameterMap;
	}

	/**
	 * 临时先这样取吧。。。
	 * 
	 * @return
	 */
	private String createNoncestr() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}