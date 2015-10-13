package com.msds.baseinfo.common;

/**
 * @页面参数实体
 * 
 */
public class Page {

	private int totalCount; // 总条数
	private int startRow;// 开始条数
	private int endRow;// 结束条数
	private String orderField;// 排序字段
	private int pageIndex;// 第几页
	private int pageSize;// 每页显示多少条
	private String orderDirection;// 升序还是降序

	public Page(int totalCount, int pageNumShown, int startRow, int endRow,
			String orderField, String orderDirection, int pageIndex,
			int pageSize) {
		super();
		this.totalCount = totalCount;
		// this.numPerPage = numPerPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.orderField = orderField;
		this.orderDirection = orderDirection;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	public Page() {
		super();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	// 初始化方法
	public void initPage(int totalCount) {
		this.totalCount = totalCount;
	}

	public void initPage() {
		this.startRow = (this.pageIndex) * this.pageSize;

		if (this.pageSize == 0) {
			this.endRow = 20;
		} else {
			this.endRow = (this.pageIndex + 1) * this.pageSize;
		}

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
