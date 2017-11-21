package com.zking.water.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zking.water.base.biz.IDictBiz;
import com.zking.water.base.entity.Dict;
import com.zking.water.sy.entity.Emp;
import com.zking.water.user.action.UserAction;
import com.zking.water.user.biz.IOrderLiteBiz;
import com.zking.water.user.entity.OrderLite;
import com.zking.water.user.entity.User;
import com.zking.water.util.Constants;
import com.zking.water.util.SpringContextUtil;

/**
 * 生成操作记录的拦截器
 * 
 * @author Administrator
 *
 */
public class GeneratingOperationRecordsInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -7091789960728737961L;

	private IOrderLiteBiz orderLiteBiz = SpringContextUtil.getBean("orderLiteBiz");
	private IDictBiz dictBiz = SpringContextUtil.getBean("dictBiz");

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		before(invocation);
		String resultCode = invocation.invoke();// 执行方法
		after(invocation, resultCode);
		return resultCode;
	}

	/**
	 * 执行方法之前执行
	 * 
	 * 类似前置通知
	 * 
	 * @param invocation
	 * @throws Exception
	 */
	public void before(ActionInvocation invocation) {
		ActionProxy actionProxy = invocation.getProxy();
		String method = actionProxy.getMethod();
		System.out.println(actionProxy.getActionName());
		System.out.println(method);
	}

	/**
	 * 执行方法之后执行
	 * 
	 * 类似后置通知
	 * 
	 * @param invocation
	 * @param resultCode
	 * @throws Exception
	 */
	public void after(ActionInvocation invocation, String resultCode) throws Exception {
		ActionProxy actionProxy = invocation.getProxy();// 获得当前请求的Action代理对象
		String method = actionProxy.getMethod();// 获得当前请求的方法名
		Object action = invocation.getAction();// 获得当前请求的Action对象
		if (action instanceof UserAction) {// 如果是UserAction
			UserAction userAction = (UserAction) action;// 强制转换为UserAction
			User user = userAction.getModel();// 得到请求中的User相关的参数
			Emp e = (Emp) userAction.getSession().getAttribute(Constants.EMP_LOGIN_SUCCESS);// 得到当前登录的员工
			OrderLite orderLite = null;
			switch (method) {// 请求的方法名
			case "save":// 如果为save
				orderLite = new OrderLite();// 创建快捷操作记录
				orderLite.setOrderType(1);// 设置工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
				orderLite.setDescription("此新户的提比提量：" + user.getFormula());// 设置说明
				break;
			case "doChangeName":// 如果为doChangeName
				orderLite = new OrderLite();
				orderLite.setOrderType(3);// 设置工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
				orderLite.setDescription("过户给：" + user.getUserName());// 设置说明
				break;
			case "doChangeBank":// 如果为doChangeBank
				orderLite = new OrderLite();
				orderLite.setOrderType(4);// 设置工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
				orderLite.setDescription("更改为" + dictBiz.findByDictNameAndValue(new Dict("收款方式", user.getPayType())));// 设置说明
				break;
			case "doChangeMeter":// 如果为doChangeMeter
				orderLite = new OrderLite();
				orderLite.setOrderType(5);// 设置工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
				orderLite.setDescription("新表类型：" + user.getMeter().getMeterType().getMeterTypeName() + "，表身码："
						+ user.getMeter().getMeterName());// 设置说明
				break;
			case "doChangeFormula":// 如果为doChangeFormula
				orderLite = new OrderLite();
				orderLite.setOrderType(6);// 设置工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
				orderLite.setDescription("旧提比提量：" + userAction.getMessage() + " 　 新提比提量：" + user.getFormula());// 设置说明
				break;
			case "doCloseAccount":// 如果为doCloseAccount
				orderLite = new OrderLite();
				orderLite.setOrderType(7);// 设置工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）
				orderLite.setDescription("销户说明：" + userAction.getMessage());// 设置说明
				break;
			}
			orderLite.setUser(user);// 设置用户（被操作的用户）
			orderLite.setEmp(e);// 设置员工（操作人）
			orderLiteBiz.save(orderLite);
		}
	}
}
