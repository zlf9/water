package com.zking.water.user.biz;

import java.util.List;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.Sms;

/**
 * 短信群发记录业务对象
 * 
 * @author Administrator
 *
 */
public interface ISmsBiz extends IBaseBiz<Sms> {
	/**
	 * 查询全部短信群发记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Sms> findAll(PageBean pageBean);
}
