<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700,900' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/chart/common/css/style.css">
<title>showFriend</title>
<style type="text/css">
#person{
float:left;width:150px;height:190px;cursor: move;background:url(<%=request.getContextPath()%>/chart/common/img/spig.png) no-repeat;
}
.bar{
	overflow:"hidden"; float:left;width:150px;height:190px;
  background-color: #ffff00;
  border: 3px solid blue;
  /* for IE */
  filter:alpha(opacity=90);
  /* CSS3 standard */
  opacity:0.9;}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/chart/common/js/jquery-1.7.js"></script>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script>
 	$(function(){
 		
 		
 		/*$("#person").hover(function (){ 
 			
            $("#bar").show();  
        },function (){  
            $("#bar").hide();  
        }); */
 		
 		var update = {"studentId":"${studentId}"};
 		$.getJSON("<%=request.getContextPath()%>/ShowFriend",update,function(msg){
 			var data = msg.data;
 			var parentDom=$('#app');
 			alert("数量:"+data.length);
 			
 			$.each(data,function(k,v){
 				parentDom.append("<div id='person'><div id='bar' class='bar' style='display: none' >"+v.id+" "+v.name+" "+v.grade+"</div></div>");
 				//$("#app").append(v.id+" "+v.name+" "+v.grade+"<br>");
 			});
 		});
	
 		
 		
 	})
 	
 	
</script>
</head>
<body>
	
	<div id="app">
	</div>
	
	
  	
</body>

<script>
	$("#app").on('mouseenter', '#person', function(){ 
		$(this).find("#bar").css('display','block');
	    //alert( $(this).text() );  
	    return false;  
	});

	$("#app").on('mouseleave', '#person', function(){ 
		$(this).find("#bar").css('display','none');
	    //alert( $(this).text() );  
	    return false;  
	}); 
</script>

</html>