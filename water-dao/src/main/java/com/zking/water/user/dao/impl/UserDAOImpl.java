package com.zking.water.user.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.dao.IUserDAO;
import com.zking.water.user.entity.User;

@SuppressWarnings("all")
public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO {

	private static final long serialVersionUID = 7159499280669130763L;

	public UserDAOImpl() {
		super();
	}

	@Override
	public User getById(final Serializable userNo) {
		try {
			return hibernateTemplate.execute(new HibernateCallback<User>() {

				@Override
				public User doInHibernate(Session session) throws HibernateException {
					String hql = "from User where disabled = 0 and userNo = '" + userNo + "'";
					Query<User> query = session.createQuery(hql);
					return query.uniqueResult();
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("根据用户编号查询用户失败", e);
		}
	}

	/**
	 * 模糊查询 且支持分页
	 */
	@Override
	public List<User> findFreetext(User user, PageBean pageBean) {
		try {
			String hql = "from User where 1=1";
			Map<String, Object> args = new HashMap<String, Object>();

			if (null != user) {
				if (StringUtils.isNotBlank(user.getUserNo())) {
					hql += " and userNo like :userNo";
					args.put("userNo", "%" + user.getUserNo().trim() + "%");
				}
				if (StringUtils.isNotBlank(user.getAbc())) {
					hql += " and abc like :abc";
					args.put("abc", "%" + user.getAbc().trim() + "%");
				}
				if (StringUtils.isNotBlank(user.getUserName())) {
					hql += " and userName like :userName";
					args.put("userName", "%" + user.getUserName().trim() + "%");
				}
				if (StringUtils.isNotBlank(user.getPhone())) {
					hql += " and phone like :phone";
					args.put("phone", "%" + user.getPhone().trim() + "%");
				}
				if (StringUtils.isNotBlank(user.getAddress())) {
					hql += " and address like :address";
					args.put("address", "%" + user.getAddress().trim() + "%");
				}
			}
			hql += " and disabled = 0";

			// Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
			// Query<User> query = session.createQuery(hql);
			// // 设置初始下标
			// query.setFirstResult(pageBean.getStartIndex());
			// // 设置要显示的数量
			// query.setMaxResults(pageBean.getPageSize());
			//
			// // 根据相关条件查询出用户集合
			// List<User> users = query.list();
			// pageBean.setTotalRecord(users.size());

			return this.executeQuery(hql, args, pageBean);
		} catch (Exception e) {
			throw new RuntimeException("模糊查询用户失败", e);
		}
	}

	// 根据辖区ID生成用户编号
	@Override
	public String doGenerateUserNo(Integer areaId) {
		try {
			// 调用存储过程
			String procdure = "{Call proc_generate_userNo(1,2)}";
			// Hibernate3.3.2版本中getSession().connection()已被弃用，替代方法SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection()
			// 来自类org.springframework.orm.hibernate3.SessionFactoryUtils
			DataSource dataSource = SessionFactoryUtils.getDataSource(hibernateTemplate.getSessionFactory());
			Connection conn = dataSource.getConnection();
			CallableStatement cs = conn.prepareCall(procdure);
			// 入参要赋值
			cs.setInt(1, areaId);
			// 出参要注册
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.execute();
			return cs.getString(2);
		} catch (Exception e) {
			throw new RuntimeException("根据辖区ID生成用户编号失败", e);
		}
	}

	@Override
	public void doChangeName(User user) {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setUserName(user.getUserName());
				u.setPhone(user.getPhone());
				u.setSmsphone(user.getSmsphone());
				u.setAddress(user.getAddress());
			}
		} catch (Exception e) {
			throw new RuntimeException("过户失败", e);
		}
	}

	@Override
	public void doChangeBank(User user) {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setPayType(user.getPayType());
				u.setBankName(user.getBankName());
				u.setBankNum(user.getBankNum());
			}
		} catch (Exception e) {
			throw new RuntimeException("代扣失败", e);
		}
	}

	@Override
	public void doChangeMeter(User user) {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setMeter(user.getMeter());
			}
		} catch (Exception e) {
			throw new RuntimeException("换表失败", e);
		}
	}

	@Override
	public void doChangeFormula(User user) {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setFormula(user.getFormula());
				u.setFormulas(user.getFormulas());
			}
		} catch (Exception e) {
			throw new RuntimeException("重签失败", e);
		}
	}

	@Override
	public void doCloseAccount(User user) {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setDisabled(true);
			}
		} catch (Exception e) {
			throw new RuntimeException("销户失败", e);
		}
	}

	@Override
	public void doChangeDocNum(User user) {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				if (u.getUserMoney() >= 0) {
					u.setDocNum(user.getDocNum());
				} else {
					throw new RuntimeException("此户水费尚未清算，不能销户。");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("档案号管理失败", e);
		}
	}

	@Override
	public List<User> findAllLackOfUser(PageBean pageBean) {
		try {
			String hql = "from User u where u.userMoney < 0";
			return this.executeQuery(hql, null, pageBean);
		} catch (Exception e) {
			throw new RuntimeException("查询所有欠费用户失败", e);
		}
	}
}
