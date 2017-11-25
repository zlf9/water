package com.zking.water.user.biz;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;

import com.zking.water.base.biz.BaseTestCase;
import com.zking.water.sy.entity.CostType;
import com.zking.water.user.entity.Formula;
import com.zking.water.user.entity.User;

public class TestFormulaBiz extends BaseTestCase {

	private static final long serialVersionUID = -5252106440488846079L;

	private IFormulaBiz formulaBiz;

	@Before
	public void setUp() {
		formulaBiz = (IFormulaBiz) getBean("formulaBiz");
	}

	@Test
	public void testSave() {
		Formula formula = new Formula();
		User user = new User();
		user.setUserNo("0100000006");
		formula.setUser(user);

		formula.setAllotText("80%");
		formula.setAllotType(2);
		formula.setAllotValue(80);

		CostType costType = new CostType();
		costType.setCode("TZ");
		costType.setId(1);
		formula.setCostType(costType);

		Serializable save = formulaBiz.save(formula);
		System.out.println(save);
	}

}
