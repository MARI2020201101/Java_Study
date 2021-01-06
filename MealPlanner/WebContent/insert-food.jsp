<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="object.Food" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Food</title>

<style>
td{width="100"}
input[type=submit]{
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

</head>
<body>
<h1>Insert New Food Data</h1>
<ul><li><h3><a href = "http://localhost:8080/MealPlanner/">Back to Food List Page</a></h3></li></ul>
<form action = "insertFood" method = "post">
<table>
<tr>
<td>FoodName : </td>
<td><input type ="text" name = "foodName"></td>
<tr/>
<tr><td>portionSize : </td><td><input type ="text" name = "portionSize"></td><tr/>
<tr><td>carb : </td><td><input type ="text" name = "carb"></td><tr/>
<tr><td>protein : </td><td><input type ="text" name = "protein"></td><tr/>
<tr><td>fat : </td><td><input type ="text" name = "fat"></td><tr/>
<tr><td>natrium : </td><td><input type ="text" name = "natrium"></td><tr/>
<tr><td>sugar : </td><td><input type ="text" name = "sugar"></td><tr/>
<tr><td>calories : </td><td><input type ="text" name = "calories"></td><tr/>
</table>
<br>
<input type ="submit" value = "submit" background-color = "#4CAF50">
</form>
</body>
</html>