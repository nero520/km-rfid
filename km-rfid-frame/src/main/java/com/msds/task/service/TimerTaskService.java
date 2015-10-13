package com.msds.task.service;

import java.util.List;

import com.msds.task.entity.TimerTask;

/**
 * 定时任务管理service
 * 
 * @author Administrator
 * 
 */
public interface TimerTaskService {

	/**
	 * 查询任务
	 * 
	 * @param timerTask
	 * @param pagination
	 * @return
	 */
	public List<TimerTask> findTimerTask(TimerTask timerTask);

	/**
	 * 更新任务信息，如果是非重复的完成任务，计入日志
	 * 
	 * @param timerTask
	 */
	public void updateByStatus(TimerTask timerTask);

	/**
	 * 修改任务
	 * 
	 * @param timerTask
	 */
	public void update(TimerTask timerTask);

	/**
	 * 保存 任务信息
	 * 
	 * @param timerTask
	 */
	public void insert(TimerTask timerTask);

	/**
	 * 删除 任务信息
	 * 
	 * @param timerTask
	 */
	public void deleteByPrimaryKey(Integer id);

	public int updateByPrimaryTaskIdAndType(TimerTask timerTask);

}
