package com.zking.water.user.biz;

import org.junit.Before;
import org.junit.Test;

import com.zking.water.base.biz.BaseTestCase;
import com.zking.water.user.dao.IUserDAO;
import com.zking.water.user.entity.User;

public class TestUserBiz extends BaseTestCase {

	private static final long serialVersionUID = -5252106440488846079L;

	private IUserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		// userDAO = (IUserDAO) getBean("userDAO");
	}

	@Test
	public void testGetById() throws Exception {
		// User user = userDAO.getById("0100000001");
		// System.out.println(user.getUserName());
	}

}
