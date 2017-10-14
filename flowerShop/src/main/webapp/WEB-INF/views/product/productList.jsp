<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
function AddPage(pageNo){
	$("input[name=pageNo]").val(pageNo); 
	var obj = document.viewTable; 
	obj.method="POST";
	obj.action="<c:url value='/productList' />"; 
	obj.submit();         
}

$(document).ready(function(){
    $("#btnAdd").click(function(){
        location.href="/productWrite";
    });
});

function listDetail(idx){ 
	document.viewTable.product_no.value = idx;
	document.viewTable.method="POST";   		
	document.viewTable.action="<c:url value='/productDetail' />";   		
	document.viewTable.submit();
}

function listUpdate(idx){ 
	document.viewTable.product_no.value = idx;
	document.viewTable.method="POST";   		
	document.viewTable.action="<c:url value='/productUpdate' />";   		
	document.viewTable.submit();
}

function saleWrite(idx){ 
	document.viewTable.product_no.value = idx;
	document.viewTable.method="POST";   		
	document.viewTable.action="<c:url value='/saleWrite' />";   		
	document.viewTable.submit();
}
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>PRODUCT LIST</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
        <div class="container">
            <div class="row">
			<!-- ************************ -->
				<c:if test="${userVo.isadmin == 'ROLE_ADMIN'}">
					<button type="button" id="btnAdd" class="btn btn-sm btn-primary">상품등록</button>
				</c:if>
				<p class="pull-right"><a href="/viewLowPrice" class="afindFont">낮은가격</a> / <a href="/viewHighPrice" class="afindFont">높은가격</a> / <a href="/viewName.do" class="afindFont">상품명</a> / <a href="/productList.do" class="afindFont">신상품</a></p>
					<br /><br /><br /> <br />
				<form name="viewTable" onsubmit="return flase;">
					<input type="hidden" name="product_no" value="1">
					
					<c:forEach var="row" items="${list}">
						<div class="col-md-3 col-sm-6" style="text-align:center;">
		                    <div class="single-shop-product">
		                        <div class="product-upper">
		                            <a href="#" class="link" onclick="javacscript:listDetail('${row.product_no }');">
										<img src="<c:url value="${path}/img/${row.product_url}" />" width="430px" height="550px">
									</a>
		                        </div> <br />
		                        	<h2>
										<a href="#" class="link" onclick="javacscript:listDetail('${row.product_no }');">${row.product_name}</a>
										<c:if test="${row.product_saleyn == 'Y'}"> 
											<a class="link" style="color:red;">SALE</a>
										</c:if>
									</h2>
		                        <div class="product-carousel-price">
		                        	<c:if test="${row.product_saleyn == 'N'}">
		                            	<ins>${row.product_price}원</ins>
		                            </c:if>
		                            <c:if test="${row.product_saleyn == 'Y'}">
		                           	 <ins>${row.sale_price}원</ins> <del>${row.product_price}원</del>
		                            </c:if>
		                        </div> <br />
		                        <c:if test="${userVo.isadmin == 'ROLE_ADMIN'}">
			                        <a href="#" class="add_to_cart_button" onclick="javacscript:listUpdate('${row.product_no }');">[상품편집]</a>                    
			                        <a href="#" class="add_to_cart_button" onclick="javacscript:saleWrite('${row.product_no }');">[세일등록]</a>              
			                    </c:if>      
		                    </div>
		                </div>
		            </c:forEach>
				</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>