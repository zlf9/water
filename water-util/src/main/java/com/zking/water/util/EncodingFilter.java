package com.zking.water.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	private String encoding = "UTF-8";

	public EncodingFilter() {
	}

	// 销毁
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 设置请求字符编码
		request.setCharacterEncoding(this.encoding);
		// 设置响应字符编码
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + this.encoding);

		// 如果是Get方式提交
		if ("GET".equals(request.getMethod().trim().toString())) {
			Map<String, String[]> map = request.getParameterMap();
			String values[] = null;
			for (String key : map.keySet()) {
				values = map.get(key);
				// for (String value : values) {
				// byte[] b = value.getBytes("ISO-8859-1");
				// value = new String(b, this.encoding);
				// System.out.println(value);
				// }
				for (int i = 0; i < values.length; i++) {
					byte[] b = values[i].getBytes("ISO-8859-1");
					values[i] = new String(b, this.encoding);
				}
			}
		}
		// 执行下一个过滤器
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String encoding = fConfig.getInitParameter("encoding");
		if (null != encoding && !"".equals(encoding.trim())) {
			this.encoding = encoding.trim();
		}
	}
}
