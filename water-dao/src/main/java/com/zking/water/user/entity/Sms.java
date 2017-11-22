package com.zking.water.user.entity;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.sy.entity.Emp;

/**
 * 短信群发记录
 * 
 * @author Administrator
 *
 */
public class Sms extends BaseEntity {

	private static final long serialVersionUID = 4590446088862095616L;

	private Integer id;// 短信群发记录编号
	private java.sql.Timestamp sendTime;// 发送时间
	private String message;// 发送内容（群发内容）
	private Integer typee;// 发送类型（0给所有用户发 1只给欠费用户发）

	private Emp emp;// 操作人

	public Sms() {
	}

	public Sms(String message, Integer typee) {
		this.message = message;
		this.typee = typee;
	}

	public Sms(java.sql.Timestamp sendTime, String message, Integer typee) {
		this.sendTime = sendTime;
		this.message = message;
		this.typee = typee;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(java.sql.Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getTypee() {
		return this.typee;
	}

	public void setTypee(Integer typee) {
		this.typee = typee;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
