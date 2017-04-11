<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>Home</title>

  
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
<style type="text/css">
#person{
float:left;width:180px;height:190px;margin-left: 50px;cursor: move;background:url(<%=request.getContextPath()%>/chart/common/img/spig.png) no-repeat;
}
.bar{
	overflow:"hidden"; float:left;width:160px;height:150px;
	margin:-10px auto auto auto;
	color:#000000;
	font-weight:bold;
  filter:alpha(opacity=60);
  opacity:0.6;}
  
.tooltip{
	overflow:"hidden"; float:left;width:110px;height:110px;
	font-weight:bold;
	color:#000000;
	margin:20px auto auto 130px;
	background-color: #E9F3F5;
	border: 3px solid #E5E5E5;
  filter:alpha(opacity=50);
  opacity:0.5;
  font-color:black}
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
							<li><a href="<%=request.getContextPath()%>/findFriend?username=<%=(String) session.getAttribute("username")%>">好友情况</a></li>
							<li><a href="about.html">图书馆</a></li>
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

	<!-- white bg -->
	<section class="section-padding-bottom">
		<div class="container" style="padding: 90px">
			<div id="app">
			</div>
	
			
		</div>
	</section>
	<footer class="tm-black-bg">
		<div class="container">
			<div class="row">
				<p class="tm-copyright-text">Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
		</div>		
	</footer>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.7.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/moment.js"></script>							<!-- moment.js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/bootstrap.min.js"></script>					<!-- bootstrap js -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/bootstrap-datetimepicker.min.js"></script>	<!-- bootstrap date time picker js, http://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery.flexslider-min.js"></script>
   	<script type="text/javascript" src="js/templatemo-script.js"></script>      		<!-- Templatemo Script -->
	<script>
		
		// Load Flexslider when everything is loaded.
		$(window).load(function() {	  		

		    $('.flexslider').flexslider({
			    controlNav: false
		    });
		    
		    var update = {"studentId":"${studentId}"};
	 		$.getJSON("<%=request.getContextPath()%>/ShowFriend",update,function(msg){
	 			var studentLocation = msg.studentLocation;
	 			var parentDom=$('#app');
	 			//alert("数量:"+data.length);
	 			
	 			$.each(studentLocation,function(k,v){
	 				parentDom.append("<div id='person'><div id='bar' class='bar' style='display: block' >"+v.name+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+v.grade+"<br></div><div id='tooltip' class='tooltip' style='display: none' >"+v.locationMap+"</div>");
	 				//$("#app").append(v.id+" "+v.name+" "+v.grade+"<br>");
	 			});
	 		});

	  	});
		
		$("#app").on('mouseenter', '#person', function(){ 
			$(this).find("#tooltip").css('display','block');
		    //alert( $(this).text() );  
		    return false;  
		});

		$("#app").on('mouseleave', '#person', function(){ 
			$(this).find("#tooltip").css('display','none');
		    //alert( $(this).text() );  
		    return false;  
		}); 
	</script>
 </body>
 </html>