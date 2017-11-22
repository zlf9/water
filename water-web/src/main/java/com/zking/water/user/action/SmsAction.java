package com.zking.water.user.action;

import java.util.List;

import com.zking.water.base.action.BaseAction;
import com.zking.water.base.entity.PageBean;
import com.zking.water.user.biz.ISmsBiz;
import com.zking.water.user.biz.IUserBiz;
import com.zking.water.user.entity.Sms;
import com.zking.water.user.entity.User;

public class SmsAction extends BaseAction<Sms> {
	private ISmsBiz smsBiz;
	private IUserBiz userBiz;

	public SmsAction() {
		super();
	}

	public void setSmsBiz(ISmsBiz smsBiz) {
		this.smsBiz = smsBiz;
	}

	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}

	/**
	 * 查询全部短信群发记录
	 * 
	 * @return
	 */
	public String findAll() {
		try {
			PageBean pageBean = handlerPageBean();
			List<Sms> smss = smsBiz.findAll(pageBean);// 查询全部短信群发记录返回短信群发记录对象集合

			result = null == smss || pageBean.getTotalRecord() < 1 ? null : smss;// 如果没有查询到则为NULL,否则为快捷操作记录对象集合

			return "user_sendMsg";
		} catch (Exception e) {
			throw new RuntimeException("查询全部短信群发记录失败", e);
		}
	}

	/**
	 * 生成发送内容
	 * 
	 * @return
	 */
	public String generateSendContent() {
		session.setAttribute("sms", model);// 生成条件
		try {
			Integer sendType = model.getTypee();// 发送类型(1.给所有用户发,2.只给欠费用户发)
			// String sendMsg = model.getMessage();// 群发内容

			// 如果为1就是给所有用户发(查询所有用户),否则如果为2就是只给欠费用户发(查询所有欠费用户),如果不为1或2则不查直接返回null
			List<User> users = null != sendType
					? (sendType == 1 ? users = userBiz.findFreetext(null, handlerPageBean())
							: (sendType == 2 ? userBiz.findAllLackOfUser(handlerPageBean()) : null))
					: null;
			/*if (null != users) {// 如果用户集合不为空
				User u = null;
				for (int i = 0; i < users.size(); i++) {// 遍历用户集合
					u = users.get(i);
					String newSendMsg = "";// 保存替换占位符后的群发内容
					if (null != sendMsg) {// 如果群发内容不为空
						newSendMsg = sendMsg.replace("{用户姓名}", u.getUserName());// 替换用户姓名
						newSendMsg = newSendMsg.replace("{欠费金额}", (u.getUserMoney() * -1) + "");// 替换欠费金额
					}
					u.setSendMsg(newSendMsg);// 生成发送内容
				}
			}*/
			this.result = users;
			return "user_sendMsg";
		} catch (Exception e) {
			throw new RuntimeException("生成发送内容失败", e);
		}
	}

	/**
	 * 群发内容替换占位符
	 * 
	 * @param sendMsg
	 *            群发内容
	 * @param user
	 *            用户信息
	 * @return 替换占位符后的群发内容
	 */
	public String sendMsgToNewSendMsg(String sendMsg, User user) {
		String newSendMsg = "";// 保存替换占位符后的群发内容
		if (null != sendMsg && null != user) {// 如果群发内容不为空
			newSendMsg = sendMsg.replace("{用户姓名}", user.getUserName());// 替换用户姓名
			newSendMsg = newSendMsg.replace("{欠费金额}", (user.getUserMoney() * -1) + "");// 替换欠费金额
		}
		return newSendMsg;
	}

}
