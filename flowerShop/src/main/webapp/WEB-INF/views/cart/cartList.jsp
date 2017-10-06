<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$("#amountUpdate").click(function(){ 
	document.form1.method="POST";   		
	document.form1.action="<c:url value='/cartUpdate' />";   		
	document.form1.submit();
});

function CartDel() {
	var chkedVal = new Array(); //배열
	var chkedObj = null;
	
	$(":checkbox[name='cartCheck']:checked").each(function(i){
		 chkedObj = new Object();
		 chkedObj.productNo = $(this).val();
		 chkedVal[i] = chkedObj; 
	 });
	if(chkedVal.length == 0){
		alert("선택된 목록이 없습니다. 삭제하시려는 목록을 체크하세요");
		return;
	}else {
		if (confirm("정말 삭제하시겠습니까?") == true){
			 $.ajax({					
					type:"POST",
					url:"/cartListDelete.do",
					dataType:"JSON",
					data : JSON.stringify(chkedVal),
					contentType: "application/json; charset=UTF-8",
					async : false,
					complete: function() {
						alert("삭제 되었습니다.")
						window.location.reload();
				    }				
				});
		}else{   //취소
	    	return;
		}
	}
}
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shopping Cart</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<form method="post" action="#">
	            <h2 class="sidebar-title">Cart List</h2>
	                <table cellspacing="0" class="shop_table cart">
	                    <thead>
	                        <tr>
	                        	<th style="text-align: center;">
									<input type="checkbox" id="cartCheckAll" name="checkall" />
								</th>
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
	                         	<td style="text-align: center;">
									<input type="checkbox" name="cartCheck" value="${row.productNo }">
								</td>
	                             <td class="product-remove">
	                                 ${row.cartNo }
	                             </td>
	
	                             <td class="product-thumbnail">
	                                 ${row.productName }
	                             </td>
	
	                             <td class="product-name">
	                                 ${row.prodctUrl }
	                             </td>
	
	                             <td class="product-quantity">
	                                 <div class="quantity buttons_added">
	                                     <input type="button" class="minus" value="-">
	                                     <input type="number" size="4" class="input-text qty text" title="Qty" value="${row.productAmount}" min="0" step="1">
	                                     <input type="button" class="plus" value="+">
	                                 </div>
	                             </td>
	
	                             <td class="product-subtotal">
	                                 ${row.productPrice }
	                             </td>
	                         </tr>
	                        </c:forEach>
	                    </tbody>
	                </table>
	                <button type="button" class="btn btn-danger btn-s-xs btnList" id="cartDelete" onclick="CartDel();">선택삭제 </button>&nbsp;
					<button type="button" class="btn btn-primary btn-s-xs btnList" id="amountUpdate">수량수정 </button>
	            </form>
	            
	            <hr />
	            
	            <form method="post" action="#">
	            	<h2 class="sidebar-title">Total Price</h2>
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
	                            	<td><strong><span class="amount">0</span></strong> </td>
	                        	</tr>
							</c:if>
							
							<c:if test="${map.sumMoney != 0}">
		                        <tr class="shipping">
		                            <th>배송비</th>
		                            <td>${map.fee }</td>
		                        </tr>
		
		                        <tr class="order-total">
		                            <th>총 결제금액</th>
		                            <td><strong><span class="amount">${map.allSum }</span></strong> </td>
		                        </tr>
		                   </c:if>
	                    </tbody>
	                </table>
	            </form>
	         <hr />
				<button type="button" class="btn btn-lg btn-shop btn-block" id="buyAllBtn">전체구매</button>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="buyBtn">선택구매</button>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>