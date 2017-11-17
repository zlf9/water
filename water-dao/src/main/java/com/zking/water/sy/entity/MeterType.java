package com.zking.water.sy.entity;

import java.util.HashSet;
import java.util.Set;

import com.zking.water.base.entity.BaseEntity;
import com.zking.water.user.entity.Meter;

/**
 * 水表型号
 * 
 * @author Administrator
 *
 */
public class MeterType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer id;// 编号
	private String meterTypeName;// 水表型号名称
	private Integer aperture;// 口径
	private Integer mavValue;// 最大表码值（吨。此种水表的默认最大表码值）
	private Integer minValue;// 下限设置 起始底码（吨。仅供参考，不做实际用途）
	private Integer life;// 周检年限（月）
	private String remark;// 备注
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	private Set<Meter> meters = new HashSet<Meter>();

	public MeterType() {
	}

	public MeterType(String meterTypeName, Integer aperture, Integer mavValue, Integer life) {
		this.meterTypeName = meterTypeName;
		this.aperture = aperture;
		this.mavValue = mavValue;
		this.life = life;
	}

	public MeterType(String meterTypeName, Integer aperture, Integer mavValue, Integer minValue, Integer life,
			String remark, Boolean disabled) {
		this.meterTypeName = meterTypeName;
		this.aperture = aperture;
		this.mavValue = mavValue;
		this.minValue = minValue;
		this.life = life;
		this.remark = remark;
		this.disabled = disabled;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeterTypeName() {
		return this.meterTypeName;
	}

	public void setMeterTypeName(String meterTypeName) {
		this.meterTypeName = meterTypeName;
	}

	public Integer getAperture() {
		return this.aperture;
	}

	public void setAperture(Integer aperture) {
		this.aperture = aperture;
	}

	public Integer getMavValue() {
		return this.mavValue;
	}

	public void setMavValue(Integer mavValue) {
		this.mavValue = mavValue;
	}

	public Integer getMinValue() {
		return this.minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getLife() {
		return this.life;
	}

	public void setLife(Integer life) {
		this.life = life;
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

	public Set<Meter> getMeters() {
		return meters;
	}

	public void setMeters(Set<Meter> meters) {
		this.meters = meters;
	}

}
