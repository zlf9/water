package com.zking.water.user.dao.impl;

import java.sql.CallableStatement;

import com.zking.water.base.dao.impl.BaseDAOImpl;
import com.zking.water.user.dao.IMeterDAO;
import com.zking.water.user.entity.Meter;

public class MeterDAOImpl extends BaseDAOImpl<Meter> implements IMeterDAO {

	private static final long serialVersionUID = 1L;

	public MeterDAOImpl() {
		super();
	}

	// 根据用户编号生成水表编号
	@Override
	public String doGenerateMeterNo(String UserNo) throws Exception {
		try {
			// 调用存储过程
			String procdure = "{Call proc_generate_meterNo(:userNo,:meterNo)}";
			CallableStatement cs = hibernateTemplate.getSessionFactory().getCurrentSession().disconnect()
					.prepareCall(procdure);
			cs.setString("userNo", UserNo);
			cs.registerOutParameter("meterNo", java.sql.Types.VARCHAR);
			cs.execute();
			return cs.getString("meterNo");
		} catch (Exception e) {
			throw new RuntimeException("根据用户编号生成水表编号失败", e);
		}
	}
}
