package com.msds.plugin.bank.unionpay;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.msds.common.Setting;
import com.msds.setting.SettingUtils;
import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;

/**
 * Plugin - 银联在线支付
 * 
 * @version 3.0
 */
@Component("unionpayPlugin")
public class UnionpayPlugin extends PaymentPlugin {

	/** 货币 */
	private static final String CURRENCY = "156";

	@Override
	public String getName() {
		return "银联在线支付";
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
		return "unionpay/install.html";
	}

	@Override
	public String getUninstallUrl() {
		return "unionpay/uninstall.html";
	}

	@Override
	public String getSettingUrl() {
		return "unionpay/setting.html";
	}

	@Override
	public String getRequestUrl() {
		return "https://unionpaysecure.com/api/Pay.action";
//		return "http://202.101.25.184/UpopWeb/api/Pay.action";
	}

	@Override
	public RequestMethod getRequestMethod() {
		return RequestMethod.post;
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
		parameterMap.put("version", "1.0.0");
		parameterMap.put("charset", "UTF-8");
		parameterMap.put("transType", "01");
		parameterMap.put("origQid", "");
		parameterMap.put("merId", pluginConfig.getAttribute("partner"));
		parameterMap.put(
				"merAbbr",
				StringUtils.abbreviate(
						setting.getSiteName().replaceAll(
								"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 40));
		parameterMap.put("acqCode", "");
		parameterMap.put("merCode", "");
		parameterMap.put("commodityUrl", setting.getSiteUrl());
		parameterMap.put("commodityName",
				StringUtils.abbreviate(description.replaceAll(
						"[^0-9a-zA-Z\\u4e00-\\u9fa5 ]", ""), 200));
		parameterMap.put("commodityUnitPrice", "");
		parameterMap.put("commodityQuantity", "");
		parameterMap.put("commodityDiscount", "");
		parameterMap.put("transferFee", "");
		parameterMap.put("orderNumber", sn);
		parameterMap.put("orderAmount", amount.multiply(new BigDecimal(100))
				.setScale(0).toString());
		parameterMap.put("orderCurrency", CURRENCY);
		parameterMap.put("orderTime",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		parameterMap.put("customerIp", request.getLocalAddr());
		parameterMap.put("customerName", "");
		parameterMap.put("defaultPayType", "");
		parameterMap.put("defaultBankNumber", "");
		parameterMap.put("transTimeout", getTimeout() * 60000);
		parameterMap.put("frontEndUrl", getNotifyUrl(sn, NotifyMethod.sync));
		parameterMap.put("backEndUrl", getNotifyUrl(sn, NotifyMethod.async));
		parameterMap.put("merReserved", "");
		parameterMap.put("signMethod", "MD5");
		parameterMap.put("signature", generateSign(parameterMap));
		return parameterMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		// Payment payment = getPayment(sn);
		if (generateSign(request.getParameterMap()).equals(
				request.getParameter("signature"))
				&& pluginConfig.getAttribute("partner").equals(
						request.getParameter("merId"))
				&& sn.equals(request.getParameter("orderNumber"))
				&& CURRENCY.equals(request.getParameter("orderCurrency"))
				&& "00".equals(request.getParameter("respCode"))
		// && payment.getAmount().multiply(new BigDecimal(100)).compareTo(new
		// BigDecimal(request.getParameter("orderAmount"))) == 0
		) {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("version", "1.0.0");
			parameterMap.put("charset", "UTF-8");
			parameterMap.put("transType", "01");
			parameterMap.put("merId", pluginConfig.getAttribute("partner"));
			parameterMap.put("orderNumber", sn);
			parameterMap.put("orderTime",
					new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			parameterMap.put("merReserved", "");
			parameterMap.put("signMethod", "MD5");
			parameterMap.put("signature", generateSign(parameterMap));
//			String result = post("http://202.101.25.184/UpopWeb/api/Query.action",
			String result = post("https://query.unionpaysecure.com/api/Query.action",
					parameterMap);
			if (ArrayUtils.contains(result.split("&"), "respCode=00")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getNotifyMessage(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
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
				parameterMap), null,
				"&" + DigestUtils.md5Hex(pluginConfig.getAttribute("key")),
				"&", false, "signMethod", "signature"));
	}

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		return request.getParameter("qid");
	}
}