<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
</head> 
<body> 
<div id="wrapper">
	<s:action name="empAction!findAllEmp" namespace="/sy" var="empAction"></s:action>
	
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷操作记录</h2>
			
			<div class="searchDiv">
				<form action="action/user/orderLite/findFreetext" method="post">
					操作类型 <s:select list="#empAction.findAllByDictName('工单类型')" listKey="value" listValue="text" name="orderType" value="#session.orderLite.orderType" headerKey="-1" headerValue="所有" class="medium"></s:select>
					操作人员 <s:select list="#empAction.result" listKey="id" listValue="empName" name="empId" value="#session.orderLite.emp.empId" headerKey="-1" headerValue="所有" class="medium"></s:select>
					
					操作日期 <span class="between">
								<input onClick="WdatePicker();" name="leftDatee" value="<fmt:formatDate value="${leftDatee }" pattern="yyyy-MM-dd"/>" />
								 - 
								<input onClick="WdatePicker();" name="rightDatee" value="<fmt:formatDate value="${rightDatee }" pattern="yyyy-MM-dd"/>" />
							</span>
					<button class="btn btn-small btn-icon btn-find" onclick="javascript:$('.searchDiv').submit();">
						<span></span>查询
					</button>
				</form>	
			</div>
			
			
			<div class="reportTitle">
				快捷操作记录
			</div>	
			<div class="height24">
				<div style="float:left;width:200px;">共 ${pageBean.totalRecord } 次快捷操作</div>
			</div>
			<table class="data display">
				<thead>
					<tr>
						<th width="128">操作时间</th>
						<th width="60">操作员</th>
						<th width="40">类型</th>
						<th width="60">用户编码</th>
						<th width="100">用户姓名</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="result != null">
						<s:iterator var="orderLite" value="result" status="st">
							<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
								<td class="center"><s:date name="#orderLite.datee" format="yyyy-MM-dd HH:mm:ss"/></td>
								<td class="center"><s:property value="#orderLite.emp.empName"/></td>
								<td class="center"><s:property value="#empAction.findByDictNameAndValue('工单类型',#orderLite.orderType)"/></td>
								<td class="center"><s:property value="#orderLite.user.userNo"/></td>
								<td class="center"><s:property value="#orderLite.user.userName"/></td>
								<td><s:property value="#orderLite.description"/></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
				</table>
				<z:page pageBean="${pageBean }" />
				
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
	<c:remove var="orderLite" scope="session"/>
</div> <!-- #wrapper -->

</body> 
</html>