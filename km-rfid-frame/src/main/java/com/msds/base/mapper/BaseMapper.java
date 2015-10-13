package com.msds.base.mapper;

import java.util.List;

import com.msds.common.BasePage;

/**
 * 基础DAO接口<br>
 * 处理公用的CRUD、分页等
 * 
 * @author LiLong 2014-7-28
 * 
 * @param <T>
 */
public interface BaseMapper<T> {

	/**
	 * 保存实体
	 * 
	 * @param Entity
	 */
	public void add(T t);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	public void delete(Object id);

	/**
	 * 更新实体
	 * 
	 * @param Entity
	 */
	public void update(T t);

	/**
	 * 返回实体
	 * 
	 * @param 主键
	 * @return
	 */
	public T findById(Object id);

	/**
	 * 返回实体List
	 * 
	 * @param 实体条件
	 * @return
	 */
	public List<T> findListByCondition(T t);

	/**
	 * 返回分页总数
	 * 
	 * @param page
	 * @return
	 */
	public int queryByCount(BasePage page);

	/**
	 * 返回分页结果
	 * 
	 * @param page
	 * @return
	 */
	public List<T> queryByList(BasePage page);

}
