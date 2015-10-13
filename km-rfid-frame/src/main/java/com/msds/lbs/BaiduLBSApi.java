package com.msds.lbs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msds.util.HttpRequest;
import com.msds.util.JsonUtils;

/**
 * 百度LBS API简单封装，后续完善<br>
 * 
 * @ClassName BaiDuApi
 * @Description 太多了,看不过来,先这样吧~
 * @author LiLong
 * @date 2015年6月10日 上午10:02:48
 * 
 */
public class BaiduLBSApi {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<String> LOCAL_IP = Arrays.asList("127.0.0.1",
			"localhost");

	/**
	 * 根据ip获取经纬度
	 * 
	 * @Description TODO
	 * @param ip
	 * @return
	 * @return Map<String,String>
	 */
	public static Map<String, String> getPoint(String ip) {
		Map<String, Object> location = getLocation(ip);
		if (location != null) {
			Map<String, Object> content = (Map<String, Object>) location
					.get("content");
			if (content != null) {
				Map<String, String> point_ = (Map<String, String>) content
						.get("point");
				if (point_ != null) {
					Map<String, String> point = new HashMap<>();
					point.put("longitude", point_.get("x"));
					point.put("latitude", point_.get("y"));
					return point;
				}
			}
		}
		return null;
	}

	/**
	 * 根据ip获取地址
	 * 
	 * @Description TODO
	 * @param ip
	 * @return
	 * @return Map<String,String>
	 */
	public static Map<String, Object> getAddress(String ip) {
		Map<String, Object> location = getLocation(ip);
		if (location != null) {
			Map<String, Object> content = (Map<String, Object>) location
					.get("content");
			if (content != null) {
				Map<String, Object> info = new HashMap<>();
				info.put("address", content.get("address"));
				Map<String, String> address_detail = (Map<String, String>) content
						.get("address_detail");
				if (address_detail != null) {
					info.put("city", address_detail.get("city"));
				}
				return info;
			}
		}
		return null;
	}

