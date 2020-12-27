<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
<form action="memberControl" method="post">
<input type = "text" name = "userID">
<input type = "text" name = "userPassword">
<input type = "text" name = "userName">
<input type = "text" name = "userAge">
<input type = "submit" value = "submit">
<div>
${memberInfo}
</div>
</form>

</body>
</html>