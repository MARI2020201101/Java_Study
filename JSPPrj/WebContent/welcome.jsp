<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<%String id = (String)session.getAttribute("id"); %>
Welcome <%=id %>
<br/>
<a href = "http://localhost/video.jsp">Watch Video</a>
<br/>
<form action="logoutControl" method ="post">
<input type ="submit" value ="logout"/>
</form>
</body>
</html>