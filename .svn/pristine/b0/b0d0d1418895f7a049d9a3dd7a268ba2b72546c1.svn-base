package com.zking.water.tag.ui;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.StringUtils;


/**
 * 自定义下拉框标签，含自动选中功能
 */
public class SelectTag extends BodyTagSupport {

	private static final long serialVersionUID = 5374847913869814413L;

	// select标签相关的属性
	private String name;
	private String componetId;
	private String styleClass;
	private String style;
	private String onchange;

	// 一个项的值和文本
	private String headValue;
	private String headText;

	// 数据源
	private List<Object> items;
	private String valueKey;// 制定某个对象属性作为value
	private String textKey;// 制定某个对象属性作为text
	private String selectedValue;// 根据指定的值选中某个项

	public SelectTag() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComponetId() {
		return componetId;
	}

	public void setComponetId(String componetId) {
		this.componetId = componetId;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getHeadValue() {
		return headValue;
	}

	public void setHeadValue(String headValue) {
		this.headValue = headValue;
	}

	public String getHeadText() {
		return headText;
	}

	public void setHeadText(String headText) {
		this.headText = headText;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	public String getValueKey() {
		return valueKey;
	}

	public void setValueKey(String valueKey) {
		this.valueKey = valueKey;
	}

	public String getTextKey() {
		return textKey;
	}

	public void setTextKey(String textKey) {
		this.textKey = textKey;
	}

	public String getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.write(getSelectString());
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getSelectString() throws Exception {
		StringBuffer sb = new StringBuffer();

		// 生成开始标签
		sb.append("<select");
		if (StringUtils.isNotBlank(name)) {
			sb.append(" name = '" + name + "'");
		}
		if (StringUtils.isNotBlank(componetId)) {
			sb.append(" id = '" + componetId + "'");
		}
		if (StringUtils.isNotBlank(styleClass)) {
			sb.append(" class = '" + styleClass + "'");
		}
		if (StringUtils.isNotBlank(style)) {
			sb.append(" style = '" + style + "'");
		}
		if (StringUtils.isNotBlank(onchange)) {
			sb.append(" onchange = '" + onchange + "'");
		}
		sb.append(">");

		// 生成第一个项
		if (StringUtils.isNotBlank(headText)) {
			sb.append("<option value='" + StringUtils.trimToEmpty(headValue)
					+ "'>" + headText);
			sb.append("</option>");
		}

		// 生成中间的项
		for (Object obj : items) {
			Object value = BeanUtilsBean.getInstance().getPropertyUtils()
					.getProperty(obj, valueKey);
			Object text = BeanUtilsBean.getInstance().getPropertyUtils()
					.getProperty(obj, textKey);
			if (null != selectedValue && value.equals(selectedValue)) {
				sb.append("<option selected");
				sb.append(" value = '" + value + "'");
				sb.append(">" + text);
				sb.append("</option>");
			} else if (null != selectedValue
					&& value.toString().equals(selectedValue.toString())) {
				sb.append("<option selected");
				sb.append(" value = '" + value + "'");
				sb.append(">" + text);
				sb.append("</option>");
			} else {
				sb.append("<option");
				sb.append(" value = '" + value + "'");
				sb.append(">" + text);
				sb.append("</option>");
			}
		}

		// 生成结束标签
		sb.append("</select>");

		return sb.toString();
	}
}