package com.msds.plugin.bank.alipayBank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.msds.common.Setting;
import com.msds.setting.SettingUtils;
import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;

/**
 * Plugin - 支付宝(纯网关)
 * 
 * @version 3.0
 */
@Component("alipayBankPlugin")
public class AlipayBankPlugin extends PaymentPlugin {

	/** 默认银行 */
	private static final String DEFAULT_BANK = "ICBCB2C";

	/** 银行参数名称 */
	public static final String BANK_PARAMETER_NAME = "bank";

	@Override
	public String getName() {
		return "支付宝(纯网关)";
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
		return "alipay_bank/install.html";
	}

	@Override
	public String getUninstallUrl() {
		return "alipay_bank/uninstall.html";
	}

	@Override
	public String getSettingUrl() {
		return "alipay_bank/setting.html";
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
	public Map<String, Object> getParameterMap(String sn, BigDecimal amount,
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
		String bank = request.getParameter(BANK_PARAMETER_NAME);
		parameterMap.put("defaultbank", StringUtils.isNotEmpty(bank) ? bank
				: DEFAULT_BANK);
		parameterMap.put("seller_id", pluginConfig.getAttribute("partner"));
		parameterMap.put("total_fee", amount.setScale(2, RoundingMode.HALF_UP)
				.toString());
		parameterMap.put("show_url", setting.getSiteUrl());
		parameterMap.put("paymethod", "bankPay");
		parameterMap.put("exter_invoke_ip", request.getLocalAddr());
		parameterMap.put("extra_common_param", "msds_car");
		parameterMap.put("sign", generateSign(parameterMap));
		return parameterMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		// Payment payment = getPayment(sn);
		if (generateSign(request.getParameterMap()).equals(
				request.getParameter("sign"))
				&& pluginConfig.getAttribute("partner").equals(
						request.getParameter("seller_id"))
				&& sn.equals(request.getParameter("out_trade_no"))
				&& ("TRADE_SUCCESS"
						.equals(request.getParameter("trade_status")) || "TRADE_FINISHED"
						.equals(request.getParameter("trade_status")))
		// && payment.getAmount().compareTo(new
		// BigDecimal(request.getParameter("total_fee"))) == 0
		) {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("service", "notify_verify");
			parameterMap.put("partner", pluginConfig.getAttribute("partner"));
			parameterMap.put("notify_id", request.getParameter("notify_id"));
			if ("true".equals(post("https://mapi.alipay.com/gateway.do",
					parameterMap))) {
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
		return DigestUtils.md5Hex(joinKeyValue(new TreeMap<String, Object>(
				parameterMap), null, pluginConfig.getAttribute("key"), "&",
				true, "sign_type", "sign"));
	}

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		return request.getParameter("trade_no");
	}

}