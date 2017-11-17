package com.zking.water.user.biz;

import java.io.Serializable;
import java.util.List;

import com.zking.water.base.biz.IBaseBiz;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.User;

/**
 * 用户业务对象
 * 
 * @author Administrator
 *
 */
public interface IUserBiz extends IBaseBiz<User> {

	/**
	 * 模糊查询用户
	 * 
	 * @param user
	 *            用户信息
	 * @param pageBean
	 *            分页对象
	 * @return 用户对象集合
	 * @throws Exception
	 */
	public List<User> findFreetext(User user, PageBean pageBean) throws Exception;

	/**
	 * 新增用户
	 * 
	 * @param user
	 *            用户信息
	 * @return 用户编号
	 * @throws Exception
	 */
	public Serializable save(User user) throws Exception;

	/**
	 * 过户
	 * 
	 * @param user
	 *            用户信息
	 */
	public void doChangeName(User user) throws Exception;

	/**
	 * 代扣
	 * 
	 * @param user
	 *            用户信息
	 */
	public void doChangeBank(User user) throws Exception;

	/**
	 * 换表
	 * 
	 * @param user
	 *            用户信息
	 */
	public void doChangeMeter(User user) throws Exception;

	/**
	 * 重签
	 * 
	 * @param user
	 *            用户信息
	 */
	public void doChangeFormula(User user) throws Exception;

	/**
	 * 销户
	 * 
	 * @param user
	 *            用户信息
	 */
	public void doCloseAccount(User user) throws Exception;

	/**
	 * 档案号管理
	 * 
	 * @param user
	 *            用户信息
	 */
	public void doChangeDocNum(User user) throws Exception;

}
