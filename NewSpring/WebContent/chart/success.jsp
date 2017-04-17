<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>首页</title>

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
  					<p style="color: #FCDD44">欢迎你，<%=(String) session.getAttribute("name")%></p>
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
							<li><a href="about.html">食堂</a></li>
							<li><a href="tours.html">剧场</a></li>
							<li><a href="tours.html">教室</a></li>
							<li><p></p></li>
						</ul>
					</nav>		
	  			</div>				
  			</div>
  		</div>	  	
  	</div>
	
	<!-- Banner -->
	<section class="tm-banner">
		<!-- Flexslider -->
		<div class="flexslider flexslider-banner">
		  <ul class="slides">
		    <li>
			    <div class="tm-banner-inner">
					<h1 class="tm-banner-title">近期的<span class="tm-yellow-text">剧场</span>活动</h1>
					<p class="tm-banner-subtitle">recent shows</p>
					<a href="#more" class="tm-banner-link">了解更多</a>	
				</div>
				<img src="<%=request.getContextPath()%>/chart/common/img/banner-1.jpg" alt="Image" />	
		    </li>
		    <li>
			    <div class="tm-banner-inner">
					<h1 class="tm-banner-title">各大<span class="tm-yellow-text">出入地</span>状态</h1>
					<p class="tm-banner-subtitle">All kinds of places</p>
					<a href="#more" class="tm-banner-link">了解更多</a>	
				</div>
		      <img src="<%=request.getContextPath()%>/chart/common/img/banner-2.jpg" alt="Image" />
		    </li>
		    <li>
			    <div class="tm-banner-inner">
					<h1 class="tm-banner-title">我的<span class="tm-yellow-text">好友</span>情况</h1>
					<p class="tm-banner-subtitle">My Friend</p>
					<a href="<%=request.getContextPath()%>/findFriend?studentId=<%=(String) session.getAttribute("studentId")%>" class="tm-banner-link">了解更多</a>	
				</div>
		      <img src="<%=request.getContextPath()%>/chart/common/img/banner-3.jpg" alt="Image" />
		    </li>
		  </ul>
		</div>	
	</section>

	<!-- gray bg -->	
	<section class="container tm-home-section-1" id="more">
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<img src="<%=request.getContextPath()%>/chart/common/img/library.jpg" alt="image" class="img-responsive">
					<a href="#">
						<div class="tm-green-gradient-bg tm-city-price-container">
							<span>图书馆</span>
							<span>实时监控</span>
							<span id="LibraryScore">出行指数:</span>
						</div>	
					</a>			
				</div>				
			</div>

			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<img src="<%=request.getContextPath()%>/chart/common/img/bathroom.jpg" alt="image" class="img-responsive">
					<a href="<%=request.getContextPath()%>/BathroomIndex">
						<div class="tm-yellow-gradient-bg tm-city-price-container">
							<span>公共浴室</span>
							<span>实时监控</span>
							<span id="BathroomScore">出行指数:</span>
						</div>	
					</a>
								
				</div>				
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
					<img src="<%=request.getContextPath()%>/chart/common/img/lunch.jpg" alt="image" class="img-responsive">
					<a href="#">
						<div class="tm-red-gradient-bg tm-city-price-container">
							<span>食堂</span>
							<span>实时监控</span>
							<span id="CanteenScore">出行指数:</span>
						</div>	
					</a>					
				</div>				
			</div>
			
			
		</div>
	
		<div class="newline">
				
			<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<img src="<%=request.getContextPath()%>/chart/common/img/theater.jpg" alt="image" class="img-responsive">
					<a href="#">
						<div class="tm-green-gradient-bg tm-city-price-container">
							<span>剧场</span>
							<span>实时监控</span>
							<span id="TheatreScore">出行指数:</span>
						</div>	
					</a>			
				</div>				
			</div>

			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<img src="<%=request.getContextPath()%>/chart/common/img/classroom.jpg" alt="image" class="img-responsive">
					<a href="#">
						<div class="tm-yellow-gradient-bg tm-city-price-container">
							<span>教室</span>
							<span>实时监控</span>
							<span id="ClassroomScore">出行指数:</span>
						</div>	
					</a>			
				</div>				
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
					<img src="<%=request.getContextPath()%>/chart/common/img/friend.jpg" alt="image" class="img-responsive">
					<a href="<%=request.getContextPath()%>/findFriend?studentId=<%=(String) session.getAttribute("studentId")%>">
						<div class="tm-red-gradient-bg tm-city-price-container">
							<span>好友</span>
							<span>出没情况</span>
						</div>	
					</a>					
				</div>				
			</div>
						
		</div>	
				
		</div>
		
		
		<div class="section-margin-top">
			<div class="row">				
				<div class="tm-section-header">
					<div class="col-lg-3 col-md-3 col-sm-3"><hr></div>
					<div class="col-lg-6 col-md-6 col-sm-6"><h2 class="tm-section-title">近期剧场活动</h2></div>
					<div class="col-lg-3 col-md-3 col-sm-3"><hr></div>	
				</div>
			</div>
			<div class="row" id="theatreShow">
				<!-- <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
					<div class="tm-home-box-2">						
						<img src="<%=request.getContextPath()%>/chart/common/img/index-03.jpg" alt="image" class="img-responsive">
						<h3>活动一</h3>
						<p class="tm-date">时间一</p>
						<div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
					<div class="tm-home-box-2">						
					    <img src="<%=request.getContextPath()%>/chart/common/img/index-04.jpg" alt="image" class="img-responsive">
						<h3>活动二</h3>
						<p class="tm-date">时间二</p>
						<div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
					<div class="tm-home-box-2">						
					    <img src="<%=request.getContextPath()%>/chart/common/img/index-05.jpg" alt="image" class="img-responsive">
						<h3>活动三</h3>
						<p class="tm-date">时间三</p>
						<div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
					<div class="tm-home-box-2 tm-home-box-2-right">						
					    <img src="<%=request.getContextPath()%>/chart/common/img/index-06.jpg" alt="image" class="img-responsive">
						<h3>活动四</h3>
						<p class="tm-date">时间四</p>
						<div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
					</div>
				</div> -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<p class="home-description">每个账号可以通过点赞来支持你所喜欢的活动</p>					
				</div>
			</div>			
		</div>
	</section>	
	
	<!-- white bg -->
	<section class="tm-white-bg section-padding-bottom">
		<div class="container">
			<div class="row">
				<div class="tm-section-header section-margin-top">
					<div class="col-lg-4 col-md-3 col-sm-3"><hr></div>
					<div class="col-lg-4 col-md-6 col-sm-6"><h2 class="tm-section-title">近期社团活动</h2></div>
					<div class="col-lg-4 col-md-3 col-sm-3"><hr></div>	
				</div>
				<div class="col-lg-6">
					<div class="tm-home-box-3">
						<div class="tm-home-box-3-img-container">
							<img src="<%=request.getContextPath()%>/chart/common/img/index-07.jpg" alt="image" class="img-responsive">	
						</div>						
						<div class="tm-home-box-3-info">
							<p class="tm-home-box-3-description">活动介绍</p>
					        <div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description box-3">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
						</div>						
					</div>					
			     </div>
			     <div class="col-lg-6">
			        <div class="tm-home-box-3">
						<div class="tm-home-box-3-img-container">
							<img src="<%=request.getContextPath()%>/chart/common/img/index-08.jpg" alt="image" class="img-responsive">	
						</div>						
						<div class="tm-home-box-3-info">
							<p class="tm-home-box-3-description">活动介绍</p>
					        <div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description box-3">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
						</div>						
					</div>
				</div>
				<div class="col-lg-6">
				    <div class="tm-home-box-3">
						<div class="tm-home-box-3-img-container">
							<img src="<%=request.getContextPath()%>/chart/common/img/index-09.jpg" alt="image" class="img-responsive">	
						</div>						
						<div class="tm-home-box-3-info">
							<p class="tm-home-box-3-description">活动介绍大概字数要大于多少呢---------------------------fdsfds-------------------------------------------------</p>
					        <div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description box-3">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
						</div>						
					</div>
			    </div>
			    <div class="col-lg-6">
			        <div class="tm-home-box-3">
						<div class="tm-home-box-3-img-container">
							<img src="<%=request.getContextPath()%>/chart/common/img/index-10.jpg" alt="image" class="img-responsive">	
						</div>						
						<div class="tm-home-box-3-info">
							<p class="tm-home-box-3-description">活动介绍</p>
					        <div class="tm-home-box-2-container">
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-heart tm-home-box-2-icon border-right"></i></a>
							<a href="#" class="tm-home-box-2-link"><span class="tm-home-box-2-description box-3">点赞/评论</span></a>
							<a href="#" class="tm-home-box-2-link"><i class="fa fa-edit tm-home-box-2-icon border-left"></i></a>
						</div>
						</div>						
					</div>
			   	</div>
			</div>		
		</div>
	</section>
	<footer class="tm-black-bg">
		<div class="container">
			<div class="row">
				<p class="tm-copyright-text">
				智慧校园出行——hang&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<a target="_blank" href="https://github.com/h704106603/hang">
				本网站github项目地址
				</a>
				</p>
			</div>
		</div>		
	</footer>
	
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.11.2.min.js"></script>      		<!-- jQuery -->
  	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/moment.js"></script>							<!-- moment.js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/bootstrap.min.js"></script>					<!-- bootstrap js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/bootstrap-datetimepicker.min.js"></script>	<!-- bootstrap date time picker js, http://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery.flexslider-min.js"></script>
