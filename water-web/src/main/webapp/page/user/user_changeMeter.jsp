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
			
			<h2>快捷换表</h2>

			<div class="searchUserDiv">
				<form action="action/user/user/findFreetext" method="post">
					用户编码 <input name="userNo" value="<s:property value='#session.user.userNo'/>" />
					用户简码 <input name="abc" value="<s:property value='#session.user.abc'/>" />
					用户姓名 <input name="userName" value="<s:property value='#session.user.userName'/>" />
					联系电话 <input name="phone" value="<s:property value='#session.user.phone'/>" />
					家庭住址 <input name="address" value="<s:property value='#session.user.address'/>" />
						 	 <input type="hidden" name="forward" value="user_changeMeter" />
					<button class="btn btn-small btn-icon btn-person" type="submit">
						<span></span>
						查询用户
					</button>
				</form>
			</div>
			
			<br/><br/>
			
			<h3 style="width:50%;">快捷换表</h3>
			
			<table width="100%">
				<thead>
					<tr>
						<th width="60"></th>
						<th width="220"></th>
						<th width="60"></th>
						<th width="220"></th>
						<th width="60"></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>用户编码</td>
						<td><input disabled="disabled" value="0100000987" /></td>
						<td>用户姓名</td>
						<td><input disabled="disabled" value="张三" /></td>
						<td>原表类型</td>
						<td><input disabled="disabled" value="DN40" /></td>
					</tr>
					<tr>
						<td>新表编号</td>
						<td><input readonly="readonly" disabled="disabled" value="自动生成" /></td>
						<td>表身码</td>
						<td><input value="01010001" /></td>
						<td>起始底码</td>
						<td><input value="2" /></td>
					</tr>
					<tr>
						<td>水表类型</td>
						<td><select style="width:158px;">
								<option>DN10</option>
								<option>DN15</option>
								<option>DN20</option>
								<option>DN40</option>
								<option>DN80</option>
								<option>DN100</option>
								<option>DN200</option>
								<option>DN500</option>
								<option>DN1000</option>
							</select></td>
						<td>水表口径</td>
						<td><input value="40" /></td>
						<td>最大码值</td>
						<td><input value="99999" onClick="WdatePicker();" /></td>
					</tr>
					<tr>
						<td>装表日期</td>
						<td><input value="2010-10-27" /></td>
						<td>水表厂家</td>
						<td colspan="3"><input size="68" value="城至水表厂" /></td>
					</tr>
				</tbody>
				</table>
				
				<div style=" margin:20px 0px 0px 66px;" >
					<button class="btn">更换水表</button>
				</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>