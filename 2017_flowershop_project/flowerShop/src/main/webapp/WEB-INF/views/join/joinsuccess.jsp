<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/include/header.jsp" %>
    <jsp:include page="${pageContext.request.contextPath }/top" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>	
<body>
<div class="container">
	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>회원가입</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="center">
		<h3>회원가입이 완료 되었습니다</h3>
		<a href="${pageContext.request.contextPath }/login"><button class="btn btn-default">로그인</button></a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/"><button class="btn btn-default">메인으로가기</button></a>
	</div>			
</div>	
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>