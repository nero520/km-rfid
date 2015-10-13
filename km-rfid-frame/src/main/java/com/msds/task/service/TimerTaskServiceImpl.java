package com.msds.task.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.task.entity.TimerTask;
import com.msds.task.entity.TimerTaskLog;
import com.msds.task.mapper.TimerTaskLogMapper;
import com.msds.task.mapper.TimerTaskMapper;

@Service("timerTaskServiceImpl")
@Transactional
public class TimerTaskServiceImpl implements TimerTaskService {

	@Resource
	private TimerTaskMapper timerTaskMapper = null;
	@Resource
	private TimerTaskLogMapper timerTaskLogMapper = null;

	/**
	 * 更新任务信息，如果是非重复的完成任务，计入日志
	 * 
	 * @param timerTask
	 */
	@CacheEvict(value = "TimerTask", key = "#timerTask.cacheId", allEntries = true)
	public void updateByStatus(TimerTask timerTask) {
		if (timerTask == null)
			return;
		// 重复任务更新，一次性任务记日志
		if ("1".equals(timerTask.getTaskType())) {
			if ("3".equals(timerTask.getStatus())
					|| "5".equals(timerTask.getStatus())
					|| "4".equals(timerTask.getStatus())) {
				TimerTaskLog timerTaskLog = new TimerTaskLog();
				try {
					BeanUtils.copyProperties(timerTaskLog, timerTask);
					timerTaskLog.setId(null);// 方便测试
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				timerTaskLogMapper.insert(timerTaskLog);
				timerTaskMapper.deleteByPrimaryKey(timerTask.getId());
			} else {
				timerTaskMapper.updateByPrimaryKey(timerTask);
			}
		} else {
			timerTaskMapper.updateByPrimaryKey(timerTask);
		}
	}

	/**
	 * 更新任务信息
	 * 
	 * @param timerTask
	 */
	@CacheEvict(value = "TimerTask", key = "#timerTask.cacheId", allEntries = true)
	public void update(TimerTask timerTask) {
		timerTaskMapper.updateByPrimaryKeySelective(timerTask);
	}

	/**
	 * 保存 任务信息
	 * 
	 * @param timerTask
	 */
	@CacheEvict(value = "TimerTask", key = "#timerTask.cacheId", allEntries = true)
	public void insert(TimerTask timerTask) {
		timerTaskMapper.insert(timerTask);
	}

	/**
	 * 按照主键删除 任务信息
	 * 
	 * @param timerTask
	 */
	@CacheEvict(value = "TimerTask", allEntries = true)
	public void deleteByPrimaryKey(Integer id) {
		timerTaskMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 查询任务
	 * 
	 * @param timerTask
	 * @param page
	 * @return
	 */
	@Cacheable(value = "TimerTask", key = "#timerTask.cacheId")
	public List<TimerTask> findTimerTask(TimerTask timerTask) {
		return timerTaskMapper.selectByExample(timerTask);
	}

	@CacheEvict(value = "TimerTask", key = "#timerTask.cacheId")
	public int updateByPrimaryTaskIdAndType(TimerTask timerTask) {
		return timerTaskMapper.updateByPrimaryTaskIdAndType(timerTask);

	}
}
