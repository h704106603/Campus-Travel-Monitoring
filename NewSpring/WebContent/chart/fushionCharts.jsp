<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微厅业务小时统计量(刷新周期5分钟)</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/FusionCharts/FusionChartsV3.js"></script>
<style type="text/css">
	html,body{
		margin:0px;
		height:100%;
		padding:0px;
	}
</style>
</head>
<body style="overflow-y:auto" scroll="no">
	<div id="chartdiv1" align="center" style="width:100%; height:100%;top:0%;position:absolute;"></div>
	

</body>
	<script type="text/javascript">
	
	var chart1 = new FusionCharts("<%=request.getContextPath()%>/chart/common/FusionCharts/MSStackedColumn2DLineDY.swf",
			"chartId1", "100%", "100%", "0", "0");
	
	var data = ${message};
	chart1.setDataXML(data.fushion);
	chart1.render("chartdiv1");

	</script>
</html>