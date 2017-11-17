package com.zking.water.base.action;

import org.apache.commons.lang3.StringUtils;

import com.zking.water.base.biz.IDictBiz;
import com.zking.water.base.entity.Dict;

public class DictAction extends BaseAction<Dict> {
	private IDictBiz dictBiz;// 字典业务对象

	public DictAction() {
		super();
	}

	public void setDictBiz(IDictBiz dictBiz) {
		this.dictBiz = dictBiz;
	}

	/**
	 * 根据字典名字得到字典对象集合
	 */
	public String findAllByDictName() throws Exception {
		result = StringUtils.isNotBlank(model.getDictName()) ? dictBiz.findAllByDictName(model.getDictName()) : null;
		return NONE;
	}

	/**
	 * 根据字典名字和字典值得到字典文本
	 */
	public String findByDictNameAndValue() throws Exception {
		result = dictBiz.findByDictNameAndValue(model).getText();
		return NONE;
	}
}
