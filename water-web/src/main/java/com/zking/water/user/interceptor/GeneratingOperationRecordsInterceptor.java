package com.zking.water.user.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 生成操作记录的拦截器
 * 
 * @author Administrator
 *
 */
public class GeneratingOperationRecordsInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -7091789960728737961L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 在Action之前执行的代码
		// ......
		// 开始执行Action
		String result = invocation.invoke();//
		// 在Action之后的代码
		// ......
		// 结束拦截器
		return result;
	}

}
