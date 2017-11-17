package com.zking.water.sy.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.sy.dao.IEmpDAO;
import com.zking.water.sy.entity.Emp;

@SuppressWarnings("all")
public class EmpDAOImpl extends BaseDAOImpl<Emp> implements IEmpDAO {

	private static final long serialVersionUID = -8742322709544521457L;

	public EmpDAOImpl() {
		super();
	}

	/**
	 * 登录
	 * 
	 * @param emp
	 *            需要验证的员工信息
	 * @return 验证通过返回完整信息 否则返回NULL
	 */
	@Override
	public Emp doLogin(final Emp emp) throws Exception {
		try {
			return hibernateTemplate.execute(new HibernateCallback<Emp>() {

				@Override
				public Emp doInHibernate(Session session) throws HibernateException {
					String hql = "from Emp where empNo = :empNo and pwd = :pwd";
					Query<Emp> query = session.createQuery(hql);
					query.setParameter("empNo", emp.getEmpNo().trim());
					query.setParameter("pwd", emp.getPwd().trim());
					return query.uniqueResult();
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("登录失败", e);
		}
	}
}
