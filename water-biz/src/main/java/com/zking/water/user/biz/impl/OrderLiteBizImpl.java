package com.zking.water.user.biz.impl;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.user.biz.IOrderLiteBiz;
import com.zking.water.user.dao.IOrderLiteDAO;
import com.zking.water.user.entity.OrderLite;

public class OrderLiteBizImpl extends BaseBizImpl<OrderLite> implements IOrderLiteBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private IOrderLiteDAO orderLiteDAO;

	public OrderLiteBizImpl() {
		super();
	}

	public void setOrderLiteDAO(IOrderLiteDAO orderLiteDAO) {
		super.setBaseDAO(orderLiteDAO);
		this.orderLiteDAO = orderLiteDAO;
	}
}
