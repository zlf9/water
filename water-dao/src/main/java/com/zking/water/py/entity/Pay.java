package com.zking.water.py.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.iv.entity.Invoice;
import com.zking.water.sy.entity.Emp;
import com.zking.water.user.entity.User;

/**
 * 交费单
 * 
 * @author Administrator
 *
 */
public class Pay extends BaseEntity {

	private static final long serialVersionUID = -1877818067722914546L;

	private String payNo;// 交费单号（规则：JF0100000987-201401-02，共22位。JF用户编码-年月-按月流水）
	private Integer payType;// 交费方式（坐收 走收 银行代扣）
	private java.sql.Timestamp payDate;// 交费日期
	private Double payMoney;// 交费金额
	private Double useMoney;// 已用金额

	private User user;// 对应用户
	private Invoice invoice;// 对应发票
	private Emp emp;// 收费员

	public Pay() {
	}

	public Pay(String payNo, Integer payType, Invoice invoice, Double payMoney, Double useMoney) {
		this.payNo = payNo;
		this.payType = payType;
		this.invoice = invoice;
		this.payMoney = payMoney;
		this.useMoney = useMoney;
	}

	public Pay(String payNo, Integer payType, java.sql.Timestamp payDate, Invoice invoice, Double payMoney,
			Double useMoney) {
		this.payNo = payNo;
		this.payType = payType;
		this.payDate = payDate;
		this.invoice = invoice;
		this.payMoney = payMoney;
		this.useMoney = useMoney;
	}

	public String getPayNo() {
		return this.payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public java.sql.Timestamp getPayDate() {
		return this.payDate;
	}

	public void setPayDate(java.sql.Timestamp payDate) {
		this.payDate = payDate;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Double getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Double getUseMoney() {
		return this.useMoney;
	}

	public void setUseMoney(Double useMoney) {
		this.useMoney = useMoney;
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

}
