<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function MessageList(){ 
	window.open("/messageList","쪽지함","width=650, height=600, top:100, left:100");
}
</script>
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
							<c:set var="user" value="${authUser }" scope="session" />
							<c:choose>
								<c:when test="${empty user}">
									<li><a href="${pageContext.request.contextPath }/join"><i
											class="fa fa-user"></i> 회원가입</a></li>
									<li><a href="${pageContext.request.contextPath }/login"><i
											class="fa fa-user"></i> 로그인</a></li>
<%-- 									<li><a href="${pageContext.request.contextPath }/admin"><i
											class="fa fa-user"></i>관리자 로그인</a></li> --%>
								</c:when>
								<c:when test="${not empty user && user.isadmin != 'ROLE_ADMIN'}">
									<li><a href="${pageContext.request.contextPath }/purchaseHistory"><i class="fa fa-user"></i> 주문내역</a></li>
									<li><a href="#"><i class="fa fa-heart"></i> 관심상품</a></li>
									<li><a href="${pageContext.request.contextPath }/cartList"><i class="fa fa-user"></i> 장바구니</a></li>
									<li><a href="${path }/customerCenter"><i class="fa fa-user"></i> 1:1문의하기</a></li>
								</c:when>
								<c:when test="${not empty user && user.isadmin == 'ROLE_ADMIN'}">
									<li><a href="${path }/allMemberList"><i class="fa fa-user"></i> 전체 회원 목록</a></li>
									<li><a href="#"><i class="fa fa-heart"></i> 구매 관리</a></li>
									<li><a href="${path }/one_to_one"><i class="fa fa-user"></i>1:1 문의목록</a></li>
								</c:when>
							</c:choose>
						</ul>
					</div>
				</div>
				
				<c:if test="${empty user}">
					<div class="col-md-4">
						<div class="header-right">
							<ul class="list-unstyled list-inline">
								<li class="dropdown dropdown-small">
								<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#">
									<span class="value">로그인이 필요합니다.</span><b class="caret"></b></a> 
								</li>
							</ul>
						</div>
					</div>
				</c:if>
				
				<c:if test="${not empty user}">
					<div class="col-md-4">
						<div class="header-right">
								<ul class="list-unstyled list-inline">
								<li class="dropdown dropdown-small">
								
								<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#">
								<span class="value">${user.user_point } 포인트  </span><b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="${pageContext.request.contextPath }/pointList">포인트 내역</a></li>							
									</ul>
								</li>
							</ul>
							<ul class="list-unstyled list-inline">
								<li class="dropdown dropdown-small">
								
								<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#">
									<span class="value">${user.user_id } 님  </span><b class="caret"></b></a> 
									<ul class="dropdown-menu">
										<li><a href="${pageContext.request.contextPath }/myInfo">회원정보수정</a></li>
										<li><a href="#">회원탈퇴</a></li>
										<li><a href="#">????</a></li>
									</ul>
								</li>
								<li><a href="${pageContext.request.contextPath }/logout">로그아웃</a></li>
							</ul>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="${pageContext.request.contextPath }/main">F<span>lowerShop</span></a>
						</h1>
					</div>
				</div>
				
				<div class="col-sm-6">
                    <div class="shopping-item">
                        <a href="#" onclick="javacscript:MessageList();">Message　　 
                        	<span class="product-count">${messageCount }</span>
                        </a>
                    </div>
                </div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">					
					<ul class="nav navbar-nav">
						<c:set var="user" value="${authUser }" scope="session" />
						<li class="active"><a href="main">Home</a></li>
						<li><a href="${path }/productList">Shop page</a></li> <!-- 상품 페이지 -->
						<li><a href="single-product.html">Single product</a></li>
						<li><a href="checkout.html">Checkout</a></li>
						<li><a href="#">Category</a></li>
						<li><a href="/productSaleList">SALE</a></li>
						<li><a href="list">자유게시판</a></li>		
						<c:choose>
							<c:when test="${not empty user && user.isadmin != 'ROLE_ADMIN'}">
								<li>
									<a href="${path }/one_to_one">고객센터</a>						
								</li>
							</c:when>
							<c:when test="${user.isadmin == 'ROLE_ADMIN' }">
								<li>
									<a href="${path }/customerCenter">고객센터</a>						
								</li>
							</c:when>
						</c:choose>																																	
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->