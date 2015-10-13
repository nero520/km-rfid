package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.entity.ServiceModelEntity;

/**
 * 前台服务车型数据包装类
 * 
 * @ClassName ServiceMode
 * @Description TODO
 * @author LiLong
 * @date 2015年4月28日 下午1:16:48
 * 
 */
public class ServiceMode extends BaseVo {

	private static final long serialVersionUID = 5172273900329339063L;

	/**
	 * 基础信息
	 */
	private ServiceModelEntity serviceModelEntity;

	/**
	 * 服务信息
	 */
	private ServiceEntity serviceEntity;

	/**
	 * 商品集合
	 */
	private List<Product> productList;
	/**
	 * 商品集合JSON
	 */
	@Deprecated
	private String productsJson;

	/**
	 * 工时集合
	 */
	private List<Laborcost> laborcostlist;
	/**
	 * 工时集合JSON
	 */
	@Deprecated
	private String laborcostsJson;

	/**
	 * 工时总费用
	 */
	private BigDecimal laborcostsPrice;

	/**
	 * 商品总费用
	 */
	private BigDecimal productsPrice;

	/**
	 * 维修厂信息
	 */
	private List<CompanyEntity> repairList;

	/**
	 * 开始时间
	 */
	private Date startDate;

	public List<CompanyEntity> getRepairList() {
		return repairList;
	}

	public void setRepairList(List<CompanyEntity> repairLists) {
		this.repairList = repairLists;
	}

	/**
	 * @Description 获取 服务基础信息
	 * @return ServiceEntity
	 */
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	/**
	 * @Description 设置 服务基础信息
	 * @param serviceEntity
	 */
	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}

	/**
	 * @Description 获取 工时集合
	 * @return List<LaborcostEntity>
	 */
	public List<Laborcost> getLaborcostlist() {
		return laborcostlist;
	}

	/**
	 * @Description 设置 工时集合
	 * @param laborcostlist
	 */
	public void setLaborcostlist(List<Laborcost> laborcostlist) {
		this.laborcostlist = laborcostlist;
	}

	/**
	 * @Description 获取 基础信息
	 * @return ServiceModelEntity
	 */
	public ServiceModelEntity getServiceModelEntity() {
		return serviceModelEntity;
	}

	/**
	 * @Description 设置 基础信息
	 * @param serviceModelEntity
	 */
	public void setServiceModelEntity(ServiceModelEntity serviceModelEntity) {
		this.serviceModelEntity = serviceModelEntity;
	}

	/**
	 * @Description 获取 商品集合
	 * @return List<Product>
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @Description 设置 商品集合
	 * @param productList
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	/**
	 * @Description 获取 商品集合JSON
	 * @return String
	 */
	@Deprecated
	public String getProductsJson() {
		return productsJson;
	}

	/**
	 * @Description 设置 商品集合JSON
	 * @param productsJson
	 */
	@Deprecated
	public void setProductsJson(String productsJson) {
		this.productsJson = productsJson;
	}

	/**
	 * @Description 获取 工时集合JSON
	 * @return String
	 */
	@Deprecated
	public String getLaborcostsJson() {
		return laborcostsJson;
	}

	/**
	 * @Description 设置 工时集合JSON
	 * @param laborcostsJson
	 */
	@Deprecated
	public void setLaborcostsJson(String laborcostsJson) {
		this.laborcostsJson = laborcostsJson;
	}

	/**
	 * @Description 获取 工时总费用
	 * @return BigDecimal
	 */
	public BigDecimal getLaborcostsPrice() {
		return laborcostsPrice;
	}

	/**
	 * @Description 设置 工时总费用
	 * @param laborcostsPrice
	 */
	public void setLaborcostsPrice(BigDecimal laborcostsPrice) {
		this.laborcostsPrice = laborcostsPrice;
	}

	/**
	 * @Description 获取 商品总费用
	 * @return BigDecimal
	 */
	public BigDecimal getProductsPrice() {
		return productsPrice;
	}

	/**
	 * @Description 设置 商品总费用
	 * @param productsPrice
	 */
	public void setProductsPrice(BigDecimal productsPrice) {
		this.productsPrice = productsPrice;
	}

	/**
	 * @Description 获取 开始时间
	 * @return String
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @Description 设置 开始时间
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
