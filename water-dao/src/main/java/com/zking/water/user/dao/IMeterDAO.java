package com.zking.water.user.dao;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.user.entity.Meter;

/**
 * 水表数据访问对象
 * 
 * @author Administrator
 *
 */
public interface IMeterDAO extends IBaseDAO<Meter> {

	/**
	 * 根据用户编号生成水表编号
	 * 
	 * @param UserNo
	 *            用户编号
	 * @return 水表编号
	 * @throws Exception
	 */
	public String doGenerateMeterNo(String UserNo);
}
