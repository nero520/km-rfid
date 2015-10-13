package com.msds.plugin.bank.gdbBank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import com.msds.plugin.PaymentPlugin;
import com.msds.plugin.PluginConfig;

/**
 * Plugin - 广东发展银行网关支付
 * 
 * @author msdzsw.com
 * @version 3.0
 */
@Component("gdbBankPlugin")
public class GDBBankPlugin extends PaymentPlugin {

	/** logger */
	private static final Logger logger = Logger.getLogger(GDBBankPlugin.class
			.getName());

	@Override
	public String getName() {
		return "广东发展银行支付";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getAuthor() {
		return "msdzsw.com";
	}

	@Override
	public String getSiteUrl() {
		return "http://umbpay.com";
	}

	@Override
	public String getInstallUrl() {
		return "gdbBank/install.html";
	}

	@Override
	public String getUninstallUrl() {
		return "gdbBank/uninstall.html";
	}

	@Override
	public String getSettingUrl() {
		return "gdbBank/setting.html";
	}

	@Override
	public String getRequestUrl() {
		return "https://www.umbpay.com/pay2_1_/paymentImplAction.do";
	}

	@Override
	public RequestMethod getRequestMethod() {
		return RequestMethod.post;
	}

	@Override
	public String getRequestCharset() {
		return "UTF-8";
	}

	/**
	 * 支付时需要配置的表单内容
	 */
	@Override
	public Map<String, Object> getParameterMap(String sn, BigDecimal amount,
			String description, HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		String merchantid = pluginConfig.getAttribute("partner");// 商户编号
		String merorderid = sn;// 订单编号
		String amountsum = amount.setScale(2, RoundingMode.HALF_UP).toString();// 订单金额（单位：元）
		String subject = "empty";// 商品分类 "1092001"
		String currencytype = "01";// 币种,01人民币
		String autojump = "1";// 银行付款成功后是否自动跳转到取货页面：0→不跳转；1→跳转
		String waittime = "5";// 跳转到取货页面的等待时间，以秒为单位，默认5秒
		String merurl = getNotifyUrl(sn, NotifyMethod.sync);// 取货URL
		String informmer = "1";// 将订单的状态通知给商户的URL：0→不通知；1→通知
		String informurl = getNotifyUrl(sn, NotifyMethod.async);// 服务器消息通知URL
		String confirm = "0";// 商户是否响应平台的确认信息：0→不返回；1→返回
		String merbank = "GDB";// 商户端所选支付银行当bankInput为0时，此字段只能为empty,在宝易互通上选择支付银行
		String tradetype = "0";// 交易类型： 0→即时到账；1→担保交易
		String bankinput = "1";// 0→其他；1→在商户端选择银行
		String interFace = "2.00";// 接口版本号，默认填写2.00

		// 生成签名
		Map<String, Object> signMap = new LinkedHashMap<String, Object>();
		signMap.put("merchantid", merchantid);
		signMap.put("merorderid", merorderid);
		signMap.put("amountsum", amountsum);
		signMap.put("subject", subject);
		signMap.put("currencytype", currencytype);
		signMap.put("autojump", autojump);
		signMap.put("waittime", waittime);
		signMap.put("merurl", merurl);
		signMap.put("informmer", informmer);
		signMap.put("informurl", informurl);
		signMap.put("confirm", confirm);
		signMap.put("merbank", merbank);
		signMap.put("tradetype", tradetype);
		signMap.put("bankInput", bankinput);
		signMap.put("interface", interFace);
		signMap.put("remark", "");
		signMap.put("mac", generateSign(signMap));

		return signMap;
	}

	@Override
	public boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request) {
		PluginConfig pluginConfig = getPluginConfig();
		// Payment payment = getPayment(sn);

		String merchantid = request.getParameter("merchantid");// 商务编号
		String merorderid = request.getParameter("merorderid");// 订单编号
		String amountsum = request.getParameter("amountsum");// 订单金额
		String currencytype = request.getParameter("currencytype");// 币种
		String subject = request.getParameter("subject");// 商品种类
		String state = request.getParameter("state");// 支付状态
		String paybank = request.getParameter("paybank");
		String banksendtime = request.getParameter("banksendtime");
		String merrecvtime = request.getParameter("merrecvtime");
		String interFace = request.getParameter("interface");
		String mac = request.getParameter("mac");// 商户签名

		Map<String, String> parameterMap = new LinkedHashMap<String, String>();
		parameterMap.put("merchantid", merchantid);
		parameterMap.put("merorderid", merorderid);
		parameterMap.put("amountsum", amountsum);
		parameterMap.put("currencytype", currencytype);
		parameterMap.put("subject", subject);
		parameterMap.put("state", state);
		parameterMap.put("paybank", paybank);
		parameterMap.put("banksendtime", banksendtime);
		parameterMap.put("merrecvtime", merrecvtime);
		parameterMap.put("interface", interFace);
		String checkMac = generateSign(parameterMap);
		boolean flag = false;
		// if (pluginConfig.getAttribute("partner").equals(merchantid) &&
		// sn.equals(merorderid)
		// && payment.getAmount().setScale(2).toString().equals(amountsum) &&
		// "01".equals(currencytype)
		// && "1".equals(state) && "2.00".equals(interFace) &&
		// checkMac.equals(mac)) {
		// flag=true;
		// }
		if (checkMac.toLowerCase().equals(mac.toLowerCase())
				&& state.equals("1")) {
			flag = true;
		}

		logger.warning("广东发展银行网关支付保卫互通数据：" + mac + "," + merchantid.toString()
				+ "," + merorderid.toString() + "," + amountsum + ","
				+ currencytype + "," + state.toString() + "," + interFace);
		logger.warning("广东发展银行网关支付数据：" + checkMac + ","
				+ pluginConfig.getAttribute("partner").toString() + "," + sn
				+ ",2,01,1,2.00");

		return flag;
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
		String str = joinKeyValue(new LinkedHashMap<String, Object>(
				parameterMap), null,
				"&merkey=" + pluginConfig.getAttribute("key"), "&", false,
				"remark");
		logger.warning(str);
		return DigestUtils.md5Hex(str);
	}

	@Override
	public String getPaymentSerialNumber(HttpServletRequest request) {
		return request.getParameter("merorderid");
	}
}