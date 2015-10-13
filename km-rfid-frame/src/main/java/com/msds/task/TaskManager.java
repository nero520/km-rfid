package com.msds.task;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.msds.mail.MailService;
import com.msds.task.entity.TimerTask;
import com.msds.task.service.TimerTaskDetail;
import com.msds.task.service.TimerTaskService;

/**
 * 定时任务管理器,继承后通重写init()与updateAndLoadTask()方法开启
 * 
 * @author LiLong 2014-5-9
 * 
 */
@Component("TaskManager")
@Lazy(false)
public class TaskManager {

	private static final Logger logger = LoggerFactory
			.getLogger(TaskManager.class);

	private static ClassLoader CLASSLOADER;
	private static Map<Integer, java.util.TimerTask> taskMap = null;
	@Value("${task.switch}")
	private String taskSwitch = "0";
	// private static long updateIntervers = 10 * 1000;
	private static Timer taskTimer = new Timer(true);
	private static Queue<TimerTask> updateTaskQueue = new LinkedList<TimerTask>();

	private TaskManager() {
	};

	@Resource(name = "timerTaskServiceImpl")
	private TimerTaskService timerTaskService;
	@Resource(name = "mailServiceImpl")
	private MailService mailService;

	// static {
	// init();
	// }

	// @PostConstruct
	private void init() {
		CLASSLOADER = (TaskManager.class).getClassLoader();
		taskMap = new TreeMap<Integer, java.util.TimerTask>();

		if ("1".equals(taskSwitch)) {
			// TimerTask task = new TimerTask() {
			// public void run() {
			// updateAndLoadTask();
			// }
			// };
			// taskTimer.scheduleAtFixedRate(task, 0, updateIntervers);
			logger.info("定时任务:on");
		} else {
			logger.info("定时任务:off");
		}
	}

