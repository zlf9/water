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
	public String findFreetext() {
		try {
			session.setAttribute("orderLite", model);// 查询条件
			PageBean pageBean = handlerPageBean();
			List<OrderLite> orderLites = orderLiteBiz.findFreetext(model, pageBean);// 模糊查询返回快捷操作记录对象集合

			result = null == orderLites || pageBean.getTotalRecord() < 1 ? null : orderLites;// 如果没有查询到则为NULL,否则为快捷操作记录对象集合

			return "user_reportShortcut";
		} catch (Exception e) {
			throw new RuntimeException("模糊查询快捷操作记录失败", e);
		}
	}

}
