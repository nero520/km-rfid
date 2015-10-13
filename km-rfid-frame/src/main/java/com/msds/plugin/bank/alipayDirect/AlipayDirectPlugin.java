package com.msds.plugin.bank.alipayDirect;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.msds.common.Setting;
import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;
import com.msds.setting.SettingUtils;
import com.msds.util.TimeCompareUtil;

/**
 * Plugin - 支付宝(即时交易)
 * 
 * @version 3.0
 */
@Component("alipayDirectPlugin")
public class AlipayDirectPlugin extends PaymentPlugin {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String getName() {
		return "支付宝(即时交易)";
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
		return "alipay_direct/install.html";
	}

	@Override
	public String getUninstallUrl() {
		return "alipay_direct/uninstall.html";
	}

	@Override
	public String getSettingUrl() {
		return "alipay_direct/setting.html";
	}

	@Override
	public String getRequestUrl() {
		return "https://mapi.alipay.com/gateway.do";
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
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("service", "create_direct_pay_by_user");
		parameterMap.put("partner", pluginConfig.getAttribute("partner"));
		parameterMap.put("_input_charset", "utf-8");
		parameterMap.put("sign_type", "MD5");
		parameterMap.put("return_url", getNotifyUrl(sn, NotifyMethod.sync));
		parameterMap.put("notify_url", getNotifyUrl(sn, NotifyMethod.async));
		parameterMap.put("out_trade_no", sn);
		parameterMap
				.put("subject", StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 60));
		parameterMap.put("body",
				StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 600));
		parameterMap.put("payment_type", "1");
		parameterMap.put("seller_id", pluginConfig.getAttribute("partner"));
		parameterMap.put("total_fee",
				amountfee.setScale(2, RoundingMode.HALF_UP).toString());
		parameterMap.put("show_url", setting.getSiteUrl());
		parameterMap.put("paymethod", "directPay");
		parameterMap.put("exter_invoke_ip", request.getLocalAddr());
		// parameterMap.put("exter_invoke_ip", "");
		parameterMap.put("extra_common_param", "msds_car");
		parameterMap.put("sign", generateSign(parameterMap));
		return parameterMap;
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
		if (generateSign(request.getParameterMap()).equals(
				request.getParameter("sign"))) {
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

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		return request.getParameter("trade_no");
	}

}