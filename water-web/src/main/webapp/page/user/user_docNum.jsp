<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
		function doChangeDocNum(){
			var userNo = $("#userNo").val().trim();
			var oldDocNum = $("#oldDocNum").val().trim();
			var docNum = $("#docNum").val().trim();
			if(oldDocNum == docNum){
				alert("新档案编号和原档案编号相同");
				return false;
			}
			return ""!=userNo&&""!=docNum&&""!=docNum;
		}
	</script>
</head> 
<body> 
<div id="wrapper">
	
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>档案号管理</h2>

			<div class="searchUserDiv">
				<form action="action/user/user/findFreetext" method="post">
					用户编码 <input name="userNo" value="<s:property value='#session.user.userNo'/>" />
					用户简码 <input name="abc" value="<s:property value='#session.user.abc'/>" />
					用户姓名 <input name="userName" value="<s:property value='#session.user.userName'/>" />
					联系电话 <input name="phone" value="<s:property value='#session.user.phone'/>" />
					家庭住址 <input name="address" value="<s:property value='#session.user.address'/>" />
						 	 <input type="hidden" name="forward" value="user_docNum" />
					<button class="btn btn-small btn-icon btn-person" type="submit">
						<span></span>
						查询用户
					</button>
				</form>
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">档案号设置</h3>
				<form action="action/user/user/doChangeDocNum" method="post" onsubmit="return doChangeDocNum()">
					<div class="field"><label for="userNo">用户编码</label> <input id="oldUserNo" name="oldUserNo" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.userNo"/>" /></div>
					
					<div class="field"><label for="oldUserName">原用户姓名</label> <input id="oldUserName" name="oldUserName" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.userName"/>" /></div>
																		  <input id="oldDocNum" name="oldDocNum" size="50" type="hidden" class="medium" value="<s:property value="result.docNum"/>" />
																		  <input id="userNo" name="userNo" size="50" type="hidden" class="medium" value="<s:property value="result.userNo"/>" />
					<div class="field"><label for="docNum">档案号</label> <input id="docNum" name="docNum" size="50" type="text" class="medium" value="<s:property value="result.docNum"/>" /></div>
	
					<div class="buttonrow">
						<button class="btn" type="submit">保存</button>
					</div>
				</form>
			</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>