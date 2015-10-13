package com.msds.task.service;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msds.mail.MailService;
import com.msds.task.entity.TimerTask;
import com.msds.util.SpringUtils;

/**
 * 定时任务扩展
 * 
 * @author lilong
 * 
 */
public class TimerTaskDetail extends java.util.TimerTask {

	private static final Logger logger = LoggerFactory
			.getLogger(TimerTaskDetail.class);

	private static MailService mailService = (MailService) SpringUtils
			.getBean("mailServiceImpl");

	private Object taskInstance = null;
	private Method taskMethod = null;
	private TimerTask timerTask = null;
	private String args = null;

	public TimerTask getTimerTask() {
		return timerTask;
	}

	public void setTimerTask(TimerTask timerTask) {
		this.timerTask = timerTask;
	}

	public void setTaskInstance(Object taskInstance) {
		this.taskInstance = taskInstance;
	}

	public void setTaskMethod(Method taskMethod) {
		this.taskMethod = taskMethod;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	@Override
	public void run() {
		try {
			setTaskStatus("2");
			if ("3".equals(timerTask.getType())) {
				if (args != null) {
					taskMethod.invoke(taskInstance, args);
				} else {
					taskMethod.invoke(taskInstance, null);
				}
			} else if ("2".equals(timerTask.getType())) {
				mailService.send(timerTask.getAddress(),
						timerTask.getSubject(), timerTask.getTaskContent(),
						false, null, false);
			} else if ("1".equals(timerTask.getType())) {

				// TODO 短信接口
			} else {
				logger.warn("任务type: " + timerTask.getTaskType() + " 没有匹配!");
			}
			setTaskStatus("3");
		} catch (Exception e) {
			e.printStackTrace();
			setTaskStatus("4");
		}
	}

	private void setTaskStatus(String status) {
		if (timerTask != null)
			timerTask.setStatus(status);
	}
}
