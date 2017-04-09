<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>分类柱状图1</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/echarts/esl.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.3.2.min.js"></script>
</head>
<body style="background-color: #000000">
				<div id="chartdiv1" style="height:98%; width:98%; position:absolute; top: 0px;  left:0px;  border:1px solid #00FF00;">			
 					
 				</div>
    <script type="text/javascript">
    if(typeof window.addEventListener=="undefined"){
		 window.attachEvent("resize",function(){
		    	option.chart.resize();
		    });
	}
	else{
		window.addEventListener("resize",function(){
	    	option.chart.resize();
	    });
	}
    require.config({
        paths:{ 
        	'echarts' : '<%=request.getContextPath()%>/chart/common/echarts/echarts',
            'echarts/chart/map' : '<%=request.getContextPath()%>/chart/common/echarts/echarts-map'
        }
    });

    require(
        [
            'echarts',
            'echarts/chart/map'
        ],
        function (ec) {
            // --- 地图 ---
        	var option = ec.init(document.getElementById('chartdiv1'));
        	$.getJSON("<%=request.getContextPath()%>/newEchartsTest",function(json){
      		    
        		alert(json);
        		var aToStr=JSON.stringify(json);
        		alert(aToStr);
      		option.setOption(json);
      		});
            
            
        }
    );

    </script>
</body>
</html>