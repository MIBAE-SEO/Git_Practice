<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>


<%
	request.setCharacterEncoding("UTF-8");
%>

<!-- 사용자데이터를 읽어들이는 bean클래스 설정 -->

<jsp:useBean id="boardbean" class="model.BoardBean">
	<jsp:setProperty name="boardbean" property="*"/>
</jsp:useBean>

<%
	//데이터 베이스에 연결
	BoardDAO bdao = new BoardDAO();
	
	//해당 게시글의 패스워드 값을 얻어온다
	String pass = bdao.getPass(boardbean.getNum());
	
	//기존 패스워드와 update시 작성했던 password값이 일치하는지 확인
	if(pass.equals(boardbean.getPassword())){
		//데이터 수정 메소드 호출
		bdao.updateBoard(boardbean);
		//수정 완료되면 전체게시글 보기
		response.sendRedirect("BoardList.jsp");
	}else{ //패스워드가 틀리다면
%>		
	 <script type="text/javascript">
		alert("패스워드가 일치 하지 않습니다. 다시 확인해 주세요");
		histroy.go(-1);	
	</script>
<% 	
	}		
%>

</body>
</html>