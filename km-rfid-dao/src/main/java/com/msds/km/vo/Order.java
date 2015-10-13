package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.ServiceEntity;

/**
 * 前台订单数据包装类
 * 
 * @ClassName Order
 * @Description TODO
 * @author LiLong
 * @date 2015年4月27日 下午4:01:49
 * 
 */
public class Order extends BaseVo {

	private static final long serialVersionUID = 5172273900329339063L;

	/**
	 * 车主信息
	 */
	private MemberModelEntity memberModelEntity;

	/**
	 * 订单基础信息
	 */
	private OrderEntity orderEntity;

	/**
	 * 商品集合
	 */
	private List<Product> productList;

	/**
	 * 工时集合
	 */
	private List<Laborcost> laborcostlist;

	/**
	 * 修理厂
	 */
	private CompanyEntity companyEntity;
	/**
	 * 服务信息
	 */
	private ServiceEntity serviceEntity;

	/**
	 * 工时总价(后台)
	 */
	public BigDecimal workDateCount;
	/**
	 * 车品牌LOGO
	 */
	private String modelLogo;
	/**
	 * 修理厂LOGO
	 */
	private String companyLogo;

	/**
	 * 开始时间
	 */
	private Date startDate;

	/**
	 * @Description 获取 工时总价
	 * @return List<Product>
	 */
	public BigDecimal getWorkDateCount() {
		if (laborcostlist != null && laborcostlist.size() > 0) {
			BigDecimal price = new BigDecimal(0);
			for (int i = 0; i < laborcostlist.size(); i++) {
				if (laborcostlist.get(i) != null) {
					BigDecimal price1 = laborcostlist.get(i).getPrice();
					price = price.add(price1);
				}
			}
			return price;
		}
		return null;
	}

	/**
	 * @Description 设置 工时总价
	 * @param productList
	 */
	public void setWorkDateCount(BigDecimal workDateCount) {
		this.workDateCount = workDateCount;
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
	 * @Description 获取 laborcostlist
	 * @return List<LaborcostEntity>
	 */
	public List<Laborcost> getLaborcostlist() {
		return laborcostlist;
	}

	/**
	 * @Description 设置 laborcostlist
	 * @param laborcostlist
	 */
	public void setLaborcostlist(List<Laborcost> laborcostlist) {
		this.laborcostlist = laborcostlist;
	}

	/**
	 * @Description 获取 修理厂
	 * @return CompanyEntity
	 */
	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	/**
	 * @Description 设置 修理厂
	 * @param company
	 */
	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	/**
	 * @Description 获取 订单基础信息
	 * @return OrderEntity
	 */
	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	/**
	 * @Description 设置 订单基础信息
	 * @param orderEntity
	 */
	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	/**
	 * @Description 获取 服务信息
	 * @return ServiceEntity
	 */
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	/**
	 * @Description 设置 服务信息
	 * @param serviceEntity
	 */
	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}

	/**
	 * @Description 获取 车品牌LOGO
	 * @return String
	 */
	public String getModelLogo() {
		return modelLogo;
	}

	/**
	 * @Description 设置 车品牌LOGO
	 * @param modelLogo
	 */
	public void setModelLogo(String modelLogo) {
		this.modelLogo = modelLogo;
	}

	/**
	 * @Description 获取 修理厂LOGO
	 * @return String
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}

	/**
	 * @Description 设置 修理厂LOGO
	 * @param companyLogo
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
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

	public MemberModelEntity getMemberModelEntity() {
		return memberModelEntity;
	}

	public void setMemberModelEntity(MemberModelEntity memberModelEntity) {
		this.memberModelEntity = memberModelEntity;
	}

}