	/**
	 * 根据ip获取位置
	 * 
	 * @Description TODO
	 * @param ip
	 * @return
	 * @return Map<String,Object>
	 */
	private static Map<String, Object> getLocation(String ip) {
		if (ip != null && !LOCAL_IP.contains(ip)) {
			Map<String, String> params = new HashMap<>();
			params.put("ip", ip);
			params.put("ak", BaiduLBSConfig.BAIDU_LBS_AK);
			params.put("coor", "bd09ll");
			String result = null;
			try {
				result = HttpRequest.post(BaiduLBSConfig.LOCATION_URL, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (result != null) {
				Map<String, Object> location = JsonUtils.toObject(result,
						Map.class);
				return location;
			}
		}
		return null;
	}

	/**
	 * 根据城市和地址获取经纬度
	 * 
	 * @Description TODO
	 * @param city
	 * @param address
	 * @return
	 * @return Map<String,String>
	 */
	public static Map<String, String> getPoint(String city, String address) {
		if (StringUtils.isNotBlank(city) && StringUtils.isNotBlank(address)) {
			Map<String, String> params = new HashMap<>();
			params.put("output", "json");
			params.put("ak", BaiduLBSConfig.BAIDU_LBS_AK);
			params.put("address", address);
			params.put("city", city);
			// params.put("callback", "showLocation");
			String result = null;
			try {
				result = HttpRequest.post(BaiduLBSConfig.GEOCODER_URL, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (result != null) {
				Map<String, Object> geoMap = JsonUtils.toObject(result,
						Map.class);
				if (geoMap != null) {
					Map<String, Object> content = (Map<String, Object>) geoMap
							.get("result");
					if (content != null) {
						Map<String, Object> location = (Map<String, Object>) content
								.get("location");
						if (location != null) {
							Map<String, String> point = new HashMap<>();
							point.put("longitude",
									String.valueOf(location.get("lng")));
							point.put("latitude",
									String.valueOf(location.get("lat")));
							return point;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 根据经纬度获取详细地址
	 * 
	 * @Description TODO
	 * @param longitude
	 * @param latitude
	 * @return
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> getAddress(String longitude,
			String latitude) {
		if (latitude != null && longitude != null) {
			Map<String, String> params = new HashMap<>();
			params.put("output", "json");
			params.put("ak", BaiduLBSConfig.BAIDU_LBS_AK);
			params.put("coordtype", "wgs84ll");
			params.put("location", latitude + "," + longitude);
			params.put("pois", "0");
			// params.put("callback", "showLocation");
			String result = null;
			try {
				result = HttpRequest.post(BaiduLBSConfig.GEOCODER_URL, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (result != null) {
				Map<String, Object> geoMap = JsonUtils.toObject(result,
						Map.class);
				if (geoMap != null) {
					Map<String, Object> content = (Map<String, Object>) geoMap
							.get("result");
					if (content != null) {
						Map<String, Object> info = new HashMap<>();
						info.put("address", content.get("formatted_address"));
						Map<String, String> addressComponent = (Map<String, String>) content
								.get("addressComponent");
						if (addressComponent != null) {
							info.put("city", addressComponent.get("city"));
							info.put("province",
									addressComponent.get("province"));
						}
						return info;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 查找附近目标
	 * 
	 * @Description 距离排序
	 * @param longitude
	 * @param latitude
	 * @param geotableId
	 * @param radius
	 * @param query
	 * @return
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> getNearby(String longitude,
			String latitude, String geotableId, String radius, String query) {
		if (latitude != null && longitude != null && geotableId != null
				&& query != null && radius != null) {
			Map<String, String> params = new HashMap<>();
			params.put("ak", BaiduLBSConfig.BAIDU_LBS_AK);
			params.put("geotable_id", geotableId);
			params.put("q", query);
			params.put("location", longitude + "," + latitude);
			params.put("radius", radius);
			params.put("sortby", "distance:1");
			// params.put("callback", "showLocation");
			String result = null;
			try {
				result = HttpRequest.get(BaiduLBSConfig.NEARBY_URL, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (result != null) {
				result = StringEscapeUtils.unescapeJava(result);
				Map<String, Object> poiMap = JsonUtils.toObject(result,
						Map.class);
				if (poiMap != null
						&& Integer.valueOf(0).equals(poiMap.get("status"))) {
					List<Map<String, Object>> contents = (List<Map<String, Object>>) poiMap
							.get("contents");
					return contents;
				}
			}
		}
		return null;
	}

	/**
	 * 转换经纬度
	 * 
	 * @Description 默认GPS转百度坐标,其他需要时候再封装吧
	 * @param longitude
	 * @param latitude
	 * @return
	 * @return Map<String,Double>
	 */
	public static Map<String, Double> switchPoint(String longitude,
			String latitude) {
		if (latitude != null && longitude != null) {
			Map<String, String> params = new HashMap<>();
			params.put("ak", BaiduLBSConfig.BAIDU_LBS_AK);
			params.put("coords", latitude + "," + longitude);
			String result = null;
			try {
				result = HttpRequest.post(BaiduLBSConfig.GEOCONV_URL, params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (result != null) {
				Map<String, Object> geoMap = JsonUtils.toObject(result,
						Map.class);
				if (geoMap != null) {
					Map<String, Double> content = (Map<String, Double>) geoMap
							.get("result");
					if (content != null) {
						Map<String, Double> point = new HashMap<>();
						point.put("longitude", content.get("x"));
						point.put("latitude", content.get("y"));
						return point;
					}
				}

			}
		}
		return null;
	}

	public static void main(String[] args) {

		// 获取地址信息
		Map<String, Object> m1 = BaiduLBSApi.getAddress("202.198.16.3");
		System.out.println(m1);

		// 获取经纬度信息
		Map<String, String> m2 = BaiduLBSApi.getPoint("202.198.16.3");
		System.out.println(m2);

		// 根据城市获取经纬度
		Map<String, String> m3 = BaiduLBSApi.getPoint("南京", "南京");
		System.out.println(m3);

		// 根据经纬度获取地址
		Map<String, Object> m4 = BaiduLBSApi.getAddress("116.31590106168461",
				"39.932705155727746");
		System.out.println(m4);

		// Map<String, Double> m5 = switchPoint(39.932705155727746,
		// 116.31590106168461);
		// System.out.println(m5);

		// 116.358807,39.893385
		// 116.32856587345, 39.939785449874,
		// 118.779954,32.093857
		List<Map<String, Object>> m6 = getNearby("118.77807440803",
				"32.057235501806", "107490", "10000", "修理厂");
		System.out.println(m6);

	}
}
