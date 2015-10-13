package com.msds.base.service;

import java.util.List;

import com.msds.common.BasePage;

/**
 * 基础Service接口<br>
 * 处理公用的CRUD、分页等
 * 
 * @author LiLong 2014-7-28
 * 
 * @param <T>
 */
public interface BaseService<T> {

	/**
	 * 保存实体
	 * 
	 * @param Entity
	 * @throws Exception
	 */
	public void add(T t) throws Exception;

	/**
	 * 删除实体
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Object id) throws Exception;

	/**
	 * 删除实体
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void delete(Object... ids) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param Entity
	 * @throws Exception
	 */
	public void update(T t) throws Exception;

	/**
	 * 返回实体
	 * 
	 * @param 主键
	 * @return
	 * @throws Exception
	 */
	public T findById(Object id) throws Exception;

	/**
	 * 返回实体List
	 * 
	 * @param 实体条件
	 * @return
	 * @throws Exception
	 */
	public List<T> findListByCondition(T t) throws Exception;

	/**
	 * 返回分页总数
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public int queryByCount(BasePage page) throws Exception;

	/**
	 * 返回分页结果
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<T> queryByList(BasePage page) throws Exception;
	
	/**
	 * 判断实体对象是否存在
	 * 
	 * @param filters
	 *            筛选
	 * @return 实体对象是否存在
	 * @throws Exception 
	 */
	boolean exists(T entity) throws Exception;

}
