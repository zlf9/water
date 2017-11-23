package com.zking.water.user.biz;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;

import com.zking.water.base.biz.BaseTestCase;
import com.zking.water.sy.entity.MeterType;
import com.zking.water.user.dao.IMeterDAO;
import com.zking.water.user.entity.Meter;
import com.zking.water.user.entity.User;

public class TestMeterBiz extends BaseTestCase {

	private static final long serialVersionUID = -5252106440488846079L;

	private IMeterBiz meterBiz;
	private IMeterDAO meterDAO;

	@Before
	public void setUp() {
		meterBiz = (IMeterBiz) getBean("meterBiz");
		meterDAO = (IMeterDAO) getBean("meterDAO");
	}

	@Test
	public void testDoGenerateMeterNo() {
		Serializable meterNo = meterDAO.doGenerateMeterNo("0100000001");
		System.out.println(meterNo);
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setUserNo("0100000001");
		Meter meter = new Meter();
		meter.setUser(user);

		meter.setMeterName("01012344");
		MeterType meterType = new MeterType();
		meterType.setId(4);
		meter.setSetupDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		meter.setMeterType(meterType);
		meter.setFactory("虚拟水表厂");

		Serializable save = meterBiz.save(meter);
		System.out.println(save);
	}

}
