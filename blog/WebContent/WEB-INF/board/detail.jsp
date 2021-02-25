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
<a class="btn btn-warning" href="/blog/board?cmd=updateForm&boardId=${board.boardId }&pageNum=${pageNum}&userId=${board.userId }">Edit</a>
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
		<br /><br/>
		<hr />
	<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2">
						<b>COMMENT</b>
					</div>
					<div class="panel-body">
					<div>
						<textarea id="comment" class="form-control" placeholder="write a comment..." rows="2"></textarea>
						<br>
						<button id="reply-save" class="btn btn-primary btn-sm" style="float: right">Submit</button>	
					</div>
					
						<ul id="reply__list" class="media-list">
								<li class="media">
									<div class="media-body">
										<strong class="text-primary"></strong>
									</div>
								</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="text" class="form-control" id="loginUserId" name="loginUserId"
		hidden="true" value=${sessionScope.loginUser.userId }>
	<input type="text" class="form-control" id="userId" name="userId"
		hidden="true" value=${board.userId }>
	<input type="text" class="form-control" id="boardId" name="boardId"
		hidden="true" value=${board.boardId }>
			<input type="text" class="form-control" id="pageNum" name="pageNum"
		hidden="true" value=${pageNum }>
		</div>
</body>
<script>
var loginUserId =$("#loginUserId").val();
var comment =$("#comment").val();
var boardId =$("#boardId").val();

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
	
var reply = {
		loginUserId : loginUserId,
		boardId : boardId,
		comment : comment
	};
	
	$("#reply-save").on("click",function(){
		console.log(reply);
		$.ajax({
			type:"post",
			url:"/blog/reply?cmd=write",
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			dataType: "json"	
		}).done({
			function(result){
				
			}
		});
	});

</script>
</html>