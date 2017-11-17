package com.zking.water.base.entity;

/**
 * 数据字典对象
 * 
 * @author Administrator
 *
 */
public class Dict extends BaseEntity {

	private static final long serialVersionUID = 1621105593057942316L;

	private Integer dictId;// 字典编号
	private String dictName;// 字典名称
	private String text;// 字典文本
	private Integer value;// 字典值
	private Integer position;// 所在位置
	private String remark;// 备注
	private Boolean disabled;// 禁用 （0可使用 1已禁用）

	public Dict() {
	}

	public Dict(String dictName, Integer value) {
		this.dictName = dictName;
		this.value = value;
	}

	public Dict(String dictName, String text, Integer value) {
		this.dictName = dictName;
		this.text = text;
		this.value = value;
	}

	public Dict(String dictName, String text, Integer value, Integer position, String remark) {
		this.dictName = dictName;
		this.text = text;
		this.value = value;
		this.position = position;
		this.remark = remark;
	}

	public Integer getDictId() {
		return this.dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

}
