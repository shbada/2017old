<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/include/header.jsp" %>
    <jsp:include page="${pageContext.request.contextPath }/top" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	 //최상단 체크박스 클릭
    $("#checkall").click(function(){
        //클릭되었으면
        if($("#checkall").prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=chk]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=chk]").prop("checked",false);
        }
    });		    
});

function AdminDel() {
	   var chkedVal = new Array(); //배열
	   var chkedObj = null;
	   
	   $(":checkbox[name='chk']:checked").each(function(i){
	       chkedObj = new Object();
	       chkedObj.user_id = $(this).val(); 
	       chkedVal[i] = chkedObj; 
	    });
	   if(chkedVal.length == 0){
	      alert("선택된 목록이 없습니다. 영구제명하시려는 회원을 선택하세요");
	      return;
	   }else {
	      if (confirm("선택된 회원들을 영구제명하시겠습니까??") == true){    
	          $.ajax({               
	               type:"POST",
	               url:"/allListDelete", 
	               dataType:"JSON",
	               data : JSON.stringify(chkedVal),
	               contentType: "application/json; charset=UTF-8",
	               async : false,
	               complete: function() {
	                  alert("처리가 완료되었습니다.")
	                  window.location.reload();   
	                }            
	            });
	      }else{   //취소
	          return;
	      }
	   }
	}


function memberDelete(idx){ 
	if(confirm("해당 회원을 영구제명 하시겠습니까?") == true){
		document.form1.user_id.value = idx;
		document.form1.method="POST";   		
		document.form1.action="<c:url value='/memberDelete' />";   		
		document.form1.submit();
	}
}

function memberDown(idx){ 
	if(confirm("해당 회원을 '일반회원'으로 강등하겠습니까?") == true){
		document.form1.user_id.value = idx;
		document.form1.method="POST";   		
		document.form1.action="<c:url value='/memberDown' />";   		
		document.form1.submit();
	}
}

function memberUp(idx){ 
	if(confirm("해당 회원을 '관리자'로 등업하시겠습니까?") == true){
		document.form1.user_id.value = idx;
		document.form1.method="POST";   		
		document.form1.action="<c:url value='/memberUp' />";   		
		document.form1.submit();
	}
}

function listDetail(idx){ 
   document.form1.user_id.value = idx;
   document.form1.method="POST";         
   document.form1.action="<c:url value='/memberDetail' />";         
   document.form1.submit();
  }
</script> 
 <title>전체 회원 목록</title>
</head>
<body>
	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>전체 회원 목록</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
<div class="single-product-area">
     <div class="container">
         <div class="row">
			<div class="table-responsive">
				<form name="form1" method="post" action="#">
           		<input type="hidden" name="user_id" value="1">
					<table cellspacing="0" class="shop_table cart">
					<tr>
						<!-- 체크박스 추가하여 체크에 따라 회원 강제 삭제 -->
						<td><input type="checkbox" id="checkall" name="checkall" /></td>
						<th>회원번호</th>
						<th>회원아이디</th>
						<th>이름</th>
						<th>회원등급</th> 
						<th>가입날짜</th>
						<th>탈퇴여부</th>
						<th>적립금</th> <!-- 최신 적립금 액수를 가져와 기록 -->			
						<th>제명</th> <!-- 사용자, 관리자 조절하기(DB연동) -->			
						<th>등업</th> <!-- 사용자, 관리자 조절하기(DB연동) -->	
					</tr>
					<c:forEach var="member" items="${list }">
						<tr>
							<td><input type="checkbox" name="chk" value="${member.user_id }"/></td>
							<td>${member.user_no }</td>
							<td>
								 <a href="#" class="link" onclick="javacscript:listDetail('${member.user_id }');">
									${member.user_id }
								 </a>
							</td>				
							<td>${member.user_name }</td>
							<td>
								<c:if test="${member.isadmin == 'ROLE_ADMIN' }">
									<sapn class="link" style="color:blue;">관리자</sapn>
								</c:if>
								<c:if test="${member.isadmin == 'ROLE_USER' }">
									일반회원
								</c:if>
							</td>
							<td>${member.user_regdate }</td>
							<td>
								<c:if test="${member.enabled == 0 }">
									<sapn class="link" style="color:red;">탈퇴</sapn>
								</c:if>
								<c:if test="${member.enabled == 1 }">
									회원
								</c:if>
							</td>
							<td>${member.user_point }</td>				
							<td>		
								<a href="#" class="link" onclick="javacscript:memberDelete('${member.user_id }');">			
									<button type="button" class="btn btn-default">영구제명</button>
								</a>																																										
							</td>	
							<td>					
								<a href="#" class="link" onclick="javacscript:memberDown('${member.user_id }');">
									<c:if test="${member.isadmin == 'ROLE_ADMIN' }">
										<button type="button" class="btn btn-default">강등</button>	
									</c:if>
								</a>
								<a href="#" class="link" onclick="javacscript:memberUp('${member.user_id }');">
									<c:if test="${member.isadmin == 'ROLE_USER' }">
										<button type="button" class="btn btn-default">등업</button>	
									</c:if>	
								</a>																																								
							</td>			
						</tr>
					</c:forEach> <!-- 컨트롤러의 addAttribute의 list -->		
				</table>
			</form>
			<button type="button" class="btn btn-danger btn-s-xs btnList" id="requestDelete2" onclick="AdminDel();">선택 회원 제명 </button>
			</div>	
			<br>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>