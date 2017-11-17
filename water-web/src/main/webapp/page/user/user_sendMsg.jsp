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
			
			<h2>短信群发</h2>
			
			<div class="height40">
				<button class="btn btn-small btn-icon btn-arrow-right"><span></span>发送</button>
				<button class="btn btn-small btn-icon btn-print"><span></span>导出为Excel文件</button>
			</div>
			<div class="height40">
				群发内容 <input style="width:550px;" value="尊敬的用户{用户姓名}，您好。你户已欠缴水费 {欠费金额} 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。" />
				<select style="width:140px;">
					<option>给所有用户发送</option>
					<option selected="selected">只给欠费用户发送</option>
				</select>
				<button class="btn btn-small btn-icon btn-refresh"><span></span>重新生成发送内容</button>
			</div>
			<div class="height40">
				注：使用 <span class="red">{用户姓名}</span> 代替用户的名字，
				使用 <span class="red">{欠费金额}</span> 代替用户的欠费金额。
			</div>
			
			
			<div class="reportTitle">
				短信群发
			</div>
			<table class="report">
			<thead>
				<tr>
					<th width="80">用户编码</th>
					<th width="80">用户姓名</th>
					<th width="80">短信号码</th>
					<th>发送内容</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">张三</td>
					<td class="left">13873823741</td>
					<td class="left">尊敬的用户张三，您好。你户已欠缴水费 1377.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">李四</td>
					<td class="left">1387434334</td>
					<td class="left">尊敬的用户李四，您好。你户已欠缴水费 3.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">王五</td>
					<td class="left">1386565656</td>
					<td class="left">尊敬的用户王五，您好。你户已欠缴水费 33.45 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">赵六</td>
					<td class="left">1387767567
					<td class="left">尊敬的用户赵六，您好。你户已欠缴水费 44.32 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">钱七</td>
					<td class="left">1387376575
					<td class="left">尊敬的用户钱七，您好。你户已欠缴水费 1324.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">唐八</td>
					<td class="left">1387387676</td>
					<td class="left">尊敬的用户唐八，您好。你户已欠缴水费 1377.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">何九</td>
					<td class="left">13873823741</td>
					<td class="left">尊敬的用户何九，您好。你户已欠缴水费 1377.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">布十</td>
					<td class="left">13873823741</td>
					<td class="left">尊敬的用户布十，您好。你户已欠缴水费 1371.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">李世民</td>
					<td class="left">13873823741</td>
					<td class="left">尊敬的用户李世民，您好。你户已欠缴水费 1337.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
				<tr>
					<td class="left">0100000987</td>
					<td class="left">李靖</td>
					<td class="left">13873823741</td>
					<td class="left">尊敬的用户李靖，您好。你户已欠缴水费 2377.16 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。</td>
				</tr>
			</tbody>
			</table>
			<div class="page">
				<a href="#">第一页</a>
				<a href="#">上一页</a>
				<input class="pageIndex" value="1"/> / <input class="pageCount" readonly="readonly" value="98765" />
				<a href="#">下一页</a>
				<a href="#">第未页</a>
			</div>
				
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>