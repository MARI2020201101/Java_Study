<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Food</title>

<style>
input[type=submit]{
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

</head>
<body>
<h1>Delete Food Data</h1>
<ul><li><h3><a href = "http://localhost:8080/MealPlanner/">Back to Food List Page</a></h3></li></ul>
<form action="deleteFood" method = "post">
Enter FoodName : 
<input type = "text" name = "foodName">
<input type = "submit" value = "delete">
</form>

</body>
</html>