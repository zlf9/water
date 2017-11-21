package com.zking.water.user.dao;

import java.util.List;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.OrderLite;

/**
 * 快捷操作记录数据访问对象
 * 
 * @author Administrator
 *
 */
public interface IOrderLiteDAO extends IBaseDAO<OrderLite> {

	/**
	 * 模糊查询
	 * 
	 * @param user
	 *            搜索条件
	 * @param pageBean
	 *            分页对象
	 * @return 查询出来的操作记录集合
	 * @throws Exception
	 */
	public List<OrderLite> findFreetext(OrderLite orderLite, PageBean pageBean);
}
