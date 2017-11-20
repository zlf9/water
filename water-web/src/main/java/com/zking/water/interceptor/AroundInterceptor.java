package com.zking.water.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public abstract class AroundInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -5111842421408970425L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.
	 * opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		before(invocation);
		// 调用下一个拦截器，如果拦截器不存在，则执行Action
		result = invocation.invoke();
		after(invocation, result);
		return result;
	}

	/**
	 * 执行方法之前执行
	 * 
	 * 类似前置通知
	 * 
	 * @param invocation
	 * @throws Exception
	 */
	public abstract void before(ActionInvocation invocation) throws Exception;

	/**
	 * 执行方法之后执行
	 * 
	 * 类似后置通知
	 * 
	 * @param invocation
	 * @param resultCode
	 * @throws Exception
	 */
	public abstract void after(ActionInvocation invocation, String resultCode) throws Exception;
}