package com.zking.water.user.biz.impl;

import java.util.List;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.base.entity.PageBean;
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

	@Override
	public List<OrderLite> findFreetext(OrderLite orderLite, PageBean pageBean) {
		return orderLiteDAO.findFreetext(orderLite, pageBean);
	}
}
