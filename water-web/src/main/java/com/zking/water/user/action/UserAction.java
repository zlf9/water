package com.zking.water.user.action;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zking.water.base.action.BaseAction;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.biz.IMeterBiz;
import com.zking.water.user.biz.IUserBiz;
import com.zking.water.user.entity.User;

public class UserAction extends BaseAction<User> {
	private IUserBiz userBiz;
	private IMeterBiz meterBiz;

	public UserAction() {
		super();
	}

	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setMeterBiz(IMeterBiz meterBiz) {
		this.meterBiz = meterBiz;
	}

	/**
	 * 查询全部用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAllUser() {
		try {
			List<User> users = userBiz.findAll();// 查询全部返回所有用户的对象集合
			result = users == null || users.size() < 1 ? null : users;// 如果没有查到则为NULL，有则为所有用户的对象集合
			return SUCCESS;
		} catch (Exception e) {
			throw new RuntimeException("查询全部用户失败", e);
		}
	}

	/**
	 * 根据用户编号查询用户对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByUserNo() {
		try {
			result = StringUtils.isNotBlank(model.getUserNo()) ? userBiz.getById(model.getUserNo()) : null;// 如果用户编号不为空则根据用户编号查询用户对象，否则直接为NULL
			return forward;
		} catch (Exception e) {
			throw new RuntimeException("根据用户编号查询用户对象失败", e);
		}
	}

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	public String findFreetext() {
		try {
			session.setAttribute("user", model);// 查询条件
			request.setAttribute("forward", forward);// 跳转页面
			PageBean pageBean = handlerPageBean();
			List<User> users = userBiz.findFreetext(model, pageBean);// 模糊查询返回用户对象集合
			/*
			 * if (null != users) { switch (pageBean.getTotalRecord()) { case 0: result =
			 * null; break; case 1: result = users.get(0); break; default: result = users;
			 * break; } }
			 */

			result = null == users || pageBean.getTotalRecord() < 1 ? null
					: pageBean.getTotalRecord() == 1 ? users.get(0) : users;// 如果没有查询到则为NULL,查询到只有一个则为用户对象,查询到多个则为用户对象集合

			return null == users || pageBean.getTotalRecord() <= 1 ? forward : "Multiple";
		} catch (Exception e) {
			throw new RuntimeException("模糊查询失败", e);
		}
	}

	/**
	 * 新户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveUser() {
		String saveResult = "";
		try {
			Serializable userNo = userBiz.save(model);// 新户
			model.setUserNo((String) userNo);// 设置用户编号
			model.getMeter().setUser(model);// 设置水表对应的用户为刚刚新建的用户
			Serializable meterNo = meterBiz.save(model.getMeter());// 新增成功后返回水表编号
			saveResult = StringUtils.isNotBlank((String) meterNo) ? SUCCESS : ERROR;// 如果水表编号不为空则新户成功,否则失败
		} catch (Exception e) {
			saveResult = ERROR;// 新户失败
			// throw new RuntimeException("添加用户和水表失败", e);
		}
		return saveResult;
	}

	/**
	 * 过户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doChangeName() {
		String changeNameResult = "";
		try {
			if (StringUtils.isNotBlank(model.getUserNo())) {// 如果用户编号不为空
				userBiz.doChangeName(model);// 过户
				changeNameResult = SUCCESS;// 过户成功
			} else {
				changeNameResult = ERROR;// 过户失败
			}
		} catch (Exception e) {
			changeNameResult = ERROR;// 过户失败
			// throw new RuntimeException("过户失败", e);
		}
		return changeNameResult;
	}

	/**
	 * 代扣
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doChangeBank() {
		String changeBankResult = "";
		try {
			if (StringUtils.isNotBlank(model.getUserNo())) {// 如果用户编号不为空
				userBiz.doChangeBank(model);// 代扣
				changeBankResult = SUCCESS;// 代扣成功
			} else {
				changeBankResult = ERROR;// 代扣失败
			}
		} catch (Exception e) {
			changeBankResult = ERROR;// 代扣失败
			// throw new RuntimeException("代扣失败", e);
		}
		return changeBankResult;
	}

	/**
	 * 销户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doCloseAccount() {
		String closeAccountResult = "";
		try {
			if (StringUtils.isNotBlank(model.getUserNo())) {// 如果用户编号不为空
				userBiz.doCloseAccount(model);// 销户
				closeAccountResult = SUCCESS;// 销户成功
			} else {
				closeAccountResult = ERROR;// 销户失败
			}
		} catch (Exception e) {
			closeAccountResult = ERROR;// 销户失败
			// throw new RuntimeException("销户失败", e);
		}
		return closeAccountResult;
	}

	/**
	 * 档案号管理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doChangeDocNum() {
		String changeDocNumResult = "";
		try {
			if (StringUtils.isNotBlank(model.getUserNo())) {// 如果用户编号不为空
				userBiz.doChangeDocNum(model);// 档案号修改或新增
				changeDocNumResult = SUCCESS;// 档案号修改或新增成功
			} else {
				changeDocNumResult = ERROR;// 档案号修改或新增失败
			}
		} catch (Exception e) {
			changeDocNumResult = ERROR;// 档案号修改或新增失败
			// throw new RuntimeException("档案号修改或新增失败", e);
		}
		return changeDocNumResult;
	}
}
