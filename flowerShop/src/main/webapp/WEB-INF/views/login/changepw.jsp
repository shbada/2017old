<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$.validator.addMethod("pwregex", function(value, element, regexpr) {
	return regexpr.test(value);
}, "영문,숫자 혼합하여 6~20자리 이내");

$(function() {
	$("form").validate({
		submitHandler : function() {
			var func = confirm("비밀번호를 변경하시겠습니까?");
			if (func) {
				return true;
			} else {
				return false;
			}
		},
		rules : {
			user_pw : {
				required : true,
				minlength : 6,
				maxlength : 20,
				pwregex : /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/
			},
			user_pwconfirm : {
				required : true,
				equalTo : user_pw
			}
		},

		messages : {
			user_pw : {
				required : "비밀번호를 입력하세요.",
				minlength : "최소 6글자 이상 입력"
			},
			user_pwconfirm : {
				required : "동일한 비밀번호를 입력하세요.",
				equalTo : "비밀번호가 일치하지 않습니다."
			}
		}
	});
})
</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Password Change</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<header class="text-left createHeader">비밀번호 변경&nbsp;
            	<span class="subCreateHeader">변경하실 비밀번호를 입력해주세요</span>
            </header>
			<!-- ************************ -->
			<form name="form" id="form" action="${pageContext.request.contextPath }/changepw" method="post">
				<label for="" class="sr-only"></label><label for="" class="sr-only"></label>
				<input type="hidden" name="user_id" value="${authUser.getUser_id() }"/>
				<input type="password" id="user_pw" name="user_pw" class="form-control" placeholder="새로운 비밀번호" required>
				<br>
				<input type="password" id="user_pwconfirm" name="user_pwconfirm" class="form-control" placeholder="새로운 비밀번호 확인" required>
				<br> 
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="변경하기" />
				<input type="button" class="btn btn-lg btn-primary btn-block" value="메인으로 가기" onclick="location.href='${pageContext.request.contextPath }/main';">
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>