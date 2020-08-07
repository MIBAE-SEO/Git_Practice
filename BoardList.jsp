<%@page import="model.BoardBean"%>
<%@ page import="model.BoardDAO"%>
<%@ page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>

<body>
<% request.setCharacterEncoding("UTF-8");
%>
	<%
		//전체게시글의 내용을 jsp쪽으로 가져와야한다.
		//게시글의 개수를 알 수 없기때문에 Vector 타입으로 가져와야한다.

		BoardDAO bdao = new BoardDAO();

		//전체게시글을 리턴 받아주는 소스
		Vector<BoardBean> vec = bdao.getAllBoard();
	%>

	<center>

		<h2>전체 게시글 보기</h2>

		<table width="700" border="1" bgcolor="skyblue">
			<tr height="40">
				<td width="50" align="center">번호</td>
				<td width="320" align="center">제목</td>
				<td width="100" align="center">작성자</td>
				<td width="150" align="center">작성일</td>
				<td width="80" align="center">조회수</td>
			</tr>	
			
		<!-- 데이터추출 -->	
		<%
			for(int i = 0; i < vec.size(); i++){
				BoardBean bean = vec.get(i); //벡터에 저장되어있는 bean클래스를 하나씩 추출한다.
		%>	
		
			<tr height="40">
				<td width="50" align="center"><%=i+1 %></td>
				<td width="320" align="left">
				<a href="BoardInfo.jsp?num=<%=bean.getNum()%>" style="text-decoration:none">
		<%
			if(bean.getRe_step() > 1){
				for(int j=0; j < (bean.getRe_step()-1)*5; j++){
		%>&nbsp;			
		<% 		}
			}
		%>		
				<%=bean.getSubject() %></a></td>
				<td width="100" align="center"><%=bean.getWriter()%></td>
				<td width="150" align="center"><%=bean.getReg_date()%></td>
				<td width="80" align="center"><%=bean.getReadcount()%></td>
			</tr>	
		<% } %>	
		
			<tr height="40">
			<td align="center" colspan="5">
			<input type="button" value="글쓰기" onclick="location.href='BoardWriteForm.jsp'">
		</table>

	</center>


</body>
</html>