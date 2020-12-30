<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="object.Food" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Food</title>
</head>
<body>
<h1>Insert New Food Data</h1>
<h2><a href = "http://localhost:8080/MealPlanner/">Back to Food List Page</a></h2>
<form action = "insertFood" method = "post">
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
</table>
<input type ="text" name = "foodName">
<input type ="text" name = "portionSize">
<input type ="text" name = "carb">
<input type ="text" name = "protein">
<input type ="text" name = "fat">
<input type ="text" name = "natrium">
<input type ="text" name = "sugar">
<input type ="text" name = "calories">
<input type ="submit" value = "submit">
</form>
</body>
</html>