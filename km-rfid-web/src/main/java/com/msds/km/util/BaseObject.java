/**
 * 
 */
package com.msds.km.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author yx.chu
 * @version 2011-7-8
 */
public class BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7836793637979526960L;
	private Integer start;
	private Integer limit;
	private Integer opType;//数据库操作方式
	private String advanceWhere;	
	private List<Integer> idList;
	private String startDate;
	private String endDate;
	private Boolean queryNull;
	private List<String> queryNullList;
	private String[] headers;
	private String[] dataIndexs;
	private String [] rowDatas;
	private String sort;//排序的列
	private String dir;//排序方向  ASC DESC
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	/**
	 * @return the idList
	 */
	public List<Integer> getIdList() {
		return idList;
	}
	/**
	 * @param idList the idList to set
	 */
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	public void setAdvanceWhere(String advanceWhere) {
		this.advanceWhere = advanceWhere;
	}
	public String getAdvanceWhere() {
		return advanceWhere;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		if(null!=startDate && !"".equals(startDate.trim()))
			this.startDate = startDate.substring(0, 10);
		else
			this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		if(null!=endDate && !"".equals(endDate.trim()))
			this.endDate = endDate.substring(0, 10);
		else
			this.endDate = endDate;
	}
	/**
	 * @return the headers
	 */
	public String[] getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String[] headers) {
		this.headers = headers;
	}
	public String[] getRowDatas() {
		return rowDatas;
	}
	public void setRowDatas(String[] rowDatas) {
		this.rowDatas = rowDatas;
	}
	/**
	 * @return the dataIndexs
	 */
	public String[] getDataIndexs() {
		return dataIndexs;
	}
	/**
	 * @param dataIndexs the dataIndexs to set
	 */
	public void setDataIndexs(String[] dataIndexs) {
		this.dataIndexs = dataIndexs;
	}
	/**
	 * @return the queryNull
	 */
	public Boolean getQueryNull() {
		return queryNull;
	}
	/**
	 * @param queryNull the queryNull to set
	 */
	public void setQueryNull(Boolean queryNull) {
		this.queryNull = queryNull;
	}
	/**
	 * @return the queryNullList
	 */
	public List<String> getQueryNullList() {
		return queryNullList;
	}
	/**
	 * @param queryNullList the queryNullList to set
	 */
	public void setQueryNullList(List<String> queryNullList) {
		this.queryNullList = queryNullList;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
}
