package com.zking.water.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zking.water.util.Constants;

/**
 * 
 * 员工登录拦截器
 * 
 * 拦截非登录员工请求
 * 
 * @author Administrator
 *
 */
public class EmpLoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -472251105261694985L;

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		Object empLoginSuccess = ActionContext.getContext().getSession().get(Constants.EMP_LOGIN_SUCCESS);
		if (null == empLoginSuccess) {
			return Constants.VIEW_LOGIN; // 这里返回员工登录页面视图
		}
		return invocation.invoke();
	}

}
