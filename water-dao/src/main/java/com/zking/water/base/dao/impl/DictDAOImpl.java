package com.zking.water.base.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.water.base.dao.IDictDAO;
import com.zking.water.base.entity.Dict;

@SuppressWarnings("all")
public class DictDAOImpl extends BaseDAOImpl<Dict> implements IDictDAO {

	private static final long serialVersionUID = -3011782159038779308L;

	public DictDAOImpl() {
		super();
	}

	// 根据字典名字查询字典列表
	@Override
	public List<Dict> findAllByDictName(String dictName) {
		try {
			String hql = "from Dict where dictName = ?";
			return (List<Dict>) hibernateTemplate.find(hql, dictName);
		} catch (Exception e) {
			throw new RuntimeException("根据字典名字查询字典列表失败", e);
		}
	}

	@Override
	public Dict findByDictNameAndValue(final Dict dict) {
		try {
			return hibernateTemplate.execute(new HibernateCallback<Dict>() {

				@Override
				public Dict doInHibernate(Session session) throws HibernateException {
					String hql = "from Dict where dictName = :dictName and value = :value";
					Query<Dict> query = session.createQuery(hql);
					query.setParameter("dictName", dict.getDictName());
					query.setParameter("value", dict.getValue());
					return query.uniqueResult();
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("根据字典名字查询字典列表失败", e);
		}
	}
}
