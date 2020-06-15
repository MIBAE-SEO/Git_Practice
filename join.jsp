<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1"> 
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>JSP 게시판 웹 사이트 </title>
</head>
<body>
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
					<li><a href="main.jsp">메인</a></li>
					<li><a href="bbs.jsp">게시판</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">접속하기<span class="caret"></span></a>
				<!--  aria-haspopup 해당요소가 하위 메뉴를 포함하고 있는지? 팝업이 가능한지? true:팝업 o false:팝업x
					  aria-expanded (특정영역 확장 축소) true : 확장 false : 축소  -->
				
								<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
								</ul>
					</li>
				</ul>
			</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
		<div class="jumbotron" style="padding-top:20px;">
			<form method="post" action="joinAction.jsp">
				<h3 style="text-align : center;">회원가입 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" 
						placeholder="아이디" name="userID"
						maxlength="20"> <!--  placeholder : 입력하지 않았을 때 나오는 내용 -->
					</div>
					<div class="form-group">
						<input type="password" class="form-control" 
						placeholder="비밀번호" name="userPassword"
						maxlength="20">
					</div>
	<!-- DB와 맞게 항목을 만들어 줘야함 -->
					<div class="form-group">
						<input type="text" class="form-control" 
						placeholder="이름" name="userName"
						maxlength="20">
					</div>
					<div class="form-group" style="text-align:center;">
						<div class="btn-grout" data-toggle="buttons">
						<label class="btn btn-primary active"> <!-- 기본선택 -->
							<input type="radio" name="userGender" autocomplete="off" value="남자" checked>남자
						</label>
						<label class="btn btn-primary "> 
							<input type="radio" name="userGender" autocomplete="off" value="여자" checked>여자
						</label>
						<div class="form-group">
						<input type="email" class="form-control" 
						placeholder="이메일" name="userEamil"
						maxlength="20">
					</div>
						</div>
					</div>
					<input type="submit" class="btn btn-primary form-control" value="회원가입">
			</form>
		</div>
	</div>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<!-- 접속하기 dropdown버튼이 안먹혀서 이 주소로 바꾸었더니 됨!! -->
	<script src="js/bootstrap.js"></script>
	

	
</body>
</html>