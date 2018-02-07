package com.bfmzdx.csp.entity;

import java.util.Date;
/**
 * 商品类别实体类
 * @author YangMing
 * @date 2018年1月19日
 */
public class ProductCategory {
	//商品类别ID
	private Long productCategoryId;
	//商品类别名
	private String productCategoryName;
	//店铺ID
	private Long shopId;
	//优先级
	private Integer priority;
	//创建时间
	private Date createTime;
	
	public Long getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ProductCategory [productCategoryId=" + productCategoryId + ", productCategoryName="
				+ productCategoryName + ", shopId=" + shopId + ", priority=" + priority + ", createTime=" + createTime
				+ "]";
	}
	
}
