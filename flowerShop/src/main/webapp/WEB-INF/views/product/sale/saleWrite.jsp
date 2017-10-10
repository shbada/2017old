<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#editBtn").click(function(){
        var sale_percent = $("#sale_percent").val(); 
        
        if (sale_percent == "") {
            alert("세일가격을 입력해주세요");
            sale_percent.focus();
        }
        
        document.form1.method="POST";
        document.form1.action="<c:url value='/saleWriteSave.do' />";
        document.form1.submit();
    });
    
    
    $("#listBtn").click(function(){
        location.href = "/productList";
    });
});
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>PRODUCT UPDATE</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<form id="form1" name="form1" method="post">
				<input type="hidden" name="product_no" value="${ProductVo.product_no}">
				<input type="hidden" name="product_price" value="${ProductVo.product_price}">
				
				<label>상품명</label>
					<input type="text" class="form-control parsley-validated" id="product_name" name="product_name" value="${ProductVo.product_name} " readonly><br />
				<label>할인율</label>
					<input type="number" class="form-control parsley-validated" id="sale_percent" name="sale_percent"><br />
				<hr>
				<button type="button" class="btn btn-lg btn-warning btn-block" id="editBtn">저장</button>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="listBtn">목록</button>
		</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>