<%@page import="java.util.Vector"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>BoardList</title>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Slab:ital,wght@1,300&family=M+PLUS+1p:wght@300&family=Noto+Serif+JP:wght@200&family=Poiret+One&display=swap" rel="stylesheet">
<style>
body{
		background-image: url("././images/writeform.jpg");
		background-repeat:no-repeat;
		background-size:cover;
		background-attachment:scroll;
	}
	
h1{
	font-family: 'Noto Serif JP', serif;
	font-size: 70px;
	
}

h2{
	font-family: 'Josefin Slab', serif;
	font-size: 20px;
}

h3{

	font-family: 'Poiret One', cursive;
	font-size: 30px;
	padding : 10px;
}


table.type01 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}


table.type01 td{
	font-family: 'Noto Serif JP', serif;
	font-size: 15px;
	font-weight: bold;
}


hr.one{
	width:1000px;
	color:black;
	
}


.btn{
 	font-family: 'Noto Serif JP', serif;
 	font-size:20px;
	background-color:transparent;
 	border:1px;
 	padding:10px;
}

.b .btn{
	margin: right;
}
</style>
</head>
<body>
<center>

<%


BoardDAO bdao = new BoardDAO();
Vector<BoardBean> vec = bdao.getAllBoard();

%>

​
		
		<h1> Customer Service </h1>
		<h2> Hello. What can we help you with? </h2>
		<h3>  - B o a r d -</h3>	
		
			<table width="1000">
				<tr>
				<td align="right">
				<input class="btn" 
					   type="button" 
					   value="write" 
				       onclick="location.href='BoardWriteForm.jsp'"/></td>
                </tr>
			</table>
			
			<hr class="one">
			<table class="type01" width="1000" >
			<tr>
                <td width="100" align="center">No</td>
                <td width="450" align="center">Title</td>
                <td width="250" align="center">Writer</td>
                <td width="150" align="center">Date</td>
                <td width="100" align="center">View</td>
             </tr>

 <%
for(int i = 0; i < vec.size(); i++){
BoardBean bean = vec.get(i); //벡터에 저장되어있는 bean클래스를 하나씩 추출한다.

%> 	
		
<tr height="40">
<td width="100" align="center"><%=i+1 %></td>
<td width="450" align="center">
<a href="BoardInfo.jsp?num=<%=bean.getNum()%>"><%=bean.getSubject() %></a></td>
<td width="250" align="center"><%=bean.getWriter()%></td>
<td width="150" align="center"><%=bean.getReg_date()%></td>
<td width="100" align="center"><%=bean.getReadcount()%></td>
</tr> 
<% } %> 
		        
	</table>
 
	</center>
</body>
</html>