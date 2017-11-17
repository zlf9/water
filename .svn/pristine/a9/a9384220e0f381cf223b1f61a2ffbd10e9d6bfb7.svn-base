package com.zking.water.base.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.water.base.biz.IDictBiz;
import com.zking.water.base.entity.Dict;
import com.zking.water.base.entity.PageBean;

@SuppressWarnings("unchecked")
public class BaseAction<T> implements ModelDriven<T>, ServletRequestAware, ServletResponseAware, ServletContextAware {

	public static final String SUCCESS = "success";// 成功
	public static final String ERROR = "error";// 失败
	public static final String NONE = "none";// NULL
	public static final String INPUT = "input";
	public static final String LOGIN = "login";// 登录
	public static final String FINDALL = "findAll";// 查全部
	public static final String SAVE = "save";// 新增
	public static final String UPDATE = "update";// 修改
	public static final String DELETE = "delete";// 删除

	protected Object result;// 保存结果
	protected String message;// 保存消息
	protected String forward;// 跳转页面
	protected IDictBiz dictBiz;// 字典业务对象
	protected T model;// 模型驱动封装

	protected HttpServletRequest request;// 请求
	protected HttpServletResponse response;// 响应
	protected HttpSession session;// 会话
	protected ServletContext application;// 应用程序上下文

	public BaseAction() {
		// 获得当前类型的带有泛型类型的父类
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		// 获得运行期的泛型类型
		Class<T> clazz = (Class<T>) types[0];
		try {
			model = clazz.newInstance();// 创建模型驱动封装对象
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public void setDictBiz(IDictBiz dictBiz) {
		this.dictBiz = dictBiz;
	}

	@Override
	public T getModel() {
		return model;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.application = context;
	}

	/**
	 * 根据字典名字得到字典对象集合
	 * 
	 * @param dictName
	 *            字典名字
	 * @return 字典对象集合
	 * @throws Exception
	 */
	public List<Dict> findAllByDictName(String dictName) throws Exception {
		return StringUtils.isNotBlank(dictName) ? dictBiz.findAllByDictName(dictName) : null;
	}

	/**
	 * 根据字典名字和字典值得到字典文本
	 * 
	 * @param dictName
	 *            字典名字
	 * @param value
	 *            字典值
	 * @return 字典文本
	 * @throws Exception
	 */
	public String findByDictNameAndValue(String dictName, Integer value) throws Exception {
		return dictBiz.findByDictNameAndValue(new Dict(dictName, value)).getText();
	}

	/**
	 * 初始化分页PageBean
	 * 
	 * @return 用来分页的对象PageBean
	 */
	public PageBean handlerPageBean() {
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		return pageBean;
	}

	/**
	 * 把消息存到session作用域
	 * 
	 * @param message
	 *            消息
	 */
	public void showMessage(String message) {
		session.setAttribute("message", message);
	}
}
