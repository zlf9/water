package com.zking.water.rd.entity;

import java.util.HashSet;
import java.util.Set;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.user.entity.User;

/**
 * 表册
 * 
 * @author Administrator
 *
 */
public class Volume extends BaseEntity {

	private static final long serialVersionUID = 3908369459642365163L;

	private Integer id;// 表册编号
	private String volumeName;// 表册名称
	private Integer areaId;// 所属辖区
	private Integer orderIndex;// 排列顺序
	private String remark;// 备注
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	private Set<User> users = new HashSet<User>();

	public Volume() {
	}

	public Volume(String volumeName, Integer areaId) {
		this.volumeName = volumeName;
		this.areaId = areaId;
	}

	public Volume(String volumeName, Integer areaId, Integer orderIndex, String remark, Boolean disabled) {
		this.volumeName = volumeName;
		this.areaId = areaId;
		this.orderIndex = orderIndex;
		this.remark = remark;
		this.disabled = disabled;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVolumeName() {
		return this.volumeName;
	}

	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
