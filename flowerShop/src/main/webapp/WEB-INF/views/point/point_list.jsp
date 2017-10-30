<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<jsp:include page="${pageContext.request.contextPath }/top" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">

var render = function(vo){
	  var html =
		  "<tr>"+
		  "<td>"+vo.buy_no+"</td>"+
		  "<td>"+vo.point_regdate+"</td>"+
		  "<td>"+vo.buy_addPoint+"</td>"+
		  "<td>"+vo.buy_usePoint+"</td>"+
		  "</tr>";
		  $("#list-select").append(html);
}

$.ajax({
	  type : 'POST',
	  url : '${pageContext.request.contextPath }/getpointlist', 
	  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	  dataType : 'json',
	  success : function(response){
		  console.log(JSON.stringify(response.data));
		  $.each(response.data, function(index, vo){
			 console.log("index " + index);
			  render(vo);
		  });
	  }
  }) 
</script>
</head>
<body>
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>포인트 내역</h2>
				</div>
			</div>
		</div>
	</div>
</div>
	<br>
	<!-- 부트스트랩으로 디자인 개선 -->
<div class="single-product-area">
     <div class="container">
         <div class="row">
			<table id="list-select" border="1" class="shop_table cart">
				<tr >
					<!-- 체크박스 추가하여 체크에 따라 회원 강제 삭제 -->
					<th>구매번호</th>
					<th>적립 날짜</th>
					<th>적립 포인트</th>
					<th>사용한 포인트</th>
				</tr>
			</table>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>