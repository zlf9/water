package com.zking.water.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.User;

@SuppressWarnings("all")
public abstract class BaseDAOImpl<T> implements IBaseDAO<T> {
	private static final long serialVersionUID = -6310590619205527463L;

	protected HibernateTemplate hibernateTemplate;

	private static final Logger log = LogManager.getLogger(BaseDAOImpl.class);
	private Class clazz;// 用于接收运行期泛型类型

	public BaseDAOImpl() {
		// 获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 增
	@Override
	public Serializable save(T t) throws Exception {
		try {
			return hibernateTemplate.save(t);
		} catch (Exception e) {
			throw new RuntimeException("增加" + clazz.getSimpleName() + "失败", e);
		}
	}

	@Override
	public void delete(T t) throws Exception {
		try {
			hibernateTemplate.delete(t);
		} catch (Exception e) {
			throw new RuntimeException("删除" + clazz.getSimpleName() + "失败", e);
		}
	}

	@Override
	public void delete(Serializable id) throws Exception {
		try {
			T t = this.getById(id);// 先取,再删
			hibernateTemplate.delete(t);
		} catch (Exception e) {
			throw new RuntimeException("删除" + clazz.getSimpleName() + "失败", e);
		}
	}

	@Override
	public void update(T t) throws Exception {
		try {
			hibernateTemplate.update(t);
		} catch (Exception e) {
			throw new RuntimeException("修改" + clazz.getSimpleName() + "失败", e);
		}
	}

	// 查 根据id查询
	@Override
	public T getById(Serializable id) throws Exception {
		try {
			return (T) hibernateTemplate.get(clazz, id);
		} catch (Exception e) {
			throw new RuntimeException("主键查询" + clazz.getSimpleName() + "失败", e);
		}
	}

	// 查询全部
	@Override
	public List<T> findAll() throws Exception {
		try {
			return (List<T>) hibernateTemplate.find("from " + clazz.getSimpleName());
		} catch (Exception e) {
			throw new RuntimeException("查询全部失败", e);
		}
	}

	// 查 符合条件的总记录数
	@Override
	public Integer getTotalCount(DetachedCriteria dc) throws Exception {
		try {
			// 设置查询的聚合函数,总记录数
			dc.setProjection(Projections.rowCount());

			List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(dc);

			// 清空之前设置的聚合函数
			dc.setProjection(null);

			if (list != null && list.size() > 0) {
				Long count = list.get(0);
				return count.intValue();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException("查询符合条件的总记录数失败", e);
		}
	}

	// 查 查询分页列表数据
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) throws Exception {
		try {
			return (List<T>) hibernateTemplate.findByCriteria(dc, start, pageSize);
		} catch (Exception e) {
			throw new RuntimeException("查询分页列表数据失败", e);
		}
	}

	/**
	 * 通用赋值方法
	 * 
	 * @param query
	 * @param args
	 */
	private void setParameters(Query<?> query, Map<String, Object> args) {
		if (log.isInfoEnabled()) {
			log.info("args=" + args);
		}

		if (null == args || 0 == args.size()) {
			return;
		}

		String name = null;
		Object value = null;
		Iterator<String> it = args.keySet().iterator();
		while (it.hasNext()) {
			name = it.next();
			value = args.get(name);
			if (value instanceof Collection) {// 仅:命名参数支持Collection集合或数组
				query.setParameterList(name, (Collection<?>) value);
			} else if (value instanceof Object[]) {
				query.setParameterList(name, (Object[]) value);
			} else {
				query.setParameter(name, value);
			}
		}
	}

	/**
	 * 将普通hql转换成查询全部的hql
	 * 
	 * @param hql
	 * @return
	 */
	private String convertHQL(String hql) {
		String s = new String(hql).toUpperCase();
		int start = s.indexOf("FROM");
		int end = s.lastIndexOf("ORDER BY");
		if (-1 == end) {
			s = "SELECT COUNT(*) " + hql.substring(start);
		} else {
			s = "SELECT COUNT(*) " + hql.substring(start, end);
		}
		return s;
	}

	/**
	 * 查全部,支持分页
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	public List<T> executeQuery(final String hql, final Map<String, Object> args, final PageBean pageBean) {
		if (null != pageBean && log.isInfoEnabled()) {
			log.info("pageBean={pageNumber=" + pageBean.getPageNumber() + ", pageSize=" + pageBean.getPageSize()
					+ ", paginate=" + pageBean.isPaginate() + "}");
		}

		if (null != pageBean && pageBean.isPaginate()) {// 查总记录数
			hibernateTemplate.execute(new HibernateCallback<Integer>() {
				public Integer doInHibernate(Session session) throws HibernateException {
					String countHQL = convertHQL(hql);
					if (log.isInfoEnabled()) {
						log.info("countHQL=[" + countHQL + "]");
					}
					Query<Object> query = session.createQuery(countHQL);
					setParameters(query, args);

					// 为兼容Long和Integer类型的oid,先将值转换成字符串，再转成Integer
					Object count = query.uniqueResult();
					pageBean.setTotalRecord(count.toString());
					return null;
				}
			});
			if (log.isInfoEnabled()) {
				log.info("totalRecord=" + pageBean.getTotalRecord());
			}
		}

		// 查询满足条件并指定页码的记录
		return hibernateTemplate.execute(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session) throws HibernateException {
				if (log.isInfoEnabled()) {
					log.info("HQL=[" + hql + "]");
				}
				Query<Object> query = session.createQuery(hql);
				setParameters(query, args);// 参数设置
				if (null != pageBean && pageBean.isPaginate()) {// 分页设置
					query.setFirstResult(pageBean.getStartIndex());
					query.setMaxResults(pageBean.getPageSize());
				}
				List<T> result = (List<T>) query.list();// 执行查询
				if (log.isInfoEnabled()) {
					log.info("result.size()=" + result.size());
				}
				return result;
			}
		});
	}

}
