package com.zking.water.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	private static final ThreadLocal<Session> local = new ThreadLocal<Session>();

	private static SessionFactory factory = null;

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}

	public static Session openSession() {
		Session session = local.get();
		if (null == session) {
			session = factory.openSession();
			local.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = local.get();
		if (null != session) {
			if (session.isOpen()) {
				session.close();
			}
			local.set(null);
		}
	}
	
	public static void main(String[] args) {
		openSession();
		closeSession();
		System.out.println("ok");
	}
}
