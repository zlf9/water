package com.zking.water.py.entity;

import java.util.HashSet;
import java.util.Set;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.rd.entity.Read;

/**
 * 水费单
 * 
 * @author Administrator
 *
 */
public class Bill extends BaseEntity {

	private static final long serialVersionUID = -5000306492166727534L;

	private String billNo;// 水费单号（规则：SF0100000987-201308，共19位，SF+用户编码+年月）
	private java.sql.Timestamp createDate;// 建单日期
	private Double billMoney;// 应交金额
	private Double realMoney;// 实交金额
	private Boolean balance;// 已结清
	private java.sql.Timestamp balanceDate;// 结清日期

	private Read read;// 对应抄表数据

	private Set<BillDetail> billDetails = new HashSet<BillDetail>();

	public Bill() {
	}

	public Bill(String billNo, Double billMoney, Double realMoney, Boolean balance) {
		this.billNo = billNo;
		this.billMoney = billMoney;
		this.realMoney = realMoney;
		this.balance = balance;
	}

	public Bill(String billNo, java.sql.Timestamp createDate, Double billMoney, Double realMoney, Boolean balance,
			java.sql.Timestamp balanceDate) {
		this.billNo = billNo;
		this.createDate = createDate;
		this.billMoney = billMoney;
		this.realMoney = realMoney;
		this.balance = balance;
		this.balanceDate = balanceDate;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public Double getBillMoney() {
		return this.billMoney;
	}

	public void setBillMoney(Double billMoney) {
		this.billMoney = billMoney;
	}

	public Double getRealMoney() {
		return this.realMoney;
	}

	public void setRealMoney(Double realMoney) {
		this.realMoney = realMoney;
	}

	public Boolean isBalance() {
		return this.balance;
	}

	public void setBalance(Boolean balance) {
		this.balance = balance;
	}

	public java.sql.Timestamp getBalanceDate() {
		return this.balanceDate;
	}

	public void setBalanceDate(java.sql.Timestamp balanceDate) {
		this.balanceDate = balanceDate;
	}

	public Read getRead() {
		return read;
	}

	public void setRead(Read read) {
		this.read = read;
	}

	public Boolean getBalance() {
		return balance;
	}

	public Set<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(Set<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

}
