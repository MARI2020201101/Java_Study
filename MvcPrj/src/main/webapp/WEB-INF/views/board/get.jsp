<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<%@ include file = "../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Read Page</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       		<div class="form-group">
                             	<label>Bno</label>
                                <input class="form-control" name = "bno" readonly ="readonly" value ='<c:out value="${board.bno }"/>'>
                             </div>
 
							<div class="form-group">
                             	<label>Title</label>
                                <input class="form-control" name = "title" readonly ="readonly" value ='<c:out value="${board.title }"/>'>
                             </div>
                             
                             <div class="form-group">
                             	<label>Content</label>
                                <textarea rows="5" cols="50" name = "content" class="form-control" readonly ="readonly"><c:out value="${board.content }"/></textarea>
                             </div>
                             
                             <div class="form-group">
                             	<label>Writer</label>
                                <input class="form-control" name = "writer" readonly ="readonly" value ='<c:out value="${board.writer }"/>'>
                             </div>
                           <form id = 'actionForm' action ="list" method= "get">
                           <input type ='hidden' name = 'pageNum' value = '${cri.pageNum }'>
                           <input type ='hidden' name = 'amount' value = '${cri.amount }'>
                           <input type ='hidden' name = 'bno' value = '${board.bno}'>
                           <input type ='hidden' name = 'type' value = '${cri.type}'>
                           <input type ='hidden' name = 'keyword' value = '${cri.keyword}'>
                           </form>
                             <button type="button" class="btn btn-default listBtn"><a href ="list">List</button>
                             <button type="button" class="btn btn-default modBtn"><a href ='modify?bno=<c:out value="${board.bno }"/>'>Modify</a></button>
				           <script>
				           var actionForm =  $("#actionForm");
				           
				           $(".listBtn").click(function(e){
				        	  e.preventDefault(); 
				        	  actionForm.find("input[name = 'bno']").remove();
				        	  actionForm.submit();
				           });
				           $(".modBtn").click(function(e){
					        	  e.preventDefault(); 
					        	  actionForm.attr("action","modify");
					        	  actionForm.submit();
					           });
				           
				           </script>                     
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

        <!-- /#page-wrapper -->
<%@ include file = "../includes/footer.jsp" %>