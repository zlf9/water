package com.zking.water.sy.dao;

import java.util.List;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.sy.entity.CostType;

/**
 * 费用类型数据访问对象
 * 
 * @author Administrator
 *
 */
public interface ICostTypeDAO extends IBaseDAO<CostType> {

	/**
	 * 根据费用类型(kind)查询全部
	 * 
	 * @param kind
	 * @return
	 */
	public List<CostType> findAllByKind(Integer kind);

}
