<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>MemberJoinProc</title>
<link href="https://fonts.googleapis.com/css2?family=Hepta+Slab:wght@200&family=Noto+Serif+KR:wght@300;400&family=Poiret+One&display=swap" rel="stylesheet">
<style>

</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>

	<jsp:useBean id="mbean" class="db.ShopMemberBean">
	<jsp:setProperty name="mbean" property="*"/>
	</jsp:useBean>
	
<% 	String id = "user2";
String password = "soldesk";
String url="jdbc:oracle:thin:@localhost:1521:XE";


try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url,id,password);

	String sql="insert into shopmember values(?,?,?,?,?)";


	PreparedStatement pstmt = con.prepareStatement(sql);


	pstmt.setString(1, mbean.getId()); 
	pstmt.setString(2, mbean.getPassword1()); 
	pstmt.setString(3, mbean.getEmail()); 
	pstmt.setString(4, mbean.getTel()); 
	pstmt.setString(5, mbean.getInfo()); 


	pstmt.executeUpdate();


	con.close();


	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	
	<script>
		alert("회원가입이 성공적으로 완료되었습니다.");
		location.href="MemberLogin.jsp";
	</script>
	
</body>
</html>