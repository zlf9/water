package com.zking.water.sy.entity;

import java.util.HashSet;
import java.util.Set;

import com.zking.water.base.entity.BaseEntity;

/**
 * 费用类型
 * 
 * 注：含用水类型和附加费类型
 * 
 * @author Administrator
 *
 */
public class CostType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer id;// 费用类型编号
	private Integer kind;// 费用类型
	private String code;// 编码 （用水类型2位数，附加费3位数）
	private String costTypeName;// 费用类型名称（根据不同情况，建议分别为该字段取别名为：用水类型名称WaterTypeName、附加费类型名称SurchargeName）
	private String fullName;// 费用类型全称（主要用于附加费）
	private Double price;// 单价（元）
	private String surchargeText;// 附加费征收范围说明文字（缓存，仅有参考意义）
	private String remark;// 备注
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	private Set<CostType> costTypes = new HashSet<CostType>();

	public CostType() {
	}

	public CostType(Integer kind, String code, String costTypeName, Double price) {
		this.kind = kind;
		this.code = code;
		this.costTypeName = costTypeName;
		this.price = price;
	}

	public CostType(Integer kind, String code, String costTypeName, String fullName, Double price, String surchargeText,
			String remark, Boolean disabled) {
		this.kind = kind;
		this.code = code;
		this.costTypeName = costTypeName;
		this.fullName = fullName;
		this.price = price;
		this.surchargeText = surchargeText;
		this.remark = remark;
		this.disabled = disabled;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKind() {
		return this.kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCostTypeName() {
		return this.costTypeName;
	}

	public void setCostTypeName(String costTypeName) {
		this.costTypeName = costTypeName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSurchargeText() {
		return this.surchargeText;
	}

	public void setSurchargeText(String surchargeText) {
		this.surchargeText = surchargeText;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Set<CostType> getCostTypes() {
		return costTypes;
	}

	public void setCostTypes(Set<CostType> costTypes) {
		this.costTypes = costTypes;
	}

	@Override
	public String toString() {
		return "CostType [id=" + id + ", kind=" + kind + ", code=" + code + ", costTypeName=" + costTypeName
				+ ", fullName=" + fullName + ", price=" + price + ", surchargeText=" + surchargeText + ", remark="
				+ remark + ", disabled=" + disabled + "]";
	}

}
