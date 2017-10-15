<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/include/header.jsp" %>
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
<body>+
<div align="center">
	<h2>문의글 작성</h2>
	<form name="form1" id="form1" method="post" action="/requestCreate">
		<div>
			분류
			<select name="request_Kind">
				<option value="1">구매관련</option>
				<option value="2">가입관련</option>
				<option value="3">기타문의</option>
			</select>
		</div>
		<div>			
			제목
			<input type="text" name="request_title" id="request_title" size="78" placeholder="제목을 입력해주세요.">			
		</div>
		<div>
			내용
			<textarea rows="4" cols="80" name="request_content" id="request_content" placeholder="내용을 입력해주세요."></textarea>
		</div>
		<div>
			아이디
			<input type="text" name="user_id" id="user_id" placeholder="아이디를 입력해주세요.">
		</div>
		<br>
		<div style="width:650px; text-align: center;">
        	<button type="button" id="btnSave">확인</button>
        	<button type="reset">취소</button>
    	</div>
    	<br>
	</form>
</div>		
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>