<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>教室情况</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/echarts/esl.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/ajaxbridge/js/FABridge.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/ajaxbridge/js/FDMSLib.js"></script>
</head>
<body style="background-color: #000000">
	 <link href="<%=request.getContextPath()%>/chart/common/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/chart/common/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/chart/common/css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
  <link href="<%=request.getContextPath()%>/chart/common/css/flexslider.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/chart/common/css/templatemo-style.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body class="tm-gray-bg">
  	<!-- Header -->
  	<div class="tm-header">
  		<div class="container">
  			<div class="row">
  				<div class="col-lg-4 col-md-2 col-sm-3 tm-site-name-container">
  					<a href="#" class="tm-site-name">智慧校园出行</a>
  					
  					<p style="color: #FCDD44">欢迎你，<%=(String) session.getAttribute("name")%><a href="LoginOut" style="color: #FCDD44">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注销</a>	</p>
  					
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
  	
 	<div id="ehartsBathroomBar1" style=" width:100%; height:100%;position:absolute; top: 20%; left:0%; ">		
 		<div id=ehartsBathroomBar1 style="width:100%; height:100%; position:absolute; left:0%; top:0%;border: 1px solid #FCDD44  ">
 			<iframe  src="<%=request.getContextPath()%>/AcademicBuildingBar" style="width:100%; height:100%;border-width: 0px;"></iframe>
 		</div>
 	</div>
 	<div id="allBathroomPie" style=" width:100%; height:100%;position:absolute; top: 120%; left:0%; ">
 		<div id="allBathroomPie" style="width:100%; height:100%; position:absolute; left:0%; top:0%;border: 0px solid #FCDD44  ">
 			<iframe  src="<%=request.getContextPath()%>/EchartsClassroomBar" style="width:100%; height:100%;border-width: 0px;"></iframe>
 		</div>
 	</div>
 	
	
</body>
</html>