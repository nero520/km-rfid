package com.msds.km.model;   

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 创建时间：2014-10-16 下午5:35:14 
 * 项目名称：order_api 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public class ListModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4505236310457503273L;

	private List<T> models = new ArrayList<T>();
	
	private int totalCount ;


	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
  
