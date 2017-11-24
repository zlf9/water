package com.zking.water.user.dao;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.user.entity.Formula;

/**
 * 提比提量数据访问对象
 * 
 * @author Administrator
 *
 */
public interface IFormulaDAO extends IBaseDAO<Formula> {

	/**
	 * 解除绑定用户的提比提量 删除
	 * 
	 * @param userNo
	 */
	public void deleteByUserNo(final String userNo);

}
