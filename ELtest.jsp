<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<%
 int i = 1;

request.setAttribute("ia", "1"); //자동으로 int로 변환하여 계산
%>

<p>
i = <%="3"+ 4 %> <!-- String이 들어가면 String으로 나옴 -->

<p>
i = ${ia+ 4 }



</body>
</html>