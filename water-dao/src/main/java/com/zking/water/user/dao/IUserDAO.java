package com.zking.water.user.dao;

import java.util.List;

import com.zking.water.base.dao.IBaseDAO;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.entity.User;

/**
 * 用户数据访问对象
 * 
 * @author Administrator
 *
 */
public interface IUserDAO extends IBaseDAO<User> {

	/**
	 * 模糊查询
	 * 
	 * @param user
	 *            搜索条件
	 * @param pageBean
	 *            分页对象
	 * @return 查询出来的用户集合
	 * @throws Exception
	 */
	public List<User> findFreetext(User user, PageBean pageBean);

	/**
	 * 根据辖区ID生成用户编号
	 * 
	 * @param areaId
	 *            辖区ID
	 * @return 用户编号
	 * @throws Exception
	 */
	public String doGenerateUserNo(Integer areaId);

	/**
	 * 过户
	 * 
	 * @param user
	 */
	public void doChangeName(User user);

	/**
	 * 代扣
	 * 
	 * @param user
	 */
	public void doChangeBank(User user);

	/**
	 * 换表
	 * 
	 * @param user
	 */
	public void doChangeMeter(User user);

	/**
	 * 重签
	 * 
	 * @param user
	 */
	public void doChangeFormula(User user);

	/**
	 * 销户
	 * 
	 * @param user
	 */
	public void doCloseAccount(User user);

	/**
	 * 档案号管理
	 * 
	 * @param user
	 */
	public void doChangeDocNum(User user);

}
