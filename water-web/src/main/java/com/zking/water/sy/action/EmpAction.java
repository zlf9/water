package com.zking.water.sy.action;

import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zking.water.base.action.BaseAction;
import com.zking.water.sy.biz.IEmpBiz;
import com.zking.water.sy.entity.Emp;
import com.zking.water.util.Constants;

public class EmpAction extends BaseAction<Emp> {
	private IEmpBiz empBiz;

	public EmpAction() {
		super();
	}

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	/**
	 * 登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLogin() throws Exception {
		Emp e = StringUtils.isNotBlank(model.getEmpNo()) && StringUtils.isNotBlank(model.getPwd())
				? empBiz.doLogin(model)
				: null;// 如果员工编号和员工密码都不为空则根据员工编号和员工密码进行登录验证,否则直接为NULL

		session.setAttribute(Constants.EMP_LOGIN_SUCCESS, e);// 存到会话中,用来保持登录状态

		PrintWriter writer = response.getWriter();
		writer.print(null != e);// 是否登录成功
		writer.close();

		return NONE;
	}

	/**
	 * 登出
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLogout() throws Exception {
		session.removeAttribute(Constants.EMP_LOGIN_SUCCESS);// 从会话中删除,用来保持登录状态
		return Constants.VIEW_LOGIN;
	}

	/**
	 * 查询全部员工
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAllEmp() throws Exception {
		List<Emp> emps = empBiz.findAll();// 查询全部返回所有员工的对象集合
		result = emps == null || emps.size() < 1 ? null : emps;// 如果没有查到则为NULL，有则为所有员工的对象集合
		return NONE;
	}
}
