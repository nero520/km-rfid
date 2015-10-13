package com.msds.km.common;

import java.math.BigDecimal;

/**
 * 公共参数
 * 
 * @ClassName CommonAttributes
 * @Description TODO
 * @author LiLong
 * @date 2014年11月21日 下午3:23:12
 * 
 */
public final class CommonAttributes {

	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy",
			"yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd",
			"yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss",
			"yyyy/MM/dd HH:mm:ss" };
	/** 货币符号 */
	public static final String CURRENCY_SIGN = "￥";
	/** 货币单位 */
	public static final String CURRENCY_UNIT = "元";
	/** 价格精度 */
	public static final int PRICE_ACCURACY = 2;
	/** 舍入方式 */
	public static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
	/** 身份信息变量 */
	public static final String MEMBER_PRINCIPAL_INFO = "MEMBER_PRINCIPAL_INFO";
	/** "用户名"Cookie名称 */
	public static final String USERNAME_COOKIE_NAME = "username";
	/** "修理厂名字"Cookie名称 */
	public static final String FULLNAME_COOKIE_NAME = "fullName";
	/** "购物车数量"Cookie名称 */
	public static final String CARTNUM_COOKIE_NAME = "cartnum";
	/** "姓名"Coolie名称" */
	public static final String NAME_COOKIE_NAME = "name";
	/** 在线支付下单后,多久失效(2小时) */
	public static final int ORDER_INVALID_DATE = 2;
	/** "用户名"Cookie名称 */
	public static final String CART_KEY_SALT = "MSDSCARTKEY";
	/** 首页 */
	public static final String HOME_PAGE = "/";
	/** 上传文件大小限制 */
	public static final long FILE_UPDATE_MAX = 2097152L;
	/** 上传文件大小限制提示 */
	public static final int FILE_UPDATE_MAX_ALERT = 2;
	/** 验证码输入次数 **/
	public static final String CAPTCHA_COUNT = "count";
	/** 购物车选中项字段 **/
	public static final String CHECKED_ITEM = "checked_item";
	/** 分页默认起始页 **/
	public static final Integer DEFAULT_PAGE_INDEX = 0;
	/** 分页默认每页大小 **/
	public static final Integer DEFAULT_PAGESIZE = 20;

	/** 登录发送手机验证码 */
	public static final String Login_SendCode = "login_sendCode:";
	/** 订单导出模板 */
	public static final String ORDER_EXPORT_TEMPLATE = CommonAttributes.class
			.getResource("/").getPath() + "excelmodel/orderTemplate.xls";

	/** 定位地址信息 */
	public static final String GEO_ADDRESS = "GEO_ADDRESS";
	/** 定位城市code */
	public static final String GEO_CITY_CODE = "GEO_CITY_CODE";
	/** 定位经度信息 */
	public static final String GEO_LONGITUDE = "GEO_LONGITUDE";
	/** 定位维度信息 */
	public static final String GEO_LATITUDE = "GEO_LATITUDE";

	/** 修理厂geotableId */
	public static final String GEO_COMPANY_ID = "107490";
	/** 修理厂query */
	public static final String GEO_COMPANY_QUERY = "修理厂";
	/** 修理厂radius */
	public static final String GEO_COMPANY_RADIUS = "10000";

	/**
	 * 不可实例化
	 */
	private CommonAttributes() {
	}

}