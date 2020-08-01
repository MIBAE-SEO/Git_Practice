<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
<%@page import="model.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>
<%

	request.setCharacterEncoding("UTF-8");
	//취미 부분은 별도로 읽어들여 다시 빈클래스에 저장.
	
	String [] hobby = request.getParameterValues("hobby");
	
	 //배열에 있는 내용을 하나의 String으로 저장.
	String texthobby="";
	for(int i=0; i<hobby.length; i++){
		texthobby += hobby[i]+" ";
	} 

%>

	<!--useBean을 이용하여 한꺼번에 데이터를 받아옴 -->
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty name="mbean" property="*"/>
	</jsp:useBean>


	
<%


 	mbean.setHobby(texthobby);
//기존취미는 주소번지가 저장되기때문에 배열의 내용을 하나의 스트링으로 저장한 변수를 다시 입력함.
	

//데이터 베이스 클래스 객체 생성
	MemberDAO mdao = new MemberDAO();
	mdao.insertMember(mbean);

	//회원가입이 완료되었다면 회원정보를 보여주는 페이지로 이동 
	response.sendRedirect("MemberList.jsp");

	//오라클에 접속하는 소스 작성
	/* String id = "user2";
	String password = "soldesk";
	String url="jdbc:oracle:thin:@localhost:1521:XE"; //접속url
	
	try{
		//1.해당 데이터베이스를 사용한다고 선언(클래스를 등록=오라클용사용)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//아파치 톰캣에 ojdbc6.jar 넣었기때문에 
		//2. 해당 데이터베이스에 접속
		Connection con = DriverManager.getConnection(url,id,password);
	
		//3. 접속 후 쿼리준비
		String sql="insert into member2 values(?,?,?,?,?,?,?,?)";
		
		//4. 쿼리사용 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//5. ?에 맞게 데이터를 매핑함
		pstmt.setString(1, mbean.getId());	
		pstmt.setString(2, mbean.getPassword1());	
		pstmt.setString(3, mbean.getEmail());	
		pstmt.setString(4, mbean.getTel());	
		pstmt.setString(5, mbean.getHobby());	
		pstmt.setString(6, mbean.getJob());	
		pstmt.setString(7, mbean.getAge());	
		pstmt.setString(8, mbean.getInfo());	
		
		
		//6. 오라클에서 쿼리를 실행하라는 소스코드
		
		pstmt.executeUpdate();
		//insert,update,delete시 사용 
		
		//7. 자원 반납
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	} */

%>
	오라클에  데이터 삽입 완료 
	
</body>
</html>