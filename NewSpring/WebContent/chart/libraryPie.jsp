<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>各浴室当前人数分布情况</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/FusionCharts/FusionChartsV3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/ajaxbridge/js/FABridge.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/ajaxbridge/js/FDMSLib.js"></script>
<style type="text/css">
	html,body{
		margin:0px;
		height:100%;
		padding:0px;
		
	}
</style>
</head>
<body style="overflow-y:auto;" scroll="no">
	<div id="chartdiv1" style="width:98%; height:98%; top:0px; left:0px; position:absolute; border:1px solid #FCDD44;">
	</div>
	
</body>
<script type="text/javascript">
	var chart1 = new FusionCharts("<%=request.getContextPath()%>/chart/common/FusionCharts/Pie3D.swf",
		"chart1", "100%", "100%", "0", "0");
	
	
	
	var data = ${message};
	chart1.setDataXML(data.allLibrary);
	chart1.render("chartdiv1");
	
	
</script>
</html>