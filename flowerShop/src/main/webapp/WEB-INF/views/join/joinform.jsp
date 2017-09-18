<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
  
  function goMain() {
	    location.href="${pageContext.request.contextPath }/main";
  }
  
  function goPopup(){
	    var pop = window.open("${pageContext.request.contextPath }/join/postPup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
  
  function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		document.form.user_addr2.value = roadAddrPart1;
		document.form.user_addr3.value = roadAddrPart2;
		document.form.user_addr4.value = addrDetail;
		document.form.user_addr1.value = zipNo;
	}
  
   $.validator.addMethod("remote", function(value, element){
    	var user_id = $("#user_id").val();
    	$.ajax({
    		type : "POST",
    		data : "user_id=" + user_id,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			url : "${pageContext.request.contextPath }/join/checkid",
			success : function(response){
				result = ( response.data == "true" ) ? false : true;
			}			
		});
		return result;
    });   
  
    $.validator.addMethod("idregex", function(value, element, regexpr){
  	return regexpr.test(value);
	});
  
    $.validator.addMethod("idregex", function(value, element, regexpr){
    	return regexpr.test(value);
	}, "영문대,소문자,숫자 4~12로 입력해 주세요.");
  
    $.validator.addMethod("nameregex", function(value, element, regexpr){
    	return regexpr.test(value);
	}, "한글로 입력하세요. (자음만 사용 불가)");
  
  	$.validator.addMethod("pwregex", function(value, element, regexpr){
  		return regexpr.test(value);
  	}, "영문,숫자 혼합하여 6~20자리 이내");
  
    $.validator.addMethod("phoneregex", function(value, element, regexpr){
		return regexpr.test(value);
	}, "잘못된 휴대폰 번호입니다.");

	$(function(){
		$("form").validate({
			submitHandler: function(){
				var func = confirm("회원가입을 완료하시겠습니까?");
				if(func){
					return true;
				} else {
					return false;
				}
			},
			rules: {
				user_id : {
					required : true,
					minlength : 4,
					maxlength : 12,
					idregex :   /^[A-Za-z0-9]{4,12}$/,
			 		remote : true
				},
				user_pw : {
					required : true,
					minlength : 6,
					maxlength : 20,
					pwregex : /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/
				},
				user_pwconfirm : {
					required : true,		
					equalTo : user_pw
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
                user_id: {
                    required : "아이디를 입력하세요.",
                    minlength : "최소 4글자 이상 입력",
                    maxlength : "최대 12글자 이하 입력",
                    idregex : "영문 대소문자 또는 숫자로 입력하세요.",
         		    remote :  "이미 사용중인 아이디입니다."
                },
                user_pw: {
                    required : "비밀번호를 입력하세요.",
                    minlength : "최소 6글자 이상 입력"
                },
                user_pwconfirm: {
                    required : "동일한 비밀번호를 입력하세요.",
                    equalTo : "비밀번호가 일치하지 않습니다."
                },
                user_name: {
                    required : "이름을 입력하세요.",
                    minlength : "최소 2글자 이상 입력",
                    maxlength : "최대 4글자 이하 입력"
                },
                user_email: {
                	required : "이메일을 입력하세요.",
                	email : "잘못된 이메일 형식입니다."
                },
                user_phone: {
                	required : "연락처를 입력해 주세요.",
                	phoneregex : "올바른 번호를 입력해주세요."
                },
                user_addr4: {
                	required : "주소를 입력해주세요."
                }
            }			
		});
	})
	
</script>

</head>
<body>

	<form name="form" id="form" action="${pageContext.request.contextPath }/join/join" method="post">
		<label for="user_id"></label>
		<input type="text" name="user_id" id="user_id" style="width:23%" placeholder="아이디"/>
		<span id ="duplicateResult"></span>
		<br><br>
		
		<label for="user_name"></label>
		<input type="text" name="user_name" id="user_name" style="width:23%" placeholder="이름 (한글 2~4자)"/><br><br>
		
		<label for="user_pw"></label>
		<input type="password" name="user_pw" id="user_pw" style="width:23%" placeholder="비밀번호 (영문,숫자 혼합하여 6~20자리 이내)"/><br><br>
		
		<label for="user_pwconfirm"></label>
		<input type="password" name="user_pwconfirm" id="user_pwconfirm" style="width:23%" placeholder="비밀번호 확인"/><br><br>
		
		<label for="user_email"></label>
		<input type="text" name="user_email" id="user_email" style="width:23%" placeholder="이메일(예: hello@world.com)"/><br><br>
		
		<label for="user_phone"></label>
		<input type="text" name="user_phone" id="user_phone" style="width:23%" placeholder="연락처( - 포함하여 입력)"/><br><br>
		

		<input type="hidden" id="confmKey" name="confmKey" value="" />
		<input type="text" id="user_addr1" name="user_addr1"  placeholder="우편번호" readonly style="width:100px; background-color:#e2e2e2;"/>&nbsp;
		<input type="button"  value="주소검색" onclick="goPopup()"><br>

	    <input type="text" id="user_addr2" placeholder="도로명" name="user_addr2" 
	     readonly style="width:23%; background-color:#e2e2e2;"/><br>
				
	  	<input type="text" id="user_addr3" placeholder="(동,읍,면)" readonly="readonly" name="user_addr3" 
	 	style="width:9%; background-color:#e2e2e2;" value=""/>&nbsp;
		<input type="text" id="user_addr4" name="user_addr4" placeholder="(상세주소)" value=""/><br>
		
		<input type="submit" value="가입 하기"/> &nbsp; &nbsp;
		<input type="reset" value="다시 작성"/> &nbsp; &nbsp;
		<input type="button" value="메인으로 가기" onclick="goMain();" />
		
	</form>

</body>
</html>