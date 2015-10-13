package com.msds.plugin.bank.alipayAppDirect;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;
import com.msds.util.AliRSA;
import com.msds.util.TimeCompareUtil;

/**
 * 支付宝App
 * 
 * @ClassName AlipayAppDirectPlugin
 * @Description TODO
 * @author LiLong
 * @date 2015年07月21日09:58:36
 * 
 */
@Component("alipayAppDirectPlugin")
public class AlipayAppDirectPlugin extends PaymentPlugin {

	@Override
	public String getName() {
		return "支付宝App";
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
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		// PluginConfig pluginConfig = getPluginConfig();

		// parameterMap.put("service", "mobile.securitypay.pay");
		// parameterMap.put("partner", pluginConfig.getAttribute("partner"));
		// parameterMap.put("_input_charset", "utf-8");
		// parameterMap.put("sign_type", "MD5");
		parameterMap.put("notify_url",
				getNotifyUrl(sn, NotifyMethod.async, ".itf"));
		parameterMap.put("out_trade_no", sn);
		parameterMap
				.put("subject", StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 60));
		parameterMap.put("body",
				StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 600));
		// parameterMap.put("payment_type", "1");
		// parameterMap.put("it_b_pay", "30m");
		// parameterMap.put("seller_id", pluginConfig.getAttribute("partner"));
		parameterMap.put("total_fee",
				amountfee.setScale(2, RoundingMode.HALF_UP).toString());
		parameterMap.put("sign", generateMD5Sign(parameterMap));

		return parameterMap;
	}

	@Override
	public boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		if (verifySign(request.getParameterMap())) {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("service", "notify_verify");
			parameterMap.put("partner", pluginConfig.getAttribute("partner"));
			parameterMap.put("notify_id", request.getParameter("notify_id"));

			logger.warn("AliPayVerifyNotify" + "|sn:" + sn + "去验证   "
					+ TimeCompareUtil.GetSysLongTime());
			String resultmessage = post("https://mapi.alipay.com/gateway.do",
					parameterMap);
			logger.warn("AliPayVerifyNotify" + "|sn:" + sn + "验证回来   "
					+ TimeCompareUtil.GetSysLongTime());
			if ("true".equals(resultmessage)) {
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

	private Boolean verifySign(Map<String, ?> parameterMap) {
		PluginConfig pluginConfig = getPluginConfig();
		String str = joinKeyValue(new TreeMap<String, Object>(parameterMap),
				null, null, "&", true, "sign_type", "sign");

		return AliRSA.verify(str, String.valueOf(parameterMap.get("sign")),
				pluginConfig.getAttribute("key"), getRequestCharset());
	}

	private String generateSign(Map<String, ?> parameterMap) {
		PluginConfig pluginConfig = getPluginConfig();
		String str = joinKeyValue(new TreeMap<String, Object>(parameterMap),
				null, null, "&", true, "sign_type", "sign");
		return AliRSA.sign(str, pluginConfig.getAttribute("privateKey"),
				getRequestCharset());
	}

	private String generateMD5Sign(Map<String, ?> parameterMap) {
		PluginConfig pluginConfig = getPluginConfig();
		String str = DigestUtils.md5Hex(
				joinKeyValue(new TreeMap<String, Object>(parameterMap), null,
						"&key=" + pluginConfig.getAttribute("privateKey"), "&",
						true, "sign_type", "sign")).toUpperCase();
		return str;
	}

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		return request.getParameter("trade_no");
	}

}