	/**
	 * 扫描
	 */
	// @Scheduled(cron = "${task.scan.cron}")
	private void updateAndLoadTask() {
		if ("1".equals(taskSwitch)) {
			Object[] keys = taskMap.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
				TimerTaskDetail timerTaskDetail = (TimerTaskDetail) taskMap
						.get(keys[i]);
				if (timerTaskDetail != null
						&& timerTaskDetail.getTimerTask() != null) {
					TimerTask timerTask = timerTaskDetail.getTimerTask();
					if (timerTask.isStatusChanged()) {
						if (!updateTaskQueue.contains(timerTask))
							updateTaskQueue.add(timerTask);
						timerTask.setStatusChanged(false);
					}
				}
			}
			updateTaskData();
			loadTask();
		}
	}

	/**
	 * 更新任务状态至数据库
	 * 
	 * @param key
	 */
	private void updateTaskData() {
		while (!updateTaskQueue.isEmpty()) {
			TimerTask timerTask = (TimerTask) updateTaskQueue.poll();
			timerTaskService.updateByStatus(timerTask);
		}
	}

	/**
	 * 任务读取
	 */
	private synchronized void loadTask() {
		TimerTask timerTask = new TimerTask();
		List<TimerTask> taskList = timerTaskService.findTimerTask(timerTask);
		if (taskList != null && taskList.size() > 0) {
			for (int i = 0; i < taskList.size(); i++) {
				timerTask = taskList.get(i);
				if (timerTask != null
						&& (!taskMap.containsKey(timerTask.getId()))) {
					newTask(timerTask);
					logger.info("成功载入定时任务：" + timerTask.getTaskName()
							+ ",任务ID:" + timerTask.getTaskId());
				} else if ("5".equals(timerTask.getStatus())) {
					cancelTask(timerTask.getId());
					taskMap.remove(timerTask.getId());
					if (!updateTaskQueue.contains(timerTask))
						updateTaskQueue.add(timerTask);
					logger.info("成功取消定时任务：" + timerTask.getTaskName()
							+ ",任务ID:" + timerTask.getTaskId());
				}
			}
		}
	}

	/**
	 * 新任务
	 * 
	 * @param key
	 * @param timerTask
	 */
	private void newTask(TimerTask timerTask) {
		if (timerTask == null)
			return;
		TimerTaskDetail timerTaskDetail = new TimerTaskDetail();
		timerTaskDetail.setTimerTask(timerTask);
		taskMap.put(timerTask.getId(), timerTaskDetail);
		String taskClass = timerTask.getTaskClass();
		String taskMethodName = timerTask.getTaskMethod();
		Object taskInstance = null;
		Method taskMethod = null;
		String args = timerTask.getTaskContent();
		try {
			if (StringUtils.isNotEmpty(taskClass)
					&& StringUtils.isNotEmpty(taskMethodName)) {
				taskInstance = getInstance(taskClass);
				if (args.isEmpty()) {
					taskMethod = taskInstance.getClass().getDeclaredMethod(
							taskMethodName, null);
				} else {
					timerTaskDetail.setArgs(args);
					taskMethod = taskInstance.getClass().getDeclaredMethod(
							taskMethodName, String.class);
				}
				timerTaskDetail.setTaskInstance(taskInstance);
				timerTaskDetail.setTaskMethod(taskMethod);
			}
			if ("1".equals(timerTask.getTaskType())) {
				taskTimer.schedule(timerTaskDetail, timerTask.getRunTime());
			} else if ("2".equals(timerTask.getTaskType())) {
				taskTimer.scheduleAtFixedRate(timerTaskDetail,
						timerTask.getDelay(), timerTask.getIntervers());
			} else if ("3".equals(timerTask.getTaskType())) {
				taskTimer.scheduleAtFixedRate(timerTaskDetail,
						timerTask.getRunTime(), timerTask.getIntervers());
			} else {
				logger.warn("任务taskType: " + timerTask.getTaskType() + " 没有匹配!");
			}
		} catch (Exception e) {
			logger.info("定时任务异常：" + timerTask.getTaskName() + ",任务ID:"
					+ timerTask.getTaskId());
			e.printStackTrace();
		}
	}

	/**
	 * 查看任务状态
	 * 
	 * @return
	 */
	public List viewTasks() {
		List taskList = new ArrayList();
		Object[] keys = taskMap.keySet().toArray();
		TimerTask timerTask = null;
		for (int i = 0; i < keys.length; i++) {
			TimerTaskDetail timerTaskDetail = (TimerTaskDetail) taskMap
					.get(keys[i]);
			if (timerTaskDetail != null) {
				timerTask = timerTaskDetail.getTimerTask();
				if (timerTask != null) {
					taskList.add(timerTask);
				}
			}
		}
		return taskList;
	}

	/**
	 * 任务取消
	 * 
	 * @param key
	 */
	public boolean cancelTask(Integer taskId) {
		TimerTaskDetail timerTaskDetail = (TimerTaskDetail) taskMap.get(taskId);
		if (timerTaskDetail != null) {
			return timerTaskDetail.cancel();
		} else {
			return false;
		}
	}

	/**
	 * 更新任务
	 * 
	 * @param key
	 */
	public boolean updateTask(String taskId) {
		TimerTaskDetail timerTaskDetail = (TimerTaskDetail) taskMap.get(taskId);
		if (timerTaskDetail != null) {
			return timerTaskDetail.cancel();
		} else {
			return false;
		}
	}

	/**
	 * 执行任务
	 * 
	 * @param key
	 */
	private static void runTask(String taskId) {
		TimerTaskDetail timerTaskDetail = (TimerTaskDetail) taskMap.get(taskId);
		// 更新状态，记录执行时间
		// taskTimer.
		// 执行任务
	}

	/**
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	private Object getInstance(String className) throws Exception {
		return CLASSLOADER.loadClass(className).getConstructor(new Class[] {})
				.newInstance(new Object[] {});
	}

}
