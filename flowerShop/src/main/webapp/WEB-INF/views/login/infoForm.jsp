<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
var user_id = '${authUser.getUser_id()}';

$.ajax({
	type : 'POST',
	url : '${pageContext.request.contextPath }/myInfo',
	data : "user_id=" + user_id,
	dataType : 'json',
	success : function(response) {
		$('#user_id').val(response.data.user_id);
		$('#user_name').val(response.data.user_name);
		$('#user_email').val(response.data.user_email);
		$('#user_phone').val(response.data.user_phone);
		$('#user_addr1').val(response.data.user_addr1);
		$('#user_addr2').val(response.data.user_addr2);
		$('#user_addr3').val(response.data.user_addr3);
		$('#user_addr4').val(response.data.user_addr4);
	}
})

function goChangePw() {
	location.href = "${pageContext.request.contextPath }/changepwform";
}

function goMain() {
	location.href = "${pageContext.request.contextPath }/main";
}

function goPopup() {
	var pop = window.open(
			"${pageContext.request.contextPath }/join/postPup", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
		roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
		detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
		buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
	document.form.user_addr2.value = roadAddrPart1;
	document.form.user_addr3.value = roadAddrPart2;
	document.form.user_addr4.value = addrDetail;
	document.form.user_addr1.value = zipNo;
}

$.validator.addMethod("idregex", function(value, element, regexpr) {
	return regexpr.test(value);
});

$.validator.addMethod("idregex", function(value, element, regexpr) {
	return regexpr.test(value);
}, "영문대,소문자,숫자 4~12로 입력해 주세요.");

$.validator.addMethod("nameregex", function(value, element, regexpr) {
	return regexpr.test(value);
}, "한글로 입력하세요. (자음만 사용 불가)");

$.validator.addMethod("pwregex", function(value, element, regexpr) {
	return regexpr.test(value);
}, "영문,숫자 혼합하여 6~20자리 이내");

$.validator.addMethod("phoneregex", function(value, element, regexpr) {
	return regexpr.test(value);
}, "잘못된 휴대폰 번호입니다.");

$(function() {
	$("form").validate({
		submitHandler : function() {
			var func = confirm("회원정보가 변경되었습니다.");
			if (func) {
				return true;
			} else {
				return false;
			}
		},
		rules : {
			user_id : {
				required : true,
				minlength : 4,
				maxlength : 12,
				idregex : /^[A-Za-z0-9]{4,12}$/,
				remote : true
			},
			user_name : {
				required : true,
				minlength : 2,
				maxlength : 4,
				nameregex : /^[가-힣]+$/
			},
			user_email : {
				required : true,
				email : true
			},
			user_phone : {
				required : true,
				phoneregex : /^01([0|1|6|7|8|9]?)-([0-9]{3,4})-([0-9]{4})$/
			},
			user_addr4 : {
				required : true
			}
		},

		messages : {
			user_id : {
				required : "아이디를 입력하세요.",
				minlength : "최소 4글자 이상 입력",
				maxlength : "최대 12글자 이하 입력",
				idregex : "영문 대소문자 또는 숫자로 입력하세요.",
				remote : "이미 사용중인 아이디입니다."
			},

			user_name : {
				required : "이름을 입력하세요.",
				minlength : "최소 2글자 이상 입력",
				maxlength : "최대 4글자 이하 입력"
			},
			user_email : {
				required : "이메일을 입력하세요.",
				email : "잘못된 이메일 형식입니다."
			},
			user_phone : {
				required : "연락처를 입력해 주세요.",
				phoneregex : "올바른 번호를 입력해주세요."
			},
			user_addr4 : {
				required : "주소를 입력해주세요."
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
					<h2>Information Change</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<header class="text-left createHeader">회원정보변경&nbsp;
            	<span class="subCreateHeader">변경하실 정보를 입력해주세요</span>
            </header>
			<form name="form" id="form" action="${pageContext.request.contextPath }/changeInfo" method="post">
				<label for="user_id"></label> <input type="text" name="user_id" id="user_id" style="width: 100%" placeholder="아이디" value="" readonly style="background-color:#e2e2e2;" /> 
				<span id="duplicateResult"></span>
				<br> 
				<label for="user_name"></label> 
				<input type="text" name="user_name" id="user_name" style="width: 100%" placeholder="이름 (한글 2~4자)" value="" />
				<br>
				<label for="user_email"></label> 
				<input type="text" name="user_email" id="user_email" style="width: 100%" placeholder="이메일(예: hello@world.com)" value="" />
				<br>
				<label for="user_phone"></label> 
				<input type="text" name="user_phone" id="user_phone" style="width: 100%" placeholder="연락처( - 포함하여 입력)" value="" /><br />
				<br>
				<input type="hidden" id="confmKey" name="confmKey" value="" /> 
				<input type="text" id="user_addr1" name="user_addr1" placeholder="우편번호" readonly style="width: 100px; background-color: #e2e2e2;" />&nbsp; 
				<input type="button" class="btn btn-default btn-sm" value="주소검색" onclick="goPopup()"><br> 
				<input type="text" id="user_addr2" placeholder="도로명" name="user_addr2" readonly style="width: 100%; background-color: #e2e2e2;" /><br>

				<input type="text" id="user_addr3" placeholder="(동,읍,면)" readonly="readonly" name="user_addr3" style="width: 50%; background-color: #e2e2e2;" value="" /> 
				<input type="text" id="user_addr4" name="user_addr4" placeholder="(상세주소)" value="" /><br /> 
				
				<hr />
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="정보 수정" /> 
				<input type="button" class="btn btn-lg btn-danger btn-block" value="비밀번호 변경" onclick="goChangePw()" />
				<input type="button" class="btn btn-lg btn-warning btn-block" value="메인으로 가기" onclick="goMain();" />
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>