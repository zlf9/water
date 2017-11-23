<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	<script type="text/javascript">
		function setTibi() {
			showWindow({
				url : 'page/sys/sys_setTibi',
				width : 630,
				height : 500
			});
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
<!-- 				<form action="action/user/user/save" method="post"> -->
				<form action="" method="post">
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
							<td><s:select list="#meterTypeAction.findAllByDictName('用户类型')" listValue="text" listKey="value" name="userType" cssStyle="width:160px;"></s:select></td>
							<td>所属辖区</td>
							<td><s:select list="#meterTypeAction.findAllByDictName('抄表辖区')" listValue="text" listKey="value" name="areaId" cssStyle="width:160px;"></s:select></td>
						</tr>
						<tr>
							<td>用户名称</td>
							<td><input name="userName"></td>
							<td>开户时间</td>
							<jsp:useBean id="time" class="java.util.Date" /> 
							<td><input readonly="readonly" value='<fmt:formatDate value="<%=new java.sql.Date(time.getTime()) %>" pattern="yyyy年MM月dd日" />' disabled="disabled"></td>
							<td>收款方式</td>
							<td><s:select list="#meterTypeAction.findAllByDictName('收款方式')" listValue="text" listKey="value" name="payType" cssStyle="width:160px;"></s:select></td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input name="phone" /></td>
							<td>开户银行</td>
							<td><input name="bankName" /></td>
							<td>银行账号</td>
							<td><input name="bankNum" /></td>
						</tr>
						<tr>
							<td>短信电话</td>
							<td><input name="smsphone" /></td>
							<td>用户地址</td>
							<td colspan="3"><input size="64" name="address" /></td>
						</tr>
						<tr>
							<td>档案编号</td>
							<td><input name="docNum" /></td>
							<td>合同编号</td>
							<td><input name="contractNum" /></td>
							<td>签订日期</td>
							<td><input name="contractDate" onclick="WdatePicker()" /></td>
						</tr>
						<tr>
							<td style="vertical-align:middle;">提比提量</td>
							<td colspan="5">
								<span class="text_button">
								<input id="txtTibi" style="width:675px;" readonly="readonly" value="[SH:80%][SY:10%][GY:10%]">
								<button onClick="setTibi();" style="height:28px;">设定</button></span>
							</td>
						</tr>
						<tr>
							<td>水表编号</td>
							<td><input readonly="readonly" disabled="disabled" value="自动生成"></td>
							<td>表身码</td>
							<td><input name="meter.meterName"></td>
							<td>水表类型</td>
							<td><s:select list="#meterTypeAction.result" listValue="meterTypeName" listKey="id" listTitle="'水表口径:'+aperture+' 起始底码:'+minValue+' 最大码值:'+mavValue" name="meter.meterType.id" cssStyle="width:160px;" ></s:select></td>
						</tr>
						<!-- <tr>
							<td>水表口径</td>
							<td><input value="40"  readonly="readonly" /></td>
							<td>起始底码</td>
							<td><input value="2"  readonly="readonly" /></td>
							<td>最大码值</td>
							<td><input value="99999"  readonly="readonly" /></td>
						</tr> -->
						<tr>
							<td>装表日期</td>
							<td><input name="meter.setupDate" onclick="WdatePicker()" /></td>
							<td>水表厂家</td>
							<td colspan="3"><input size="64" name="meter.factory" /></td>
						</tr>
					</tbody>
					</table>
					
					<div style=" margin:20px 0px 0px 66px;">
						<button class="btn">创建新户</button>
					</div>
				</form>
		</div> <!-- .x12 -->
		
	</div>
	<!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>