<%@page import="db.CarListBean"%>
<%@page import="java.util.Vector"%>
<%@page import="db.RentCarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

<!-- 데이터베이스를 연결하여 최신순 자동차 3대만 뿌려주는 데이터를 가져옴   -->

<%
	//데이터베이스 생성
	RentCarDAO rdao = new RentCarDAO();

	//벡터를 이용하여 데이터를 저장
	Vector<CarListBean> v = rdao.getSelectCar();

%>



</body>
</html>