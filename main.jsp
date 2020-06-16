<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1"> 
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>JSP 게시판 웹 사이트 </title>
</head>
<body> 
<% //로그인이 된 사람들은 그 로그인 정보를 담기.
	String userID=null;
	if(session.getAttribute("userID")!=null){
		userID = (String)session.getAttribute("userID");
	}
%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-togle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span> 
						<!-- 축소했을때 짝대기 3개 나오게 3개 씀! 확대하면 내비게이션 bar가 안생긴다! -->
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.jsp">메인</a></li>
					<li><a href="bbs.jsp">게시판</a></li>
				</ul>
				
				
				<!-- 로그인이 되어있지 않은 경우()-->
				<%
					if(userID==null){ 
						
				%>
				
				
				<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">접속하기<span class="caret"></span></a>

				
						<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
						</ul>
					</li>
				</ul>
				
				
				<!-- 로그인이 되어있는 경우()-->
				<% 
					}else{ 
						
				%>	
				<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">회원관리<span class="caret"></span></a>
				
								<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
								</ul>
					</li>
				</ul>
				<% 
					}
				%>
			</div>
	</nav>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<!-- 접속하기 dropdown버튼이 안먹혀서 이 주소로 바꾸었더니 됨!! -->
	<script src="js/bootstrap.js"></script>
</body>
</html>