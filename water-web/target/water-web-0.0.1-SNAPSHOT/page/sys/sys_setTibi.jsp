<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
</head> 
<body> 
<s:action name="costTypeAction!findAllCostTypeByKind" namespace="/sy" var="costTypeAction">
	<s:param name="kind" value="1"></s:param>
</s:action>

<div id="wrapper">
	
	
	<div style="width:90%; margin:0 auto;">
	<br/>
	<h2>设置提比提量值</h2>

	<input id="txtTibi" readonly="readonly" style="width:50%;" value="[SH:20][SY:30%][XZ:50%][GY:*]" />
	<button class="btn-icon btn-small btn-check btn-blue" onclick="ok();"><span></span>确定</button>
	<button class="btn-icon btn-small btn-cross btn-grey" onclick="ok();"><span></span>取消</button>
	
	<br/><br/>

	<table id="tibiTable" class="data display">
	<thead>
		<tr>
			<th>用水类型</th>
			<th>提取方式</th>
			<th>提取值</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr class="odd">
			<td>SH:生活用水</td>
			<td><s:select list="#costTypeAction.findAllByDictName('提取方式')" listValue="text" listKey="value" name="allotType" cssStyle="height:28px;"></s:select></td>
			<td><input value="20" /></td>
			<td><button class="btn btn-small btn-red">移除</button></td>
		</tr>
		<tr class="even">
			<td>SY:商业用水</td>
			<td><s:select list="#costTypeAction.findAllByDictName('提取方式')" listValue="text" listKey="value" name="allotType" cssStyle="height:28px;"></s:select></td>
			<td><input value="30%" /></td>
			<td><button class="btn btn-small btn-red">移除</button></td>
		</tr>
		<tr class="odd">
			<td>XZ:行政用水</td>
			<td><s:select list="#costTypeAction.findAllByDictName('提取方式')" listValue="text" listKey="value" name="allotType" cssStyle="height:28px;"></s:select></td>
			<td><input value="50%" /></td>
			<td><button class="btn btn-small btn-red">移除</button></td>
		</tr>
		<tr class="even">
			<td>GY:工业用水</td>
			<td><s:select list="#costTypeAction.findAllByDictName('提取方式')" listValue="text" listKey="value" name="allotType" cssStyle="height:28px;"></s:select></td>
			<td><input value="*" /></td>
			<td><button class="btn btn-small btn-red">移除</button></td>
		</tr>
	</tbody>
	</table>
	
	<s:select list="#costTypeAction.result" listValue="code+':'+costTypeName" listKey="id" name="id" headerKey="-1" headerValue="添加新规则" cssStyle="width:98%;" onchange="addtibi(this);"></s:select>
	
	<pre>操作说明：
1.提量   指定常量值，如：20，说明提取20吨做为该类型用水
2.提比   指定百分比，如：20%，说明从提量后剩余中提取20%做为该类型用水
3.取剩余 指定*号，说明把提量以及提比之后剩余量做为该类型用水
	</pre>

</div>
	
	
</div> <!-- #wrapper -->
	<script type="text/javascript">
		function ok(){
			//parent.close(); //简单的处理
			
			//模拟返回数据
			//returnWindow('[SH:100%]');
		}
		
		//添加提比提量规则
		function addtibi(sel){
			var name = $(sel).val();
			if(name=='添加新规则')return;
			var tbody = $('#tibiTable tbody');
			tbody.append('<tr><td>'+name+'</td><td><s:select list="#costTypeAction.findAllByDictName(\'提取方式\')" listValue="text" listKey="value" name="allotType" cssStyle="height:28px;"></s:select></td><td><input value="20%" /></td><td><button class="btn btn-small btn-red">移除</button></td></tr>');
		}
	</script>
</body> 
</html>