<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<!-- 세션을 이용한 로그인처리 -->
<%
	String id = (String)session.getAttribute("id");

	//로그인이 되어있지 않다면 
	if(id ==null){
		id="GEUST";
	}

%>
	<table width="1000" >
		<tr height="70">
		 <td colspan="4">
		 	<img alt="" src="img/logo.png" height="65">
		 </td>
		 <td align="center" width="200" >
		 	<%=id %>님 반갑습니다. 
		 </td>
		 <tr height="50">
		 <td align="center" width="200" bgcolor="red">
		 	<font color="white" size="4"> 예약하기 
		 	<a href="CarReserveMain.jsp" style="text-decoration:none"></a></font>
		 </td>
		 <td align="center" width="200" bgcolor="red">
		 	<font color="white" size="4"> 예약확인 
		 	<a href="#" style="text-decoration:none"></a></font>
		 </td>
		 <td align="center" width="200" bgcolor="red">
		 	<font color="white" size="4"> 자유게시판
		 	<a href="#" style="text-decoration:none"></a></font>
		 </td>
		 <td align="center" width="200" bgcolor="red">
		 	<font color="white" size="4"> 이벤트 
		 	<a href="#" style="text-decoration:none"></a></font>
		 </td>
		 <td align="center" width="200" bgcolor="red">
		 	<font color="white" size="4"> 고객센터 
		 	<a href="#" style="text-decoration:none"></a></font>
		 </td>
	</table>


</body>
</html>