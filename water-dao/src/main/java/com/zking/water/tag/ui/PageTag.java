package com.zking.water.tag.ui;

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.zking.water.base.entity.PageBean;

public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = -6650240612580556566L;

	private PageBean pageBean;

	public PageTag() {
		super();
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if (null != pageBean) {
				JspWriter out = pageContext.getOut();
				out.print(getHTML());
			}
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成分页相关的HTML
	 * 
	 * @return
	 */
	public String getHTML() {
		StringBuffer bf = new StringBuffer();
		// 1. 生成表单数据
		bf.append("<form id='pageForm' action='" + pageBean.getUrl() + "' method='post'>");
		String[] values = null;// 参数值
		Map<String, String[]> m = pageBean.getParameterMap();
		for (String name : m.keySet()) {
			if ("pageNumber".equals(name)) {
				continue;// 忽略页码
			}
			values = m.get(name);
			// bookName = [西游记]
			// hobby = [a,b,c]
			for (String value : values) {
				bf.append("<input type='hidden' name='" + name + "' value='" + value + "'>");
			}
		}
		bf.append("<input type='hidden' name='pageNumber' value=''>");
		bf.append("</form>");

		// 2. 生成按钮
		bf.append("<div style='text-align: right;font-size: 14px'>每页" + pageBean.getPageSize() + "条，共"
				+ pageBean.getTotalRecord() + "条，<b>" + pageBean.getPageNumber() + "</b>/<b>" + pageBean.getMaxPageNumber()
				+ "</b>&nbsp;&nbsp;<a href='javascript:gotoPage(1)'>首页</a>&nbsp;&nbsp;<a href='javascript:gotoPage("
				+ pageBean.getPreviousPageNumber() + ")'>上一页</a>&nbsp;&nbsp;<a href='javascript:gotoPage("
				+ pageBean.getNextPageNumber() + ")'>下一页</a>&nbsp;&nbsp;<a href='javascript:gotoPage("
				+ pageBean.getMaxPageNumber() + ")'>尾页</a>");
		bf.append(
				"&nbsp;<input style='width:30px;text-align: center;' type='text' id='skipPageNumber' value=''><a href='javascript:skipPage(1)'>&nbsp;GO</a>");
		bf.append("</div>");

		// 3. 动态js
		bf.append("<script type='text/javascript'>");
		bf.append("function gotoPage(pageNumber) {");
		bf.append("  document.getElementById('pageForm').pageNumber.value = pageNumber;");
		bf.append("  document.getElementById('pageForm').submit();");
		bf.append("}");
		bf.append("var min = 1;");
		bf.append("var max = " + pageBean.getMaxPageNumber() + ";");
		bf.append("function skipPage(){");
		bf.append("  var pageNumber = document.getElementById('skipPageNumber').value;");
		bf.append("  if(!pageNumber||isNaN(pageNumber)||parseInt(pageNumber)<min||parseInt(pageNumber)>max){");
		bf.append("    alert('请输入一个'+min+'~'+max+'之间的数字');");
		bf.append("    return;");
		bf.append("  }");
		bf.append("  gotoPage(pageNumber);");
		bf.append("}");
		bf.append("</script>");
		return bf.toString();
	}

}
