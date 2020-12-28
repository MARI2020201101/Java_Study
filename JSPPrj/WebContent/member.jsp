<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    
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
<c:forEach var = "member" items = "${members}" >
${member}
</c:forEach>
</div>
</form>

</body>
</html>