package com.zking.water.user.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.zking.water.base.biz.impl.BaseBizImpl;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.biz.IUserBiz;
import com.zking.water.user.dao.IUserDAO;
import com.zking.water.user.entity.User;

public class UserBizImpl extends BaseBizImpl<User> implements IUserBiz {
	private static final long serialVersionUID = 1264222658209438863L;

	private IUserDAO userDAO;

	public UserBizImpl() {
		super();
	}

	public void setUserDAO(IUserDAO userDAO) {
		super.setBaseDAO(userDAO);
		this.userDAO = userDAO;
	}

	@Override
	public User getById(Serializable userNo) {
		return userDAO.getById(userNo);
	}

	@Override
	public List<User> findFreetext(User user, PageBean pageBean) {
		return userDAO.findFreetext(user, pageBean);
	}

	@Override
	public Serializable save(User user) {
		String userNo = userDAO.doGenerateUserNo(user.getAreaId());
		user.setUserNo(userNo);
		return userDAO.save(user);
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
		userDAO.doChangeMeter(user);
	}

	@Override
	public void doChangeFormula(User user) {
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