<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
</head> 
<body> 
<div id="wrapper">
	
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷代扣</h2>

			<div class="searchUserDiv">
				<form action="action/user/user/findFreetext" method="post">
					用户编码 <input name="userNo" value="<s:property value='#session.user.userNo'/>" />
					用户简码 <input name="abc" value="<s:property value='#session.user.abc'/>" />
					用户姓名 <input name="userName" value="<s:property value='#session.user.userName'/>" />
					联系电话 <input name="phone" value="<s:property value='#session.user.phone'/>" />
					家庭住址 <input name="address" value="<s:property value='#session.user.address'/>" />
						 	 <input type="hidden" name="forward" value="user_changeBank" />
					<button class="btn btn-small btn-icon btn-person" type="submit">
						<span></span>
						查询用户
					</button>
				</form>
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline">
				<h3 style="width:50%;">快捷代扣</h3>
				<div class="field"><label for="oldUserNo">用户编码</label> <input id="oldUserNo" name="oldUserNo" size="50" type="text" class="medium" disabled="disabled" value="0100000987" /></div>
				
				<div class="field"><label for="oldUserName">用户姓名</label> <input id="oldUserName" name="oldUserName" size="50" type="text" class="medium" disabled="disabled" value="张三" /></div>
				<div class="field"><label for="oldPayType">原收款方式</label> <input id="oldPayType" name="oldPayType" size="50" type="text" class="medium" disabled="disabled" value="坐收" /></div>
				<div class="field"><label for="oldBankName">原开户银行</label> <input id="oldBankName" name="oldBankName" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				<div class="field"><label for="oldBankNum">原银行账号</label> <input id="oldBankNum" name="oldBankNum" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				
				
				<input id="userNo" name="userNo" value="0100000987" />
				<div class="field"><label for="payType">新收款方式</label> 
					<s:select list="#Action." name="payType"></s:select>
				</div>
				<div class="field"><label for="bankName">新开户银行</label> <input id="bankName" name="bankName" size="50" type="text" class="medium" value="" /></div>
				<div class="field"><label for="bankNum">新银行账号</label> <input id="bankNum" name="bankNum" size="50" type="text" class="medium" value="" /></div>
				

				<div class="buttonrow">
					<button class="btn">保存银行代扣设置</button>
				</div>

			</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>