<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#editBtn").click(function(){
        var productName = $("#product_name").val();
        var productPrice = $("#product_price").val(); 
        var productDesc = $("#product_desc").val(); 
        
        if(product_name == "") {
            alert("상품명을 입력해주세요");
            product_name.foucs();
        } else if (product_price == "") {
            alert("상품 가격을 입력해주세요");
            product_price.focus();
        } else if (product_desc == "") {
            alert("상품 설명을 입력해주세요");
            product_desc.focus();
        }
        document.form1.method="POST";
        document.form1.action="<c:url value='/productUpdateSave.do' />";
        document.form1.submit();
    });
    
    $("#deleteBtn").click(function(){
        if(confirm("상품을 삭제하시겠습니까?")){
        	document.form1.method="POST";
            document.form1.action="<c:url value='/productDelete.do' />";
            document.form1.submit();
        }
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
			<form id="form1" name="form1" enctype="multipart/form-data" method="post">
				<input type="hidden" name="product_no" value="${ProductVo.product_no}">
				
				<label>이미지</label>
					<img src="${path}/images/${ProductVo.product_url}" height="300px" width="310px"> <br> 
					<input type="file" class="form-control parsley-validated" id="product_photo" name="product_photo"><br />
				<label>상품명</label>
					<input type="text" class="form-control parsley-validated" id="product_name" name="product_name" value="${ProductVo.product_name}"><br />
				<label>가격</label>
					<input type="number" class="form-control parsley-validated" id="product_price" name="product_price" value="${ProductVo.product_price}"><br />
				<label>소개</label>
					<textarea class="form-control freeTextarea" maxlength="2000" name="product_desc" id="product_desc">${ProductVo.product_desc}</textarea><br />
				<hr>
				<button type="button" class="btn btn-lg btn-warning btn-block" id="editBtn">저장</button>
				<button type="button" class="btn btn-lg btn-danger btn-block" id="deleteBtn">삭제</button>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="listBtn">목록</button>
		</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>