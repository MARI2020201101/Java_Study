<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="object.Food" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food List</title>
</head>
<body>
<h1>Food List</h1>
<h2><a href = "insert-food.jsp">Insert New Data</a></h2>
<h2><a href = "delete-food.jsp">Delete Data</a></h2>
	Search by FoodName : 
	<form action ="selectFood" method="post">
	<input type = "text" name = "foodName" >
	<input type = "submit" value ="search">
	</form>
	
	<form action="selectAllFood">
	<table>
	<tr>
	<td>FoodName </td>
	<td>│ portionSize │</td>
	<td>carb │</td>
	<td>protein │</td>
	<td>fat │</td>
	<td>natrium │</td>
	<td>sugar │</td>
	<td>calories│</td>
	</tr>
	<c:forEach var = "food" items = "${foods}">
	<tr>
	<td>${food.foodName} </td>
	<td>│ ${food.portionSize}</td>
	<td>${food.carb}</td>
	<td>${food.protein}</td>
	<td>${food.fat}</td>
	<td>${food.natrium}</td>
	<td>${food.sugar}</td>
	<td>${food.calories}</td>
	<br >
	</tr>
	</c:forEach>
	</table>
	</form>

	
</body>
</html>