package com.zking.water.sy.biz;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.sy.entity.Emp;

/**
 * 员工业务对象
 * 
 * @author Administrator
 *
 */
public interface IEmpBiz extends IBaseBiz<Emp> {

	/**
	 * 登录
	 * 
	 * @param emp
	 * @return
	 */
	public Emp doLogin(final Emp emp) throws Exception;
}
