package com.msds.base.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.msds.common.Message;

/**
 * 基类Controller,各个项目BaseController基础后自行扩展
 * 
 * @ClassName BaseController
 * @Description TODO
 * @author LiLong
 * @date 2014年11月21日 下午3:15:14
 * 
 */
public class BasisController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/** 错误视图 */
	protected static final String ERROR_VIEW = "/common/error";

	/** 错误消息 */
	protected static final Message ERROR_MESSAGE = new Message(false, "处理失败");

	/** 成功消息 */
	protected static final Message SUCCESS_MESSAGE = new Message(true, "处理成功");

	/**
	 * 数据绑定
	 * 
	 * @param binder
	 *            WebDataBinder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new HtmlCleanEditor(true,
				true));
		binder.registerCustomEditor(Date.class, new DateEditor(true));
	}

	/**
	 * 添加瞬时消息
	 * 
	 * @param redirectAttributes
	 *            RedirectAttributes
	 * @param message
	 *            消息
	 */
	protected void addFlashMessage(RedirectAttributes redirectAttributes,
			Message message) {
		if (redirectAttributes != null && message != null) {
			redirectAttributes.addFlashAttribute("FLASH_MESSAGE", message);
		}
	}

	/**
	 * 
	 * 提示成功信息
	 * 
	 * @param message
	 * @return
	 */
	public static Message sendSuccessMessage(String message) {
		return new Message(true, message);
	}

	/**
	 * 
	 * 提示成功信息
	 * 
	 * @param message
	 * @return
	 */
	public static Message sendSuccessMessage() {
		return new Message(true, null);
	}

	/**
	 * 
	 * 提示失败信息
	 * 
	 * @param message
	 * @return
	 */
	public static Message sendFailureMessage(String message) {
		return new Message(false, message);
	}
}