package com.zking.water.rd.entity;

import java.util.HashSet;
import java.util.Set;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.py.entity.Bill;
import com.zking.water.sy.entity.Emp;
import com.zking.water.user.entity.User;

/**
 * 抄表数据
 * 
 * @author Administrator
 *
 */
public class Read extends BaseEntity {

	private static final long serialVersionUID = 9166664518892834201L;

	private Integer id;// 抄表数据编号
	private Integer readYear;// 抄表年份
	private Integer readMonth;// 抄表月份
	private java.sql.Timestamp readDate;// 抄表时间
	private Integer preValue;// 上月表码
	private Boolean enter;// 已输入
	private Integer curValue;// 本月表码
	private Boolean dial;// 转表
	private Integer amount;// 用水量
	private String formula;// 套用提比提量值
	private Boolean audit;// 已审核
	private java.sql.Timestamp auditDate;// 审核日期

	private User user;// 对应用户
	private Emp readEmp;// 抄表人
	private Emp auditEmp;// 审核人

	private Set<Bill> bills = new HashSet<Bill>();

	public Read() {
	}

	public Read(Integer readYear, Integer readMonth, Integer preValue, Boolean enter, Integer curValue, Boolean dial,
			Integer amount, Boolean audit) {
		this.readYear = readYear;
		this.readMonth = readMonth;
		this.preValue = preValue;
		this.enter = enter;
		this.curValue = curValue;
		this.dial = dial;
		this.amount = amount;
		this.audit = audit;
	}

	public Read(Integer readYear, Integer readMonth, java.sql.Timestamp readDate, Integer preValue, Boolean enter,
			Integer curValue, Boolean dial, Integer amount, String formula, Boolean audit,
			java.sql.Timestamp auditDate) {
		this.readYear = readYear;
		this.readMonth = readMonth;
		this.readDate = readDate;
		this.preValue = preValue;
		this.enter = enter;
		this.curValue = curValue;
		this.dial = dial;
		this.amount = amount;
		this.formula = formula;
		this.audit = audit;
		this.auditDate = auditDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReadYear() {
		return this.readYear;
	}

	public void setReadYear(Integer readYear) {
		this.readYear = readYear;
	}

	public Integer getReadMonth() {
		return this.readMonth;
	}

	public void setReadMonth(Integer readMonth) {
		this.readMonth = readMonth;
	}

	public java.sql.Timestamp getReadDate() {
		return this.readDate;
	}

	public void setReadDate(java.sql.Timestamp readDate) {
		this.readDate = readDate;
	}

	public Integer getPreValue() {
		return this.preValue;
	}

	public void setPreValue(Integer preValue) {
		this.preValue = preValue;
	}

	public Boolean isEnter() {
		return this.enter;
	}

	public void setEnter(Boolean enter) {
		this.enter = enter;
	}

	public Boolean getEnter() {
		return enter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getDial() {
		return dial;
	}

	public Boolean getAudit() {
		return audit;
	}

	public Integer getCurValue() {
		return this.curValue;
	}

	public void setCurValue(Integer curValue) {
		this.curValue = curValue;
	}

	public Boolean isDial() {
		return this.dial;
	}

	public void setDial(Boolean dial) {
		this.dial = dial;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Boolean isAudit() {
		return this.audit;
	}

	public void setAudit(Boolean audit) {
		this.audit = audit;
	}

	public java.sql.Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(java.sql.Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public Emp getReadEmp() {
		return readEmp;
	}

	public void setReadEmp(Emp readEmp) {
		this.readEmp = readEmp;
	}

	public Emp getAuditEmp() {
		return auditEmp;
	}

	public void setAuditEmp(Emp auditEmp) {
		this.auditEmp = auditEmp;
	}

}
