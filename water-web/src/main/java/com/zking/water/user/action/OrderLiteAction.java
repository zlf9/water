package com.zking.water.user.action;

import java.util.List;

import com.zking.water.base.action.BaseAction;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.biz.IOrderLiteBiz;
import com.zking.water.user.entity.OrderLite;

public class OrderLiteAction extends BaseAction<OrderLite> {
	private IOrderLiteBiz orderLiteBiz;

	public OrderLiteAction() {
		super();
	}

	public void setOrderLiteBiz(IOrderLiteBiz orderLiteBiz) {
		this.orderLiteBiz = orderLiteBiz;
	}

	/**
	 * 模糊查询快捷操作记录
	 * 
	 * @return
	 */
	public String findFreetext() throws Exception {
		session.setAttribute("orderLite", model);// 查询条件
		PageBean pageBean = handlerPageBean();
		List<OrderLite> users = orderLiteBiz.findFreetext(model, pageBean);// 模糊查询返回快捷操作记录对象集合

		result = null == users || pageBean.getTotalRecord() < 1 ? null
				: pageBean.getTotalRecord() == 1 ? users.get(0) : users;// 如果没有查询到则为NULL,查询到只有一个则为快捷操作记录对象,查询到多个则为快捷操作记录对象集合

		return "user_reportShortcut";
	}

}
