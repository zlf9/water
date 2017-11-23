<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/head.jsp"%>

<script type="text/javascript">
	$(document).ready(function() { 
		var oweMoney = $("#oweMoney").val().trim();
		if (oweMoney != '0.00 元') {
			//alert("注：此户水费尚未清算，不能销户。");
			$("#closeAccountSubmit").attr("disabled", true);
			$("#closeAccountSubmit").attr("class",
					$("#closeAccountSubmit").attr("class") + " btn-grey");
			$("#owe").css("display", "block");
		} else {
			$("#closeAccountSubmit").attr("disabled", false);
			$("#owe").css("display", "none");
		}
	});

	function doCloseAccount() {
		var userNo = $("#userNo").val().trim();
		var oweMoney = $("#oweMoney").val().trim();
		var closeAccountRemark = $("#closeAccountRemark").val().trim();
		
		if(""==userNo){
			$("#message").html("请查询需要销户的用户后再进行操作");
			return false;
		}
		
		if (oweMoney != '0.00 元') {
			//alert("注：此户水费尚未清算，不能销户。");
			$("#closeAccountSubmit").attr("disabled", true);
			$("#closeAccountSubmit").attr("class",
					$("#closeAccountSubmit").attr("class") + " btn-grey");
			$("#owe").css("display", "block");
			return false;
		}
		if ("" == closeAccountRemark) {
			$("#message").html("请输入销户说明");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="wrapper">

		<%@ include file="/common/top.jsp"%>

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>快捷销户</h2>

				<div class="searchUserDiv">
					<form action="action/user/user/findFreetext" method="post">
						用户编码 <input name="userNo"
							value="<s:property value='#session.user.userNo'/>" /> 用户简码 <input
							name="abc" value="<s:property value='#session.user.abc'/>" />
						用户姓名 <input name="userName"
							value="<s:property value='#session.user.userName'/>" /> 联系电话 <input
							name="phone" value="<s:property value='#session.user.phone'/>" />
						家庭住址 <input name="address"
							value="<s:property value='#session.user.address'/>" /> <input
							type="hidden" name="forward" value="user_delete" />
						<button class="btn btn-small btn-icon btn-person" type="submit">
							<span></span> 查询用户
						</button>
					</form>
				</div>

				<br /> <br />



				<div class="form label-inline uniform">
					<h3 style="width: 50%;">快捷销户</h3>
					<form action="action/user/user/doCloseAccount" method="post"
						onsubmit="return doCloseAccount()">
						<div class="field">
							<label for="userNo">用户编码</label> <input id="oldUserNo"
								name="oldUserNo" size="50" type="text" class="medium"
								disabled="disabled" value="<s:property value="result.userNo"/>" />
						</div>

						<div class="field">
							<label for="oldUserName">原用户姓名</label> <input id="oldUserName"
								name="oldUserName" size="50" type="text" class="medium"
								disabled="disabled"
								value="<s:property value="result.userName"/>" />
						</div>

						<div class="field">
							<label for="oweMoney">欠费金额</label> <input id="oweMoney"
								name="oweMoney" size="50" type="text" class="medium"
								disabled="disabled"
								value="<s:if test="result.userMoney >= 0">0.00</s:if><s:else><s:property value="@java.lang.Math@abs(result.userMoney)"/></s:else> 元" />
						</div>
						<input id="userNo" name="userNo" size="50" type="hidden"
							class="medium" value="<s:property value="result.userNo"/>" />
						<div class="field">
							<label for="closeAccountRemark">销户说明</label> <input
								id="closeAccountRemark" name="user.closeAccountRemark" size="100"
								type="text" class="medium" value="" />
						</div>

						<div id="owe"
							style="padding-left: 145px; color: red; display: block;">
							注：此户水费尚未清算，不能销户。</div>
							
						<div id="message" style="padding-left: 145px; color: red; display: block;"></div>
						<div class="buttonrow">
							<button id="closeAccountSubmit" class="btn" disabled="disabled"
								type="submit">销户</button>
						</div>
					</form>
				</div>
			</div>
			<!-- .x12 -->

		</div>
		<!-- #content -->

		<%@ include file="/common/bottom.jsp"%>

		<c:remove var="user" scope="session" />
	</div>
	<!-- #wrapper -->

</body>
</html>