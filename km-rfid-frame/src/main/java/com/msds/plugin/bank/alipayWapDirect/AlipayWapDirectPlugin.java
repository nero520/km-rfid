package com.msds.plugin.bank.alipayWapDirect;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.msds.common.Setting;
import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;
import com.msds.setting.SettingUtils;
import com.msds.util.TimeCompareUtil;

/**
 * 支付宝手机即时交易
 * 
 * @ClassName AlipayWapDirectPlugin
 * @Description TODO
 * @author LiLong
 * @date 2015年5月20日 下午3:19:00
 * 
 */
@Component("alipayWapDirectPlugin")
public class AlipayWapDirectPlugin extends PaymentPlugin {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String getName() {
		return "支付宝手机(即时交易)";
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
		Setting setting = SettingUtils.get();
		PluginConfig pluginConfig = getPluginConfig();
		// 授权
		String requestToken = this.authorization(sn, amountfee, description,
				pluginConfig, setting);
		if (requestToken == null)
			return null;
		// 支付
		Map<String, Object> sParaTemp = new HashMap<String, Object>();
		sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
		sParaTemp.put("partner", pluginConfig.getAttribute("partner"));
		sParaTemp.put("_input_charset", "utf-8");
		sParaTemp.put("sec_id", "MD5");
		sParaTemp.put("format", "xml");
		sParaTemp.put("v", "2.0");
		StringBuffer sbt = new StringBuffer(128);
		sbt.append("<auth_and_execute_req><request_token>");
		sbt.append(requestToken);
		sbt.append("</request_token></auth_and_execute_req>");
		sParaTemp.put("req_data", sbt.toString());
		sParaTemp.put("sign", generateSign(sParaTemp));
		return sParaTemp;
	}

