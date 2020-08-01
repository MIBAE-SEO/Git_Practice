<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty name="mbean" property="*"/> <!-- *써도 필요한 정보만 들어감 -->
	</jsp:useBean>
	
	<%
		
		MemberDAO mdao = new MemberDAO();
		//패스워드만 가져오는 소스 (DB에서 가져온 pass값이 저장)
		

		String password1 = mdao.getPassword1(mbean.getId());
		
		//수정하기 위해서 작성한 패스워드 값과 기존 DB에서 가져온 패스워드 값을 비교한다
		if(mbean.getPassword1().equals(password1)){
			
			//MemberDAO 클래스의 회원수정 메소드를 호출
			mdao.updateMember(mbean);
			response.sendRedirect("MemberList.jsp");
			
		}else{
 	%>		
 		<script type="text/javascript">
 			alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
 			history.go(-1);
 		</script>
 	<% 	
		}
	
	%>
</body>
</html>