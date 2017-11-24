<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
	
		function ok(){
			window.close(); //简单的处理
			
			//模拟返回数据
			//returnWindow('[SH:100%]');
		}
		
	</script>
</head> 
<body onload="init();"> 
<s:action name="costTypeAction!findAllCostTypeByKind" namespace="/sy" var="costTypeAction">
	<s:param name="kind" value="1"></s:param>
</s:action>

<div id="wrapper">
	
	
	<div style="width:90%; margin:0 auto;">
	<br/>
	<h2>设置提比提量值</h2>

	<input id="txtTibi" readonly="readonly" style="width:50%;" value="" />
	<button class="btn-icon btn-small btn-check btn-blue" onclick="ok();"><span></span>确定</button>
	<button class="btn-icon btn-small btn-cross btn-grey" onclick="ok();"><span></span>取消</button>
	
	<br/><br/>

	<table id="tibiTable" class="data display">
	<thead>
		<tr>
			<th>用水类型</th>
			<th>提取值</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	</tbody>
	</table>
	
	<s:select id="costTypeSelect" list="#costTypeAction.result" listValue="code+':'+costTypeName" listKey="id" name="id" headerKey="-1" headerValue="添加新规则" cssStyle="width:98%;" onchange="addtibi(this);"></s:select>
	
	<pre>操作说明：
1.提量   指定常量值，如：20，说明提取20吨做为该类型用水
2.提比   指定百分比，如：20%，说明从提量后剩余中提取20%做为该类型用水
3.取剩余 指定*号，说明把提量以及提比之后剩余量做为该类型用水
	</pre>

</div>
	
	
</div> <!-- #wrapper -->
	<script type="text/javascript">
		function init(){
			var oldFormula = window.dialogArguments;
			$("#txtTibi").val(oldFormula);
			var reg=new RegExp("[\\[,\\]]","g");
			oldFormula = oldFormula.replace(reg, ' ');
			var fms = oldFormula.split("  ");
			for(x in fms){
				var fm = fms[x];
				var arr = fm.split(":");
				var fmCode = arr[0].trim();
				var fmValue = arr[1].trim();
				var codeName = $("#costTypeSelect option").eq(code2Id(fmCode)).text();
				addtibi2(codeName,fmValue);
			}
		}
		
		function code2Id(code){
			var id = -1;
			$("#costTypeSelect option").each(function(i){
				var text = $(this).text().trim();
				var textCode = text.split(":")[0].trim();
				if(code == textCode){
					id = $(this).val();
				}
			});
			
			return id;
		}
		
		//添加提比提量规则
		function addtibi(sel){
			var name = $("#costTypeSelect option:selected").text();
			if(name=='添加新规则')return;
			var tbody = $('#tibiTable tbody');
			tbody.append('<tr><td class="center">'+name+'</td><td class="center"><input value="0" /></td><td><button class="btn btn-small btn-red" onclick="removetibi(this);">移除</button></td></tr>');
			$("#txtTibi").val($("#txtTibi").val()+"["+name.split(":")[0].trim()+":"+0+"]");
		}
		
		//添加提比提量规则2
		function addtibi2(codeName,value){
			var tbody = $('#tibiTable tbody');
			tbody.append('<tr><td class="center">'+codeName+'</td><td class="center"><input value="'+value+'" /></td><td><button class="btn btn-small btn-red" onclick="removetibi(this);">移除</button></td></tr>');
		}
		
		//移除提比提量规则
		function removetibi(sel){
			sel.parentNode.parentNode.parentNode.removeChild(sel.parentNode.parentNode);
		}
		
	</script>
</body> 
</html>