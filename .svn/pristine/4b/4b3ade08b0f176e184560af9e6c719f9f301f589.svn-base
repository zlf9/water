package com.zking.water.rd.biz.impl;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.rd.biz.IReadBiz;
import com.zking.water.rd.dao.IReadDAO;
import com.zking.water.rd.entity.Read;

public class ReadBizImpl extends BaseBizImpl<Read> implements IReadBiz {

	private static final long serialVersionUID = 2856407233732836888L;

	private IReadDAO readDAO;

	public ReadBizImpl() {
		super();
	}

	public void setReadDAO(IReadDAO readDAO) throws Exception {
		super.setBaseDAO(readDAO);
		this.readDAO = readDAO;
	}
}
