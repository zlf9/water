package com.zking.water.sy.biz;

import java.util.List;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.sy.entity.CostType;

/**
 * 费用类型业务对象
 * 
 * @author Administrator
 *
 */
public interface ICostTypeBiz extends IBaseBiz<CostType> {

	/**
	 * 根据费用类型(kind)查询全部
	 * 
	 * @param kind
	 * @return
	 */
	public List<CostType> findAllByKind(Integer kind);

}
