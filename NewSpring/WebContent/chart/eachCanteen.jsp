<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>各食堂当前人数分布情况</title>
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
	<div id="chartdiv1" style="width:100%; height:33%; top:0px; left:1px; position:absolute; border:1px solid #FCDD44;">
	</div>
	<div id="chartdiv2" style="width:100%; height:34%; top:33%; left:1px; position:absolute; border:1px solid #FCDD44;">
	</div>
	<div id="chartdiv3" style="width:100%; height:33%; top:67%; left:1px; position:absolute; border:1px solid #FCDD44;">
	</div>
	
</body>
<script type="text/javascript">
	
	var timer = window.setInterval(showSecondes,6000000);
	function showSecondes() {
		location.href = "<%=request.getContextPath()%>/EachCanteenPie";
	}

	var chart1 = new FusionCharts("<%=request.getContextPath()%>/chart/common/FusionCharts/Pie3D.swf",
		"chart1", "100%", "100%", "0", "0");
	var chart2 = new FusionCharts("<%=request.getContextPath()%>/chart/common/FusionCharts/Pie3D.swf",
			"chart2", "100%", "100%", "0", "0");
	var chart3 = new FusionCharts("<%=request.getContextPath()%>/chart/common/FusionCharts/Pie3D.swf",
			"chart3", "100%", "100%", "0", "0");
	
	
	var data = ${message};
	chart1.setDataXML(data.eachCanteen1);
	chart1.render("chartdiv1");
	chart2.setDataXML(data.eachCanteen2);
	chart2.render("chartdiv2");
	chart3.setDataXML(data.eachCanteen3);
	chart3.render("chartdiv3");
	
</script>
</html>