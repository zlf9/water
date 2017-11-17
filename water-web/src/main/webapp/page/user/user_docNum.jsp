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
			
			<h2>档案号管理</h2>

			<div class="searchUserDiv">
				用户编码 <input value="0100000987" />
				用户简码 <input value="张三" />
				用户姓名 <input />
				联系电话 <input />
				家庭住址 <input />
				<button class="btn btn-small btn-icon btn-person"><span></span>查询用户</button>
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">档案号设置</h3>
				<div class="field"><label for="id">用户编码</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled" value="0100000987" /></div>
				
				<div class="field"><label for="name">用户姓名</label> <input id="name" name="lname" size="50" type="text" class="medium" disabled="disabled" value="张三" /></div>
							
				<div class="field"><label for="name">档案号</label> <input id="name" name="lname" size="50" type="text" class="medium" value="X39F-4328" /></div>

				<div class="buttonrow">
					<button class="btn">保存</button>
				</div>

			</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>