<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="user.UserDAO" %>
<%@ page import ="java.io.PrintWriter" %> <!-- 자바스크립트 문장을 이용하게 위해서 -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/> <!--현재페이지에서만 사용-->
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<jsp:setProperty name="user" property="userName"/>
<jsp:setProperty name="user" property="userGender"/>
<jsp:setProperty name="user" property="userEmail"/>
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
			userID=(String) session.getAttribute("userID");
		}
		if(userID != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되어 있습니다.')");
			script.println("location.href='main.jsp'"); 
			script.println("<script>");
		} //로그인이 된 사람은 다시 로그인이 되지 못하도록 한다.

        if(user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null ||
                        user.getUserGender() == null || user.getUserEmail()==null){
        	
            PrintWriter script = response.getWriter();
            System.out.println(user.getUserID()+"pass: "+user.getUserPassword()+"name:"+user.getUserName()+"gender:"+
           		user.getUserGender()+"email:"+user.getUserEmail());
            script.println("<script>");
            script.println("alert('입력이 안된 사항이 있습니다.')");
            script.println("history.back()");
            script.println("</script>");
	}else {
        UserDAO userDAO = new UserDAO();
        int result = userDAO.join(user);
            if(result == -1){
                PrintWriter script = response.getWriter(); //하나의 스크립트 문장을 넣을 수 있도록.
                script.println("<script>");
                script.println("alert('이미 존재하는 아이디 입니다.')");
                script.println("history.back()");
                script.println("</script>");
            }
		 else{
			//로그인에 생성했을때 세션을 부여한다
			session.setAttribute("userID",user.getUserID());
             PrintWriter script = response.getWriter();
             script.println("<script>");
             script.println("location.href= 'main.jsp'");
             script.println("</script>"); 
             }
     }

	//mysql connector 드라이버를 web-inf lib에 추가하여 실행해보기 
%>
</body>
</html>