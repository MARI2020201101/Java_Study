<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Memo</title>

</head>
<body>
<h1>Let's see Contents!</h1>
<form action ="/view.contents">
<table width = "500" border = "1">
<tr>
<td width = "100">No.</td>
<td>${memo.no}</td>
</tr>
<tr>
<td>Title</td>
<td>${memo.title}</td>
</tr>
<tr>
<td>Contents</td>
<td>${memo.contents}</td>
</tr>
<tr>
<td></td>
<td colspan = "5" align = "right"><a href = "view.update?no=${memo.no }">Edit</a>&emsp;
<a onclick="return confirm('Confirm Delete?')" href="delete?no=${memo.no}" class="btn btn-primary">Delete</a>&emsp;
<a href = "/mymemo/">Back to List</a></td>
</tr>
</table>
</form>
</body>
</html>