<%@page import="model.BoardDAO"%>
<%@page import="model.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>UpdateForm</title>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@200&family=Josefin+Slab:ital,wght@1,300&family=M+PLUS+1p:wght@300&family=Noto+Serif+JP:wght@200&family=Poiret+One&display=swap" rel="stylesheet">
<style>
body{
 	 
		background: url(images/writeform.jpg) no-repeat center center fixed; 
  		background-repeat:no-repeat;
		background-size:cover;
	}   
	
	
	
h2{

	font-family: 'Poiret One', cursive;
	font-size: 40px;
	padding : 20px;
}

h3{
	font-family: 'Josefin Slab', serif;
	font-size: 17px;
	padding : 10px;
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
<%
int num= Integer.parseInt(request.getParameter("num").trim());


BoardDAO bdao = new BoardDAO();
BoardBean bean = bdao.getOneUpdateBoard(num);
%>

	<center>
		<h2>  - Update Form -</h2>
		<h3 style="color:#497649">  ! You Can Edit ONLY TITLE &amp; CONTENT ! </h3>
		
	
	
	<form action="BoardUpdateProc.jsp">
		<table class="table01" width="700" >
				<tr height="70">
					<td align="center" width="50">Writer</td>
					<td class="td01" align="center" width="300">
					<input type="text" name="writer" size="50" value="<%=bean.getWriter() %>" disabled="disabled" />
				</tr>
			
				<tr  height="70">
					<td align="center" width="50">Email</td>
					<td class="td01" align="center" width="300">
					<input type="text" name="email" size="50" value="<%=bean.getEmail() %>" disabled="disabled"/></td>
				</tr> 
				
				<tr height="70">
					<td align="center" width="50">Title
					<td class="td01" align="center" width="300">
					<input type="text" name="subject" size="50" value="<%=bean.getSubject() %>" />
					</td>
				</tr>
			
				
				
				<tr  height="100">
					<td align="center" width="50">Content</td>
					<td class="td01" align="center" width="300">
					<textarea rows="10" cols="51" name="content" style="background-color:transparent"><%=bean.getContent() %></textarea></td>
				</tr> 
			
				<tr  height="70">
					<td align="left" width="50">Password</td>
					<td class="td01" align="left" width="100">
					<input type="password" name="password" size="20"/></td>
				</tr> 
			
			
			<tr height="100">
				<td align ="center" colspan="4">
					<input type="hidden" name="num" value="<%=bean.getNum() %>" style="text-decoration:none">
					<input class="btn" type="submit" value="UPDATE"> &nbsp;&nbsp;
					<input class="btn" type="button" value="LIST" onclick="location.href='BoardList.jsp'">
				</td>
			</tr>
		</table>
		</form>
</center>
</body>
</html>