<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>ReplyForm</title>
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

.btn{
	font-family: 'Dosis', sans-serif;
	font-color:#0E6635;
 	font-size:20px;
	background-color:transparent;
	border:1px;
 	padding:50px;
}

</style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
%>


	<center>
	<h1>  - Reply Form -</h1>
	
	<jsp:useBean id="boardbean" class="model.BoardBean">
	<jsp:setProperty name="boardbean" property="*" />
	</jsp:useBean>
	
	<%
	
		int num = Integer.parseInt(request.getParameter("num"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
	
	%>
	
	<form action="BoardReplyProc.jsp">
		<table class="table01" width="700" >
				<tr height="70">
					<td align="center" width="50">Writer</td>
					<td class="td01" align="center" width="300">
					<input type="text" name="writer" size="50"  />
				</tr>
			
				<tr height="70">
					<td align="center" width="50">Title
					<td class="td01" align="center" width="300">
					<input type="text" name="subject" size="50" value="[답글] " /></td>
				</tr>
			
				<tr  height="70">
					<td align="center" width="50">Email</td>
					<td class="td01" align="center" width="300">
					<input type="text" name="email" size="50"  /></td>
				</tr> 
				
				<tr  height="70">
					<td align="center" width="50">Password</td>
					<td class="td01" align="center" width="300">
					<input type="password" name="password" size="50" /></td>
				</tr> 
				
				<tr  height="100">
					<td align="center" width="50">Content</td>
					<td class="td01" align="center" width="300">
					<textarea rows="10" cols="51" name="content" style="background-color:transparent"></textarea></td>
				</tr> 
			
			
			
			<tr height="100">
				<td align ="center" colspan="4">
					<input type="hidden" name="ref" value="<%=ref %>">
					<input type="hidden" name="re_step" value="<%=re_step %>"> 
					<input type="hidden" name="re_level" value="<%=re_level %>"> 
					<input class="btn" type="submit" value="SUBMIT"> &nbsp;&nbsp;
					<input class="btn" type="button" value="LIST" onclick="location.href='BoardList.jsp'">
				</td>
			</tr>
		</table>
		</form>
</center>
</body>
</html>