<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Food</title>
</head>
<body>
<h1>Delete Food Data</h1>
<h2><a href = "http://localhost:8080/MealPlanner/">Back to Food List Page</a></h2>
<form action="deleteFood" method = "post">
<input type = "text" name = "foodName">
<input type = "submit" value = "delete">
</form>

</body>
</html>