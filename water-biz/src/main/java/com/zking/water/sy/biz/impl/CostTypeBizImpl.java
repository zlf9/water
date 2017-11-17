package com.zking.water.sy.biz.impl;

import java.util.List;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.sy.biz.ICostTypeBiz;
import com.zking.water.sy.dao.ICostTypeDAO;
import com.zking.water.sy.entity.CostType;

public class CostTypeBizImpl extends BaseBizImpl<CostType> implements ICostTypeBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private ICostTypeDAO costTypeDAO;

	public CostTypeBizImpl() {
		super();
	}

	public void setCostTypeDAO(ICostTypeDAO costTypeDAO) {
		super.setBaseDAO(costTypeDAO);
		this.costTypeDAO = costTypeDAO;
	}

	@Override
	public List<CostType> findAllByKind(Integer kind) {
		return costTypeDAO.findAllByKind(kind);
	}
}
