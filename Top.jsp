<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>Top</title>
<link href="https://fonts.googleapis.com/css2?family=Encode+Sans+Semi+Expanded:wght@300&family=Poiret+One&display=swap" rel="stylesheet">
<style>	


*{margin: 0px; padding: 0px;}
ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/
a{text-decoration: none;} /* 링크에 밑줄 같은거 제거*/
 
header{
    width: 1800px; /*메인 이미지의 너비 사이즈와 같음*/
    height: 130px;
    background-color: #2d3a4b;
    position: relative;
}
 
/* 제목영역안에 있는 메인 로고 이미지 위치 지정 */
#logo{
	font-family: 'Poiret One', cursive;
    position: absolute;
    left: 100px;
    font-color: white;
    font-size:100px;
}

#logo a{
color: white;
}
 
#top_menu{
    position: absolute;
    top: 20px;
    right: 100px;
    color: white;
}
 
#top_menu a{
font-family:'Encode Sans Semi Expanded', sans-serif;
color: white;
}
 

nav{
    position: absolute;
    bottom: 25px;
    left: 550px;
    font-size: 20px;
}
 
nav li{
    display: inline;
    margin-right:150px;
    padding:10px;
}
 
nav li a{
font-family:'Encode Sans Semi Expanded', sans-serif;
color: white;
}
 
 
#page{width: 1800px; 
margin: 0px auto;}


</style> 




</head>
<body>
<%
	String id = (String)session.getAttribute("id");

	if(id ==null){
		id="GUEST";
	}
	
	String logout = request.getParameter("logout");

	if(logout!=null){
	session.setAttribute("id", null);
	session.setMaxInactiveInterval(0);
	}
	
%>


			 <div id="page"> 
 
        <header>
            <div id="logo">
                <a href="ShopMain.jsp">fitzroy</a>
            </div>
 
            <div id="top_menu">
                <a href="ShopMain.jsp">HOME</a> | 
                <a href="ShopMain.jsp?center=ShopNotice.jsp">NOTICE</a> |
                <a href="ShopMain.jsp?center=MemberLogin.jsp">LOGIN</a> |
                <a href="ShopMain.jsp?center=MemberJoin.jsp">JOIN</a> &nbsp;&nbsp;&nbsp;&nbsp;
                <%=id %>님 
                <% 
                if(id.equals("GUEST")){ %>
                <button onclick="location.href='ShopMain.jsp?center=MemberLogin.jsp'">로그인</button>
                <%}else if(id!=null){
                %>
                 <button onclick="location.href='MemberLogout.jsp?logout=1'">로그아웃</button>
                <%} %> 
            </div>
 
            <nav>
                <ul>
                    <li><a href="ShopMain.jsp?center=ShopList.jsp">SHOP</a></li>
                    <li><a href="ShopMain.jsp?center=ShopCart.jsp">CART</a></li>
                    <li><a href="ShopMain.jsp?center=ShopBoard.jsp">BOARD</a></li>
                    <li><a href="ShopMain.jsp?center=ShopContact.jsp">CONTACT</a></li>
                    <li><a href="ShopMain.jsp?center=ShopAbout.jsp">ABOUT</a></li>
                    
                </ul>
            </nav>
 
        </header>
 
   
 	</div>
 
</body>
</html>