<%@page import="model.MemberBean" %>
<%@page import="model.MemberDAO" %>
<%@page import="java.util.Vector" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

	<!-- 1. 데이터 베이스에서 모든 회원 정보 가져오기 -->
	
	
	<%
		MemberDAO mdao = new MemberDAO();
		//회원들의 정보가 얼마나 저장되어 있는지 모르기에 가변길이 Vector를 이용하여 작업.
		//클래스의 최상위는 오브젝트. 벡터는 오브젝트를 담음. 
		//이렇게 지정하지 않으면 object타입으로 불러와져서 한 번 더 캐스팅해야하는 수고가 있음. 
		Vector<MemberBean> vec = mdao.allSelectMember();
		
	%>
	
	<!-- 2. table태그를 이용하여 화면에 회원정보 출력  -->
	<center>
	<h2> 모든 회원 보기 </h2>
	<table width="800" border="1">
		<tr height="50">
		<td align="center" width="150"> 아이디</td>
		<td align="center" width="250"> 이메일</td>
		<td align="center" width="200"> 전화번호</td>
		<td align="center" width="200"> 취미</td>
	</tr>
	
	<%
		for(int i=0; i< vec.size(); i++){
			MemberBean bean = vec.get(i); //벡터에 담긴 빈클래스를 하나씩 추출	
		
	%>
	<tr height="50">
		<td align="center" width="150">
		<a href="MemberInfo.jsp?id=<%=bean.getId()%>"> <%=bean.getId() %></a></td>
		<td align="center" width="250"> <%=bean.getEmail() %></td>
		<td align="center" width="200"> <%=bean.getTel() %></td>
		<td align="center" width="200"> <%=bean.getHobby() %></td>
	</tr>
	<%} %>
	</table>
	
	</center>
</body>
</html>