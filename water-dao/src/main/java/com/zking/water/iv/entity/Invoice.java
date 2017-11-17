package com.zking.water.iv.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.Emp;

/**
 * 发票
 * 
 * @author Administrator
 *
 */
public class Invoice extends BaseEntity {

	private static final long serialVersionUID = 7086944535175034515L;

	private String invoiceNo;// 发票号码（一般是8位。批量收费时是10位，前8位相同，后2位是流水号。）
	private Integer invoiceType;// 发票类型（0普通发票 1增值税发票）
	private Boolean used;// 已使用
	private java.sql.Timestamp useDate;// 使用日期
	private Boolean invalid;// 已作废
	private java.sql.Timestamp invalidDate;// 作废日期
	private Boolean archived;// 已交票
	private java.sql.Timestamp archiveDate;// 交票日期

	private Emp emp;// 领用收费员
	private InInvoice inInvoice;// 入库批次
	private OutInvoice outInvoice;// 出库批次
	private Archive archive;// 交票批次

	public Invoice() {
	}

	public Invoice(String invoiceNo, Integer invoiceType, Boolean used, Boolean invalid, Boolean archived) {
		this.invoiceNo = invoiceNo;
		this.invoiceType = invoiceType;
		this.used = used;
		this.invalid = invalid;
		this.archived = archived;
	}

	public Invoice(String invoiceNo, Integer invoiceType, Boolean used, java.sql.Timestamp useDate, Boolean invalid,
			java.sql.Timestamp invalidDate, Boolean archived, java.sql.Timestamp archiveDate) {
		this.invoiceNo = invoiceNo;
		this.invoiceType = invoiceType;
		this.used = used;
		this.useDate = useDate;
		this.invalid = invalid;
		this.invalidDate = invalidDate;
		this.archived = archived;
		this.archiveDate = archiveDate;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Integer getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Boolean isUsed() {
		return this.used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public java.sql.Timestamp getUseDate() {
		return this.useDate;
	}

	public void setUseDate(java.sql.Timestamp useDate) {
		this.useDate = useDate;
	}

	public Boolean isInvalid() {
		return this.invalid;
	}

	public void setInvalid(Boolean invalid) {
		this.invalid = invalid;
	}

	public java.sql.Timestamp getInvalidDate() {
		return this.invalidDate;
	}

	public void setInvalidDate(java.sql.Timestamp invalidDate) {
		this.invalidDate = invalidDate;
	}

	public Boolean isArchived() {
		return this.archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
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

	public InInvoice getInInvoice() {
		return inInvoice;
	}

	public void setInInvoice(InInvoice inInvoice) {
		this.inInvoice = inInvoice;
	}

	public OutInvoice getOutInvoice() {
		return outInvoice;
	}

	public void setOutInvoice(OutInvoice outInvoice) {
		this.outInvoice = outInvoice;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public Boolean getUsed() {
		return used;
	}

	public Boolean getInvalid() {
		return invalid;
	}

	public Boolean getArchived() {
		return archived;
	}

}
