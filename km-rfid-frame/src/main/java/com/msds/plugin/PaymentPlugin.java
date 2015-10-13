package com.msds.plugin;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.msds.common.Setting;
import com.msds.plugin.entity.PluginConfigEntity;
import com.msds.plugin.service.PluginConfigAttributeService;
import com.msds.plugin.service.PluginConfigService;
import com.msds.setting.SettingUtils;
import com.msds.util.RedisUtil;

/**
 * Plugin - 支付
 * 
 */
public abstract class PaymentPlugin implements Comparable<PaymentPlugin> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());;

	/** 支付方式名称属性名称 */
	public static final String PAYMENT_NAME_ATTRIBUTE_NAME = "paymentName";

	/** 手续费类型属性名称 */
	public static final String FEE_TYPE_ATTRIBUTE_NAME = "feeType";

	/** 手续费属性名称 */
	public static final String FEE_ATTRIBUTE_NAME = "fee";

	/** LOGO属性名称 */
	public static final String LOGO_ATTRIBUTE_NAME = "logo";

	/** 描述属性名称 */
	public static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

	/**
	 * 手续费类型
	 */
	public enum FeeType {

		/** 按比例收费 */
		scale,

		/** 固定收费 */
		fixed
	}

	/**
	 * 请求方法
	 */
	public enum RequestMethod {

		/** POST */
		post,

		/** GET */
		get
	}

	/**
	 * 通知方法
	 */
	public enum NotifyMethod {

		/** 通用 */
		general,

		/** 同步 */
		sync,

		/** 异步 */
		async
	}

	@Resource(name = "pluginConfigService")
	private PluginConfigService pluginConfigService;
	@Resource(name = "pluginConfigAttributeService")
	private PluginConfigAttributeService pluginConfigAttributeService;

	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public final String getPluginId() {
		return getClass().getAnnotation(Component.class).value();
	}

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	public abstract String getName();

	/**
	 * 获取版本
	 * 
	 * @return 版本
	 */
	public abstract String getVersion();

	/**
	 * 获取作者
	 * 
	 * @return 作者
	 */
	public abstract String getAuthor();

	/**
	 * 获取网址
	 * 
	 * @return 网址
	 */
	public abstract String getSiteUrl();

	/**
	 * 获取安装URL
	 * 
	 * @return 安装URL
	 */
	public abstract String getInstallUrl();

	/**
	 * 获取un安装URL
	 * 
	 * @return un安装URL
	 */
	public abstract String getUninstallUrl();

	/**
	 * 获取设置URL
	 * 
	 * @return 设置URL
	 */
	public abstract String getSettingUrl();

	/**
	 * 获取是否已安装
	 * 
	 * @return 是否已安装
	 */
	public boolean getIsInstalled() {
		return pluginConfigService.pluginIdExists(getPluginId());
	}

	/**
	 * 获取插件配置
	 * 
	 * @return 插件配置
	 */
	public PluginConfig getPluginConfig() {
		String pluginId = getPluginId();
		PluginConfig pluginConfig = null;
		try {
			pluginConfig = RedisUtil.getMapValue("PluginConfig", pluginId);
		} catch (Exception e) {
			logger.error("redis获取PluginConfig缓存异常");
			e.printStackTrace();
		}
		if (pluginConfig != null) {
			return pluginConfig;
		}
		pluginConfig = new PluginConfig();
		PluginConfigEntity pluginConfigEntity = pluginConfigService
				.findByPluginId(pluginId);
		if (pluginConfigEntity == null)
			return null;
		BeanUtils.copyProperties(pluginConfigEntity, pluginConfig);
		Map<String, String> Attribute = pluginConfigAttributeService
				.findMapByPluginConfig(pluginConfig.getId());
		pluginConfig.setAttributes(Attribute);
		RedisUtil.setMapValue("PluginConfig", pluginId, pluginConfig);
		return pluginConfig;
	}

	/**
	 * 获取是否已启用
	 * 
	 * @return 是否已启用
	 */
	public boolean getIsEnabled() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig.getIsEnabled() : false;
	}

	/**
	 * 获取属性值
	 * 
	 * @param name
	 *            属性名称
	 * @return 属性值
	 */
	public String getAttribute(String name) {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig.getAttribute(name) : null;
	}

	/**
	 * 获取排序
	 * 
	 * @return 排序
	 */
	public Integer getOrder() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig.getOrders() : null;
	}

	/**
	 * 获取支付方式名称
	 * 
	 * @return 支付方式名称
	 */
	public String getPaymentName() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig
				.getAttribute(PAYMENT_NAME_ATTRIBUTE_NAME) : null;
	}

	/**
	 * 获取手续费类型
	 * 
	 * @return 手续费类型
	 */
	public FeeType getFeeType() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? FeeType.valueOf(pluginConfig
				.getAttribute(FEE_TYPE_ATTRIBUTE_NAME)) : null;
	}

	/**
	 * 获取手续费
	 * 
	 * @return 手续费
	 */
	public BigDecimal getFee() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? new BigDecimal(
				pluginConfig.getAttribute(FEE_ATTRIBUTE_NAME)) : null;
	}

	/**
	 * 获取LOGO
	 * 
	 * @return LOGO
	 */
	public String getLogo() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig
				.getAttribute(LOGO_ATTRIBUTE_NAME) : null;
	}

	/**
	 * 获取描述
	 * 
	 * @return 描述
	 */
	public String getDescription() {
		PluginConfig pluginConfig = getPluginConfig();
		return pluginConfig != null ? pluginConfig
				.getAttribute(DESCRIPTION_ATTRIBUTE_NAME) : null;
	}

	/**
	 * 获取请求URL
	 * 
	 * @return 请求URL
	 */
	public abstract String getRequestUrl();

	/**
	 * 获取请求方法
	 * 
	 * @return 请求方法
	 */
	public abstract RequestMethod getRequestMethod();

	/**
	 * 获取请求字符编码
	 * 
	 * @return 请求字符编码
	 */
	public abstract String getRequestCharset();

	/**
	 * 获取请求参数
	 * 
	 * @param sn
	 *            编号
	 * @param description
	 *            描述
	 * @param request
	 *            httpServletRequest
	 * @return 请求参数
	 */
	public abstract Map<String, Object> getParameterMap(String sn,
			BigDecimal amountfee, String description, HttpServletRequest request);

	/**
	 * 验证通知是否合法
	 * 
	 * @param sn
	 *            编号
	 * @param notifyMethod
	 *            通知方法
	 * @param request
	 *            httpServletRequest
	 * @return 通知是否合法
	 */
	public abstract boolean verifyNotify(String sn, NotifyMethod notifyMethod,
			HttpServletRequest request);

	/**
	 * 获取通知返回消息
	 * 
	 * @param sn
	 *            编号
	 * @param notifyMethod
	 *            通知方法
	 * @param request
	 *            httpServletRequest
	 * @return 通知返回消息
	 */
	public abstract String getNotifyMessage(String sn,
			NotifyMethod notifyMethod, HttpServletRequest request);

	/**
	 * 获取超时时间
	 * 
	 * @return 超时时间
	 */
	public abstract Integer getTimeout();

	/**
	 * 从HttpServletRequest得到交易的流水单号 不含有流水单号的接口返回订单号
	 * 
	 * @return 交易的流水单号
	 */
	public abstract String getPaymentSerialNumber(HttpServletRequest request);

	/**
	 * 计算支付手续费
	 * 
	 * @param amount
	 *            金额
	 * @return 支付手续费
	 */
	public BigDecimal calculateFee(BigDecimal amount) {
		BigDecimal fee;
		if (getFeeType() == FeeType.scale) {
			fee = amount.multiply(getFee());
		} else {
			fee = getFee();
		}
		return fee.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * 计算支付金额
	 * 
	 * @param amount
	 *            金额
	 * @return 支付金额
	 */
	public BigDecimal calculateAmount(BigDecimal amount) {
		return amount.add(calculateFee(amount)).setScale(2,
				RoundingMode.HALF_UP);
	}

	/**
	 * 获取通知URL
	 * 
	 * @param sn
	 *            编号
	 * @param notifyMethod
	 *            通知方法
	 * @return 通知URL
	 */
	protected String getNotifyUrl(String sn, NotifyMethod notifyMethod) {
		Setting setting = SettingUtils.get();
		if (notifyMethod == null) {
			return setting.getSiteUrl() + "/payment/notify/"
					+ NotifyMethod.general + "/" + sn + ".html";
		}
		return setting.getSiteUrl() + "/payment/notify/" + notifyMethod + "/"
				+ sn + ".html";
	}

	/**
	 * 获取通知URL
	 * 
	 * @param sn
	 *            编号
	 * @param notifyMethod
	 *            通知方法
	 * @param suffix
	 *            后缀扩展名
	 * @return 通知URL
	 */
	protected String getNotifyUrl(String sn, NotifyMethod notifyMethod,
			String suffix) {
		Setting setting = SettingUtils.get();
		if (notifyMethod == null) {
			return setting.getSiteUrl() + "/payment/notify/"
					+ NotifyMethod.general + "/" + sn + suffix;
		}
		return setting.getSiteUrl() + "/payment/notify/" + notifyMethod + "/"
				+ sn + suffix;
	}

	/**
	 * 连接Map键值对
	 * 
	 * @param map
	 *            Map
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @param separator
	 *            连接符
	 * @param ignoreEmptyValue
	 *            忽略空值
	 * @param ignoreKeys
	 *            忽略Key
	 * @return 字符串
	 */
	protected String joinKeyValue(Map<String, Object> map, String prefix,
			String suffix, String separator, boolean ignoreEmptyValue,
			String... ignoreKeys) {
		List<String> list = new ArrayList<String>();
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = ConvertUtils.convert(entry.getValue());
				if (StringUtils.isNotEmpty(key)
						&& !ArrayUtils.contains(ignoreKeys, key)
						&& (!ignoreEmptyValue || StringUtils.isNotEmpty(value))) {
					list.add(key + "=" + (value != null ? value : ""));
				}
			}
		}
		return (prefix != null ? prefix : "")
				+ StringUtils.join(list, separator)
				+ (suffix != null ? suffix : "");
	}

	/**
	 * 连接Map值
	 * 
	 * @param map
	 *            Map
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @param separator
	 *            连接符
	 * @param ignoreEmptyValue
	 *            忽略空值
	 * @param ignoreKeys
	 *            忽略Key
	 * @return 字符串
	 */
	protected String joinValue(Map<String, Object> map, String prefix,
			String suffix, String separator, boolean ignoreEmptyValue,
			String... ignoreKeys) {
		List<String> list = new ArrayList<String>();
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = ConvertUtils.convert(entry.getValue());
				if (StringUtils.isNotEmpty(key)
						&& !ArrayUtils.contains(ignoreKeys, key)
						&& (!ignoreEmptyValue || StringUtils.isNotEmpty(value))) {
					list.add(value != null ? value : "");
				}
			}
		}
		return (prefix != null ? prefix : "")
				+ StringUtils.join(list, separator)
				+ (suffix != null ? suffix : "");
	}

	/**
	 * 支付宝RSA签名串生成 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	protected Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("")
					|| key.equalsIgnoreCase("sign")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 支付宝RSA签名串生成 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	protected String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 *            URL
	 * @param parameterMap
	 *            请求参数
	 * @return 返回结果
	 */
	protected String post(String url, Map<String, Object> parameterMap) {
		Assert.hasText(url);
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			if (parameterMap != null) {
				for (Entry<String, Object> entry : parameterMap.entrySet()) {
					String name = entry.getKey();
					String value = ConvertUtils.convert(entry.getValue());
					if (StringUtils.isNotEmpty(name)) {
						nameValuePairs.add(new BasicNameValuePair(name, value));
					}
				}
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity);
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 *            URL
	 * @param parameterMap
	 *            请求参数
	 * @return 返回结果
	 */
	protected String post(String url, String parameter) {
		Assert.hasText(url);
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);
			if (parameter != null) {
				httpPost.setEntity(new StringEntity(parameter, "UTF-8"));
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity, "UTF-8");
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * GET请求
	 * 
	 * @param url
	 *            URL
	 * @param parameterMap
	 *            请求参数
	 * @return 返回结果
	 */
	protected String get(String url, Map<String, Object> parameterMap) {
		Assert.hasText(url);
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			if (parameterMap != null) {
				for (Entry<String, Object> entry : parameterMap.entrySet()) {
					String name = entry.getKey();
					String value = ConvertUtils.convert(entry.getValue());
					if (StringUtils.isNotEmpty(name)) {
						nameValuePairs.add(new BasicNameValuePair(name, value));
					}
				}
			}
			HttpGet httpGet = new HttpGet(url
					+ (StringUtils.contains(url, "?") ? "&" : "?")
					+ EntityUtils.toString(new UrlEncodedFormEntity(
							nameValuePairs, "UTF-8")));
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpGet.setConfig(requestConfig);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity);
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		PaymentPlugin other = (PaymentPlugin) obj;
		return new EqualsBuilder().append(getPluginId(), other.getPluginId())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getPluginId()).toHashCode();
	}

	public int compareTo(PaymentPlugin paymentPlugin) {
		return new CompareToBuilder()
				.append(getOrder(), paymentPlugin.getOrder())
				.append(getPluginId(), paymentPlugin.getPluginId())
				.toComparison();
	}

}