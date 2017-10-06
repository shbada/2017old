<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">

</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>FIND ID</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<header class="text-left createHeader">비밀번호 찾기&nbsp;
            	<span class="subCreateHeader">가입하신 회원님의 아이디와 이메일을 입력해주세요</span>
            </header>
			<form action="${pageContext.request.contextPath}/mailSendingId" method="post">
      			<input type="text" name="user_email" placeholder="이메일을 입력해주세요." class="form-control" ><hr>  
      			<input type="submit" value="아이디 찾기" class="btn btn-lg btn-primary btn-block">
  			</form><br>
  			${msg }
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>