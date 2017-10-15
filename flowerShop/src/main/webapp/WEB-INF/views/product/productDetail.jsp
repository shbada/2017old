<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	listReply(5);
	
    $("#btnList").click(function(){
        location.href="/productList";
    });
    
    $("#btnAdd").click(function(){
			var formData = $("form[name=frm]").serialize(); //값을 다가지고와서 변수에 담는다 (리스트형식으로 값이 들어감)
			$.ajax({
				type:"POST",
				url: "<c:url value='/cartInsert'/>",
				dataType:"text",
				data: formData,
				success: function(result){
					if(result == 'ok'){
						 location.href="/cartList";
					}
					if(result == 'fal'){
						alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
						location.href="/login";
					}
				},
				error: function(result){
					alert('에러가 발생하였습니다.');
					return;
				},
			});
	 	});
    
   	$("#LikeUp").click(function(){ 
   		if(confirm("추천 하시겠습니까?")==true){
   			
   			var formData = $("form[name=frm]").serialize(); 
   			$.ajax({
   				type:"POST",
   				url: "<c:url value='/likeUpSave'/>",
   				dataType:"text",
   				data: formData,
   				success: function(result){
   					if(result == 'ok'){
   						alert("추천이 완료되었습니다.");
   						window.location.reload();
   					}
   					if(result == 'fal'){
   						alert("이미 추천한 상품입니다.");
   					}
   					if(result == 'null'){
   						alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
   						location.href="/login";
   					}
   				},
   				error: function(result){
   					alert('에러가 발생하였습니다.');
   					return;
   				},
   			});
   		}
   	});
   	
   	$("#btnReply").click(function(){
		if($("#after_content").val().replace(/\s/g,"").length == 0){ 
            alert("리뷰 내용을 입력하세요.");
            $("#after_content").focus();
            return false;
         }
		
		if(confirm("회원님의 리뷰를 등록하시겠습니까?")==true){
			document.getElementById("after_content").value= $("#after_content").val().replace(/\n/g,"<br>");

			var formData = $("form[name=frm]").serialize(); 
			
			$.ajax({
				type:"POST",
				url: "<c:url value='/afterReplyWrite'/>", 
				dataType:"text",
				data: formData,
				success: function(result){ 
						if(result == 'ok'){
							alert("회원님의 리뷰가 등록되었습니다!");
							$("#after_content").val(''); 
							listReply("5");
	   					}
	   					if(result == 'fal'){
	   						alert("로그인이 필요합니다.");
	   						$("#after_content").val(''); 
							listReply("5");
	   					}
					}
			});
		}
	});
});

function listReply(pageCnt){
	$("form[name=replyFrm] input[name=pageNo]").val('1');
	$("form[name=replyFrm] input[name=pageCnt]").val(pageCnt);
	$.ajax({
		type:"POST",
		data: $("form[name=replyFrm]").serialize(),
		url: "<c:url value='/afterReplyList'/>",
		success: function(result){
			$("#listReply").html(result);
			
		}
	});
}
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>PRODUCT DETAIL</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<form class="form-horizontal" name="frm">
		        	<h2 class="related-products-title">Flower Porudct</h2>
		            <div class="product-content-right">
		                <div class="product-breadcroumb">
		                    <a href="/productList">상품 목록으로 돌아가기</a>
		                </div>
		                
		                <div class="row">
		                    <div class="col-sm-6">
		                        <div class="product-images">
		                            <div class="product-main-img">
		                               <img src="<c:url value="${path }/img/${ProductVo.product_url}" />" width="430px" height="550px">
		                            </div>
		                        </div>
		                    </div>
		                    <br />
		                    <div class="col-sm-6">
		                        <div class="product-inner">
		                            <h2 class="product-name">${ProductVo.product_name}</h2>
		                            <div class="product-inner-price">
		                                <ins>${ProductVo.product_price}</ins> <del>${ProductVo.product_price}</del>
		                            </div>    
		                            
	                                <div class="quantity">
	                                    <input type="number" name="product_amount" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1">
	                                </div>&nbsp;
										<input type="hidden" name="product_no" value="${ProductVo.product_no}">
										<input type="hidden" name="product_name" value="${ProductVo.product_name}">
										<input type="hidden" name="product_url" value="${ProductVo.product_url}">
										<input type="hidden" name="product_price" value="${ProductVo.product_price}">
	
										<button type="button" class="add_to_cart_button" id="btnAdd">장바구니에 담기</button>
		                            <hr>
		                            <div role="tabpanel">
		                                <div class="tab-content">
		                                    <div role="tabpanel" class="tab-pane fade in active" id="home">
		                                        <h4>Product Description</h4>  
		                                        <p>${ProductVo.product_desc}</p>
		                                    </div>
		                                </div>
		                            </div>
		                            
		                            <hr>
		                            
		                            <div role="tabpanel">
		                                <div class="tab-content">
		                                    <div role="tabpanel" class="tab-pane fade in active" id="home">
		                                    	<h4>Product Like</h4>
		                                        <a class="heart" href="#">♥ &nbsp;${like}</a> &nbsp;
		                           				 <button type="button" class="btn btn-danger btn-s-xs" id="LikeUp">추천하기</button>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                	</div>
		              </div>
		                
		                <hr>
		                
		                <div class="related-products-wrapper">
		                	 <h2 class="related-products-title">Member Review</h2>
		                	<div>
								<div class="table-responsive" id="listReply"></div>
							</div>
	                   </div>
	                   
	                   <hr>
	                   
		                <div class="related-products-wrapper">
		                    <h2 class="related-products-title">Write Review</h2>
	                        <!-- 후기댓글 넣는 곳 시작점 --> 
                         	<label class="" for="billing_first_name">* 상품 평점</label>&nbsp;
                            <select class="country_to_state country_select" id="after_level" name="after_level">
                               <option value="5">5점-매우만족</option>
                               <option value="4">4점-만족</option>
                               <option value="3">3점-보통</option>
                               <option value="2">2점-조금부족</option>
                               <option value="1">1점-부족</option>
                            </select>
	                   </div>
		               </div><br />
		                    
	                   <label class="" for="billing_first_name">* 상품 후기내용</label>
	                   <textarea class="form-control freeReplTextarea" maxlength="2000" name="after_content" id="after_content" placeholder="내용을 입력하세요"></textarea>
	                    &nbsp;
	                    <button type="button" class="btn btn-lg btn-warning btn-block" id="btnReply">리뷰 등록</button>
                    </form>
                    
                    <form name="replyFrm">
						<input type="hidden" name="product_no" value="${ProductVo.product_no }" />
					    <input type="hidden" name="pageCnt" value="">
				      	<input type="hidden" name="pageNo" value="${pageVO.pageNo}">
					</form>
			    </div>                    
			</div>
	</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>