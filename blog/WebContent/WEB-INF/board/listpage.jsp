<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 
<!DOCTYPE html>
<html>
<body>
<div class = "container">
<c:forEach var="board" items="${boards}">
<div class="card w-90">
  <div class="card-body">
    <h5 class="card-title" >${board.title }</h5>
    <h6 class="card-subtitle" id="boardId" name="boardId" hidden="true">${board.boardId }</h6>
    <p class="card-text">${board.content }</p>
    <a href="${pageContext.request.contextPath}/board?cmd=detail" class="btn btn-primary">Read more Detail</a>
  </div>
 </div>
 <br>
</c:forEach>
<br>
<form >
<nav aria-label="pagination">
  <ul class="pagination justify-content-end">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1" value="${pagination.prevPage }">Previous</a>
    </li>
<c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.lastPage }">
    <li class="page-item" >
    <a class="page-link" href="/blog/board?cmd=listpage&pageNum=${pageNum }" id = "pagenNum" name = "pagenNum" >${pageNum}</a>
    </li>
</c:forEach>    
    <li class="page-item">
      <a class="page-link" href="#" >Next</a>
    </li>
  </ul>
</nav>
</form>
</div>
</body>
<script>
$("#pageNum").on("click",function(e){
	e.preventDefault();
	$("form").attr("action","/blog/board?cmd=listpage");
			.attr("method","get");
	
	this.submit();
});
</script>
</html>