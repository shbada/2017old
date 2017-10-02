<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
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
</head>
<body>
	<%-- <c:set var="user" value="${authUser }" scope="session" /> --%>
	<form name="form" id="form"
		action="${pageContext.request.contextPath }/changepw" method="post">
		<label for="" class="sr-only"></label><label for="" class="sr-only"></label>
		<input type="hidden" name="user_id" value="${authUser.getUser_id() }"/>
		<input type="password" id="user_pw" name="user_pw"
			class="form-control" placeholder="새로운 비밀번호" required><br>
		<br> <input type="password" id="user_pwconfirm"
			name="user_pwconfirm" class="form-control" placeholder="새로운 비밀번호 확인"
			required><br> <input type="submit" value="변경하기" />
		&nbsp; &nbsp; <input type="button" value="메인으로 가기"
			onclick="location.href='${pageContext.request.contextPath }/main';">
	</form>
</body>
</html>