<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

	<center>
	<h2>회원가입</h2>
	<form action="Proc.do" method="post">
	
	
		<table width="500" border="1">
		<tr height="50">
		<td width="150" align="center">아이디</td>
		<td width="350" align="center"><input type="text" name="id" size="40">
		</td>
		
		<tr height="50">
		<td width="150" align="center">비밀번호</td>
		<td width="350" align="center"><input type="password" name="pass1" 
		size="40" placeholder="아이디는 영문으로 입력해주세요">
		</td>
		
		<tr height="50">
		<td width="150" align="center">비밀번호 확인</td>
		<td width="350" align="center"><input type="password" name="pass2" 
		size="40" placeholder="비밀번호는 영문+숫자 조합으로 입력해주세요">
		</td>
		
		<tr height="50">
		<td width="150" align="center">이메일</td>
		<td width="350" align="center"><input type="email" name="email" size="40" >
		</td>
		
		<tr height="50">
		<td width="150" align="center">전화번호</td>
		<td width="350" align="center"><input type="tel" name="tel" size="40">
		</td>
		
		
		<tr height="50">
			<td width="150" align="center">당신의 관심분야</td>
			<td width="150" align="center">
			<input type="checkbox" name="hobby" value="캠핑">캠핑 &nbsp;
			<input type="checkbox" name="hobby" value="등산">등산 &nbsp;
			<input type="checkbox" name="hobby" value="영화">영화 &nbsp;
			<input type="checkbox" name="hobby" value="독서">독서 &nbsp;
			</td>
			</tr>
			
		<tr height="50">
			<td width="150" align="center">당신의 직업</td>
			<td width="150" align="center">
			<select name="job">
			<option value="교사">교사</option>
			<option value="의사">의사</option>
			<option value="변호사">변호사</option>
			<option value="검사">검사</option>
			</select>
			</td>
			</tr>
			
		<tr height="50">
			<td width="150" align="center">당신의 연령은</td>
			<td width="150" align="center">
			<input type="radio" name="age" value="10">10대 &nbsp;
			<input type="radio" name="age" value="20">20대 &nbsp;
			<input type="radio" name="age" value="30">30대 &nbsp;
			<input type="radio" name="age" value="40">40대 &nbsp;
			</td>
			</tr>
			
			
		<tr height="50">
			<td width="150" align="center">하고싶은말</td>
			<td width="150" align="center">
			<textarea rows="5" cols="40" name="info"></textarea>
		</td>
		</tr>
		
		
		<tr height="50">
		<td align="center" colspan="2">
		<input type="submit" value="회원 가입">
		<input type="submit" value="취소">
		</td>
		</tr>
		</table>
	</form>
	</center>
</body>
</html>