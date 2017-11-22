package com.zking.water.user.dao.impl;

import java.util.List;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.dao.ISmsDAO;
import com.zking.water.user.entity.Sms;

public class SmsDAOImpl extends BaseDAOImpl<Sms> implements ISmsDAO {

	private static final long serialVersionUID = 1L;

	public SmsDAOImpl() {
		super();
	}

	@Override
	public List<Sms> findAll(PageBean pageBean) {
		return super.executeQuery("form Sms s left join fetch s.user u", null, pageBean);
	}
}
