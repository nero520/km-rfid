package com.msds.km.base;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.msds.base.controller.BasisController;
import com.msds.common.DataList;

/**
 * 基础Service接口<br>
 * 处理公用的CRUD、分页等
 * 
 * @author LiLong 2014-7-28
 * 
 * @param <T>
 */
public class BaseController extends BasisController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public final static String SUCCESS = "success";
	public final static String MSG = "msg";
	public final static String DATA = "data";
	public final static String LOGOUT_FLAG = "logoutFlag";

	/**
	 * 跳转页面
	 * 
	 * @Description TODO
	 * @param viewName
	 * @param context
	 * @return
	 * @return ModelAndView
	 */
	public ModelAndView forword(String viewName, Map context) {
		return new ModelAndView(viewName, context);
	}

	/**
	 * 返回列表数据
	 * 
	 * @param total
	 * @param data
	 * @return
	 */
	public static DataList returnDataGrid(Integer total, List data) {
		return new DataList(total, data);
	}
}
