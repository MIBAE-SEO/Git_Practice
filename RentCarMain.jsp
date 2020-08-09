<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<body>

<%

	String center = request.getParameter("center");

	//처음 실행시에는 center값이 넘어오지 않기때문에 null처리 
	if(center==null){
		center = "Center.jsp"; //디폴트 센터값 부여
	}
%>

<center>
<table width="1000">
<!-- top 부분  -->
	<tr height="100" align="center">
		<td align="center" width="1000"><jsp:include page="Top.jsp"/></td>
	</tr>
	
<!-- center 부분  -->
	<tr align="center">
		<td align="center" width="1000"><jsp:include page="<%=center %>"/></td>
	</tr>
	
<!-- bottom 부분  -->	
	<tr height="100" align="center">
		<td align="center" width="1000"><jsp:include page="Bottom.jsp"/></td>
	</tr>
</table>
</center>
</body>
</html>