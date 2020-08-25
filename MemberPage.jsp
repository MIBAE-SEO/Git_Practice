<%@page import="db.ShopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>MemberLoginResponse</title>
<link href="https://fonts.googleapis.com/css2?family=Hepta+Slab:wght@200&family=Noto+Serif+KR:wght@300;400&family=Poiret+One&display=swap" rel="stylesheet">
<style>
 body{
		background: url(images/login.jpg) no-repeat center center fixed;  
   		background-repeat:no-repeat; 
   		background-position:50% 137px;
  		width:1800; 

} 

.h1{
	font-family: 'Hepta Slab', serif;
	font-size: 60px;
	color:white;
}

h2{
	font-family: 'Hepta Slab', serif;
	font-size: 40px;
	font-weight:lighter;
	text-decoration:underline;
	
	color:white;
}

h3{
	font-size: 40px;
	font-weight:lighter;
	color:white;
}

.a01{
	
	font-family: 'Hepta Slab', serif;
	font-size: 20px;
}

a:visited { color: white; text-decoration: none;}
a:hover { color: #FF7A85; text-decoration: none;}

</style>

</head>
<body>


<%
request.setCharacterEncoding("UTF-8");


String id = (String)session.getAttribute("id");


%>



	<center>
	<table width="1800">
	<tr align="center">
		<td align="center" width="1800"><jsp:include page="Top.jsp"/></td>
	</tr>
	</table>
	
	
	<table>
	<tr height="200">
	</table>
	
	<div class="h1">
		<h1> Hello, </h1>
		
			<h2><%=id %> </h2>
	</div>
	
	<h3>|</h3>
	
	<div><a class="a01" href="ShopMain.jsp?center=ShopList.jsp"> Go to the shop →</a></div>
	<div><a class="a01" href="ShopMain.jsp?center=ShopCart.jsp">   My Cart →</a></div>
		
		
		<table>
		<tr height="190">
		</table>

	
	
	<tr align="center">
		<td align="center" width="1800"><jsp:include page="Bottom.jsp"/></td>
	</tr>
	
</body>
</html>