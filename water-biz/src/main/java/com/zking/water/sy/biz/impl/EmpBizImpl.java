package com.zking.water.sy.biz.impl;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.sy.biz.IEmpBiz;
import com.zking.water.sy.dao.IEmpDAO;
import com.zking.water.sy.entity.Emp;

public class EmpBizImpl extends BaseBizImpl<Emp> implements IEmpBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private IEmpDAO empDAO;

	public EmpBizImpl() {
		super();
	}

	public void setEmpDAO(IEmpDAO empDAO) {
		super.setBaseDAO(empDAO);
		this.empDAO = empDAO;
	}

	/**
	 * 登录
	 * 
	 * @param emp
	 *            需要验证的员工信息
	 * @return 验证通过返回完整信息 否则返回NULL
	 */
	@Override
	public Emp doLogin(final Emp emp) {
		return empDAO.doLogin(emp);
	}

}
