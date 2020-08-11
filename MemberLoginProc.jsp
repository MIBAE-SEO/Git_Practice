<%@page import="db.RentCarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	
	//회원아이디와 로그인아이디가 일치하는지
	
	RentCarDAO rdao = new RentCarDAO();
	
	//해당 회원이 있는지 여부를 숫자로 표현 
	int result = rdao.getMember(id, pass); 
	
	if(result==0){ 
		%>
				
		<script type="text/javascript">
			alert("회원 아이디 또는 패스워드가 틀립니다");
			location.href('RentCarMain.jsp?center=MemeberLogin.jsp');
		</script>
		
<%		
	} else{
		
		//로그인처리가 되었다면
		session.setAttribute("id", id);
		response.sendRedirect("RentCarMain.jsp");
	}
%>


</body>
</html>