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
					<c:if test="${not empty sessionScope.loginUser.userId }">
					<div>
						<form >
						<textarea id="content" class="form-control" placeholder="write a comment..." rows="2"></textarea>
						</form>
						<button id="reply-save" onClick="saveReply()" class="btn btn-primary btn-sm" style="float: right">Submit</button>	
					</div>
					<br><br>
					</c:if>
						<ul id="replyList" class="list-group">
						  	<c:forEach var = "reply" items ="${replyList }">
								<li class="list-group-item">
									<div class="media-body">
										<strong class="text-primary">${reply.username }</strong>
										<div class="mb-1">
										${reply.content }
										<c:if test="${sessionScope.loginUser.userId == reply.userId}">
										<i class="bi bi-trash" onClick="deleteReply(${reply.replyId })" style="float: right"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  										<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  										<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
										</svg></i>
										</c:if>
										</div>
									</div>
								</li>
								<br>
								
							</c:forEach>
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
$(".btn-delete").on("click",function(e){
	e.preventDefault();
	var boardId =$("#boardId").val();
	$.ajax({
		type:"post",
		url:"/blog/board?cmd=delete&boardId=" + boardId,
		async:false,
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

function saveReply(){
	
	var userId =$("#loginUserId").val();
	var content =$("#content").val();
	var boardId =$("#boardId").val();
	var reply = {
			userId : userId,
			boardId : boardId,
			content : content
		};
	$.ajax({
		type:"post",
		url:"/blog/reply?cmd=write",
		data: JSON.stringify(reply),
		contentType: "application/json; charset=utf-8",
		dataType: "json"	
	}).done(
		function(result){
				$("#content").val('');			
				addReply(result);
		});
};

function addReply(reply){

	var newReply = "";
	
	newReply +=`<li class="list-group-item"><div class="media-body">`;
	newReply +='<strong class="text-primary">' + reply.username +'</strong>';
	newReply +=	'<div class="mb-1">' + reply.content ;
	newReply +='<i class="bi bi-trash" onClick="deleteReply(' + reply.replyId + ')" style="float: right"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">';
	newReply +=`<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>`;
	newReply +=`<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>`;
	newReply +=`</svg></i></div></div></li><br>`;
	
	$("#replyList").prepend(newReply);

};

function deleteReply(replyId){
	console.log(replyId);
	$.ajax({
		type:'post',
		url:'/blog/reply?cmd=delete',
		data: {replyId:replyId},
		contentType:'application/x-www-form-urlencoded; charset=UTF-8'
		
	}).done(function(result){
		if(result==1){
			location.reload();
		}else{
			alert("Delete failed....");
		}
	}); 
}; 
</script>
</html>