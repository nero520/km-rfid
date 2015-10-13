package com.msds.task.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.task.entity.TimerTask;
import com.msds.task.service.TimerTaskService;

@Controller("timerTaskController")
@RequestMapping("/TimerTask")
public class TimerTaskController {

	@Resource(name = "timerTaskServiceImpl")
	private TimerTaskService timerTaskService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		timerTaskService.findTimerTask(new TimerTask());
		return null;
	}
}
