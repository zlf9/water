package com.zking.water.py.action;

import org.apache.commons.lang3.StringUtils;

import com.zking.water.base.action.BaseAction;
import com.zking.water.py.biz.IBillBiz;
import com.zking.water.py.entity.Bill;

public class BillAction extends BaseAction<Bill> {
	private IBillBiz billBiz;// 水费单业务对象

	public BillAction() {
		super();
	}

	public void setBillBiz(IBillBiz billBiz) {
		this.billBiz = billBiz;
	}

	public String getById() throws Exception {
		result = StringUtils.isNotBlank(model.getBillNo()) ? billBiz.getById(model.getBillNo()) : null;// 如果水费单编号不为空则根据水费单编号查询水费单对象，否则直接为NULL
		return "getById";
	}

}
