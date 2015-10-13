package com.msds.common;

/**
 * 分页基础
 * 
 * @author LiLong 2014-7-29
 * 
 */
public class Pager {

	private int pageId = 0; // 当前页
	private int rowCount = 0; // 总行数
	private int pageSize = 10; // 页大小
	private int pageOffset = 0;// 当前页起始记录
	private String orderField;

	protected void doPage() {
	
	}

	public String getOrderCondition() {
		String condition = "";
		if (this.orderField != null && this.orderField.length() != 0) {
			condition = " order by " + orderField;
		}
		return condition;
	}

	public String getQueryCondition() {
		
		this.pageOffset = (this.pageId) * this.pageSize;

		if (this.pageSize == 0) {
			this.pageSize = 20;
		} else {
			//修改分页bug   limit  10,20  : 从第十行开始，查询第10-30行数据
//			this.pageSize = (this.pageId + 1) * this.pageSize;
		}
		
		String condition = "";
		condition = " limit " + pageOffset + "," + pageSize;
		return condition;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		this.doPage();
	}

	public int getRowCount() {
		return rowCount;
	}

}