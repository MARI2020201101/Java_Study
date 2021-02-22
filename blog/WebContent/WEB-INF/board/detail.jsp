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
		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					INFO</h4>

				<ul class="list-group mb-3">
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Count</h6>
						</div> <span class="text-muted">${board.count }</span>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Date</h6>
						</div> <span class="text-muted">${board.writeDate}</span>
					</li>
										<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Writer</h6>
						</div> <span class="text-muted">${board.username}</span>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Delete</h6>
						</div> <span class="text-muted"><button type="button"
								class="btn btn-danger mb-3 ">GO</button></span>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Edit</h6>
						</div> <span class="text-muted"><button type="button"
								class="btn btn-warning mb-3">GO</button></span>
					</li>
				</ul>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Detail View</h4>
				<div>
					<div class="input-group mb-3">
						<input type="text" name="title" class="form-control"
							aria-label="Sizing example input" readonly: BG white
							aria-describedby="inputGroup-sizing-default"
							value="${board.title }">
					</div>
					<div class="form-group shadow-textarea">
						<div class="form-group">
							<label for="comment"></label>
							<textarea class="form-control" rows="5" id="comment" readonly: BG
								white >${board.content }</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<input type="text" class="form-control" id="userId" name="userId"
		hidden="true" value=${board.userId }>
	<input type="text" class="form-control" id="userId" name="userId"
		hidden="true" value=${board.boardId }>





</body>

</html>