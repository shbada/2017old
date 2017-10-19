<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<jsp:include page="${pageContext.request.contextPath }/top" />
<link href='/resources/css/buy.css' rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">

function returnCart() {
	if (confirm("장바구니로 돌아가시겠습니까? \n \"확인\" 을 누르시면 \n\"배송정보\" 는 사라 집니다.") == true) {
		   document.location.href="/cartList";         
		} 
}

function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
		roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
		detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
		buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
	document.form.buy_addr2.value = roadAddrPart1;
	document.form.buy_addr3.value = roadAddrPart2;
	document.form.buy_addr4.value = addrDetail;
	document.form.buy_addr1.value = zipNo;
}

function goPopup() {
	var pop = window.open(
			"${pageContext.request.contextPath }/join/postPup", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function checkPayment() {
	var totalCartNo = "";  
	var cart_no = null;
	
	$(":text[name=cart_no]").each(function(i){
		 cart_no = $(this).val(); 
		 totalCartNo += cart_no+","; 
	 });
	if (confirm("결제 하시겠습니까?") == true) {
		document.form.totalCartNo.value = totalCartNo;
		document.form.method="POST";   		
		document.form.action="<c:url value='/payment' />";   		
		document.form.submit();
	}
	return;
}
</script>

<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Buy product</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<form name="form1" method="post" action="#">
				<input type="hidden" name="user_id" value="${map.user_id }">
				<input type="hidden" name="allSum" value="${map.allSum}">
				<h2 class="sidebar-title">Cart List</h2>
				<table cellspacing="0" class="shop_table cart">
					<thead>
						<tr>
							<th class="product-subtotal">번호</th>
							<th class="product-remove">상품명</th>
							<th class="product-thumbnail">상품</th>
							<th class="product-price">수량</th>
							<th class="product-quantity">상품 가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${map.list}" varStatus="i">
							<tr class="cart_item">
								<td class="product-remove">
									<input type="text" size="4" style="border: 0;" name="cart_no" value="${row.cart_no}" readonly="readonly"/> 
								</td>
								<td class="product-thumbnail">
									${row.product_name }
								</td>
								<td class="product-name">
									<img src="${pageContext.request.contextPath }/img/${row.product_url}" width="145" height="145">
								</td>
								<td class="product-quantity">
									<div class="quantity buttons_added">
										<input type="number" name="product_amount" size="1" class="input-text qty text" style="border: 0; text-align: center;" title="Qty" value="${row.product_amount}" readonly="readonly"> 
										<input type="hidden" name="product_no" value="${row.product_no}">
									</div>
								</td>
								<td class="product-subtotal">
									<input type="number" name="product_price" size="5" style="border: 0;text-align: center;" value="${row.product_price }" readonly="readonly"/> 
								</td>				
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h2 class="sidebar-title">Total Price</h2>
				<span class="subCreateHeader">5만원 미만의 금액은 배송비 2500원입니다.</span>
				<table cellspacing="0" class="shop_table cart">
					<tbody>
						<tr class="cart-subtotal">
							<th>주문 금액</th>
							<td><span class="amount">${map.sumMoney }</span></td>
						</tr>
						<c:if test="${map.sumMoney == 0}">
							<tr class="shipping">
								<th>배송비</th>
								<td>0</td>
							</tr>

							<tr class="order-total">
								<th>총 결제금액</th>
								<td>
									<strong><span class="amount">0</span></strong>
								</td>
							</tr>
						</c:if>

						<c:if test="${map.sumMoney != 0}">
							<tr class="shipping">
								<th>배송비</th>
								<td>${map.fee }</td>
							</tr>

							<tr class="order-total">
								<th>총 결제금액</th>
								<td><strong><span class="amount">${map.allSum }</span></strong>
								</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</form>
			<hr />
			<h2 class="sidebar-title">배송정보 입력</h2>
			<form name="form" id="form" action="#" method="post">
				<input type="hidden" name="totalCartNo" value="1">
				<input type="hidden" name="user_id" value="${map.user_id}">
				<input type="hidden" name="buy_totalPrice" value="${map.allSum}">
				<label for="user_id"></label> <input type="text" name="buy_name"id="buy_name" style="width: 100%" placeholder="받는사람 이름" /> <spanid="duplicateResult"></span><br /> <label for="user_name"></label>
				<input type="text" name="buy_phone" id="buy_phone"style="width: 100%" placeholder="받는사람 연락처( - 포함하여 입력)" /><br /> 
				<br />
				<input type="hidden" id="confmKey" name="confmKey" value="" />
				<input type="text" id="buy_addr1" name="buy_addr1"placeholder="우편번호" readonly style="width: 100px; background-color: #e2e2e2;" />&nbsp; 
				<input type="button" class="btn btn-default btn-sm" value="주소검색" onclick="goPopup()"><br /> 
				<input type="text"id="buy_addr2" placeholder="도로명" name="buy_addr2" readonly style="width: 100%; background-color: #e2e2e2;" /><br /> 
				<input type="text" id="buy_addr3" placeholder="(동,읍,면)" readonly="readonly" name="buy_addr3" style="width: 50%; background-color: #e2e2e2;" value="" /> 
				<input type="text" id="buy_addr4" name="buy_addr4" placeholder="(상세주소)" value="" /><br />
				<hr />
				<h2 class="sidebar-title">Point 적립/할인</h2>
				<hr />
				<input type="button" class="btn btn-lg btn-primary btn-block"value="결제 하기" onclick="checkPayment()" /> 
				<input type="button"class="btn btn-lg btn-warning btn-block" value="장바구니로 돌아가기"onclick="returnCart()" />
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>