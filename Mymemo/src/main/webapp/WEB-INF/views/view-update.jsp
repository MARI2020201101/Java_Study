<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Memo</title>
</head>
<body>
<form action ="view.update" method="post">
<table width = "500" border = "1">
<tr>
<td width = "100">No.</td>
<td><input type = "text" name = "no" value ="${memo.no}" readonly="readonly"></td>
</tr>
<tr>
<td>Title</td>
<td><input type = "text" name = "title" value = "${memo.title}" ></td>
</tr>
<tr>
<td>Contents</td>
<td><textarea rows="20" cols="40" name = "contents">${memo.contents}</textarea></td>
</tr>
<tr>
<td></td>
<td colspan = "5" align="right"><input type = "submit" value = "Edit" ></td>
</tr>
</table>
</form>
</body>
</html>