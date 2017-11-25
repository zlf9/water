<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			doChangePayType();
		});
	
		var bool = false;
	
		function setTibi() {
			var formula = $("#formula").val().trim();
			
			var returnFormula = window.showModalDialog("page/sys/sys_setTibi", formula, "dialogHeight:600px;dialogWidth:800px;");
			$("#formula").val(null==returnFormula||""==returnFormula.trim()?formula:returnFormula);
			
		
			/* showWindow({
				url : 'page/sys/sys_setTibi',
				width : 630,
				height : 500, 
				callback: function(val){
					//alert(val.addr);  //回调处理
				}
			}); */
		}
		
		function doBtnClick(){
			bool = true;
		}
		
		function saveUser(){
			var submitBool = bool; 
			bool = false;
			
			if(submitBool){
	// 			var userType = $("#userType").val().trim();
	// 			var areaId = $("#areaId").val().trim();
				var userName = $("#userName").val().trim();
				var phone = $("#phone").val().trim();
				var payTypeName = $("#payTypeSelect option:checked").text().trim();
				var bankName = $("#bankName").val().trim();
				var bankNum = $("#bankNum").val().trim();
				
				var smsphone = $("#smsphone").val().trim();
				var address = $("#address").val().trim();
				var docNum = $("#docNum").val().trim();
				var contractNum = $("#contractNum").val().trim();
				var contractDate = $("#contractDate").val().trim();
				
				var formula = $("#formula").val().trim();
				
				var meterName = $("#meterName").val().trim();
				var meterSetupDate = $("#meterSetupDate").val().trim();
				var meterFactory = $("#meterFactory").val().trim();
			
				var userNamePattern = /^([a-zA-Z0-9\u4e00-\u9fa5\·]{1,10})$/;
				var phonePattern = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
				var phonePattern2 = /^((\d{3,4}-)|\d{3.4}-)?\d{7,8}$/;
				
				if("" == userName){
					$("#message").html("用户名称不能为空");
					return false;
				}else if(!userNamePattern.test(userName)){
					$("#message").html("用户姓名格式错误");
					return false;
				}else if("" == phone){
					$("#message").html("联系电话不能为空");
					return false;
				}else if((!phonePattern.test(phone))&&(!phonePattern2.test(phone))){
					$("#message").html("联系电话格式错误");
					return false;
				}else if(payTypeName == '银行代扣'){
					if("" == bankName){
						$("#message").html("开户银行不能为空");
						return false;
					}else if("" == bankNum){
						$("#message").html("银行账号不能为空");
						return false;
					}
				}
				if("" == smsphone){
					$("#message").html("短信电话不能为空");
					return false;
				}else if((!phonePattern.test(smsphone))&&(!phonePattern2.test(smsphone))){
					$("#message").html("短信电话格式错误");
					return false;
				}else if("" == address){
					$("#message").html("联系地址不能为空");
					return false;
				}else if("" == docNum){
					$("#message").html("档案编号不能为空");
					return false;
				}else if("" == contractNum){
					$("#message").html("合同编号不能为空");
					return false;
				}else if("" == contractDate){
					$("#message").html("合同签订日期不能为空");
					return false;
				}else if("" == formula){
					$("#message").html("请设定提比提量");
					return false;
				}else if("" == meterName){
					$("#message").html("水表的表身码不能为空");
					return false;
				}else if("" == meterSetupDate){
					$("#message").html("水表的装表日期不能为空");
					return false;
				}else if("" == meterFactory){
					$("#message").html("水表的水表厂家不能为空");
					return false;
				}
			}
			return submitBool;
		}
		
		function doChangePayType(){
			var payTypeName = $("#payTypeSelect option:checked").text().trim();
			if(payTypeName == '银行代扣'){
				$("#bankName").attr("disabled", false);
				$("#bankNum").attr("disabled", false);
			}else{
				$("#bankName").attr("disabled", true);
				$("#bankNum").attr("disabled", true);
			}
		}
	</script>
