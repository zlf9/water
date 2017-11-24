<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<base target="_self">
	
	<script type="text/javascript">
		function setTibi() {
			var oldFormula = $("#oldFormula").val().trim();
			var formula = $("#formula").val().trim();
			
		
			var returnFormula = window.showModalDialog("page/sys/sys_setTibi", "" == formula ? oldFormula : formula, "dialogHeight:600px;dialogWidth:800px;");
			$("#formula").val(null==returnFormula||""==returnFormula.trim()?returnFormula:formula);
			
		
			/* showWindow({
				url : 'page/sys/sys_setTibi',
				width : 630,
				height : 500, 
				callback: function(val){
					//alert(val.addr);  //回调处理
				}
			}); */
		}
		
		function doChangeFormula(){
			return false;
		}
	</script>
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
				<form action="action/user/user/doChangeFormula" method="post" onsubmit="return doChangeFormula()">
					<div class="field">
						<label for="userNo">用户编码</label> 
						<input id="userNo" name="userNo" type="hidden" value="<s:property value="result.userNo"/>" />
						<input id="oldUserNo" name="oldUserNo" size="50" type="text" class="medium" disabled="disabled" 
							   value="<s:property value="result.userNo"/>" />
					</div>
						
					<div class="field">
						<label for="oldUserName">原用户姓名</label> 
						<input id="oldUserName" name="oldUserName" size="50" type="text" class="medium" disabled="disabled" 
							   value="<s:property value="result.userName"/>" />
					</div>
						
					<div class="field">
						<label for="oldFormula">原提比提量</label> 
					    <span class="text_button">
						<input id="oldFormula" name="oldFormula" disabled="disabled"
						 	   style="width:342px;" readonly="readonly" value="<s:property value="result.formula"/>" />
					    </span>
					</div>
								
					<div class="field">
						<label for="formula">现提比提量</label> 
						<span class="text_button">
							<input id="formula" name="formula" style="width:300px;" readonly="readonly" value="[SH:80%][SY:10%][GY:10%]" />
							
							<button onClick="setTibi();" style="height:28px;">设定</button>
						</span>
					</div>
	
					<div id="message" style="padding-left: 145px; color: red; display: block;"></div>
					<div class="buttonrow">
						<button class="btn" type="submit">重新签订用水协议</button>
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