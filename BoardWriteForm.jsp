<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>WriteForm</title>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Shadows+Into+Light&display=swap" rel="stylesheet">
<style>

 body{
 	 
		background: url(images/writeform.jpg) no-repeat center center fixed; 
  		background-repeat:no-repeat;
		background-size:cover;
	}   
	
	
	h1{
	
	font-family: 'Abril Fatface', cursive;
	font-size: 70px;
	padding : 20px;
	}
	
table.table01 td{
	
	font-family: 'Dosis', sans-serif;
	font-size: 20px;
	text-align:center;
	}
	



.btn{
	font-family: 'Dosis', sans-serif;
	font-color:#0E6635;
 	font-size:20px;
	background-color:transparent;
	border:1px;
 	padding:50px;
}

input
{
	font-family: 'Dosis', sans-serif;
	background-color:transparent;
	border-bottom: teal 1px solid;
	border-left: medium none;
	border-right: medium none;
	border-top: medium none;
	font-size: 13pt;
}

textarea
{
	font-family: 'Dosis', sans-serif;
	border-bottom: teal 1px solid;
	border-left: teal 1px solid;
	border-right: teal 1px solid;
	border-top: teal 1px solid;
	font-size: 13pt;
	text-decoration: none;
}

</style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
%>

<center>
	<h1> New Write Form </h1>
	<form action="BoardWriteProc.jsp" method="post">
		<table class="table01" width="700" >
			<tr height="50">
				<td width="500">
				<input type="text" name="writer" size="50" placeholder="Enter Your Name "/>
				</td>
			</tr> 
			<tr height="70">
				<td width="500">
				<input type="email" name="email" size="50" placeholder="Enter Your Email"/></td>
			</tr>
			<tr height="70">
				<td width="500">
				<input type="text" name="subject" size="50" placeholder="Title"/></td>
			</tr>
			
			<tr height="70">
				<td width="500"><textarea rows="15" cols="51" name="cotent" placeholder="Message"style="background-color:transparent"></textarea></td>
			</tr>
			
			<tr height="70">
				<td width="500">
				<input type="password" name="password" size="30" placeholder="Enter Your Password"/></td>
			</tr>
			
			<tr height="50">
				<td align ="center" colspan="2">
					<input class="btn" type="submit" value="SUBMIT"> &nbsp;&nbsp;
					<input class="btn" type="reset" value="REWRITE"> &nbsp;&nbsp;
					<input class="btn" type="button" value="LIST" onclick="location.href='BoardList.jsp'">
			</tr>
		</table>
	</form>
</center>
</body>
</html>