package com.zking.water.user.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.MeterType;

/**
 * 水表
 * 
 * @author Administrator
 *
 */
public class Meter extends BaseEntity {

	private static final long serialVersionUID = 2005540158877169730L;

	private String meterNo;// 水表编号（14位，规则：M+10位用户编码+杠+2位流水号。如：M0100000987-02，表示用户0100000987的第2块水表，此用户换过一次表。）
	private String meterName;// 表身码
	private java.sql.Timestamp setupDate;// 装表日期
	private String factory;// 水表厂家
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	private MeterType meterType;// 所属水表型号
	private User user;// 所属用户

	public Meter() {
	}

	public Meter(String meterNo, String meterName, String factory) {
		this.meterNo = meterNo;
		this.meterName = meterName;
		this.factory = factory;
	}

	public Meter(String meterNo, String meterName, java.sql.Timestamp setupDate, String factory, Boolean disabled) {
		this.meterNo = meterNo;
		this.meterName = meterName;
		this.setupDate = setupDate;
		this.factory = factory;
		this.disabled = disabled;
	}

	public String getMeterNo() {
		return this.meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getMeterName() {
		return this.meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public java.sql.Timestamp getSetupDate() {
		return this.setupDate;
	}

	public void setSetupDate(java.sql.Timestamp setupDate) {
		this.setupDate = setupDate;
	}

	public String getFactory() {
		return this.factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public MeterType getMeterType() {
		return meterType;
	}

	public void setMeterType(MeterType meterType) {
		this.meterType = meterType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
