<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>湖南省自来水公司营销管理信息系统 - 员工登陆</title>

<%@ include file="/common/head.jsp"%>
<link rel="stylesheet" href="css/login.css" type="text/css"
	media="screen" title="no title" />

<script type="text/javascript">
	function doLogin() {
		var empNo = $("#empNo").val().trim();
		var pwd = $("#pwd").val().trim();
		if ("" != empNo && "" != pwd) {
			$.post("action/sy/emp/doLogin", {
				'empNo' : empNo,
				'pwd' : pwd
			}, function(data) {
				if ("true" == data) {
					alert("登录成功");
					location.href = 'page/common/workspace';
				} else {
					alert("员工编号或者登陆密码错误");
				}
			}, "text"); 
		} else {
			alert("请输入完整登录信息");
		}
	}
</script>
</head>
<body>
	<div id="login_background">
		<div id="login">
			<h1>员工登陆</h1>
			<div id="login_panel">
				<div class="login_fields">
					<div class="field">
						<label for="empNo">员工工号：</label> <input type="text" name="empNo"
							value="" id="empNo" tabindex="1" placeholder="请输入您的员工编号" />
					</div>

					<div class="field">
						<label for="pwd">登陆密码： </label> <input type="password" name="pwd"
							value="" id="pwd" tabindex="2" placeholder="请输入您的密码" />
					</div>
				</div>
				<!-- .login_fields -->

				<div class="login_actions">
					<button type="button" onclick="doLogin()" class="btn btn-orange"
						tabindex="3">登陆</button>
				</div>
			</div>
			<!-- #login_panel -->
		</div>
		<!-- #login -->
	</div>
</body>
</html>