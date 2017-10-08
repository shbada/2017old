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
					<h2>SUCCESS!</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<h4 class="FontCenter">회원님의 이메일로 메일이 발송되었습니다.</h4><br /><br />
			<input type="button" class="btn btn-lg btn-danger btn-block" value="로그인" onclick="location.href='${pageContext.request.contextPath }/login';">
			<input type="button" class="btn btn-lg btn-primary btn-block" value="메인으로 가기" onclick="location.href='${pageContext.request.contextPath }/main';">
		    <p></p>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>