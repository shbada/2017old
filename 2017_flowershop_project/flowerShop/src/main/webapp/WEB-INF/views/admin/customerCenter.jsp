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
		//버튼의 id값을 연동해서 클릭 시 수행
		$("#btnSave").click(function() {			
			var title = $("#request_title").val();
			var content = $("#request_content").val();
			var id = $("#user_id").val();						
			
			//각각 비어있을시 입력하도록 커서를 갔다둔다.
			if(title == "") {
				alert("제목을 입력하세요.");
				document.form1.request_title.focus(); //해당 폼으로 커서 이동
				return; //완료 시 다음으로 넘어감
			}
			if(content == "") {
				alert("내용을 입력하세요.");
				document.form1.request_content.focus();
				return;
			}
			if(id == "") {
				alert("로그인이 필요합니다.");
				location.href="/login";
				return;
			}
			document.form1.submit();
		});
	});
	
	//전송 버튼 누르면 해당 url로 이동(컨트롤러에서 처리)
	function goPage() {
		location.href="/mailForm";		
	}
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
	<form name="form1" id="form1" method="post" action="/requestCreate" enctype="multipart/form-data">
		<table class="table table-bordered">			
			<tr>
				<td>분류</td>
				<td>
					<select name="request_kind">
						<option value="1">상품문의</option>
						<option value="2">회원문의</option>
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
				<td>파일 첨부</td>
				<td>
					<!-- input type="file" 이라고 꼭 저어줘야 함 -->
        			<input type="file" class="form-control1" id="uploadFile" name="uploadFile" style="border:0px solid black;" class="form-control"/>
				</td>				
			</tr>		
			<c:set var="user" value="${authUser }" scope="session" />
			<c:choose>
				<c:when test="${empty user}">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="user_id" id="user_id" size="78" class="form-control" readonly/></td>				
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="user_id" id="user_id" size="78" class="form-control" value="${user.user_id }" readonly/></td>				
					</tr>
				</c:otherwise>
			</c:choose>																										     							
		</table>									
		<div align="center">
			<!-- id값은 제이쿼리 연동 -->
			<input type="button" id="btnSave" class="btn btn-primary btn btn-block" value="확인">								
        	<input type="reset" value="취소" class="btn btn-warning btn btn-block">
		</div>							        	      
	</form>
	<button onclick="goPage()" class="btn btn-success btn btn-block">메일 보내기</button>
</div>		
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>