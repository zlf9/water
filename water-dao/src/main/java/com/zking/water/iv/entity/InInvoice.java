package com.zking.water.iv.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.Emp;

/**
 * 发票入库
 * 
 * @author Administrator
 *
 */
public class InInvoice extends BaseEntity {

	private static final long serialVersionUID = 8817732086365073845L;

	private Integer id;// 发票入库编号
	private Integer invoiceType;// 发票类型（0普通发票 1增值税发票）
	private String startNo;// 开始号码
	private String endNo;// 结束号码
	private Integer counts;// 总张数
	private java.sql.Timestamp inDate;// 入库时间

	private Emp inEmp;// 入库操作人

	public InInvoice() {
	}

	public InInvoice(Integer invoiceType, String startNo, String endNo, Integer counts) {
		this.invoiceType = invoiceType;
		this.startNo = startNo;
		this.endNo = endNo;
		this.counts = counts;
	}

	public InInvoice(Integer invoiceType, String startNo, String endNo, Integer counts, java.sql.Timestamp inDate) {
		this.invoiceType = invoiceType;
		this.startNo = startNo;
		this.endNo = endNo;
		this.counts = counts;
		this.inDate = inDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getStartNo() {
		return this.startNo;
	}

	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	public String getEndNo() {
		return this.endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	public Integer getCounts() {
		return this.counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public java.sql.Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(java.sql.Timestamp inDate) {
		this.inDate = inDate;
	}

	public Emp getInEmp() {
		return inEmp;
	}

	public void setInEmp(Emp inEmp) {
		this.inEmp = inEmp;
	}

}
