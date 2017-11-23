package com.zking.water.base.biz;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTestCase implements Serializable {

	private static final long serialVersionUID = 2507625130944801246L;

	private static ApplicationContext applicationContext;

	public BaseTestCase() {
		super();
	}

	static {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext-base.xml",
				"spring/applicationContext-dao-base.xml",
				"spring/applicationContext-dao-iv.xml",
				"spring/applicationContext-dao-py.xml",
				"spring/applicationContext-dao-rd.xml",
				"spring/applicationContext-dao-sy.xml",
				"spring/applicationContext-dao-user.xml",
				"spring/applicationContext-biz-base.xml",
				"spring/applicationContext-biz-iv.xml",
				"spring/applicationContext-biz-py.xml",
				"spring/applicationContext-biz-rd.xml",
				"spring/applicationContext-biz-sy.xml",
				"spring/applicationContext-biz-user.xml");
	}

	public Object getBean(String name) {
		return applicationContext.getBean(name);
	}
}
