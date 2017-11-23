<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
	
		$(function(){
			doChangeMeterType();
		});
		
		function doChangeMeterType(){
			$("#meterTypeName").val($("#meterTypeSelect option:selected").text().trim());
		}
		
		function doChangeMeter(){
			var userNo = $("#userNo").val().trim();
			
			var meterName = $("#meterName").val().trim();
			var setupDate = $("#setupDate").val().trim();
			var factory = $("#factory").val().trim();
			
			if(""==userNo){
				$("#message").html("请查询需要换表的用户后再进行操作");
				return false;
			}else if("" == meterName){
				$("#message").html("表身码不能为空");
				return false;
			}else if("" == setupDate){
				$("#message").html("装表日期不能为空");
				return false;
			}else if("" == factory){
				$("#message").html("水表厂家不能为空");
				return false;
			}
		}
	</script>
</head> 
<body> 
<div id="wrapper">
	
	<s:action name="meterTypeAction!findAllMeterType" namespace="/sy" var="meterTypeAction"/>
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
			<form action="action/user/user/doChangeMeter" method="post" onsubmit="return doChangeMeter()">
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
							<td><input disabled="disabled" id="oldUserNo" name="oldUserNo" value="<s:property value='result.userNo'/>" /></td>
							<td>用户姓名</td>
							<td><input disabled="disabled" id="oldUserName" name="oldUserName" value="<s:property value='result.userName'/>" /></td>
							<td>原表类型</td>
							<td><input disabled="disabled" id="oldUserName" name="oldUserName" value="<s:property value='result.meter.meterType.meterTypeName'/>" /></td>
						</tr>
						<tr>
							<td>新表编号</td>
							<td><input readonly="readonly" disabled="disabled" value="自动生成" /></td>
							<td>表身码</td>
							<td><input id="meterName" name="meter.meterName" /></td>
							<td>水表类型</td>
							<td>
								<input type="hidden" id="userNo" name="userNo" value="<s:property value='result.userNo'/>" />
								<input type="hidden" id="meterTypeName" name="meter.meterType.meterTypeName" value="" />
								<s:select id="meterTypeSelect" list="#meterTypeAction.result" listKey="id" listValue="meterTypeName" listTitle="'水表口径:'+aperture+' 起始底码:'+minValue+' 最大码值:'+mavValue" name="meter.meterType.id" style="width: 160px;" onchange="doChangeMeterType();"></s:select>
							</td>
						</tr>
						<!-- <tr>
							<td>水表口径</td>
							<td><input value="40" /></td>
							<td>起始底码</td>
							<td><input value="2" /></td>
							<td>最大码值</td>
							<td><input value="99999" onClick="WdatePicker();" /></td>
						</tr> -->
						<tr>
							<td>装表日期</td>
							<td><input id="setupDate" name="meter.setupDate" onClick="WdatePicker();" /></td>
							<td>水表厂家</td>
							<td colspan="3"><input size="64" id="factory" name="meter.factory" /></td>
						</tr>
					</tbody>
				</table>
				<div id="message" style="padding-left: 145px; color: red; display: block;"></div>
				<div style=" margin:20px 0px 0px 66px;" >
					<button class="btn" type="submit">更换水表</button>
				</div>
			</form>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
	<c:remove var="user" scope="session"/>
</div> <!-- #wrapper -->

</body> 
</html>