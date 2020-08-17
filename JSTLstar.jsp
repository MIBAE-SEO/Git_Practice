<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>


	<!-- 총 3개의 for문이 필요 (outer, inner1 ,inner2)
	
		 *
		***
	   *****	
	  *******
	 *********
	 
	 -->
	 
<!-- 5개의 반복적인일을 하는 outer for문  -->
	<c:forEach var="i" begin="0" end="4">
		<!-- 공백을 출력하는 반복문 작성 -->
		<c:forEach var="j" begin="${i+1}" end="4">
			&nbsp;
			
		</c:forEach>
			
			<!-- *을 출력하는 반복문 작성 -->
			<c:forEach var="j" begin="1" end="${1+(i*2)}">
			*
			</c:forEach>
		<br>	
	</c:forEach>
	 
</body>
</html>