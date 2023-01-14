<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#goback").click(function(){
        location.href="/purchaseHistory";
    });
    
});

</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>구매내역 상세보기</h2>
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
                  <h2 class="sidebar-title">Detail</h2>
                   <table cellspacing="0" class="shop_table cart">
                       <tbody>
                           <tr class="cart-subtotal">
                               <th>구매번호</th>
                               <td><span class="amount">${BuyVo.buy_no }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>주문자이름</th>
                               <td><span class="amount">${BuyVo.buy_name }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>주문자 연락처</th>
                               <td><span class="amount">${BuyVo.buy_phone }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>주문자 주소</th>
                               <td><span class="amount">${BuyVo.buy_addr1 } ${BuyVo.buy_addr2 } ${BuyVo.buy_addr3 } ${BuyVo.buy_addr4 }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>적립 포인트</th>
                               <td><span class="amount">${BuyVo.buy_addPoint }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>사용 포인트</th>
                               <td><span class="amount">${BuyVo.buy_usePoint }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>총 가격</th>
                               <td><span class="amount">${BuyVo.buy_totalPrice }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>주문날짜</th>
                               <td><span class="amount">${BuyVo.buy_regDate }</span></td>
                           </tr>
                          
                       </tbody>
                   </table>
               </form>
               <button type="button" class="btn btn-lg btn-primary btn-block" id="goback">주문내역으로 돌아가기</button>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>