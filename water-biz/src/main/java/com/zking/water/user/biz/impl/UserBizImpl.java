package com.zking.water.user.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.base.entity.PageBean;
import com.zking.water.sy.entity.CostType;
import com.zking.water.user.biz.IUserBiz;
import com.zking.water.user.dao.IFormulaDAO;
import com.zking.water.user.dao.IMeterDAO;
import com.zking.water.user.dao.IUserDAO;
import com.zking.water.user.entity.Formula;
import com.zking.water.user.entity.Meter;
import com.zking.water.user.entity.User;
import com.zking.water.util.ChineseCharToEn;

public class UserBizImpl extends BaseBizImpl<User> implements IUserBiz {
	private static final long serialVersionUID = 1264222658209438863L;

	private IUserDAO userDAO;
	private IMeterDAO meterDAO;
	private IFormulaDAO formulaDAO;

	public UserBizImpl() {
		super();
	}

	public void setUserDAO(IUserDAO userDAO) {
		super.setBaseDAO(userDAO);
		this.userDAO = userDAO;
	}

	public void setMeterDAO(IMeterDAO meterDAO) {
		this.meterDAO = meterDAO;
	}

	public void setFormulaDAO(IFormulaDAO formulaDAO) {
		this.formulaDAO = formulaDAO;
	}

	@Override
	public User getById(Serializable userNo) {
		return userDAO.getById(userNo);
	}

	@Override
	public List<User> findFreetext(User user, PageBean pageBean) {
		return userDAO.findFreetext(user, pageBean);
	}

	/**
	 * 新增用户,并且同时新增水表.(水表和用户绑定)
	 */
	@Override
	public Serializable save(User user) {
		Meter meter = user.getMeter();// 得到用户中水表信息

		String userNo = userDAO.doGenerateUserNo(user.getAreaId());// 根据辖区ID生成用户编号
		user.setUserNo(userNo);//// 设置用户编号
		String abc = ChineseCharToEn.getAllFirstLetter(user.getUserName());// 获得用户名称的首拼字母(简码)
		user.setAbc(abc);// 设置用户的简码
		// user.setMeter(null);//设置用户对应的水表为null(不然会一起新增,设置映射不级联新增也可以)
		userDAO.save(user);// 新户

		meter.setUser(user);// 设置水表对应的用户为刚刚新建的用户(绑定用户)
		String meterNo = meterDAO.doGenerateMeterNo(userNo);// 据用户编号生成水表编号
		meter.setMeterNo(meterNo);// 设置水表编号
		meterDAO.save(meter);// 新增水表
		return userNo;
	}

	@Override
	public void doChangeName(User user) {
		userDAO.doChangeName(user);
	}

	@Override
	public void doChangeBank(User user) {
		userDAO.doChangeBank(user);
	}

	@Override
	public void doChangeMeter(User user) {
		String meterNo = meterDAO.doGenerateMeterNo(user.getUserNo());
		user.getMeter().setMeterNo(meterNo);
		meterDAO.doUpdateMeter(user);
	}

	@Override
	public void doChangeFormula(User user) {
		formulaDAO.deleteByUserNo(user.getUserNo());// 解除绑定用户的提比提量

		String formula = user.getFormula();// [SH:80%][SY:10%][GY:10%]
		formula = formula.replace("[", " ");//
		formula = formula.replace("]", " ");// 两次替换后变为： SH:80% SY:10% GY:10%
		String[] fms = formula.split("  ");// 根据两个空格分割成数组,长度为3, 值为下标0： SH:80%,下标1： SY:10%,下标2： GY:10%
		Formula f = null;
		CostType costType = null;
		for (String fm : fms) {// 值为下标0： SH:80%,下标1： SY:10%,下标2： GY:10%
			String[] arr = fm.split(":");// 根据冒号(:)分割成数组
			String fmCode = arr[0].trim(); // 用水类型代码
			String fmValue = arr[1].trim();// 提比提量值
			f = new Formula();// 新建提比提量
			f.setAllotText(fmValue);// 设置提取值表述
			f.setAllotType(fmValue.contains("%") ? 2 : (fmValue.trim().equals("*") ? 3 : 1));// 设置提取方式,如果提比提量值包含百分号(%),则为提比,如果提比提量值是*,则为取剩余,否则为提量
			f.setAllotValue(fmValue.contains("%") ? Integer.parseInt(fmValue.replace("%", ""))
					: (fmValue.equals("*") ? null : Integer.parseInt(fmValue)));// 设置提取值,如果提比提量值包含百分号(%),则去掉百分号,如果提比提量值是*,则为null,否则为提量(取原值)

			costType = new CostType();
			costType.setId(1);// 设置用水类型编号(不知道为什么不设置这个就报错，好像可以随便设置?)
			costType.setCode(fmCode);// 设置用水类型代码
			f.setCostType(costType);// 绑定用水类型

			f.setUser(user);// 绑定用户
			formulaDAO.save(f);// 添加提比提量
		}

		userDAO.doChangeFormula(user);
	}

	@Override
	public void doCloseAccount(User user) {
		userDAO.doCloseAccount(user);
	}

	@Override
	public void doChangeDocNum(User user) {
		userDAO.doChangeDocNum(user);
	}

	@Override
	public List<User> findAllLackOfUser(PageBean pageBean) {
		return userDAO.findAllLackOfUser(pageBean);
	}
}