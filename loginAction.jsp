<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="user.UserDAO" %>
<%@ page import ="java.io.PrintWriter" %> <!-- 자바스크립트 문장을 이용하게 위해서 -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/> <!--현재페이지에서만 사용-->
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트 </title>
</head>
<body>
<%
	String userID = null;
	if(session.getAttribute("userID")!=null){
		userID=(String) session.getAttribute("userID"); //할당된 id담기 
	}
	if(userID != null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어 있습니다.')");
		script.println("location.href='main.jsp'"); 
		script.println("<script>");
	} //로그인이 된 사람은 다시 로그인이 되지 못하도록 한다.
	
	UserDAO userDAO = new UserDAO();
	int result = userDAO.login(user.getUserID(), user.getUserPassword());
	
	if(result ==1){
		//로그인에 생성했을때 세션을 부여한다
		session.setAttribute(user.getUserID(), user.getUserPassword());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href='main.jsp'");
		script.println("</script>");
	}else if ( result == 0 ){ 
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다')");
		script.println("history.back()"); //이전페이지로 돌리기(로그인페이지로) 
		script.println("</script>");
	}else if ( result == -1 ){ //아이디가 존재하지 않음
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");
		script.println("history.back()"); //이전페이지로 돌리기(로그인페이지로) 
		script.println("</script>");
	}else if ( result == -2 ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스 오류가 발생했습니다')");
		script.println("history.back()"); //이전페이지로 돌리기(로그인페이지로) 
		script.println("</script>");
	}
	
	//mysql connector 드라이버를 web-inf lib에 추가하여 실행해보기 
%>
</body>
</html>