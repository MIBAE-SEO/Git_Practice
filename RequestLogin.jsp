<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

	<center>
		<h2>로그인 페이지</h2>
		
	<!-- get방식과 post방식의 차이  -->
	<form action="RequestloginProc.jsp" method="post">
	
	
	<table width="400" border="1">
	<tr height="60">
		<td align="center" width="150"> 아이디 </td>
		<td align="left" width="250"> 
			<input type="text" name="id">
		</td>
	</tr>
	<tr height="60">
		<td align="center" width="150"> 비밀번호 </td>
		<td align="left" width="250"> 
			<input type="password" name="password">
		</td>
	</tr>
	<tr height="60">
	<td colspan="2" align="center">
	<input type="submit" value="전송">
	</td>
	</tr>
	</table>

			</form>
	</center>
</body>
</html>