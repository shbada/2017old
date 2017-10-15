<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script>
$(document).ready(function(){
    $("#addBtn").click(function(){
        var product_name = $("#product_name").val(); 
        var product_price = $("#product_price").val(); 
        var product_desc = $("#product_desc").val(); 
        var product_photo = $("#product_photo").val();

        if(product_name == "") {
            alert("상품명을 입력해주세요");
            product_name.foucs();
        } else if (product_price == "") {
            alert("상품 가격을 입력해주세요");
            product_price.focus();
        } else if (product_desc == "") {
            alert("상품 설명을 입력해주세요");
            product_desc.focus();
        } else if (product_photo == "") {
            alert("상품 사진을 입력해주세요");
            product_photo.focus();
        }
        document.form1.action="<c:url value='/productWriteSave' />";
        document.form1.submit();
    });
    
    $("#listBtn").click(function(){
        location.href='/productList';
    });
});
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>PRODUCT WRITE</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<form id="form1" name="form1" enctype="multipart/form-data" method="post">
				<label>상품명</label>
				<input type="text" class="form-control parsley-validated" name="product_name" id="product_name" maxlength="100"><br />
				<label>가격</label>
				<input type="text" class="form-control parsley-validated" name="product_price" id="product_price" maxlength="100"><br />
				<label>상품설명</label>
				<textarea class="form-control freeTextarea" maxlength="2000" name="product_desc" id="product_desc"></textarea>
				<label>이미지</label>
				<input type="file" class="form-control parsley-validated" name="product_photo" id="product_photo"><br />
				<hr>
				<button type="button" class="btn btn-lg btn-danger btn-block" id="addBtn">저장</button>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="listBtn">목록</button>
			</form>
		</div>
	</div>
</div>

<!-- ALTER TABLE product RENAME COLUMN product_comment TO product_desc; -->
<%@ include file="/WEB-INF/include/footer.jsp" %>