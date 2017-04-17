<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>好友明细情况</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/echarts/esl.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/ajaxbridge/js/FABridge.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/ajaxbridge/js/FDMSLib.js"></script>
</head>
<body style="background-color: #ffffff">
	 <link href="<%=request.getContextPath()%>/chart/common/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/chart/common/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/chart/common/css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
  <link href="<%=request.getContextPath()%>/chart/common/css/flexslider.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/chart/common/css/templatemo-style.css" rel="stylesheet">
	
	<style>
	table tr:first-child{background:#0066CC; color:#fff;font-weight:bold;} /*第一行标题蓝色背景*/
	table{border-top:1pt solid #C1DAD7;border-left:1pt solid #C1DAD7;margin: 0 auto;width: 1200px;height: 600px;} 
	td{ padding:5px 10px; text-align:center;border-right:1pt solid #C1DAD7;border-bottom:1pt solid #C1DAD7;}
	tr:nth-of-type(odd){ background:#c6f9f7} /* odd 标识奇数行，even标识偶数行 */
	tr:hover{ background: #E0F0F0;} /*鼠标悬停后表格背景颜色*/
</style>
  </head>
  <body class="tm-gray-bg">
  	<!-- Header -->
  	<div class="tm-header">
  		<div class="container">
  			<div class="row">
  				<div class="col-lg-4 col-md-2 col-sm-3 tm-site-name-container">
  					<a href="#" class="tm-site-name">智慧校园出行</a>	
  				</div>
	  			<div class="col-lg-8 col-md-10 col-sm-9">
	  				<div class="mobile-menu-icon">
		              <i class="fa fa-bars"></i>
		            </div>
	  				<nav class="tm-nav">
						<ul>
							<li><a href="<%=request.getContextPath()%>/Index" class="active">首页</a></li>
							<li><a href="<%=request.getContextPath()%>/findFriend?studentId=<%=(String) session.getAttribute("studentId")%>">好友情况</a></li>
							<li><a href="<%=request.getContextPath()%>/LibraryIndex">图书馆</a></li>
							<li><a href="<%=request.getContextPath()%>/BathroomIndex">公共浴室</a></li>
							<li><a href="<%=request.getContextPath()%>/CanteenIndex">食堂</a></li>
							<li><a href="<%=request.getContextPath()%>/TheatreIndex">剧场</a></li>
							<li><a href="<%=request.getContextPath()%>/ClassroomIndex">教室</a></li>
							
						</ul>
					</nav>		
	  			</div>				
  			</div>
  		</div>	  	
  	</div>
  	
  	
  	<div id="friendDetails">
  	   <table id="table"
		    <tr>
	            <th>姓名</th>
	            <th>班级</th>
	            <th>时间</th>
	            <th>出入地</th>
	        </tr>
	        <c:forEach var="LocationDetails" items="${locationDetailsList}"> 
			<tr>
	            <th data-field="name">${LocationDetails.name}</th>
	            <th data-field="grade">${LocationDetails.grade}</th>
	            <th data-field="time">${LocationDetails.time}</th>
	            <th data-field="details">${LocationDetails.details}</th>
	        </tr>
			</c:forEach>
    	</table>
	 	
     </div>
	
</body>
</html>