package com.zking.water.base.entity;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页通用类
 */
public class PageBean implements Serializable {
	private static final long serialVersionUID = -7544706514503688395L;

	/** 页码 */
	private int pageNumber = 1;
	/** 页大小 */
	private int pageSize = 10;
	/** 总记录数 */
	private int totalRecord;
	/** 总页数(总记录数/页大小) */
	private int totalPage;

	/** 是否分页，默认分页 */
	private boolean paginate = true;

	/** 上一次请求的地址 */
	private String url;
	/** 请求中的参数 */
	private Map<String, String[]> parameterMap;

	public PageBean() {
		super();
	}

	/**
	 * 初始化分页数据
	 */
	public void setRequest(HttpServletRequest request) {
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");
		this.setPageNumber(pageNumber);
		this.setPageSize(pageSize);
		this.url = request.getContextPath() + request.getServletPath();
		this.parameterMap = request.getParameterMap();
	}

	public boolean isPaginate() {
		return paginate;
	}

	public void setPaginate(boolean paginate) {
		this.paginate = paginate;
	}

	public void setPaginate(String paginate) {
		paginate = null == paginate ? "" : paginate.trim();
		if ("false".equalsIgnoreCase(paginate)) {
			this.paginate = false;
		} else {
			this.paginate = true;
		}
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		if (null != pageNumber && !"".equals(pageNumber.trim())) {
			this.pageNumber = Integer.parseInt(pageNumber);
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageSize(String pageSize) {
		if (null != pageSize && !"".equals(pageSize.trim())) {
			this.pageSize = Integer.parseInt(pageSize);
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setTotalRecord(String totalRecord) {
		this.totalRecord = Integer.valueOf(totalRecord);
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalRecord / pageSize;
	}

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	/** 获取下一页的页码 */
	public int getNextPageNumber() {
		int nextPageNumber = pageNumber + 1;
		if (nextPageNumber > this.getMaxPageNumber()) {
			nextPageNumber = this.getMaxPageNumber();
		}
		return nextPageNumber;
	}

	/** 获取上一页的页码 */
	public int getPreviousPageNumber() {
		int previousPageNumber = pageNumber - 1;
		if (previousPageNumber < 1) {
			previousPageNumber = 1;
		}
		return previousPageNumber;
	}

	/** 获取最大页码数 */
	public int getMaxPageNumber() {
		int maxPageNumber = this.totalRecord / this.pageSize;
		if (totalRecord % pageSize != 0) {
			maxPageNumber++;
		}
		return maxPageNumber;
	}

	/** 获取开始下标 */
	public int getStartIndex() {
		return (this.pageNumber - 1) * this.pageSize;
	}

	/** 获取结束下标 */
	public int getEndIndex() {
		return this.pageNumber * this.pageSize - 1;
	}
}
