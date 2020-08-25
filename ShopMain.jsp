<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>ShopMainMainList</title>
<style>

</style>
</head>
<body>

<%
	String center = request.getParameter("center");

	if(center==null){
		center="Center.jsp";
	}
%>

<center>
<table width="1800">
	<tr align="center">
		<td align="center" width="1800"><jsp:include page="Top.jsp"/></td>
	</tr>
	
	<tr align="center">
		<td align="center" width="1800"><jsp:include page="<%=center %>"/></td>
	</tr>
	
	<tr align="center">
		<td align="center" width="1800"><jsp:include page="Bottom.jsp"/></td>
	</tr>
</table>
</center>
</body>
</html>