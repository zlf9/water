package com.zking.water.sy.action;

import com.zking.water.base.action.BaseAction;
import com.zking.water.sy.biz.IMeterTypeBiz;
import com.zking.water.sy.entity.MeterType;

public class MeterTypeAction extends BaseAction<MeterType> {
	private IMeterTypeBiz meterTypeBiz;

	public MeterTypeAction() {
		super();
	}

	public void setMeterTypeBiz(IMeterTypeBiz meterTypeBiz) {
		this.meterTypeBiz = meterTypeBiz;
	}

	public String findAllMeterType() {
		try {
			result = meterTypeBiz.findAll();// 查询全部水表型号
			return NONE;
		} catch (Exception e) {
			throw new RuntimeException("查询全部水表型号失败", e);
		}
	}

}
