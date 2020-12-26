<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video</title>
</head>
<body>
<%session.getAttribute("user"); %>
<iframe width="560" height="315" 
src="https://www.youtube.com/embed/iMMEbhU80-A" 
frameborder="0" 
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
allowfullscreen></iframe>
</body>
</html>