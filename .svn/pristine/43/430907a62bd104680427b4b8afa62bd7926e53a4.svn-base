package com.zking.water.iv.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.Emp;

/**
 * 发票出库
 * 
 * @author Administrator
 *
 */
public class OutInvoice extends BaseEntity {

	private static final long serialVersionUID = 2799357612847977282L;

	private Integer id;// 发票出库编号
	private String startNo;// 开始号码
	private String endNo;// 结束号码
	private Integer counts;// 总张数
	private java.sql.Timestamp outDate;// 出库日期

	private Emp emp;// 领用人
	private InInvoice inInvoice;// 对应入库
	private Emp outEmp;// 出库操作人

	public OutInvoice() {
	}

	public OutInvoice(String startNo, String endNo, Integer counts) {
		this.startNo = startNo;
		this.endNo = endNo;
		this.counts = counts;
	}

	public OutInvoice(String startNo, String endNo, Integer counts, java.sql.Timestamp outDate) {
		this.startNo = startNo;
		this.endNo = endNo;
		this.counts = counts;
		this.outDate = outDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public java.sql.Timestamp getOutDate() {
		return this.outDate;
	}

	public void setOutDate(java.sql.Timestamp outDate) {
		this.outDate = outDate;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public InInvoice getInInvoice() {
		return inInvoice;
	}

	public void setInInvoice(InInvoice inInvoice) {
		this.inInvoice = inInvoice;
	}

	public Emp getOutEmp() {
		return outEmp;
	}

	public void setOutEmp(Emp outEmp) {
		this.outEmp = outEmp;
	}

}
