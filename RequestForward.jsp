<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<!-- RequestLogin에서 넘어온 아이디와 패스워드를 읽어들임 -->

<%
	//사용자의 정보가 저장되어있는 객체 request의 getParameter를 이용해서 사용자정보 추출
	String id = request.getParameter("id"); //사용자의 id값을 읽어와서 변수 id에 저장하시오
	String password = request.getParameter("password");
	
%>
	<h2> 
	여기는 RequestForward 페이지 입니다.<br>
	당신의 아이디는 <%= id %> 이고 패스워드는 <%= password %>입니다. 
	</h2>
	
	
</body>
</html>