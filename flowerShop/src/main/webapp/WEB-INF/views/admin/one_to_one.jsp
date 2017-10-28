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
 <title></title> 
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var result = '${msg}';
	if(result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
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
						<h2>1:1 문의목록</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<table class="table table-striped">
		<tr>
			<th>번호</th>			
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>
			<th>분류</th>
		</tr>
		
		<!-- 회원이 쓴것만 보여주기 -->
		<c:forEach var="board" items="${one_to_one }">
			<c:set var="user" value="${authUser }" scope="session" />
			<c:choose>
				<c:when test="${user.user_id == board.user_id}">
					<tr>
						<td>${board.request_no }</td>
						<td><a href="/requestView?request_no=${board.request_no}">${board.request_title }</a></td>				
						<td>${board.request_content }</td>
						<td>
							<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${board.request_kind == '1'}">
									상품문의
								</c:when>
								<c:when test="${board.request_kind == '2'}">
									회원문의
								</c:when>
								<c:when test="${board.request_kind == '3'}">
									기타문의
								</c:when>						
							</c:choose>									
						</td>
					</tr>
				</c:when>			
				<c:when test="${user.isadmin  == 'ROLE_ADMIN'}">
					<tr>
						<td>${board.request_no }</td>
						<td><a href="/requestView?request_no=${board.request_no}">${board.request_title }</a></td>				
						<td>${board.request_content }</td>
						<td>
							<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${board.request_kind == '1'}">
									상품문의
								</c:when>
								<c:when test="${board.request_kind == '2'}">
									회원문의
								</c:when>
								<c:when test="${board.request_kind == '3'}">
									기타문의
								</c:when>						
							</c:choose>									
						</td>
					</tr>
				</c:when>				
			</c:choose>		
		</c:forEach>
	</table>					
</div>	
<br>
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>