<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#goback").click(function(){
        location.href="/allMemberList";
    });
    
});

</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>회원정보 상세보기</h2>
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
                               <th>회원 아이디</th>
                               <td><span class="amount">${UserVo.user_id }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>회원 이름</th>
                               <td><span class="amount">${UserVo.user_name }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>회원 이메일</th>
                               <td><span class="amount">${UserVo.user_email }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>회원 연락처</th>
                               <td><span class="amount">${UserVo.user_phone }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>회원 주소</th>
                               <td><span class="amount">${UserVo.user_addr1 } ${UserVo.user_addr2 } ${UserVo.user_addr3 } ${UserVo.user_addr4 }</span></td>
                           </tr>
                           
                           <tr class="cart-subtotal">
                               <th>가입날짜</th>
                               <td><span class="amount">${UserVo.user_regdate }</span></td>
                           </tr>
                          
                       </tbody>
                   </table>
               </form>
               <button type="button" class="btn btn-lg btn-primary btn-block" id="goback">목록으로 돌아가기</button>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>