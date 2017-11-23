package com.zking.water.user.biz;

import java.io.Serializable;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.user.entity.Meter;

/**
 * 水表业务对象
 * 
 * @author Administrator
 *
 */
public interface IMeterBiz extends IBaseBiz<Meter> {

	/**
	 * 新增水表
	 */
	public Serializable save(Meter meter);

	/**
	 * 禁用用户的水表
	 */
	public void doDisableMeter(Meter meter);
}
