package com.zking.water.base.biz.impl;

import java.util.List;

import com.zking.water.base.biz.IDictBiz;
import com.zking.water.base.dao.IDictDAO;
import com.zking.water.base.entity.Dict;

public class DictBizImpl extends BaseBizImpl<Dict> implements IDictBiz {
	private static final long serialVersionUID = -182905878034900399L;

	private IDictDAO dictDAO;

	public DictBizImpl() {
		super();
	}

	public void setDictDAO(IDictDAO dictDAO) {
		super.setBaseDAO(dictDAO);
		this.dictDAO = dictDAO;
	}

	@Override
	public List<Dict> findAllByDictName(String dictName) {
		return dictDAO.findAllByDictName(dictName);
	}

	@Override
	public Dict findByDictNameAndValue(Dict dict) {
		return dictDAO.findByDictNameAndValue(dict);
	}
}
