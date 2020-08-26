<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>MemberLogin</title>
<link href="https://fonts.googleapis.com/css2?family=Hepta+Slab:wght@200&family=Noto+Serif+KR:wght@300;400&family=Poiret+One&display=swap" rel="stylesheet">
<style>
 body{
		background: url(images/login.jpg) no-repeat center center fixed;  
   		background-repeat:no-repeat; 
   		background-position:50% 137px;
  		width:1800; 

} 

.h01{
	font-family:'Hepta Slab', serif;
	font-size: 35px;
	font-weight:200;
	color:white;
	padding-top:100px;
	padding-bottom:15px;
}

input
{
	font-family: 'Hepta Slab', serif;
	background-color:transparent;
	border-bottom: white 1px solid;
	border-left: medium none;
	border-right: medium none;
	border-top: medium none;
	font-size: 15pt;
	color:white;
	margin-top: 15px;
	margin-bottom: 15px;
}

input::placeholder {
  color: white;
}

.btn{
	font-family: 'Hepta Slab', serif;
	font-weight:bold;
 	font-size:17px;
	color:white;
	background-color:transparent;
	border:1px;
	padding-bottom:45px;
}
</style>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");
	%>
	
	<div class="h01">
	<h1>Welcome to fitzroy</h1>
	<h2>- Login -</h2>
	</div>
	
	<table>
	<tr height="80">
	</table>
	<form action="MemberLoginProc.jsp" method="post" >
	
	<table class="table01" width="800" align="center" >
		
		<tr height="50">
		<td width="100" align="center">
		<input type="text" name="id" size="30" placeholder="Enter your ID"/></td>
		</tr>
		
		<tr height="50">
		<td width="100" align="center">
		<input type="password" name="pass" size="30" placeholder="Enter your Password"/></td>
		</tr>
		
		
		<tr height="60">
		<td align="center" colspan="5">
		<input class="btn" type="submit" value="Login">
		
		</td>
		</tr>
		</table>
		
		<table>
		<tr height="130">
		</table>
	</form>
	
	
</body>
</html>