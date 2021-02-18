<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 
<!DOCTYPE html>
<html>
<body>
<form class = "container center_div" action="/blog/user?cmd=login" method="post">
  <div class="form-group ">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" name= "username" placeholder="Enter username">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name= "password" placeholder="Password">
  </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>