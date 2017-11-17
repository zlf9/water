package com.zking.water.py.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.CostType;

/**
 * 水费单明细
 * 
 * @author Administrator
 *
 */
public class BillDetail extends BaseEntity {

	private static final long serialVersionUID = -2296397844711334505L;

	private Integer id;// 水费单明细编号
	private Integer amount;// 水量
	private Double price;// 单价
	private Double detailMoney;// 应收金额
	private Double realMoney;// 实收金额
	private Boolean balance;// 已结清
	private java.sql.Timestamp balanceDate;// 结清日期

	private Bill bill;// 对应水费单
	private CostType costType;// 费用项

	public BillDetail() {
	}

	public BillDetail(Integer amount, Double price, Double detailMoney, Double realMoney, Boolean balance) {
		this.amount = amount;
		this.price = price;
		this.detailMoney = detailMoney;
		this.realMoney = realMoney;
		this.balance = balance;
	}

	public BillDetail(Integer amount, Double price, Double detailMoney, Double realMoney, Boolean balance,
			java.sql.Timestamp balanceDate) {
		this.amount = amount;
		this.price = price;
		this.detailMoney = detailMoney;
		this.realMoney = realMoney;
		this.balance = balance;
		this.balanceDate = balanceDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDetailMoney() {
		return this.detailMoney;
	}

	public void setDetailMoney(Double detailMoney) {
		this.detailMoney = detailMoney;
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

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Boolean getBalance() {
		return balance;
	}

	public CostType getCostType() {
		return costType;
	}

	public void setCostType(CostType costType) {
		this.costType = costType;
	}

}
