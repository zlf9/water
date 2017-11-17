package com.zking.water.sy.action;

import com.zking.water.base.action.BaseAction;
import com.zking.water.sy.biz.ICostTypeBiz;
import com.zking.water.sy.entity.CostType;

public class CostTypeAction extends BaseAction<CostType> {
	private ICostTypeBiz costTypeBiz;

	public CostTypeAction() {
		super();
	}

	public void setCostTypeBiz(ICostTypeBiz costTypeBiz) {
		this.costTypeBiz = costTypeBiz;
	}

	/**
	 * 查询全部费用类型
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAllCostType() throws Exception {
		result = costTypeBiz.findAll();// 查询全部费用类型
		return FINDALL;
	}

	/**
	 * 根据费用类型查询全部费用类型
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAllCostTypeByKind() throws Exception {
		result = costTypeBiz.findAllByKind(model.getKind());// 根据费用类型(Kind)查询全部费用类型
		return "findAllCostTypeByKind";
	}

}
