<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

	<!-- 
	0.멤버리스트에서 넘긴 id를 받아옴
	1.DB에서 한명의 회원의 정보를 가져옴   -->
<%
	String id = request.getParameter("id"); //멤버리스트에서 넘겨준 id를 받음 

	MemberDAO mdao = new MemberDAO();
	MemberBean mbean = mdao.oneSelectMember(id); //해당하는 id의 회원정보를 리턴
	

%>
<center>

	<h2>회원 정보 보기</h2>

	<table width="400" border="1">
	
	<tr height="50">
		<td align ="center" width="150">아이디</td>
		<td width="250"><%=mbean.getId() %></td>
	</tr>
	<tr height="50">
		<td align ="center" width="150">이메일</td>
		<td width="250"><%=mbean.getEmail() %></td>
	</tr>
	<tr height="50">
		<td align ="center" width="150">전화번호</td>
		<td width="250"><%=mbean.getTel() %></td>
	</tr>
	<tr height="50">
		<td align ="center" width="150">취미</td>
		<td width="250"><%=mbean.getHobby() %></td>
	</tr>
	<tr height="50">
		<td align ="center" width="150">직업</td>
		<td width="250"><%=mbean.getJob() %></td>
	</tr>
	<tr height="50">
		<td align ="center" width="150">나이</td>
		<td width="250"><%=mbean.getAge() %></td>
	</tr>
	<tr height="50">
		<td align ="center" width="150">정보</td>
		<td width="250"><%=mbean.getInfo() %></td>
	</tr>
	
	<tr height="50">
		<td align ="center" colspan="2">
		<button onclick="location.href='MemberUpdateForm.jsp?id=<%=mbean.getId()%>'">회원수정</button>
		<button onclick="location.href='MemberDeleteForm.jsp?id=<%=mbean.getId()%>'">회원삭제</button>
		<button onclick="location.href='MemberList.jsp?id=<%=mbean.getId()%>'">목록보기</button>
		<button onclick="location.href='MemberJoin.jsp?id=<%=mbean.getId()%>'">회원가입</button>
		

		</td>
	</tr> 
	
	
	
	
	</table>
	</center>
</body>
</html>