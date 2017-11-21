package com.zking.water.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.dao.IOrderLiteDAO;
import com.zking.water.user.entity.OrderLite;

public class OrderLiteDAOImpl extends BaseDAOImpl<OrderLite> implements IOrderLiteDAO {

	private static final long serialVersionUID = 1L;

	public OrderLiteDAOImpl() {
		super();
	}

	/**
	 * 模糊查询 且支持分页
	 */
	@Override
	public List<OrderLite> findFreetext(OrderLite orderLite, PageBean pageBean) {
		try {
			String hql = "from OrderLite where 1=1";
			Map<String, Object> args = new HashMap<String, Object>();

			if (null != orderLite.getEmp() && null != orderLite.getEmp().getId() && orderLite.getEmp().getId() > 0) {
				hql += " and empId = :empId";
				args.put("empId", orderLite.getEmp().getId());
			}
			if (null != orderLite.getOrderType() && orderLite.getOrderType() > 0) {
				hql += " and orderType = :orderType";
				args.put("orderType", orderLite.getOrderType());
			}
			if (null != orderLite.getLeftDatee()) {
				hql += " and datee >= :leftDatee";
				args.put("leftDatee", orderLite.getLeftDatee());
			}
			if (null != orderLite.getRightDatee()) {
				hql += " and datee <= :rightDatee";
				args.put("rightDatee", orderLite.getRightDatee());
			}

			hql += " order by datee desc";

			// Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
			// Query<OrderLite> query = session.createQuery(hql);
			// // 设置初始下标
			// query.setFirstResult(pageBean.getStartIndex());
			// // 设置要显示的数量
			// query.setMaxResults(pageBean.getPageSize());
			//
			// // 根据相关条件查询出快捷操作记录集合
			// List<OrderLite> orderLites = query.list();
			// pageBean.setTotalRecord(orderLites.size());

			return this.executeQuery(hql, args, pageBean);
		} catch (Exception e) {
			throw new RuntimeException("模糊查询快捷操作记录失败", e);
		}
	}

}
