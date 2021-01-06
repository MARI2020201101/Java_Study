<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="object.Food" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food List</title>
<style>
table{width="100" height="50"}
</style>

</head>
<body>
<h1>Food List</h1>
<ul>
<li><h3><a href = "insert-food.jsp">Insert New Data</a></h3></li>
<li><h3><a href = "delete-food.jsp">Delete Data</a></h3></li>
</ul>

	<form action="selectAllFood">
	──────────────────────────────────────────────────────────────────
	<table>
	<tr>
	<td width="200" height="50">FoodName </td>
	<td width="120" height="50">│ portionSize </td>
	<td width="120" height="50">│ carb </td>
	<td width="120" height="50">│ protein </td>
	<td width="120" height="50">│ fat </td>
	<td width="120" height="50">│ natrium </td>
	<td width="120" height="50">│ sugar </td>
	<td width="120" height="50">│ calories</td>
	</tr>
	
	<c:forEach var = "food" items = "${foods}">
	<tr>
	<td>${food.foodName} </td>
	<td>│ ${food.portionSize}</td>
	<td>│ ${food.carb}</td>
	<td>│ ${food.protein}</td>
	<td>│ ${food.fat}</td>
	<td>│ ${food.natrium}</td>
	<td>│ ${food.sugar}</td>
	<td>│ ${food.calories}<td>
	</tr>
	</c:forEach>
	</table>
	</form>
	──────────────────────────────────────────────────────────────────
	
</body>
</html>