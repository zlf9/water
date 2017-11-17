package com.zking.water.sy.entity;

import com.zking.water.base.entity.BaseEntity;

/**
 * 附加费关联
 * 
 * @author Administrator
 *
 */
public class Surcharge extends BaseEntity {

	private static final long serialVersionUID = -3700752714722601785L;

	private Integer id;// 附加费关联编号
	private Integer surchargeId;// 附加费ID（其实就是费用类型ID）
	private Integer waterTypeId;// 用水类型ID（其实就是费用类型ID）

	public Surcharge() {
	}

	public Surcharge(Integer surchargeId, Integer waterTypeId) {
		this.surchargeId = surchargeId;
		this.waterTypeId = waterTypeId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSurchargeId() {
		return this.surchargeId;
	}

	public void setSurchargeId(Integer surchargeId) {
		this.surchargeId = surchargeId;
	}

	public Integer getWaterTypeId() {
		return this.waterTypeId;
	}

	public void setWaterTypeId(Integer waterTypeId) {
		this.waterTypeId = waterTypeId;
	}

}
