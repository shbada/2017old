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
					<h2>Name</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<h1>Login Success!!!</h1>
    		<h2>${user.username} 님 환영합니다. </h2>
    		<p></p>
    		<h3><a href="/home">home</a></h3>
    		<sec:authorize access="hasRole('ROLE_ADMIN')">
        		<h3><a href="javascript:alert('관리자군요.')";>관리자만 보임</a></h3>
    		</sec:authorize>
    		<h3><a href="/logout">logout</a></h3>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>