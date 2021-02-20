<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../data/header.jsp" %> 
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!DOCTYPE html>
<html>
<body>
<div class = "container">
<form action ="/blog/board?cmd=write" method="post">
<input type="text" class="form-control" id="userId" name="userId"  hidden="true">
	<div class="input-group mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-default" >Title</span>
	  <input type="text" name="title" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
	  
	</div>
		<div id="summernote" name="content" >
	</div>
	<br>
	  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

</body>
<script type="text/javascript">

$(document).ready(function() {
  $('#summernote').summernote({
	  height: 300,                 // set editor height
	  minHeight: null,             // set minimum height of editor
	  maxHeight: null,             // set maximum height of editor
	  focus: true                  // set focus to editable area after initializing summernote
	});
});
</script>
</html>