package com.msds.open.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.msds.km.vo.Product;
import com.msds.open.api.vo.CartItem;
import com.msds.open.api.vo.OrderRequest;
import com.msds.open.api.vo.OrderResponse;
import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;
import com.msds.util.JsonUtils;

@Service("openApiService")
public class OpenApiService {

	private static final Logger logger = LoggerFactory
			.getLogger(OpenApiService.class);
	@Value("${open.api.url}")
	private String url = "http://123.57.40.158:8080/open_web/router";
	@Value("${open.api.appKey}")
	private String appKey = "2";
	@Value("${open.api.appSecret}")
	private String appSecret = "A40396795474F62B6A2337FC07BD27FF";
	@Value("${open.api.v}")
	private String v = "1.0";

	public String addOrder(String customerId, List<Product> productList,
			String receiverId) throws OpenApiException {
		Map<String, String> params = new LinkedHashMap<String, String>();
		String method = "msds.order.add";

		OrderRequest order = new OrderRequest();

		List<CartItem> cartItems = new ArrayList<CartItem>();
		for (Product product : productList) {
			CartItem cartItem = new CartItem();
			cartItem.setProductId(product.getProductId());
			cartItem.setQuantity(product.getQuantity());
			cartItems.add(cartItem);
		}

		order.setCustomerId(customerId);
		order.setCartItems(cartItems);
		order.setReceiverId(receiverId);

		String request = JsonUtils.toJson(order);
		params.put("params", request);
		logger.info("接口参数:{}", request);
		String response = null;
		try {
			response = send(method, params);
		} catch (Exception e) {
			logger.error("open api 接口发送出错!");
			e.printStackTrace();
			throw new OpenApiException("open api 接口发送出错!");
		}
		logger.info("响应:{}", response);
		OrderResponse orderResponse = JsonUtils.toObject(response,
				OrderResponse.class);
		if ("0".equals(orderResponse.getCode())) {
			if (orderResponse.getDetail() != null) {
				return orderResponse.getDetail().getOrderSn();
			}
		}
		throw new OpenApiException(orderResponse.getMessage());
	}

	/**
	 * 统一发送
	 * 
	 * @Description TODO
	 * @param method
	 * @param params
	 * @throws Exception
	 * @return void
	 */
	private String send(String method, Map<String, String> params)
			throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("method", method);
		form.add("appKey", appKey);
		form.add("v", v);
		form.add("format", "json");
		form.add("timestamp", DateUtils.DateToString(new Date(),
				DateStyle.YYYY_MM_DD_HH_MM_SS));

		for (String key : params.keySet()) {
			form.add(key, params.get(key));
		}

		String sign = RopUtils.sign(form.toSingleValueMap(), appSecret);
		form.add("sign", sign);
		// Set<String> keys = form.keySet();
		// StringBuffer sb = new StringBuffer();
		// for (String key : keys) {
		// if (sb.length() == 0) {
		// sb.append(url + "?" + key + "=" + form.getFirst(key));
		// } else {
		// sb.append("&" + key + "=" + form.getFirst(key));
		// }
		// }
		// logger.info("请求:{}", sb.toString());
		String response = restTemplate.postForObject(url, form, String.class);
		return response;
	}

}
