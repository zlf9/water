<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function() {
			var oldPayType = $("#oldPayType").val().trim();
			if(oldPayType == '银行代扣'){
				$("#oldBankNameDiv").css("display", "block");
				$("#oldBankNumDiv").css("display", "block");
			}else{
				$("#oldBankNameDiv").css("display", "none");
				$("#oldBankNumDiv").css("display", "none");
			}
			doChangePayType();
		});
	
		function doChangePayType(){
			var payTypeName = $("#payTypeSelect option:selected").text().trim();
			if(payTypeName == '银行代扣'){
				$("#bankNameDiv").css("display", "block");
				$("#bankNumDiv").css("display", "block");
			}else{
				$("#bankNameDiv").css("display", "none");
				$("#bankNumDiv").css("display", "none");
			}
		}
		
		function doChangeBank(){
			var userNo = $("#userNo").val().trim();
			
			var oldUserName = $("#oldUserName").val().trim();
			var oldPayType = $("#oldPayType").val().trim();
			var oldBankName = $("#oldBankName").val().trim();
			var oldBankNum = $("#oldBankNum").val().trim();
			
			var payTypeName = $("#payTypeSelect option:selected").text().trim();
			var bankName = $("#bankName").val().trim();
			var bankNum = $("#bankNum").val().trim();
			
			
			if(""==userNo){
				$("#message").html("请查询需要代扣的用户后再进行操作");
				return false;
			}
			
			if(payTypeName != '银行代扣'){
				if(oldPayType == payTypeName){
					$("#message").html("新收款方式和原收款方式相同");
					return false;
				}
			}else{
				if("" == bankName){
					$("#message").html("开户银行不能为空");
					return false;
				}else if("" == bankNum){
					$("#message").html("银行账号不能为空");
					return false;
				}else if(oldBankNum == bankNum){
					$("#message").html("原银行账号和新银行账号相同");
					return false;
				}
			}
		}
	</script>
</head> 
<body> 
<div id="wrapper">
	<s:action name="dictAction!findAllByDictName" namespace="/dict" var="dictAction">
		<s:param name="dictName" value="'收款方式'"></s:param>
	</s:action>
	
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
				<form action="action/user/user/doChangeBank" method="post" onsubmit="return doChangeBank()">
					<div class="field"><label for="userNo">用户编码</label> <input id="oldUserNo" name="oldUserNo" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.userNo"/>" /></div>
						
					<div class="field"><label for="oldUserName">原用户姓名</label> <input id="oldUserName" name="oldUserName" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.userName"/>" /></div>
					<div class="field"><label for="oldPayType">原收款方式</label> <input id="oldPayType" name="oldPayType" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="#dictAction.findByDictNameAndValue('收款方式',result.payType)"/>" /></div>
					<div class="field" id="oldBankNameDiv"><label for="oldBankName">原开户银行</label> <input id="oldBankName" name="oldBankName" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.bankName"/>" /></div>
					<div class="field" id="oldBankNumDiv"><label for="oldBankNum">原银行账号</label> <input id="oldBankNum" name="oldBankNum" size="50" type="text" class="medium" disabled="disabled" value="<s:property value="result.bankNum"/>" /></div>
					
					
					<input id="userNo" name="userNo" type="hidden" value="<s:property value="result.userNo"/>" />
					<div class="field"><label for="payType">新收款方式</label> 
						<s:select id="payTypeSelect" list="#dictAction.result" listKey="value" listValue="text" name="payType" style="width: 353px;" onchange="doChangePayType();"></s:select>
					</div>
					<div class="field" id="bankNameDiv"><label for="bankName">新开户银行</label> <input id="bankName" name="bankName" size="50" type="text" class="medium" value="" /></div>
					<div class="field" id="bankNumDiv"><label for="bankNum">新银行账号</label> <input id="bankNum" name="bankNum" size="50" type="text" class="medium" value="" /></div>
					
	
					<div id="message" style="padding-left: 145px; color: red; display: block;"></div>
					<div class="buttonrow">
						<button class="btn" type="submit">保存银行代扣设置</button>
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