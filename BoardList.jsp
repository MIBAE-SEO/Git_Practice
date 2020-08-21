<%@page import="java.util.Vector"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>BoardList</title>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@200&family=Josefin+Slab:ital,wght@1,300&family=M+PLUS+1p:wght@300&family=Noto+Serif+JP:wght@200&family=Poiret+One&display=swap" rel="stylesheet">
<style>
body{
		background-image: url("././images/writeform.jpg");
		background-repeat:no-repeat;
		background-size:cover;
		background-attachment:scroll;
	}
	
h1{
	font-family: 'Abril Fatface', cursive;
	font-size: 70px;
	
}

h2{
	font-family: 'Josefin Slab', serif;
	font-size: 20px;
}

h3{

	font-family: 'Poiret One', cursive;
	font-size: 30px;
	padding : 5px;
}

table.type01 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}

table.type02 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
    font-weight: bold;
}

table.type01 td01{
	font-family: 'Gothic A1', sans-serif;
	font-size: 50px;
	font-weight: bold;
}

table.type01 td02{
	font-family: 'Gothic A1', sans-serif;
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
		
			<table width="1000" height="30">
				<tr>
				<td align="right">
				<input class="btn" 
					   type="button" 
					   value="<write>" 
				       onclick="location.href='BoardWriteForm.jsp'"/></td>
                </tr>
			</table>
			
				<hr class="one">
			<table class="type02" width="1000" >
			<tr>
                <td class="td01" width="100" align="left">No</td>
                <td class="td01" width="450" align="center">Title</td>
                <td class="td01" width="250" align="center">Writer</td>
                <td class="td01" width="150" align="center">Date</td>
                <td class="td01" width="100" align="center">View</td>
             </tr>
			</table>           
				<hr class="one">
 
 	<%
		for(int i = 0; i < vec.size(); i++){
		BoardBean bean = vec.get(i); 

	%> 	
			<table class="type01" width="1000" >
			<tr>
				<td class="td02" width="100" align="left"><%=i+1 %></td>
				<td class="td02" width="450" align="left">
				<a href="BoardInfo.jsp?num=<%=bean.getNum()%>" style="text-decoration:none">
				<%
				if(bean.getRe_step()>1){
					for(int j=0; j<(bean.getRe_step()-1)*5; j++){
				%>&nbsp;	
				<% }
				}
				%>
				<%=bean.getSubject() %></a></td>
				<td class="td02" width="250" align="center"><%=bean.getWriter()%></td>
				<td class="td02" width="150" align="center"><%=bean.getReg_date()%></td>
				<td class="td02" width="100" align="center"><%=bean.getReadcount()%></td>
			</tr> 
	<% } %> 
		        
	</table>
	</center>
</body>
</html>