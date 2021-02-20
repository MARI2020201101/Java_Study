<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="./WEB-INF/data/header.jsp" %> 

<!DOCTYPE html>
<html>
<body>
<form class = "container center_div" action="/blog/user?cmd=register" method="post">
  <div class="form-group ">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
  </div>
  <button type="button" class="btn btn-warning mb-3" id ="usernameCheck" >Check my Username</button>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password"placeholder="Password" required>
  </div>
  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control" id="email" name="email"placeholder="Enter email" required>
  </div>
  <div class="form-group">
    <label for="address">Address</label>
    <input type="text" class="form-control" id="address" name="address" placeholder="Enter address" required>
  </div>
  <button type="button" class="btn btn-warning mb-3" id ="addressSearch" onClick="goPopup()">Search my Address</button>
  <br>
  <button type="submit" class="btn btn-primary" id ="register">Submit</button>
</form>

</body>
<script>
var usernameCheck = false;

	$("#usernameCheck").on("click", function(e) {
		e.preventDefault();
		var username = $("#username").val();
		console.log(username);
		
		$.ajax({
			url : "/blog/user?cmd=usernameCheck",
			method : 'GET',
			data : {username:username},
			dataType : 'text',
			success : function(data) {
				console.log(data);
				if(data==0){
					usernameCheck = false;
					alert("This Username is already Exist....");
				}else{
					usernameCheck = true;
					alert("You can use this Username...!!");
				}
			}
		});

	});
	$("#register").on("click", function(e){
		e.preventDefault();
		if(usernameCheck===true){
			console.log(usernameCheck);
			$("form").submit();
		}else{
			alert("Please Check Username.....")
		}
	});
</script>
</html>