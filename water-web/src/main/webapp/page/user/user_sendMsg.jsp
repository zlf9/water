<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
		function tableToexcel(){
			$(".table2excel").table2excel({
				exclude: ".noExl",
				name: "短信群发",
				filename: "短信群发",
				exclude_img: true,
				exclude_links: true,
				exclude_inputs: true
			});
		}		
	</script>
</head> 
<body> 
<div id="wrapper">
	<s:action name="dictAction!findAllByDictName" namespace="/dict" var="dictAction">
		<s:param name="dictName" value="'发送类型'"></s:param>
	</s:action>
	
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>短信群发</h2>
			
			<div class="height40">
				<button class="btn btn-small btn-icon btn-arrow-right"><span></span>发送</button>
				<button id="tableToexcel" class="btn btn-small btn-icon btn-print" onclick="tableToexcel()"><span></span>导出为Excel文件</button>
			</div>
			<div class="height40">
				<form action="action/user/sms/generateSendContent" method="post">
					群发内容 <input name="message" style="width:550px;" value="尊敬的用户{用户姓名}，您好。你户已欠缴水费 {欠费金额} 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。" />
					<s:select list="#dictAction.result" listKey="value" listValue="text" name="typee" value="#session.sms.typee" style="width:140px;"></s:select>
					<button class="btn btn-small btn-icon btn-refresh" type="submit"><span></span>生成发送内容</button>
				</form>
			</div>
			<div class="height40">
				注：使用 <span class="red">{用户姓名}</span> 代替用户的名字，
				使用 <span class="red">{欠费金额}</span> 代替用户的欠费金额。
			</div>
			
			
			<div class="reportTitle">
				短信群发
			</div>
			<s:if test="result == null">
				<div class="center"><h4>请先生成发送内容</h4></div>
			</s:if>
			<s:else>
				<div class="table-responsive table2excel" data-tableName="Test Table 1">
					<table class="data display table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width="15%">用户编码</th>
								<th width="15%">用户姓名</th>
								<th width="15%">短信号码</th>
								<th width="55%">发送内容</th>
							</tr>
						</thead>
						<tbody>
							<s:if test="result != null">
								<s:iterator var="user" value="result" status="st">
									<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
										<td style="text-align: center;"><s:property value="#user.userNo"/></td>
										<td style="text-align: center;"><s:property value="#user.userName"/></td>
										<td style="text-align: center;"><s:property value="#user.smsphone"/></td>
										<td class="left"><s:property value="sendMsgToNewSendMsg(#session.sms.message,#user)"/></td>
									</tr>
								</s:iterator>
							</s:if>
						</tbody>
					</table>
				</div>
				<div class="page">
					<z:page pageBean="${pageBean }"/>
				</div>
			</s:else>	
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>