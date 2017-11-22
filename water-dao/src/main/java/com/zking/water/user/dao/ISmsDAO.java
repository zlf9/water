package com.zking.water.user.dao;

import java.util.List;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.Sms;

/**
 * 短信群发记录数据访问对象
 * 
 * @author Administrator
 *
 */
public interface ISmsDAO extends IBaseDAO<Sms> {

	/**
	 * 查询全部短信群发记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Sms> findAll(PageBean pageBean);
}
