package com.zking.water.user.biz;

import java.util.List;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.OrderLite;

/**
 * 快捷操作记录业务对象
 * 
 * @author Administrator
 *
 */
public interface IOrderLiteBiz extends IBaseBiz<OrderLite> {

	/**
	 * 模糊查询快捷操作记录
	 * 
	 * @param user
	 *            搜索条件
	 * @param pageBean
	 *            分页对象
	 * @return 查询出来的操作记录集合
	 * @throws Exception
	 */
	public List<OrderLite> findFreetext(OrderLite orderLite, PageBean pageBean) throws Exception;
}
