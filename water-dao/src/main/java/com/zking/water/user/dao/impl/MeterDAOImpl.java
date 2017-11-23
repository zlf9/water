package com.zking.water.user.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.user.dao.IMeterDAO;
import com.zking.water.user.entity.Meter;

public class MeterDAOImpl extends BaseDAOImpl<Meter> implements IMeterDAO {

	private static final long serialVersionUID = 1L;

	public MeterDAOImpl() {
		super();
	}

	@Override
	public String doGenerateMeterNo(String userNo) {
		try {
			// 调用存储过程
			String procdure = "{Call proc_generate_meterNo(?, ?)}";
			// Hibernate3.3.2版本中getSession().connection()已被弃用，替代方法SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection()
			// 来自类org.springframework.orm.hibernate3.SessionFactoryUtils
			DataSource dataSource = SessionFactoryUtils.getDataSource(hibernateTemplate.getSessionFactory());
			Connection conn = dataSource.getConnection();
			CallableStatement cs = conn.prepareCall(procdure);
			cs.setString(1, userNo);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.execute();
			return cs.getString(2);
		} catch (Exception e) {
			throw new RuntimeException("根据用户编号生成水表编号失败", e);
		}
	}

	/**
	 * 解除绑定用户的水表 删除
	 * 
	 * @param userNo
	 */
	@Override
	public void deleteByUserNo(final String userNo) {
		try {
			hibernateTemplate.execute(new HibernateCallback<Meter>() {

				@Override
				public Meter doInHibernate(Session session) throws HibernateException {
					session.doWork(new Work() {

						@Override
						public void execute(Connection connection) throws SQLException {
							String sql = "delete from t_us_meter where userNo = ?";
							PreparedStatement pstmt = connection.prepareStatement(sql);
							pstmt.setString(1, userNo);
							pstmt.executeUpdate();
						}
					});
					return null;
				}

			});

		} catch (Exception e) {
			throw new RuntimeException("解除绑定用户的水表水表失败", e);
		}
	}

	@Override
	public void doDisableMeter(final Meter meter) {
		try {
			hibernateTemplate.execute(new HibernateCallback<Meter>() {

				@Override
				public Meter doInHibernate(Session session) throws HibernateException {
					session.doWork(new Work() {

						@Override
						public void execute(Connection connection) throws SQLException {
							String sql = "update t_us_meter m set disabled = 1 where disabled = 0 and m.userNo = ?";
							PreparedStatement pstmt = connection.prepareStatement(sql);
							pstmt.setString(1, meter.getUser().getUserNo());
							pstmt.executeUpdate();
						}
					});
					return null;
				}

			});

		} catch (Exception e) {
			throw new RuntimeException("禁用水表失败", e);
		}
	}
}
