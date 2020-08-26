<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/Tr/html4/loose.dtd">
<html>
<head>
<title>Bag List</title>
<style>


.td01{
	
	background-color: #2d3a4b;
}

.td02{
	color:white;
	text-align:center;
	background-color: #2d3a4b;
}

a{
	color:white;
}
p{
	color:white;
}

.p01{
	font-size: 40px;
	text-align: center;
	width="300";
	hegiht="160";
}

.a01{
	font-size: 20px;
	text-align: center;
	width="300";
	hegiht="160";
}
</style>
</head>
<body>

<center>
<table>
	<tr>
	<td class="td01" width="300" height="130" colspan="5" >
	<p class="p01"> List Of BACKPACK<br>
	<a class="a01" href="ShopMain.jsp?center=ShopList.jsp">Back To the LIST</a></p></td>
	</tr>
	<tr>
	<td><img src="./images/bag1.jpg" 
	onmouseover="this.src='./images/bag1_1.jpg';"
	onmouseout="this.src='./images/bag1.jpg';"></td>
	
	<td><img src="./images/bag2.jpg" 
	onmouseover="this.src='./images/bag2_1.jpg';"
	onmouseout="this.src='./images/bag2.jpg';"></td>
	
	<td><img src="./images/bag3.jpg" 
	onmouseover="this.src='./images/bag3_1.jpg';"
	onmouseout="this.src='./images/bag3.jpg';"></td>
	
	<td><img src="./images/bag4.jpg" 
	onmouseover="this.src='./images/bag4_1.jpg';"
	onmouseout="this.src='./images/bag4.jpg';"></td>
	
	<td><img src="./images/bag5.jpg" 
	onmouseover="this.src='./images/bag5_1.jpg';"
	onmouseout="this.src='./images/bag5.jpg';"></td>
	
	
	</tr>
<tr>
	<td class="td02" width="300" height="160">
	<div>수량 선택하기
	<select>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select> </div>
	<br>
	<a href="#"> Add to CART </a>
	</td>
	<td class="td02" width="300" height="160">
	<div>수량 선택하기
	<select>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select> </div>
	<br>
	<a href="#"> Add to CART </a>
	</td>
	<td class="td02" width="300" height="160">
	<div>수량 선택하기
	<select>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select> </div>
	<br>
	<a href="#"> Add to CART </a>
	</td>
	<td class="td02" width="300" height="160">
	<div>수량 선택하기
	<select>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select> </div>
	<br>
	<a href="#"> Add to CART </a>
	</td>
	<td class="td02" width="300" height="160">
	<div>수량 선택하기
	<select>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select> </div>
	<br>
	<a href="#"> Add to CART </a>
	</td>
	</tr>
</table>
</center>
</body>
</html>