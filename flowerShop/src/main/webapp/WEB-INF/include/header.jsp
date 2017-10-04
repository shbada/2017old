<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>꽃&디퓨저 쇼핑몰</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="../../resources/css/owl.carousel.css">
<link rel="stylesheet" href="../../resources/style.css">
<link rel="stylesheet" href="../../resources/css/responsive.css">
<link rel="stylesheet" href="../../resources/css/seohae.css">

<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="../../resources/js/owl.carousel.min.js"></script>
<script src="../../resources/js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="../../resources/js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="../../resources/js/main.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

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
									<li><a href="${pageContext.request.contextPath }/admin"><i
											class="fa fa-user"></i>관리자 로그인</a></li>
								</c:when>
								<c:when test="${not empty user}">
									<li><a href="#"><i class="fa fa-user"></i> 주문내역</a></li>
									<li><a href="#"><i class="fa fa-heart"></i> 관심상품</a></li>
									<li><a href="${pageContext.request.contextPath }/cartList"><i class="fa fa-user"></i> 장바구니</a></li>
									<li><a href="checkout.html"><i class="fa fa-user"></i> 1:1문의하기</a></li>
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
<<<<<<< HEAD
							<a href="main">e<span>Electronics</span></a>
=======
							<a href="${pageContext.request.contextPath }/main">F<span>lowerShop</span></a>
>>>>>>> origin/master
						</h1>
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
						<li class="active"><a href="main">Home</a></li>
						<li><a href="${path }/productList">Shop page</a></li> <!-- 상품 페이지 -->
						<li><a href="single-product.html">Single product</a></li>
						<li><a href="checkout.html">Checkout</a></li>
						<li><a href="#">Category</a></li>
						<li><a href="#">SALE</a></li>
						<li><a href="list">자유게시판</a></li>
						<li><a href="#">고객센터</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->