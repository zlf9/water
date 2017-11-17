package com.zking.water.iv.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.Emp;

/**
 * 交票记录
 * 
 * @author Administrator
 *
 */
public class Archive extends BaseEntity {

	private static final long serialVersionUID = -8092396166611718321L;

	private Integer id;// 交票记录编号
	private String startNo;// 起始号码
	private String endNo;// 结束号码
	private Integer counts;// 总张数
	private java.sql.Timestamp archiveDate;// 交票日期

	private Emp emp;// 领用人
	private InInvoice inInvoice;// 对应入库
	private Emp archiveEmp;// 收票人

	public Archive() {
	}

	public Archive(String startNo, String endNo, Integer counts) {
		this.startNo = startNo;
		this.endNo = endNo;
		this.counts = counts;
	}

	public Archive(String startNo, String endNo, Integer counts, java.sql.Timestamp archiveDate) {
		this.startNo = startNo;
		this.endNo = endNo;
		this.counts = counts;
		this.archiveDate = archiveDate;
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

	public java.sql.Timestamp getArchiveDate() {
		return this.archiveDate;
	}

	public void setArchiveDate(java.sql.Timestamp archiveDate) {
		this.archiveDate = archiveDate;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Emp getArchiveEmp() {
		return archiveEmp;
	}

	public void setArchiveEmp(Emp archiveEmp) {
		this.archiveEmp = archiveEmp;
	}

	public InInvoice getInInvoice() {
		return inInvoice;
	}

	public void setInInvoice(InInvoice inInvoice) {
		this.inInvoice = inInvoice;
	}

}
