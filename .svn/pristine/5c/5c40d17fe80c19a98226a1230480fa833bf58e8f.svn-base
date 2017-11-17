package com.zking.water.user.dao.impl;

import java.sql.CallableStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

	/**
	 * 模糊查询 且支持分页
	 */
	@Override
	public List<User> findFreetext(User user, PageBean pageBean) throws Exception {
		try {
			String hql = "from User where 1=1";
			Map<String, Object> args = new HashMap<String, Object>();

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
	public String doGenerateUserNo(Integer areaId) throws Exception {
		try {
			// 调用存储过程
			String procdure = "{Call proc_generate_userNo(:areaId,:userNo)}";
			CallableStatement cs = hibernateTemplate.getSessionFactory().getCurrentSession().disconnect()
					.prepareCall(procdure);
			// 入参要赋值
			cs.setInt("areaId", areaId);
			// 出参要注册
			cs.registerOutParameter("userNo", java.sql.Types.VARCHAR);
			cs.execute();
			return cs.getString("userNo");
		} catch (Exception e) {
			throw new RuntimeException("根据辖区ID生成用户编号失败", e);
		}
	}

	@Override
	public void doChangeName(User user) throws Exception {
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
	public void doChangeBank(User user) throws Exception {
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
	public void doChangeMeter(User user) throws Exception {
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
	public void doChangeFormula(User user) throws Exception {
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
	public void doCloseAccount(User user) throws Exception {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setDisabled(user.getDisabled());
			}
		} catch (Exception e) {
			throw new RuntimeException("销户失败", e);
		}
	}

	@Override
	public void doChangeDocNum(User user) throws Exception {
		try {
			User u = getById(user.getUserNo());
			if (u != null) {
				u.setDocNum(user.getDocNum());
			}
		} catch (Exception e) {
			throw new RuntimeException("档案号管理失败", e);
		}
	}
}
