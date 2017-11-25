package com.zking.water.user.biz.impl;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.user.biz.IFormulaBiz;
import com.zking.water.user.dao.IFormulaDAO;
import com.zking.water.user.entity.Formula;

public class FormulaBizImpl extends BaseBizImpl<Formula> implements IFormulaBiz {

	private static final long serialVersionUID = -4510295877951659694L;

	private IFormulaDAO formulaDAO;

	public FormulaBizImpl() {
		super();
	}

	public void setFormulaDAO(IFormulaDAO formulaDAO) {
		super.setBaseDAO(formulaDAO);
		this.formulaDAO = formulaDAO;
	}

}