<!--
	<script src="js/froogaloop.js"></script>
	<script src="js/jquery.fitvid.js"></script>
-->
   	<script type="text/javascript" src="js/templatemo-script.js"></script>      		<!-- Templatemo Script -->
	<script>
		
		// Load Flexslider when everything is loaded.
		$(window).load(function() {	  		

		    $('.flexslider').flexslider({
			    controlNav: false
		    });
		    
		    $.getJSON("<%=request.getContextPath()%>/GetAllLocationScore",function(msg){
	 			var libraryScore = msg.libraryScore;
	 			var bathroomScore = msg.bathroomScore;
	 			var canteenScore = msg.canteenScore;
	 			var theatreScore = msg.theatreScore;
	 			var classroomScore = msg.classroomScore;
	 			$("#LibraryScore").html("出行指数："+libraryScore+"%");
	 			$("#BathroomScore").html("出行指数："+bathroomScore+"%");
	 			$("#CanteenScore").html("出行指数："+canteenScore+"%");
	 			$("#TheatreScore").html("出行指数："+theatreScore+"%");
	 			$("#ClassroomScore").html("出行指数："+classroomScore+"%");
	 			
	 		});
		    
		    $.getJSON("<%=request.getContextPath()%>/TheatreShowDetails",function(msg){
	 			var theatreShowList = msg.theatreShowList;
	 			var parentDom=$('#theatreShow');
	 			//alert("数量:"+data.length);
	 			
	 			$.each(studentLocation,function(k,v){
	 				parentDom.append("</div>");
	 			});
	 		});

	  	});
	</script>
	
	
 </body>
 </html>