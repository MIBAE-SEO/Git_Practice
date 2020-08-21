<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<% request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="boardbean" class="model.BoardBean">
	<jsp:setProperty name="boardbean" property="*"/>
</jsp:useBean>


<%
	BoardDAO bdao = new BoardDAO();
	bdao.ReplyBoard(boardbean); 
	
	response.sendRedirect("BoardList.jsp");
	
%>

</body>
</html>