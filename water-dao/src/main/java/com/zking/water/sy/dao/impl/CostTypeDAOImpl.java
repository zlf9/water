package com.zking.water.sy.dao.impl;

import java.util.List;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.sy.dao.ICostTypeDAO;
import com.zking.water.sy.entity.CostType;

@SuppressWarnings("unchecked")
public class CostTypeDAOImpl extends BaseDAOImpl<CostType> implements ICostTypeDAO {

	private static final long serialVersionUID = 1L;

	public CostTypeDAOImpl() {
		super();
	}

	@Override
	public List<CostType> findAllByKind(Integer kind) {
		try {
			String hql = "from CostType where kind = ?";
			return (List<CostType>) hibernateTemplate.find(hql, kind);
		} catch (Exception e) {
			throw new RuntimeException("根据费用类型(kind)查询全部失败", e);
		}
	}

}
