<%@page import="db.CarListBean"%>
<%@page import="java.util.Vector"%>
<%@page import="db.RentCarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<center>

<!-- 데이터베이스를 연결하여 최신순 자동차 3대만 뿌려주는 데이터를 가져옴   -->

<%
	//데이터베이스 생성
	RentCarDAO rdao = new RentCarDAO();

	//벡터를 이용하여 데이터를 저장
	Vector<CarListBean> v = rdao.getSelectCar();

%>

	<table width="1000">
		<tr height="240">
		<%
		for(int i=0; i<v.size(); i++){
			CarListBean bean = v.get(i);
		%>
			<td width="333" align="center">	
			<a href="RentCarMain.jsp?center=CarReserveInfo.jsp?no=<%= bean.getNo()%>">
			<img alt="" src="img/<%=bean.getImg()%>" width="300" height="200" > 
			</a><p>
			차랑명 : <%=bean.getName() %>
			</td>
		<%
		}%>
		
	</table>
	
		<hr color="black" size="1">
		&nbsp;
		&nbsp;
	<p>
		<font size="4" color="gray"><b>차량 검색 하기</b></font><br><br><br>
		<form action="RentCarMain.jsp?center=CarCategoryList.jsp" method="post">
		<font size="4" color="gray">차량 검색 하기</font>&nbsp;&nbsp;
		<select name="category">
			<option value="1">소형</option>
			<option value="2">중형</option>
			<option value="3">대형</option>
			<option value="4">고급형</option>
		</select>&nbsp;&nbsp;
		<input type="submit" value="검색">
		<br>
		<br>
		</form>
		
		<button onclick="location.href='RentCarMain.jsp?center=CarAllList.jsp'">전체 검색</button>
</center>
</body>
</html>