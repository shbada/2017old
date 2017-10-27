<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
function buyDetail(idx){ 
	document.form1.buy_no.value = idx;
	document.form1.method="POST";   		
	document.form1.action="<c:url value='/buyDetail' />";   		
	document.form1.submit();
}

function listDetail(idx){ 
	document.form1.product_no.value = idx;
	document.form1.method="POST";   		
	document.form1.action="<c:url value='/productDetail' />";   		
	document.form1.submit();
}
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>주문내역</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
     <div class="container">
         <div class="row">
         <!-- ************************ -->
         <form name="form1" method="post" action="#">
           <input type="hidden" name="buy_no" value="1">
           <input type="hidden" name="product_no" value="1">
          <h2 class="sidebar-title">구매내역 목록</h2>
              <table cellspacing="0" class="shop_table cart">
                  <thead>
                      <tr>
                         <th class="product-subtotal">구매번호</th>
                          <th class="product-remove">상품명</th>
                          <th class="product-thumbnail">상품</th>
                          <th class="product-price">수량</th>
                          <th class="product-quantity">상품 가격</th>
                          <th class="product-quantity">적립 포인트</th>
                          <th class="product-quantity">사용 포인트</th>
                          <th class="product-quantity">주문 총 가격</th>
                          <th class="product-quantity">주문날짜</th>
                          <th class="product-quantity">상세보기</th>
                      </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="row" items="${map.list}" varStatus="i">
                       <tr class="cart_item">
                      	 <td class="product-thumbnail">
                               ${row.buy_no }
                           </td>
                           
                           <td class="product-thumbnail">
                           	   <a href="#" class="link" onclick="javacscript:listDetail('${row.product_no }');">
                               		${row.product_name }
                               </a>
                           </td>

                           <td class="product-name">
                               <a href="#" class="link" onclick="javacscript:listDetail('${row.product_no }');">
                                  <img src="${pageContext.request.contextPath }/img/${row.product_url}" width="145" height="145">
                               </a>
                           </td>

                           <td class="product-quantity">
                               ${row.product_amount }
                           </td>

                           <td class="product-subtotal">
                          	${row.product_price}원
                           </td>
                           
                           <td class="product-subtotal">
                          	${row.buy_addPoint}
                           </td>
                           
                           <td class="product-subtotal">
                          	${row.buy_usePoint}
                           </td>
                           
                           <td class="product-subtotal">
                          	${row.buy_totalPrice}
                           </td>
                           
                           <td class="product-subtotal">
                          	${row.buy_regDate}
                           </td>
                           
                           <td class="product-thumbnail">
                           	 <a href="#" class="btn btn-default" onclick="javacscript:buyDetail('${row.buy_no }');">주문자 상세정보</a>
                           </td>
                       </tr>
                      </c:forEach>
                  </tbody>
              </table>
          </form>
      </div>
   </div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>