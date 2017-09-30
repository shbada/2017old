<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
							<li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
							<li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
							<li><a href="cart.html"><i class="fa fa-user"></i> My
									Cart</a></li>
							<li><a href="checkout.html"><i class="fa fa-user"></i>
									Checkout</a></li>

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
									<li><a href="${pageContext.request.contextPath }/"><i
											class="fa fa-user"></i>${user.user_id } 님 </a></li>
									<li><a href="${pageContext.request.contextPath }/logout"><i
											class="fa fa-user"></i> 로그아웃</a></li>
								</c:when>
							</c:choose>

						</ul>
					</div>
				</div>

				<div class="col-md-4">
					<div class="header-right">
						<ul class="list-unstyled list-inline">
							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"><span class="key">currency
										:</span><span class="value">USD </span><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">USD</a></li>
									<li><a href="#">INR</a></li>
									<li><a href="#">GBP</a></li>
								</ul></li>

							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"><span class="key">language
										:</span><span class="value">English </span><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">English</a></li>
									<li><a href="#">French</a></li>
									<li><a href="#">German</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
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
							<a href="index.html">e<span>Electronics</span></a>
						</h1>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="cart.html">장바구니 - <!-- <span class="cart-amunt">$800</span>  -->
							<i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
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
						<li class="active"><a href="index.html">Home</a></li>
						<li><a href="${path }/productList">Shop page</a></li> <!-- 상품 페이지 -->
						<li><a href="single-product.html">Single product</a></li>
						<li><a href="cart.html">Cart</a></li>
						<li><a href="checkout.html">Checkout</a></li>
						<li><a href="#">Category</a></li>
						<li><a href="list">자유게시판</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->