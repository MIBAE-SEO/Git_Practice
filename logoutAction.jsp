<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그아웃 페이지  </title>
</head>
<body>
<%
       session.invalidate(); //할당해제 

%>

	<script>
		location.href="main.jsp";
	</script>
</body>
</html>