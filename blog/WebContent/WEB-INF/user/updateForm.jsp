<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 
<!DOCTYPE html>
<html>
<body>
<form class = "container center_div" action="/blog/user?cmd=update" method="post">
  <div class="form-group ">
  <input type="text" class="form-control" id="userId" name="userId" value="${loginUser.userId }" hidden="true">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" name="username" value="${loginUser.username }" required>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" required>
  </div>
  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control" id="email" name="email" value="${loginUser.email }" required>
  </div>
  <div class="form-group">
    <label for="address">Address</label>
    <input type="text" class="form-control" id="address" name="address" value="${loginUser.address}" required>
  </div>
  <br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>