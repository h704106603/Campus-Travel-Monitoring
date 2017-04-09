<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign In & Sign Up Form Widget Flat Responsive Widget Template :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Sign In Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- js -->
<script src="<%=request.getContextPath()%>/chart/common/js/jquery-1.7.js"></script>
<!-- //js -->
<link href="<%=request.getContextPath()%>/chart/common/css/login.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
html, body{
    font-size: 100%;
	font-family: 'Raleway', sans-serif;
	background:url(<%=request.getContextPath()%>/chart/common/img/login_banner.jpg) no-repeat 0px 0px;
	background-size:cover;
	-webkit-background-size:cover;
	-moz-background-size:cover;
	-o-background-size:cover;
	-ms-background-size:cover;
	background-attachment:fixed;
}

i.fa.fa-times.fa-pencil {
    background:url(<%=request.getContextPath()%>/chart/common/img/login_1.png) no-repeat 7px 5px;
    display: block;
    width: 30px;
    height: 30px;
}
i.fa.fa-times{
	background:url(<%=request.getContextPath()%>/chart/common/img/login_2.png) no-repeat 7px 6px;
    display: block;
    width: 30px;
    height: 30px;
}
</style>
</head>
<body>
	<div class="main">
		<h1>欢迎访问智慧校园出行</h1>
		<div class="w3_login">
			<div class="w3_login_module">
				<div class="module form-module">
				  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
					<div class="tooltip">登录/注册</div>
				  </div>
				  <div class="form">
					<h2>登录</h2>
					<form action="doLogin" method="post">
					  <input type="text" name="username" placeholder="学号" required=" ">
					  <input type="password" name="password" placeholder="密码" required=" ">
					  <input type="submit" value="确认">
					</form>
				  </div>
				  <div class="form">
					<h2>注册</h2>
					<form action="doRegister" method="post">
					  <input type="text" name="username" placeholder="学号" required=" ">
					  <input type="text" name="name" placeholder="姓名" required=" ">
					   <input type="password" name="password" placeholder="密码" required=" ">
					  <input type="text" name="grade" placeholder="班级" required=" ">
					  <input type="submit" value="确认">
					</form>
				  </div>
				  <!-- <div class="cta"><a href="#">忘记密码</a></div> -->
				</div>
			</div>
			<script>
			$(function(){
				var wrongmessage = '${wrongmessage}';
				if(wrongmessage=="登录失败"){
					alert("登录失败，请重新登录！");
				}
				if(wrongmessage=="注册失败"){
					alert("注册失败，请重新注册！");
				}
				
				
			});
				
				$('.toggle').click(function(){
				  // Switches the Icon
				  $(this).children('i').toggleClass('fa-pencil');
				  // Switches the forms  
				  $('.form').animate({
					height: "toggle",
					'padding-top': 'toggle',
					'padding-bottom': 'toggle',
					opacity: "toggle"
				  }, "slow");
				});
				
				
				
			</script>
		</div>
		<div class="agileits_copyright">
			<p> 智慧校园出行  | Hang</p>
		</div>
	</div>
</body>
</html>