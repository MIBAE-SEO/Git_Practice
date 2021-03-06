<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.ShopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>MemberLoginProc</title>
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

String id = request.getParameter("id"); 
String pass = request.getParameter("pass");


ShopDAO sdao = new ShopDAO();

int result= sdao.getMember(id,pass); 

if(result==0){
	%>
	<script>
		alert("회원 아이디 또는 패스워드가 다릅니다.");
		location.href="ShopMain.jsp?center=MemberLogin.jsp";
	</script>
<% }
else{
	session.setAttribute("id",id);
	response.sendRedirect("MemberPage.jsp");
}
%>

	
</body>
</html>