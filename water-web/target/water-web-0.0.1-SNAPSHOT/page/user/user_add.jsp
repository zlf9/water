<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
</head> 
<body> 
<div id="wrapper">
	
	<div id="content" class="xgrid">

		<div class="x12">
			
			<h2>快捷新户</h2>
				<form action="action/user/user/save" method="post">
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
							<td><select style="width:156px;">
									<option>私户</option>
									<option>公户</option>
								</select></td>
							<td>所属辖区</td>
							<td><select style="width:156px;">
									<option>城东区</option>
									<option>城南区</option>
									<option>城西区</option>
									<option>城北区</option>
									<option>新开发区</option>
									<option>旧城区</option>
									<option>特别商户区</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>用户名称</td>
							<td><input name="userName"></td>
							<td>开户时间</td>
							<jsp:useBean id="time" class="java.util.Date" /> 
							<td><input readonly="readonly" value='<fmt:formatDate value="<%=new java.sql.Date(time.getTime()) %>" pattern="yyyy年MM月dd日" />' disabled="disabled"></td>
							<td>收款方式</td>
							<td><select style="width:156px;">
									<option>坐收</option>
									<option>走收</option>
									<option>银行代扣</option>
								</select></td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input name="phone"></td>
							<td>开户银行</td>
							<td><input name="bankName"></td>
							<td>银行账号</td>
							<td><input name="bankNum"></td>
						</tr>
						<tr>
							<td>短信电话</td>
							<td><input name="smsphone"></td>
							<td>用户地址</td>
							<td colspan="3"><input size="68" name="address"></td>
						</tr>
						<tr>
							<td>档案编号</td>
							<td><input value="A4954-394P1#4"></td>
							<td>合同编号</td>
							<td><input value="W20101027-19"></td>
							<td>签订日期</td>
							<td><s:datetextfield format="yyyy-MM-dd"></s:datetextfield></td>
						</tr>
						<tr>
							<td style="vertical-align:middle;">提比提量</td>
							<td colspan="5">
								<span class="text_button">
								<input id="txtTibi" style="width:668px;" readonly="readonly" value="[SH:80%][SY:10%][GY:10%]">
								<button onClick="setTibi();">设定</button></span>
							</td>
						</tr>
						<tr>
							<td>水表编号</td>
							<td><input readonly="readonly" disabled="disabled" value="自动生成"></td>
							<td>表身码</td>
							<td><input value="01010001"></td>
							<td>起始底码</td>
							<td><input value="2"></td>
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
							<td><input value="40"></td>
							<td>最大码值</td>
							<td><input value="99999" onClick="WdatePicker();"></td>
						</tr>
						<tr>
							<td>装表日期</td>
							<td><input value="2010-10-27"></td>
							<td>水表厂家</td>
							<td colspan="3"><input size="68" value="城至水表厂"></td>
						</tr>
					</tbody>
					</table>
					
					<div style=" margin:20px 0px 0px 66px;">
						<button class="btn">创建新户</button>
					</div>
				</form>
		</div> <!-- .x12 -->
		
	</div><%@ include file="/common/top.jsp"%>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">快捷新户</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	 <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>