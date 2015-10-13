package com.msds.km.model;

import java.io.Serializable;

/**
 * 结算单
 * @author hebiao
 *
 */
public class SettleAccountModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算单号
	 */
	private String settleSn;
	/**
	 * 结算时间段 开始
	 */
	private String start;
	/**
	 * 结算时间段 结束
	 */
	private String end;
	
	/**
	 * 状态名
	 */
	private String stateName;
	
	/**
	 * 结算金额
	 */
	private String price;

	public String getSettleSn() {
		return settleSn;
	}

	public void setSettleSn(String settleSn) {
		this.settleSn = settleSn;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	

}
