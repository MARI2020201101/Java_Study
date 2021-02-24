<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!DOCTYPE html>
<html>
<body>
	<div class="container">
	<br/>
<a class="btn btn-info" href="/blog/board?cmd=list&pageNum=${pageNum}">List</a>
<c:if test="${board.userId == sessionScope.loginUser.userId}">
<a class="btn btn-danger btn-delete" >Delete</a>
<a class="btn btn-warning" href="/blog/board?cmd=updateForm&boardId=${board.boardId }&pageNum=${pageNum}">Edit</a>
</c:if>


		<br /><br/>
		<h3 class="m-2">
			<b>${board.title}</b>
		</h3>
		<h6 class="m-2 " style="color: #A9A9A9">
			&nbsp;WRITER : <i>${board.username}</i> &nbsp; READCOUNT : <i>${board.count}</i>&nbsp;
			WRITEDATE : <i>${board.writeDate}</i>
		</h6>
		<hr />
		<div class="form-group">
			<div class="m-2">${board.content}</div>
		</div>
	</div>
	<input type="text" class="form-control" id="userId" name="userId"
		hidden="true" value=${board.userId }>
	<input type="text" class="form-control" id="boardId" name="boardId"
		hidden="true" value=${board.boardId }>
			<input type="text" class="form-control" id="pageNum" name="pageNum"
		hidden="true" value=${pageNum }>
</body>
<script>
var boardId =$("#boardId").val();
console.log(boardId);
$(".btn-delete").on("click",function(e){
	e.preventDefault();
	$.ajax({
		type:"post",
		url:"/blog/board?cmd=delete&boardId=" + boardId,
		contentType: 'application/x-www-form-urlencoded; charset=utf-8',
		success : function(data) {
					console.log("data :" + data);
					if(data==1){
						alert("Delete Succeess");
						window.location.href="/blog/board?cmd=list";
					}else{
						alert("Delete Failed");
						window.location.href="/blog/board?cmd=list";
					}
	}
});
});
</script>
</html>