package com.zking.water.user.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.Emp;

/**
 * 快捷操作记录
 * 
 * @author Administrator
 *
 */
public class OrderLite extends BaseEntity {

	private static final long serialVersionUID = -503370677947910118L;

	private Integer id;// 快捷操作记录编号
	private Integer orderType;// 工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
	private java.sql.Timestamp datee;// 操作时间
	private String description;// 说明

	private User user;// 对应用户
	private Emp emp;// 操作人

	// 模糊查询属性
	private java.sql.Timestamp leftDatee;// 左边的操作时间
	private java.sql.Timestamp rightDatee;// 右边的操作时间

	public OrderLite() {
	}

	public OrderLite(Integer orderType) {
		this.orderType = orderType;
	}

	public OrderLite(Integer orderType, java.sql.Timestamp datee, String description) {
		this.orderType = orderType;
		this.datee = datee;
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public java.sql.Timestamp getDatee() {
		return this.datee;
	}

	public void setDatee(java.sql.Timestamp datee) {
		this.datee = datee;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public java.sql.Timestamp getLeftDatee() {
		return leftDatee;
	}

	public void setLeftDatee(java.sql.Timestamp leftDatee) {
		this.leftDatee = leftDatee;
	}

	public java.sql.Timestamp getRightDatee() {
		return rightDatee;
	}

	public void setRightDatee(java.sql.Timestamp rightDatee) {
		this.rightDatee = rightDatee;
	}

}
