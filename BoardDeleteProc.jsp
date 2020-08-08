<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>

<body>


	<%
	
	//usebean이 귀찮을 수 있고 두개만 받아오면 되니 그냥 씀
	
	String pass = request.getParameter("password");
	int num = Integer.parseInt(request.getParameter("num")); 
	
	//데이터베이스 연결
	BoardDAO bdao = new BoardDAO();
	String password = bdao.getPass(num);
	
	//기존 패스워드값과 delete form 에서 작성한 패스워드를 비교
	if(pass.equals(password)){
		//패스워드가 둘 다 같다면
		bdao.deleteBoard(num);  
	
		response.sendRedirect("BoardList.jsp");
		
	}else{
	
	%>
	
	<script>
		alert("패스워드가 일치 하지 않습니다. 다시 확인해 주세요.");
		history.go(-1);
	</script>
	<%
	} %>
</body>
</html>