	@Override
	public boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		// Payment payment = getPayment(sn);
		// if
		// (generateSign(request.getParameterMap()).equals(request.getParameter("sign"))
		// &&
		// pluginConfig.getAttribute("partner").equals(request.getParameter("seller_id"))
		// && sn.equals(request.getParameter("out_trade_no")) &&
		// ("TRADE_SUCCESS".equals(request.getParameter("trade_status")) ||
		// "TRADE_FINISHED".equals(request.getParameter("trade_status")))
		// && payment.getAmount().compareTo(new
		// BigDecimal(request.getParameter("total_fee"))) == 0) {
		if (notifyMethod == NotifyMethod.async) {
			if (generateSignNoSort(request)
					.equals(request.getParameter("sign"))) {
				String notify_id = null;
				try {
					Document document = DocumentHelper.parseText(request
							.getParameter("notify_data"));
					notify_id = document.selectSingleNode("//notify/notify_id")
							.getText();
				} catch (DocumentException e) {
					logger.error("解析支付宝回调失败,sn:{}", sn);
					e.printStackTrace();
					return false;
				}

				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("service", "notify_verify");
				parameterMap.put("partner",
						pluginConfig.getAttribute("partner"));
				parameterMap.put("notify_id", notify_id);
				logger.warn("AliPayVerifyNotify" + "|sn:" + sn + "去验证   "
						+ TimeCompareUtil.GetSysLongTime());
				String resultmessage = post(
						"https://mapi.alipay.com/gateway.do", parameterMap);
				logger.warn("AliPayVerifyNotify" + "|sn:" + sn + "验证回来   "
						+ TimeCompareUtil.GetSysLongTime());

				if ("true".equals(resultmessage)) {
					return true;
				}
			}
		} else if (notifyMethod == NotifyMethod.sync) {
			if (generateSign(request.getParameterMap()).equals(
					request.getParameter("sign"))) {
				return true;
			}
		}
		return false;
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
		String str = DigestUtils.md5Hex(joinKeyValue(
				new TreeMap<String, Object>(parameterMap), null,
				pluginConfig.getAttribute("key"), "&", true, "sign_type",
				"sign"));
		return str;
	}

	/**
	 * 生成签名(不排序)
	 * 
	 * @param request
	 *            参数
	 * @return 签名
	 */
	private String generateSignNoSort(HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		StringBuffer signParams = new StringBuffer();
		signParams.append("service=" + request.getParameter("service"));
		signParams.append("&v=" + request.getParameter("v"));
		signParams.append("&sec_id=" + request.getParameter("sec_id"));
		signParams
				.append("&notify_data=" + request.getParameter("notify_data"));
		signParams.append(pluginConfig.getAttribute("key"));
		return DigestUtils.md5Hex(signParams.toString());
	}

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		String trade_no = null;
		try {
			Document document = DocumentHelper.parseText(request
					.getParameter("notify_data"));
			trade_no = document.selectSingleNode("//notify/trade_no").getText();
		} catch (DocumentException e) {
			logger.error("支付回调解析XML失败。");
			e.printStackTrace();
		}
		return trade_no;
	}

	/**
	 * 解析远程模拟提交后返回的信息，获得token
	 * 
	 * @param text
	 *            要解析的字符串
	 * @return 解析结果
	 * @throws Exception
	 */
	private String getRequestToken(String text) throws Exception {
		String request_token = "";
		// 以“&”字符切割字符串
		String[] strSplitText = text.split("&");
		// 把切割后的字符串数组变成变量与数值组合的字典数组
		Map<String, String> paraText = new HashMap<String, String>();
		for (int i = 0; i < strSplitText.length; i++) {
			// 获得第一个=字符的位置
			int nPos = strSplitText[i].indexOf("=");
			// 获得字符串长度
			int nLen = strSplitText[i].length();
			// 获得变量名
			String strKey = strSplitText[i].substring(0, nPos);
			// 获得数值
			String strValue = strSplitText[i].substring(nPos + 1, nLen);
			// 放入MAP类中
			paraText.put(strKey, strValue);
		}

		if (paraText.get("res_data") != null) {
			String res_data = paraText.get("res_data");
			// 解析加密部分字符串（RSA与MD5区别仅此一句）
			// token从res_data中解析出来（也就是说res_data中已经包含token的内容）
			Document document = DocumentHelper.parseText(res_data);
			request_token = document.selectSingleNode(
					"//direct_trade_create_res/request_token").getText();
		}
		return request_token;
	}

	private String authorization(String sn, BigDecimal amountfee,
			String description, PluginConfig pluginConfig, Setting setting) {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("service", "alipay.wap.trade.create.direct");
		parameterMap.put("partner", pluginConfig.getAttribute("partner"));
		parameterMap.put("_input_charset", "utf-8");
		parameterMap.put("sec_id", "MD5");
		parameterMap.put("format", "xml");
		parameterMap.put("v", "2.0");
		parameterMap.put("req_id", sn);
		StringBuffer sb = new StringBuffer(512);
		sb.append("<direct_trade_create_req><notify_url>");
		sb.append(getNotifyUrl(sn, NotifyMethod.async, ".itf"));
		sb.append("</notify_url><call_back_url>");
		sb.append(getNotifyUrl(sn, NotifyMethod.sync, ".itf"));
		sb.append("</call_back_url><seller_account_name>");
		sb.append(pluginConfig.getAttribute("sellerEmail"));
		sb.append("</seller_account_name><out_trade_no>");
		sb.append(sn);
		sb.append("</out_trade_no><subject>");
		sb.append(StringUtils.abbreviate(
				description.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 60));
		sb.append("</subject><total_fee>");
		sb.append(amountfee.setScale(2, RoundingMode.HALF_UP).toString());
		sb.append("</total_fee><merchant_url>");
		sb.append(setting.getPayErrorUrl());
		sb.append("</merchant_url></direct_trade_create_req>");
		parameterMap.put("req_data", sb.toString());
		parameterMap.put("sign", generateSign(parameterMap));
		String requestToken = null;
		try {
			String retHtml = post(this.getRequestUrl(), parameterMap);
			retHtml = URLDecoder.decode(retHtml, "utf-8");
			requestToken = getRequestToken(retHtml);
		} catch (Exception e) {
			logger.error("支付宝授权失败,sn:{}", sn);
			e.printStackTrace();
		}
		return requestToken;
	}

}