package com.zking.water.user.entity;

import java.util.HashSet;
import java.util.Set;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.py.entity.Pay;
import com.zking.water.rd.entity.Read;
import com.zking.water.rd.entity.Volume;

/**
 * 用户
 * 
 * 注：即用水户
 * 
 * @author Administrator
 *
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = 1823238414422512300L;

	private String userNo;// 用户编码（规则：共10位，前2位表示辖区，后8位是全局流水号）
	private String userName;// 用户姓名（最多40个汉字）
	private String abc;// 简码
	private java.sql.Timestamp createDate;// 创建日期
	private String address;// 联系地址（即用水地址）
	private String phone;// 联系电话
	private String smsphone;// 短信电话（发短信用的电话）
	private Integer areaId;// 所属辖区
	private Integer userType;// 用户类型（公户、私户）
	private Integer payType;// 收款方式（坐收、走收、银行代扣）
	private String bankName;// 开户银行
	private String bankNum;// 银行账号
	private String formula;// 提比提量值
	private Double userMoney;// 用户金额（正数是预缴费余额、负数是欠费金额）
	private String docNum;// 档案编号
	private String pwd;// 密码（MD5加密。暂时无用，为将来的移动互联网查询预留的字段）
	private String contractNum;// 合同编号（指供水协议的合同编号）
	private java.sql.Timestamp contractDate;// 合同签订日期
	private Integer volumeOrderIndex;// 在表册中的序号
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	private Meter meter;
	private Volume volume;// 所属表册

	private Set<Formula> formulas = new HashSet<Formula>();
	private Set<Read> reads = new HashSet<Read>();
	private Set<Pay> pays = new HashSet<Pay>();

	public User() {
	}

	public User(String userNo, String userName, String address, String phone, String smsphone, Integer areaId,
			Integer userType, Integer payType, String formula) {
		this.userNo = userNo;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
		this.smsphone = smsphone;
		this.areaId = areaId;
		this.userType = userType;
		this.payType = payType;
		this.formula = formula;
	}

	public User(String userNo, String userName, String abc, java.sql.Timestamp createDate, String address, String phone,
			String smsphone, Integer areaId, Integer userType, Integer payType, String bankName, String bankNum,
			String formula, Double userMoney, String docNum, String pwd, String contractNum,
			java.sql.Timestamp contractDate, Integer volumeOrderIndex, Boolean disabled) {
		this.userNo = userNo;
		this.userName = userName;
		this.abc = abc;
		this.createDate = createDate;
		this.address = address;
		this.phone = phone;
		this.smsphone = smsphone;
		this.areaId = areaId;
		this.userType = userType;
		this.payType = payType;
		this.bankName = bankName;
		this.bankNum = bankNum;
		this.formula = formula;
		this.userMoney = userMoney;
		this.docNum = docNum;
		this.pwd = pwd;
		this.contractNum = contractNum;
		this.contractDate = contractDate;
		this.volumeOrderIndex = volumeOrderIndex;
		this.disabled = disabled;
	}

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAbc() {
		return this.abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSmsphone() {
		return this.smsphone;
	}

	public void setSmsphone(String smsphone) {
		this.smsphone = smsphone;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNum() {
		return this.bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Double getUserMoney() {
		return this.userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	public String getDocNum() {
		return this.docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContractNum() {
		return this.contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public java.sql.Timestamp getContractDate() {
		return this.contractDate;
	}

	public void setContractDate(java.sql.Timestamp contractDate) {
		this.contractDate = contractDate;
	}

	public Integer getVolumeOrderIndex() {
		return this.volumeOrderIndex;
	}

	public void setVolumeOrderIndex(Integer volumeOrderIndex) {
		this.volumeOrderIndex = volumeOrderIndex;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	public Set<Formula> getFormulas() {
		return formulas;
	}

	public void setFormulas(Set<Formula> formulas) {
		this.formulas = formulas;
	}

	public Set<Read> getReads() {
		return reads;
	}

	public void setReads(Set<Read> reads) {
		this.reads = reads;
	}

	public Set<Pay> getPays() {
		return pays;
	}

	public void setPays(Set<Pay> pays) {
		this.pays = pays;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userName=" + userName + ", abc=" + abc + ", createDate=" + createDate
				+ ", address=" + address + ", phone=" + phone + ", smsphone=" + smsphone + ", areaId=" + areaId
				+ ", userType=" + userType + ", payType=" + payType + ", bankName=" + bankName + ", bankNum=" + bankNum
				+ ", formula=" + formula + ", userMoney=" + userMoney + ", docNum=" + docNum + ", pwd=" + pwd
				+ ", contractNum=" + contractNum + ", contractDate=" + contractDate + ", volumeOrderIndex="
				+ volumeOrderIndex + ", disabled=" + disabled + ", meter=" + meter + ", volume=" + volume
				+ ", formulas=" + formulas + ", reads=" + reads + ", pays=" + pays + "]";
	}

}
