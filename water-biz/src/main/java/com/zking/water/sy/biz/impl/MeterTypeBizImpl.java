package com.zking.water.sy.biz.impl;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.sy.biz.IMeterTypeBiz;
import com.zking.water.sy.dao.IMeterTypeDAO;
import com.zking.water.sy.entity.MeterType;

public class MeterTypeBizImpl extends BaseBizImpl<MeterType> implements IMeterTypeBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private IMeterTypeDAO meterTypeDAO;

	public MeterTypeBizImpl() {
		super();
	}

	public void setMeterTypeDAO(IMeterTypeDAO meterTypeDAO) {
		super.setBaseDAO(meterTypeDAO);
		this.meterTypeDAO = meterTypeDAO;
	}

}
