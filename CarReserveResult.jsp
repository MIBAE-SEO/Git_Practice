
<%@page import="db.CarListBean"%>
<%@page import="db.RentCarDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="rbean" class="db.CarReserveBean"> 
	<jsp:setProperty name="rbean" property="*"/>
 </jsp:useBean>
 

<!-- 로그인처리 : 게스트일 시 예약 불가  -->

	
<%
	String id = (String)session.getAttribute("id");

	
	if(id==null){ //session에서 넘어오기때문에 null로 넘어옴. Top.jsp에서 넘어오는것아님.
%>
	<script>
	alert("로그인 후 예약이 가능합니다");
	location.href=('RentCarMain.jsp?center=MemberLogin.jsp');
	</script>
<% 
	}


	//날짜비교
	
	Date d1 = new Date();
	Date d2 = new Date();
	
	//날짜를 yyyy-mm-dd로 바꿔주는 클래스선언
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
	d1 = sdf.parse(rbean.getRday());
	d2 = sdf.parse(sdf.format(d2));
	
	//날짜비교 메소드를 사용할 수 있음.
	int compare = d1.compareTo(d2);
	
	//렌트예약 하려는 날짜보다 현재날짜가 크다면 -1
	//예약하려는 날짜와 현재날짜가 같다면 0 
	//예약하려는 날짜가 더 크다면 1을 리턴 
	
	if(compare < 0){ //오늘보다 적은 이전날짜 선택시 
		
		%>
		<script>
		alert("현재일 기준 이전날짜는 선택할 수 없습니다.");
		history.go(-1);
		</script>
	<% 
		}
	
	//DB에 저장하기위해 bean클래스에 맞는 테이블을 만들어준다.
	
	//결과적으로 아무런 문제가 없다면 데이터 저장후 결과페이지 보여주기
	//아이디 값이 bean클래스에  없기때문에
	
	String id1 = (String)session.getAttribute("id");
	rbean.setId(id1);
	
	//데이터베이스에 bean클래스를 저장
	RentCarDAO rdao = new RentCarDAO();
	rdao.setReserveCar(rbean);
	
	//차량 정보 얻어오기
	CarListBean cbean = rdao.getOneCar(rbean.getNo());
	
	//차량 렌탈 총 금액
	int totalcar = cbean.getPrice() * rbean.getQty()*rbean.getDday();
	
	//옵션 금액
	int usein=0;
	if(rbean.getUsein()==1) usein=10000;
	int usewifi=0;
	if(rbean.getUsein()==1) usewifi=10000;
	int useseat=0;
	if(rbean.getUsein()==1) useseat=10000;
	int totaloption = (rbean.getQty() * rbean.getDday())*( usein+usewifi+useseat);
%>
<center>
	<table width="1000">
	<tr height="100">
			<td align="center" >
	<font size="6" color="gray">차량 예약 최종 확인</font>
	</td></tr>
	<tr>
			<td align="center" >
	<img alt="" src="img/<%=cbean.getImg()%>" width="470" %></td>
	</tr>
	<tr height="50">
		<td align="center">
		<font size="3" color="black">차량 대여 금액 <%=totalcar%>원 입니다.</font> 
	</td>
	</tr>
	<tr height="50">
		<td align="center">
		<font size="3" color="black">차량 총 옵션 금액 <%=totaloption %>원 입니다.</font>
	</td>
	</tr>
	<tr height="50">
		<td align="center">
		<font size="5" color="red">렌탈 총 금액 <%=totaloption+totalcar %>원 입니다.</font>
	</td>
	</tr>
</table>
</center>


</body>
</html>