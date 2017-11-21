<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
		function doChangeName(){
			var userNo = $("#userNo").val().trim();
			
			var oldUserName = $("#oldUserName").val().trim();
			var oldPhone = $("#oldPhone").val().trim();
			var oldSMSPhone = $("#oldSMSPhone").val().trim();
			var oldAddress = $("#oldAddress").val().trim();
			
			var userName = $("#userName").val().trim();
			var phone = $("#phone").val().trim();
			var smsphone = $("#smsphone").val().trim();
			var address = $("#address").val().trim();
			
			if(oldUserName == userName&&oldPhone == phone&&oldSMSPhone == smsphone&&oldAddress == address){
				alert("新信息和原信息相同");
				return false;
			}
			
			return ""!=userNo&&""!=userName&&""!=phone&&""!=smsphone&&""!=address;
		}
	</script>
</head> 
<body> 
<div id="wrapper">
	
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷过户</h2>

			<div class="searchUserDiv">
				<form action="action/user/user/findFreetext" method="post">
					用户编码 <input name="userNo" value="<s:property value='#session.user.userNo'/>" />
					用户简码 <input name="abc" value="<s:property value='#session.user.abc'/>" />
					用户姓名 <input name="userName" value="<s:property value='#session.user.userName'/>" />
					联系电话 <input name="phone" value="<s:property value='#session.user.phone'/>" />
					家庭住址 <input name="address" value="<s:property value='#session.user.address'/>" />
						 	 <input type="hidden" name="forward" value="user_changeName" />
					<button class="btn btn-small btn-icon btn-person" type="submit">
						<span></span>
						查询用户
					</button>
				</form>
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">快捷过户</h3>
				<form action="action/user/user/doChangeName" method="post" onsubmit="return doChangeName()">
					<div class="field"><label for="userNo">用户编码</label> <input id="oldUserNo" name="oldUserNo" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.userNo"/>" /></div>
					
					<div class="field"><label for="oldUserName">原用户姓名</label> <input id="oldUserName" name="oldUserName" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.userName"/>" /></div>
					<div class="field"><label for="oldPhone">原联系电话</label> <input id="oldPhone" name="oldPhone" size="50" type="text" class="medium" disabled="disabled" value="<s:property value='result.phone'/>" /></div>
					<div class="field"><label for="oldSMSPhone">原短信电话</label> <input id="oldSMSPhone" name="oldSMSPhone" size="50" type="text" class="medium" disabled="disabled" value="<s:property value='result.smsphone'/>" /></div>
					<div class="field"><label for="oldAddress">原联系地址</label> <input id="oldAddress" name="oldAddress" size="50" type="text" class="medium" disabled="disabled" value="<s:property value='result.address'/>" /></div>
					
					
																				<input id="userNo" name="userNo" size="50" type="hidden" class="medium" value="<s:property value="result.userNo"/>" />
					<div class="field"><label for="userName">新用户姓名</label> <input id="userName" name="userName" size="50" type="text" class="medium" value="" /></div>
					<div class="field"><label for="phone">新联系电话</label> <input id="phone" name="phone" size="50" type="text" class="medium" value="" /></div>
					<div class="field"><label for="smsphone">新短信电话</label> <input id="smsphone" name="smsphone" size="50" type="text" class="medium" value="" /></div>
					<div class="field"><label for="address">新联系地址</label> <input id="address" name="address" size="50" type="text" class="medium" value="" /></div>
					
	
					<div class="buttonrow">
						<button class="btn" type="submit">过户</button>
					</div>
				</form>
			</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	<c:remove var="user" scope="session"/>
</div> <!-- #wrapper -->

</body> 
</html>