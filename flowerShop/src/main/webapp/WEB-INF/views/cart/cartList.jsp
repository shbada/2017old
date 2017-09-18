<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
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
    </div> <!-- End Page title area -->
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">BEST PRODUCTS</h2>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                    </div>
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">SALE PRODUCTS</h2>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                        <div class="thubmnail-recent">
                            <img src="../../resources/img/product-thumb-1.jpg" class="recent-thumb" alt="">
                            <h2><a href="single-product.html">Sony Smart TV - </a></h2>
                            <div class="product-sidebar-price">
                                <ins>$700.00</ins> <del>$800.00</del>
                            </div>                             
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="#">
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
	                                       <tr>
                                            <td class="actions" colspan="6">
                                                <input type="submit" value="수량변경" name="update_cart" class="button">
                                                <input type="submit" value="선택삭제" name="update_cart" class="button">
                                                <input type="submit" value="선택구매" name="update_cart" class="button">
                                                <input type="submit" value="전체구매" name="update_cart" class="button">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                            
                            <div class="cart_totals ">
                            <form method="post" action="#">
                            <h2 class="sidebar-title">Total Price</h2>
                                <table cellspacing="0" class="shop_table cart">
                                    <tbody>
                                        <tr class="cart-subtotal">
                                            <th>주문 금액</th>
                                            <td><span class="amount">${map.sumMoney }</span></td>
                                        </tr>

                                        <tr class="shipping">
                                            <th>배송비</th>
                                            <td>${map.fee }</td>
                                        </tr>

                                        <tr class="order-total">
                                            <th>총 결제금액</th>
                                            <td><strong><span class="amount">${map.allSum }</span></strong> </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>