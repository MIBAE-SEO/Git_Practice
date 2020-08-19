<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>Board</title>
<link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300;600&display=swap" rel="stylesheet">
<style>


body{
 	 
		background: url(images/boardmain.jpg) no-repeat center center fixed; 
  		webkit-background-size: cover;
  		moz-background-size: cover;
  		o-background-size: cover;
  		background-size: cover;
	}  
	
	
	.wrap{
  	position:absolute;
  	top:0;right:0;bottom:0;left:0;
  	display:-webkit-box;
  	display:-moz-box;
 	display:-ms-flexbox;
  	display:-webkit-flex;
  	display:flex;

  	align-items:center;
  	justify-content:center;
  	-webkit-align-items:center;
  	-webkit-justify-content:center;

  	-webkit-box-pack:center;
  	-webkit-box-align:center;
  	-moz-box-pack:center;
  	-moz-box-align:center;
  	-ms-box-pack:center;
  	-ms-box-align:center;
	}

	.wrap .content{
	background:none;
	}
	
	a{
		font-family: 'Comfortaa', cursive;
		font-size:200px;
		font-color:black;
		text-decoration: none;

	}
	
	a:visited { color: black; text-decoration: none;}
 	a:hover { color: white; text-decoration: none;}

</style>
</head>
<body>


<div class="wrap">
  <span class="content" style="font-size:250pt;"><a href="BoardList.jsp">BOARD</a>
  </span>
</div>


</body>
</html>