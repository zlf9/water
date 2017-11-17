package com.zking.water.rd.action;

import com.zking.water.base.action.BaseAction;
import com.zking.water.rd.biz.IReadBiz;
import com.zking.water.rd.entity.Read;

public class ReadAction extends BaseAction<Read> {
	private IReadBiz readBiz;

	public ReadAction() {
		super();
	}

	public void setReadBiz(IReadBiz readBiz) {
		this.readBiz = readBiz;
	}

	public String getById() throws Exception {
		result = model.getId() != null ? readBiz.getById(model.getId()) : null;// 如果抄表数据编号不为空则根据抄表数据编号查询抄表数据对象，否则直接为NULL
		return "getById";
	}

}
