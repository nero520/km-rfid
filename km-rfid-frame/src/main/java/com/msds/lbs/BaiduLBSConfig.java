package com.msds.lbs;

/**
 * 百度LBS基础信息
 * 
 * @ClassName BaiDuLBSConfig
 * @Description TODO
 * @author LiLong
 * @date 2015年6月10日 上午10:11:51
 * 
 */
public class BaiduLBSConfig {

	/** 百度lbs ak密钥 */
	public static final String BAIDU_LBS_AK = "WixSEVWd3qqXcQ9zjB14TBBe";

	/** 百度lbs 地址 */
	public static final String BAIDU_DOMAIN = "http://api.map.baidu.com";
	/** Place Suggestion API */
	public static final String SUGGESTION_URL = BAIDU_DOMAIN
			+ "/place/v2/suggestion/";
	/** Geocoding API */
	public static final String GEOCODER_URL = BAIDU_DOMAIN + "/geocoder/v2/";
	/** IP定位API */
	public static final String LOCATION_URL = BAIDU_DOMAIN + "/location/ip";
	/** 坐标转换API */
	public static final String GEOCONV_URL = BAIDU_DOMAIN + "/geoconv/v1/?";
	/** poi周边搜索API */
	public static final String NEARBY_URL = BAIDU_DOMAIN
			+ "/geosearch/v3/nearby";
}
