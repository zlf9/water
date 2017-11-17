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
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-base.xml",
				"spring/applicationContext-dao.xml", "spring/applicationContext-biz.xml");
	}

	public Object getBean(String name) {
		return applicationContext.getBean(name);
	}
}
