<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="z" uri="/zking"%>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>湖南省自来水公司营销管理信息系统</title>

<link rel="stylesheet" href="css/reset.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/text.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/form.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/buttons.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/grid.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/layout.css" type="text/css"
	media="screen" title="no title" />

<link rel="stylesheet"
	href="css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/plugin/jquery.visualize.css"
	type="text/css" media="screen" title="no title" />
<link rel="stylesheet" href="css/plugin/facebox.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="css/plugin/uniform.default.css"
	type="text/css" media="screen" title="no title" />
<link rel="stylesheet" href="css/plugin/dataTables.css" type="text/css"
	media="screen" title="no title" />

<link rel="stylesheet" href="css/custom.css" type="text/css"
	media="screen" title="no title">

<style type="text/css">
table.data thead th {
	vertical-align: middle;
	text-align: center;
}

.tab_content {
	min-height: 220px;
}
</style>

<script src="js/jquery/jquery-1.11.0.min.js"></script>
<script src="js/jquery/jquery.table2excel.js"></script>
<script src="js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
<script src="js/misc/excanvas.min.js"></script>
<script src="js/jquery/facebox.js"></script>
<script src="js/jquery/jquery.visualize.js"></script>
<script src="js/jquery/jquery.dataTables.min.js"></script>
<script src="js/jquery/jquery.tablesorter.min.js"></script>
<script src="js/jquery/jquery.uniform.min.js"></script>
<script src="js/jquery/jquery.placeholder.min.js"></script>
<script src="My97DatePicker/WdatePicker.js"></script>

<script src="js/widgets.js"></script>
<script src="js/dashboard.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		Dashboard.init();

		//选择项初始化
		$('.tab_container').tabs();
		
		$("#pagetitle").text($(".x12 h2").text());
		
	});
</script>