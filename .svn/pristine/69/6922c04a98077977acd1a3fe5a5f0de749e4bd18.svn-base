package com.zking.water.user.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.CostType;

/**
 * 提比提量
 * 
 * @author Administrator
 *
 */
public class Formula extends BaseEntity {

	private static final long serialVersionUID = 5594458320808720040L;

	private Integer id;// 提比提量编号
	private String allotText;// 提取值表述（仅供参考，如：80%）
	private Integer allotType;// 提取方式（0提量 1提比 2取剩余）
	private Integer allotValue;// 提取值（提量时表示水量，提比时表示百分比，取剩余时此字段无用）

	private User user;// 对应用户
	private CostType costType;// 用水类型（其实就是费用类型）

	public Formula() {
	}

	public Formula(Integer allotType) {
		this.allotType = allotType;
	}

	public Formula(String allotText, Integer allotType, Integer allotValue) {
		this.allotText = allotText;
		this.allotType = allotType;
		this.allotValue = allotValue;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAllotText() {
		return this.allotText;
	}

	public void setAllotText(String allotText) {
		this.allotText = allotText;
	}

	public Integer getAllotType() {
		return this.allotType;
	}

	public void setAllotType(Integer allotType) {
		this.allotType = allotType;
	}

	public Integer getAllotValue() {
		return this.allotValue;
	}

	public void setAllotValue(Integer allotValue) {
		this.allotValue = allotValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CostType getCostType() {
		return costType;
	}

	public void setCostType(CostType costType) {
		this.costType = costType;
	}

}
