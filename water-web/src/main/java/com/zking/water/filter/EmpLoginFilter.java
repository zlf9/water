package com.zking.water.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.zking.water.sy.entity.Emp;

/**
 * 员工登录过滤器
 * 
 * @author Administrator
 *
 */
public class EmpLoginFilter implements Filter {

	public EmpLoginFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();// 根据request得到session

		Object e = session.getAttribute("empLoginSuccess");// 从session作用域中取出员工登录成功对象

		// 如果对象不为空并且员工编号和员工密码都不为空,则通过。否则不通过且跳到登录页面
		if (null != e && StringUtils.isNotBlank(((Emp)e).getEmpNo()) && StringUtils.isNotBlank(((Emp)e).getPwd())) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

}