</head> 
<body> 
<div id="wrapper">
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid">
		<s:action name="meterTypeAction!findAllMeterType" namespace="/sy" var="meterTypeAction"></s:action>
		<div class="x12">
			
			<h2>快捷新户</h2>
				<form action="action/user/user/saveUser" method="post" onsubmit="return saveUser()">
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
							<td><input readonly="readonly" value="自动生成" disabled="disabled"></td>
							<td>用户类型</td>
							<td><s:select list="#meterTypeAction.findAllByDictName('用户类型')" listValue="text" listKey="value" name="userType" id="userType" cssStyle="width:160px;"></s:select></td>
							<td>所属辖区</td>
							<td><s:select list="#meterTypeAction.findAllByDictName('抄表辖区')" listValue="text" listKey="value" name="areaId" id="areaId" cssStyle="width:160px;"></s:select></td>
						</tr>
						<tr>
							<td>用户名称</td>
							<td><input id="userName" name="userName"></td>
							<td>开户时间</td>
							<jsp:useBean id="time" class="java.util.Date" /> 
							<td><input readonly="readonly" value='<fmt:formatDate value="<%=new java.sql.Date(time.getTime()) %>" pattern="yyyy年MM月dd日" />' disabled="disabled"></td>
							<td id="payTypeSelect">收款方式</td>
							<td id="payTypeSelectTd"><s:select list="#meterTypeAction.findAllByDictName('收款方式')" listValue="text" listKey="value" name="payType" id="payTypeSelect" cssStyle="width:160px;" onchange="doChangePayType();"></s:select></td>
							</tr>
						<tr>
							<td>联系电话</td>
							<td><input id="phone" name="phone" /></td>
							<td id="bankNameNameTd">开户银行</td>
							<td id="bankNameValueTd"><input id="bankName" name="bankName" /></td>
							<td id="bankNumNameTd">银行账号</td>
							<td id="bankNumValueTd"><input id="bankNum" name="bankNum" /></td>
						</tr>
						<tr>
							<td>短信电话</td>
							<td><input id="smsphone" name="smsphone" /></td>
							<td>用户地址</td>
							<td colspan="3"><input size="64" id="address" name="address" /></td>
						</tr>
						<tr>
							<td>档案编号</td>
							<td><input id="docNum" name="docNum" /></td>
							<td>合同编号</td>
							<td><input id="contractNum" name="contractNum" /></td>
							<td>签订日期</td>
							<td><input id="contractDate" name="contractDate" onclick="WdatePicker()" /></td>
						</tr>
						<tr>
							<td style="vertical-align:middle;">提比提量</td>
							<td colspan="5">
								<span class="text_button">
								<input id="formula" name="formula" style="width:675px;" readonly="readonly" value="">
								<button onClick="setTibi();" style="height:28px;">设定</button></span>
							</td>
						</tr>
						<tr>
							<td>水表编号</td>
							<td><input readonly="readonly" disabled="disabled" value="自动生成"></td>
							<td>表身码</td>
							<td><input id="meterName" name="meter.meterName"></td>
							<td>水表类型</td>
							<td><s:select list="#meterTypeAction.result" listValue="meterTypeName" listKey="id" listTitle="'水表口径:'+aperture+' 起始底码:'+minValue+' 最大码值:'+mavValue" name="meter.meterType.id" id="meterTypeId" cssStyle="width:160px;" ></s:select></td>
						</tr>
						<!-- <tr>
							<td>水表口径</td>
							<td><input value="40" readonly="readonly" /></td>
							<td>起始底码</td>
							<td><input value="2" readonly="readonly" /></td>
							<td>最大码值</td>
							<td><input value="99999" readonly="readonly" /></td>
						</tr> -->
						<tr>
							<td>装表日期</td>
							<td><input id="meterSetupDate" name="meter.setupDate" onclick="WdatePicker()" /></td>
							<td>水表厂家</td>
							<td colspan="3"><input size="64" id="meterFactory" name="meter.factory" /></td>
						</tr>
					</tbody>
					</table>
					
					<div id="message" style="padding-left: 66px; color: red; display: block;"></div>
					<div style=" margin:20px 0px 0px 66px;">
						<button class="btn" type="submit" onclick="doBtnClick()">创建新户</button>
					</div>
				</form>
		</div> <!-- .x12 -->
		
	</div>
	<!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>