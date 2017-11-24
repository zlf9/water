package com.zking.water.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.user.dao.IFormulaDAO;
import com.zking.water.user.entity.Formula;

public class FormulaDAOImpl extends BaseDAOImpl<Formula> implements IFormulaDAO {

	private static final long serialVersionUID = 1L;

	public FormulaDAOImpl() {
		super();
	}

	/**
	 * 解除绑定用户的提比提量 删除
	 * 
	 * @param userNo
	 */
	@Override
	public void deleteByUserNo(final String userNo) {
		try {
			hibernateTemplate.execute(new HibernateCallback<Formula>() {

				@Override
				public Formula doInHibernate(Session session) throws HibernateException {
					session.doWork(new Work() {

						@Override
						public void execute(Connection connection) throws SQLException {
							String sql = "delete from t_us_formula where userNo = ?";
							PreparedStatement pstmt = connection.prepareStatement(sql);
							pstmt.setString(1, userNo);
							pstmt.executeUpdate();
						}
					});
					return null;
				}

			});

		} catch (Exception e) {
			throw new RuntimeException("解除绑定用户的提比提量失败", e);
		}
	}

}
