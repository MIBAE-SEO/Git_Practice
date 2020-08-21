<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>BoardInfo</title>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Gothic+A1:wght@200&family=Josefin+Slab:ital,wght@1,300&family=M+PLUS+1p:wght@300&family=Noto+Serif+JP:wght@200&family=Poiret+One&display=swap" rel="stylesheet">
<style>

body{
 	 
		background: url(images/writeform.jpg) no-repeat center center fixed; 
  		background-repeat:no-repeat;
		background-size:cover;
	}   
	
	
h1{

	font-family: 'Poiret One', cursive;
	font-size: 30px;
	padding : 55px;
}

	
table.table01 td{
	
	font-family: 'Dosis', sans-serif;
	font-size: 20px;
	
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



<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO bdao = new BoardDAO();
	BoardBean bean = bdao.getOneBoard(num);  

%>

<center>
	<h1>  - B o a r d -</h1>
		<table class="table01" width="700" >
				<tr height="70">
					<td align="center" width="50">No</td>
					<td class="td01" align="center" width="300"><input type="text" name="no" size="50" value="<%=bean.getNum() %>" disabled="disabled"/>
				</tr>
			
				<tr height="70">
					<td align="center" width="50">Writer
					<td class="td01" align="center" width="300"><input type="text" name="no" size="50" value="<%=bean.getWriter() %>" disabled="disabled"/></td>
				</tr>
			
				<tr  height="70">
					<td align="center" width="50">Email</td>
					<td class="td01" align="center" width="300">
					<input type="text" name="email" size="50" value="<%=bean.getEmail()%>" disabled="disabled"/></td>
				</tr> 
				
				<tr  height="70">
					<td align="center" width="50">Title</td>
					<td class="td01" align="center" width="300">
					<input type="text" name="title" size="50" value="<%=bean.getSubject()%>" disabled="disabled"/></td>
				</tr> 
				
				<tr  height="100">
					<td align="center" width="50">Content</td>
					<td class="td01" align="center" width="300">
					<textarea rows="10" cols="51" name="content" style="background-color:transparent" disabled="disabled"><%=bean.getContent()%></textarea></td>
				</tr> 
			
			
			
			<tr height="100">
				<td align ="center" colspan="4">
					<input class="btn" type="button" value="REPLY" onclick="location.href='BoardReplyForm.jsp?num=<%=bean.getNum()%>&ref=<%=bean.getRef()%>&re_step=<%=bean.getRe_step()%>&re_level=<%=bean.getRe_level()%>'"> &nbsp;&nbsp;
					<input class="btn" type="button" value="EDIT" onclick="location.href='BoardUpdateForm.jsp?num=<%=bean.getNum()%>'"> &nbsp;&nbsp;
					<input class="btn" type="button" value="DELETE" onclick="location.href='BoardDeleteForm.jsp?num=<%=bean.getNum()%>'"> &nbsp;&nbsp;
					<input class="btn" type="button" value="LIST" onclick="location.href='BoardList.jsp?num=<%=bean.getNum()%>'">
				</td>
			</tr>
		</table>
		
</center>
</body>
</html>