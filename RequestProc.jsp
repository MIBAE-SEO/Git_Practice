<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<center>

<h2> 회원 정보 보기 </h2>

<%
	//post방식으로 데이터가 넘어올때 한글깨짐현상이 생길 수 있음
		 request.setCharacterEncoding("UTF-8");

	//각종 사용자로부터 넘어온 데이터를 저장해줌
		String id = request.getParameter("id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
	//checkbox는 여러개를 받아 와야 하기 때문에 String 타입으로 받을 수 없고 
	//배열 타입으로 return 받는다.
			
		String [] hobby = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String age = request.getParameter("age");
		String info = request.getParameter("info");
		
		if(!password1.equals(password2)){
%>
	<script type="text/javascript">
		alert("비밀번호가 틀립니다"); //경고창
		history.go(-1); //이전페이지로 이동
	</script>	
<% 		
		}
%>

	<table width="500" border="1">
		<tr height="50">
			<td width="150" align="center">아이디</td>
			<td width="350" align="center"><%= id %>
		</td>
		
		
		<tr height="50">
		<td width="150" align="center">이메일</td>
		<td width="350" align="center"><%= email %>
		</td>
		
		<tr height="50">
		<td width="150" align="center">전화번호</td>
		<td width="350" align="center"><%= tel %>
		</td>
		
		<!-- 배열은 for문 돌려서 출력해야한다  -->
		<tr height="50">
		<td width="150" align="center">관심분야</td>
		<td width="350" align="center">
		<%
			for(int i=0; i<hobby.length; i++){
				out.write(hobby[i]+" ");
			}
		%>
		</td>
		
		<tr height="50">
		<td width="150" align="center">직업</td>
		<td width="350" align="center"><%= job %>
		</td>
		
		<tr height="50">
		<td width="150" align="center">연령</td>
		<td width="350" align="center"><%= age %>
		</td>
		
		<tr height="50">
		<td width="150" align="center">하고싶은말</td>
		<td width="350" align="center"><%= info %>
		</td>	

		
</center>
</body>
</html>