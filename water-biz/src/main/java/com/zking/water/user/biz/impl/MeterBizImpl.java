package com.zking.water.user.biz.impl;

import java.io.Serializable;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.user.biz.IMeterBiz;
import com.zking.water.user.dao.IMeterDAO;
import com.zking.water.user.entity.Meter;

public class MeterBizImpl extends BaseBizImpl<Meter> implements IMeterBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private IMeterDAO meterDAO;

	public MeterBizImpl() {
		super();
	}

	public void setMeterDAO(IMeterDAO meterDAO) {
		super.setBaseDAO(meterDAO);
		this.meterDAO = meterDAO;
	}

	// 新增水表
	@Override
	public Serializable save(Meter meter) {
		String meterNo = meterDAO.doGenerateMeterNo(meter.getUser().getUserNo());
		meter.setMeterNo(meterNo);
		return meterDAO.save(meter);
	}
}
