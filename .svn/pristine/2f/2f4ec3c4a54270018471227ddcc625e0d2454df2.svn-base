package com.zking.water.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.zking.water.base.entity.PageBean;

/**
 * 公共数据访问对象
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDAO<T> extends Serializable {
	/**
	 * 增
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public Serializable save(T t) throws Exception;

	/**
	 * 删
	 * 
	 * @param t
	 * @throws Exception
	 */
	public void delete(T t) throws Exception;

	/**
	 * 删
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Serializable id) throws Exception;

	/**
	 * 改
	 * 
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception;

	/**
	 * 查 根据id查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T getById(Serializable id) throws Exception;

	/**
	 * 查询全部
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> findAll() throws Exception;

	/**
	 * 查 符合条件的总记录数
	 * 
	 * @param dc
	 * @return
	 * @throws Exception
	 */
	public Integer getTotalCount(DetachedCriteria dc) throws Exception;

	/**
	 * 查 查询分页列表数据
	 * 
	 * @param dc
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) throws Exception;

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	public List<T> executeQuery(final String hql, final Map<String, Object> args, final PageBean pageBean);
}
