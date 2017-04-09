<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Success Page</title>

<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript">  
$(document).ready(function(){  
});  
</script>
<style type="text/css">  
	.jianli_apply {
display: block; 
width: 100px;
height: 30px;
border: 1px solid #CCC;
background: #9c9d9e;
margin-top: 20px;
}
.jianli_apply a {
font-size: 14px;
padding: 2px 6px;
display: block;
color: #ffffff;
}
</style>
</head>
<body>

<h4>Success Page</h4>
	<table width="200" border="1">
    <tr>
        <td colspan="2">登陆成功</td>
    <tr>
        <td>欢迎你</td>
        <td><%=(String) session.getAttribute("username")%></td>
    </tr>
    <div class="jianli_apply">
  	<a href="<%=request.getContextPath()%>/findFriend?username=<%=(String) session.getAttribute("username")%>">查找好友</a>
	</div>
</table>
</body>
</html>
