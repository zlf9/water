package com.zking.water.py.biz.impl;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.py.biz.IBillBiz;
import com.zking.water.py.dao.IBillDAO;
import com.zking.water.py.entity.Bill;

public class BillBizImpl extends BaseBizImpl<Bill> implements IBillBiz {

	private static final long serialVersionUID = 3199381869360808661L;

	private IBillDAO billDAO;

	public BillBizImpl() {
		super();
	}

	public void setBillDAO(IBillDAO billDAO) {
		super.setBaseDAO(billDAO);
		this.billDAO = billDAO;
	}

}
