<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Memo</title>
</head>
<body>
<h1>Welcome to MyMemo Page!</h1>
<form action="/">
<table width = "500" border = "1">
<tr>
<td width = "100">No</td>
<td>Title</td>
</tr>
<tr>
<c:forEach var = "memo" items = "${memos}">
<td>${memo.no}</td>
<td><a href = "view.contents?no=${memo.no}">${memo.title}</a></td>
</tr>
</c:forEach>
<tr>
<td colspan = "5" align = "right"><a href = "write">Write</a></td>
</tr>
</table>

</form>

</body>
</html>