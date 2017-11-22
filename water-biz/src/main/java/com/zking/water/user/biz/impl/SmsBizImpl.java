package com.zking.water.user.biz.impl;

import java.util.List;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.biz.ISmsBiz;
import com.zking.water.user.dao.ISmsDAO;
import com.zking.water.user.entity.Sms;

public class SmsBizImpl extends BaseBizImpl<Sms> implements ISmsBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private ISmsDAO smsDAO;

	public SmsBizImpl() {
		super();
	}

	public void setSmsDAO(ISmsDAO smsDAO) {
		super.setBaseDAO(smsDAO);
		this.smsDAO = smsDAO;
	}

	@Override
	public List<Sms> findAll(PageBean pageBean) {
		return smsDAO.findAll(pageBean);
	}
}
