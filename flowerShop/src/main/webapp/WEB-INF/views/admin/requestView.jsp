<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/include/header.jsp" %>
    <jsp:include page="${pageContext.request.contextPath }/top" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>1:1 문의</title> 
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">		

	$("#btnUpdate").click(function() {
		var title = $("#request_title").val();
		var content = $("#request_content").val();
		var id = $("#user_id").val();
		if(title == "") {
			alert("제목을 입력하세요");
			document.form1.request_title.focus();
			return;
		}
		if(content == "") {
			alert("내용을 입력하세요");
			document.form1.request_content.focus();
			return;
		}
		if(id == "") {
			alert("아이디를 입력하세요");
			document.form1.user_id.focus();
			return;
		}
		document.form1.action = "${path}/admin/requestUpdate";
		document.form1.submit();
					
	});

	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		/* 삭제처리 */
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/requestDelete"); //action속성에 /requestDelete인곳이 대상
			formObj.submit();
		});
		
		/* 수정처리  */		
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/requestUpdate");				
			formObj.submit();
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
						<h2>1:1 문의내용</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form name="form1" method="post" role="form">
		<table class="table table-bordered">
			<tr>
				<td>작성일자</td>
				<td><fmt:formatDate value="${dto.regdate }" pattern="yyyy-MM-dd a HH:mm:ss"/></td>
			</tr>	
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="request_title" id="request_title" size="78" value="${dto.request_title }" placeholder="제목을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="4" cols="80" name="request_content" id="request_content" placeholder="내용을 입력해주세요.">${dto.request_content }</textarea>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="user_id" id="user_id" value="${dto.user_id }" readonly="readonly" placeholder="아이디를 입력해주세요.">
				</td>
			</tr>
		</table>									
		<div align="center">
			<input type="hidden" name="request_no" value="${dto.request_no }">		
			<input type="button" id="btnUpdate" class="btn btn-warning" value="수정">	
			<input type="button" id="btnDelete" class="btn btn-danger" value="삭제">
		</div>						
	</form>
</div>	
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>