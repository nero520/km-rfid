package com.msds.plugin.bank.weixinPay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;
import com.msds.util.JsonUtils;
import com.msds.util.XMLUtils;

/**
 * 微信支付
 * 
 * @ClassName WeiXinPayPlugin
 * @Description TODO
 * @author LiLong
 * @date 2015年06月23日 下午13:17:27
 * 
 */
@Component("weiXinPayPlugin")
public class WeiXinPayPlugin extends PaymentPlugin {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/** 统一下单 */
	private static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/** 授权 */
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

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
		return "MSDS";
	}

	@Override
	public String getSiteUrl() {
		return "http://www.minshengec.com";
	}

	@Override
	public String getInstallUrl() {
		return "alipay_wap_direct/install.html";
	}

	@Override
	public String getUninstallUrl() {
		return "alipay_wap_direct/uninstall.html";
	}

	@Override
	public String getSettingUrl() {
		return "alipay_wap_direct/setting.html";
	}

	@Override
	public String getRequestUrl() {
		return "http://mclient.alipay.com/service/rest.htm";
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

		String code = request.getParameter("code");
		logger.info("微信code:{}", code);
		if (StringUtils.isNotBlank(code)) {
			// 授权
			String openId = this.authorize(code, pluginConfig);
			// openId = "onGjcs-wk7WI-DwfnygJPvjkCWh0";
			if (StringUtils.isNotBlank(openId)) {
				// 统一支付
				String prepayId = this.unifiedOrder(sn, amountfee, description,
						pluginConfig, openId);
				return this.getParameters(pluginConfig, prepayId);
			}
		}
		return null;
	}

	private String authorize(String code, PluginConfig pluginConfig) {

		Map<String, Object> sParaTemp = new HashMap<String, Object>();
		sParaTemp.put("appid", pluginConfig.getAttribute("appid"));
		sParaTemp.put("secret", pluginConfig.getAttribute("secret"));
		sParaTemp.put("code", code);
		sParaTemp.put("grant_type", "authorization_code");
		String ret = get(ACCESS_TOKEN_URL, sParaTemp);
		logger.info("授权返回报文:{}", ret);
		if (StringUtils.isNotBlank(ret)) {
			Map<String, String> map = JsonUtils.toObject(ret, Map.class);
			if (map != null) {
				return map.get("openid");
			}
		}
		return null;
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
			String description, PluginConfig pluginConfig, String openid) {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("appid", pluginConfig.getAttribute("appid"));
		parameterMap.put("mch_id", pluginConfig.getAttribute("mch_id"));
		// parameterMap.put("spbill_create_ip", "14.23.150.211");
		parameterMap.put("nonce_str", createNoncestr());

		parameterMap.put("openid", openid);
		parameterMap
				.put("body", StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 32));
		parameterMap.put("out_trade_no", sn);// 商户订单号
		parameterMap.put("total_fee", amountfee.multiply(new BigDecimal(100))
				.setScale(0, BigDecimal.ROUND_HALF_UP).toString());// 总金额
		parameterMap.put("notify_url",
				getNotifyUrl(sn, NotifyMethod.async, ".itf"));// 通知地址
		parameterMap.put("trade_type", "JSAPI");// 交易类型

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
		parameterMap.put("appId", pluginConfig.getAttribute("appid"));
		parameterMap.put("timeStamp", String.valueOf(new Date().getTime()));
		parameterMap.put("nonceStr", this.createNoncestr());
		parameterMap.put("package", "prepay_id=" + prepayId);
		parameterMap.put("signType", "MD5");
		parameterMap.put("paySign", generateSign(parameterMap));
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