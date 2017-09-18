<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
 <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>After Reply</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="#">
                            <h2 class="sidebar-title">After Reply</h2>
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                        	<th class="product-subtotal">번호</th>
                                        	<th class="product-price">만족도</th>
                                            <th class="product-remove">상품명</th>
                                            <th class="product-thumbnail">상품</th>
                                            <th class="product-quantity">후기내용</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="row" items="${map.list}" varStatus="i">
	                                        <tr class="cart_item">
	                                            <td class="product-remove">
	                                                ${row.afterNo }
	                                            </td>
	
	                                            <td class="product-thumbnail">
	                                                ${row.afterLevel }
	                                            </td>
	
	                                            <td class="product-name">
	                                                ${row.productName }
	                                            </td>
	                                            <td class="product-name">
	                                                ${row.productUrl }
	                                            </td>
	                                            <td class="product-name">
	                                                ${row.afterContent }
	                                            </td>
	                                        </tr>
	                                       </c:forEach>
                                    </tbody>
                                </table>
                            </form>                      
                    </div>                    
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>