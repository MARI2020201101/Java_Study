<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 

<!DOCTYPE html>
<html>
<body>
	<div class="container">
		<form action="/blog/board?cmd=update" method="post">
			
			<div class="input-group mb-3">
				<input type="text" name="title" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default" value="${board.title }">
			</div>
			<textarea id="summernote" class="form-control" id="content"
				name="content" >
				${board.content }
			</textarea>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			
			<input type="text" class="form-control" id="userId" name="userId"
				value="${board.userId }" hidden="true"> 
			<input type="text" class="form-control" id="boardId" name="boardId"
				value="${board.boardId }" hidden="true"> 
			<input type="text" class="form-control" id="pageNum" name="pageNum" 
				value="${pageNum }" hidden="true">
		</form>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true
		// set focus to editable area after initializing summernote
		});
	});
</script>
</html>