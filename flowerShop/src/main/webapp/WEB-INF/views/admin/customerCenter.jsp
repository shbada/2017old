<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/include/header.jsp" %>     
     <jsp:include page="${pageContext.request.contextPath }/top" />
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
     <%@ page session="true"%>        
     
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnSave").click(function() {
			var title = $("#request_title").val();
			var content = $("#request_content").val();
			var id = $("#user_id").val();						
			
			if(title == "") {
				alert("제목을 입력하세요.");
				document.form1.request_title.focus();
				return;
			}
			if(content == "") {
				alert("내용을 입력하세요.");
				document.form1.request_content.focus();
				return;
			}
			if(id == "") {
				alert("아이디를 입력하세요.");
				document.form1.user_id.focus();
				return;
			}
			document.form1.submit();
		});
	});
</script> 
</head>
<body>
<div class="container">	
	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>1:1 문 의</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form name="form1" id="form1" method="post" action="/requestCreate">
		<table class="table table-bordered">			
			<tr>
				<td>분류</td>
				<td>
					<select name="request_Kind">
						<option value="1">상품문의</option>
						<option value="2">가입문의</option>
						<option value="3">기타문의</option>
					</select>
				</td>				
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="request_title" id="request_title" size="78" class="form-control" placeholder="제목을 입력해주세요.">
				</td>				
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="4" cols="80" name="request_content" id="request_content" class="form-control" placeholder="내용을 입력해주세요."></textarea>
				</td>				
			</tr>					
			<tr>
				<td>아이디</td>
				<td>					
					<input type="text" name="user_id" id="user_id" class="form-control" placeholder="아이디를 입력해주세요.">
				</td>				
			</tr>
		</table>	
		<div align="center">			
			<!-- 로그인 해야지 작성가능 -->					
			<input type="button" id="btnSave" class="btn btn-primary" value="확인">								
        	<input type="reset" value="취소" class="btn btn-warning">
		</div>													        	        
	</form>
</div>		
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>