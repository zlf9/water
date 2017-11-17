<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/head.jsp"%>
<script type="text/javascript">
	function ok(no) {
		location.href = "action/user/user/findByUserNo?userNo="+no+"&forward=${forward}";
	}
</script>
<style type="text/css">
table.data thead th {
	text-align: left;
}
</style>
</head>
<body>

	<div style="width: 90%; margin: 0 auto;">
		<br />
		<h2>选择用户</h2>


		<table class="data display">
			<thead>
				<tr>
					<th>用户编码</th>
					<th>用户姓名</th>
					<th>简码</th>
					<th>电话</th>
					<th>地址</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="result != null">
					<s:iterator var="user" value="result" status="st">
						<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
							<td><a href="javascript:;" onClick="ok('<s:property value="#user.userNo"/>');"><s:property value="#user.userNo"/></a></td>
							<td><a href="javascript:;" onClick="ok('<s:property value="#user.userNo"/>');"><s:property value="#user.userName"/></a></td>
							<td><s:property value="#user.abc"/></td>
							<td><s:property value="#user.phone"/></td>
							<td><s:property value="#user.address"/></td>
						</tr>
					</s:iterator>
				</s:if>

			</tbody>
		</table>
		
		<z:page pageBean="${pageBean }" />

	</div>


</body>
</html>