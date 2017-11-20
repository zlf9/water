<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
		<title>啊哦！出错了！  湖南省自来水公司营销管理信息系统</title> 
</head> 
<body> 
<div id="wrapper">
	
	<%@ include file="/common/top.jsp"%>
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2 style="color:red;">啊哦！出错了！</h2>
			
			<div style="min-height:300px;">
				<img style="float:left; margin-top:80px;" src="images/error.jpg" />
				
				<div style="padding-top:100px;padding-left:200px; color:red;">
					这是一个出错演示页面。<br/>
					不知道因为什么原因，出现了一个错误。<br/>
					建议你点击返回后，刷新重试。
				</div>
			</div>
			<div class="clear"></div>
			
			<div style="text-align:center;">
				<button class="btn" onClick="history.back(-1);">返回</button>
			</div>
				
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
</div> <!-- #wrapper -->

</body> 
</html>