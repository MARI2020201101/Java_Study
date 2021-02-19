<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 
<!DOCTYPE html>
<html>
<body>
<div class = "container">
<div class="card w-90">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="${pageContext.request.contextPath}/board?cmd=detail" class="btn btn-primary">Read more Detail</a>
  </div>
 </div>
</div>
</body>
</html>