package com.msds.common;

import java.util.List;

/**
 * 列表 数据、总数 封装类
 * 
 * @author LiLong 2014-7-29
 */
public class DataList {

	/**
	 * 构造
	 * 
	 * @param success
	 * @param msg
	 */
	public DataList(Integer total, List data) {
		setTotal(total);
		setData(data);
	}

	/**
	 * 是否总数
	 */
	private Integer total;;

	/**
	 * 结果集
	 */
	private List data;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	};

}
