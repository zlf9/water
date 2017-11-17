package com.zking.water.base.biz.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.base.entity.PageBean;

public class BaseBizImpl<T> implements IBaseBiz<T> {

	private static final long serialVersionUID = -708305353556588573L;

	private IBaseDAO<T> baseDAO;

	public BaseBizImpl() {
		super();
	}

	public void setBaseDAO(IBaseDAO<T> baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public Serializable save(T t) throws Exception {
		return baseDAO.save(t);
	}

	@Override
	public void delete(T t) throws Exception {
		baseDAO.delete(t);
	}

	@Override
	public void delete(Serializable id) throws Exception {
		baseDAO.delete(id);
	}

	@Override
	public void update(T t) throws Exception {
		baseDAO.update(t);
	}

	@Override
	public T getById(Serializable id) throws Exception {
		return baseDAO.getById(id);
	}

	@Override
	public List<T> findAll() throws Exception {
		return baseDAO.findAll();
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) throws Exception {
		return baseDAO.getTotalCount(dc);
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) throws Exception {
		return baseDAO.getPageList(dc, start, pageSize);
	}

	@Override
	public List<T> executeQuery(String hql, Map<String, Object> args, PageBean pageBean) {
		return baseDAO.executeQuery(hql, args, pageBean);
	}

}
