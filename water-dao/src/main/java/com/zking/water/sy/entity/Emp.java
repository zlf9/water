package com.zking.water.sy.entity;

import com.zking.water.base.entity.BaseEntity;

/**
 * 员工
 * 
 * @author Administrator
 *
 */
public class Emp extends BaseEntity {

	private static final long serialVersionUID = -4131450515774462076L;

	private Integer id;// 员工编号
	private String empName;// 员工名称
	private String empNo;// 工号
	private String pwd;// 密码 （MD5加密）
	private Integer deptId;// 部门
	private String remark;// 备注
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	public Emp() {
	}

	public Emp(String empName, String empNo, String pwd, Integer deptId) {
		this.empName = empName;
		this.empNo = empNo;
		this.pwd = pwd;
		this.deptId = deptId;
	}

	public Emp(String empName, String empNo, String pwd, Integer deptId, String remark, Boolean disabled) {
		this.empName = empName;
		this.empNo = empNo;
		this.pwd = pwd;
		this.deptId = deptId;
		this.remark = remark;
		this.disabled = disabled;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

}
