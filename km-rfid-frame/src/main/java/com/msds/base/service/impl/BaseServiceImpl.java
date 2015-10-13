package com.msds.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msds.base.mapper.BaseMapper;
import com.msds.base.service.BaseService;
import com.msds.common.BasePage;

/**
 * 基础Service接口实现<br>
 * 处理公用的CRUD、分页等
 * 
 * @author LiLong 2014-7-28
 * 
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public abstract BaseMapper<T> baseMapper();

	public void add(T t) throws Exception {
		baseMapper().add(t);
	}

	/**
	 * 删除实体
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Object id) {
		baseMapper().delete(id);
	}

	/**
	 * 删除实体
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void delete(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			baseMapper().delete(id);
		}
	}

	/**
	 * 更新实体
	 * 
	 * @param Entity
	 * @throws Exception
	 */
	public void update(T t) throws Exception {
		baseMapper().update(t);
	}

	/**
	 * 返回实体
	 * 
	 * @param 主键
	 * @return
	 * @throws Exception
	 */
	public T findById(Object id) throws Exception {
		return baseMapper().findById(id);
	}

	/**
	 * 返回实体List
	 * 
	 * @param 实体条件
	 * @return
	 * @throws Exception
	 */
	public List<T> findListByCondition(T t) {
		return baseMapper().findListByCondition(t);
	}

	/**
	 * 返回分页总数
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public int queryByCount(BasePage page) throws Exception {
		return baseMapper().queryByCount(page);
	}

	/**
	 * 返回分页结果
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<T> queryByList(BasePage page) throws Exception {
		Integer rowCount = queryByCount(page);
		page.getPager().setRowCount(rowCount);
		return baseMapper().queryByList(page);
	}

	@Override
	public boolean exists(T entity) throws Exception {
		return queryByCount((BasePage) entity) > 0;
	}

}
