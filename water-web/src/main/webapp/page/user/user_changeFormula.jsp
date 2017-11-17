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
			
			<h2>快捷重签</h2>

			<div class="searchUserDiv">
				<form action="action/user/user/findFreetext" method="post">
					用户编码 <input name="userNo" value="<s:property value='#session.user.userNo'/>" />
					用户简码 <input name="abc" value="<s:property value='#session.user.abc'/>" />
					用户姓名 <input name="userName" value="<s:property value='#session.user.userName'/>" />
					联系电话 <input name="phone" value="<s:property value='#session.user.phone'/>" />
					家庭住址 <input name="address" value="<s:property value='#session.user.address'/>" />
						 	 <input type="hidden" name="forward" value="user_changeFormula" />
					<button class="btn btn-small btn-icon btn-person" type="submit">
						<span></span>
						查询用户
					</button>
				</form>
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">快捷重签</h3>
				<div class="field"><label for="id">用户编码</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled" value="0100000987" /></div>
				
				<div class="field"><label for="name">用户姓名</label> <input id="name" name="lname" size="50" type="text" class="medium" disabled="disabled" value="张三" /></div>
				
				<div class="field"><label for="name">原提比提量</label> <span class="text_button">
			<input id="batchTibi" disabled="disabled"
				style="width:245px;" readonly="readonly" value="[SH:80%][SY:20%]" /></span></div>
							
				<div class="field"><label for="name">现提比提量</label> <span class="text_button">
			<input id="batchTibi" 
				style="width:200px;" readonly="readonly" value="[SH:80%][SY:10%][GY:10%]" />
			<button onClick="setTibi();">设定</button></span></div>

				<div class="buttonrow">
					<button class="btn">重新签订用水协议</button>
				</div>

			</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>