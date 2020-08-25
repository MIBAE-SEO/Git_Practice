<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>MemberJoin</title>
<link href="https://fonts.googleapis.com/css2?family=Hepta+Slab:wght@200&family=Noto+Serif+KR:wght@300;400&family=Poiret+One&display=swap" rel="stylesheet">
<style>



 body{
		background: url(images/join.jpg) no-repeat center center fixed;  
   		background-repeat:no-repeat; 
   		background-position:50% 138px;
  		width:1800; 

} 



.h01{
	font-family:'Hepta Slab', serif;
	font-size: 25px;
	font-weight:200;
	color:white;
	padding-top:50px;
	padding-bottom:15px;
}


input
{
	font-family: 'Noto Serif KR', serif;
	background-color:transparent;
	border-bottom: white 1px solid;
	border-left: medium none;
	border-right: medium none;
	border-top: medium none;
	font-size: 11pt;
	font-color:white;
	margin-top: 15px;
	margin-bottom: 15px;
}

textarea
{
	font-family: 'Noto Serif KR', serif;
	border-bottom: white 1px solid;
	border-left: white 1px solid;
	border-right: white 1px solid;
	border-top: white 1px solid;
	font-size: 11pt;
	text-decoration: none;
	background-color:transparent;
}

input::placeholder {
  color: white;
}

textarea::placeholder {
  color: white;
}

.btn{
	font-family: 'Noto Serif KR', serif;
 	font-size:17px;
	color:white;
	background-color:transparent;
	border:1px;
 	padding-bottom:15px;
}

</style>
</head>
<body>

	<% request.setCharacterEncoding("UTF-8");
	%>
	
	
	<div class="h01">
	<h1>Create fitzroy Profile</h1>
	</div>
	
	<form action="MemberJoinProc.jsp" method="post" >
	
	<table width="800" align="right" >
		
		<tr height="60">
		<td width="100" align="left">
		<input type="text" name="id" size="35" placeholder="ID"/></td>
		</tr>
		
		<tr height="60">
		<td width="100" align="left">
		<input type="password" name="password1" size="35" placeholder="Password"/></td>
		</tr>
		
		<tr height="60">
		<td width="100" align="left">
		<input type="password" name="password2" size="35" placeholder="Confrim Password"/></td>
		</tr>
		
		<tr height="60">
		<td width="100" align="left">
		<input type="email" name="email" size="35" placeholder="Email"/></td>
		</tr>
		
		
		<tr height="60">
		<td width="100" align="left">
		<input type="tel" name="tel" size="35" placeholder="Phone"/></td>
		</tr>
		
		
		<tr height="100">
		<td width="100" align="left">
		<textarea rows="9" cols="40" name="info" placeholder="Comment to fitzroy"></textarea>
		</td>
		</tr>
		
		<tr height="60">
		<td align="center" colspan="5">
		<input class="btn" type="submit" value="CREATE">
		</td>
		</tr>
		</table>
	</form>
</body>
</html>