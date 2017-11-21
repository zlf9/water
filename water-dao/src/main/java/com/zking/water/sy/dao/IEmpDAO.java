package com.zking.water.sy.dao;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.sy.entity.Emp;

/**
 * 员工数据访问对象
 * 
 * @author Administrator
 *
 */
public interface IEmpDAO extends IBaseDAO<Emp> {

	/**
	 * 登录
	 * 
	 * @param emp
	 * @return
	 */
	public Emp doLogin(final Emp emp);
}
