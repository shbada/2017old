<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/messagePop.jsp"%>
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
function messageSendWrite(idx){ 
	document.form1.msg_send.value = idx;
	document.form1.method="POST";   		
	document.form1.action="<c:url value='/messageSendWrite' />";   		
	document.form1.submit();
}

$(document).ready(function(){
    $("#sendDelete").click(function(){
        location.href="/messageList";
    });
    
    $("#deleteBtn").click(function(){
        if(confirm("해당 쪽지를 삭제하시겠습니까?")){
        	document.form1.method="POST";
            document.form1.action="<c:url value='/messageGetDelete.do' />";
            document.form1.submit();
        }
    });
});

</script>
<!-- *** -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>받은 쪽지 상세보기</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			 <a href="#" class="link"  onclick="javacscript:messageSendWrite('${MessageVo.msg_send }');">
               <button type="button" class="btn btn-warning afind" id="messageSendWrite">답장보내기 </button>
          	 </a>
          	 <hr>
			<!-- ************************ -->
			<form id="form1" name="form1" method="post">
				<input type="hidden" name="msg_send" value="${MessageVo.msg_send}">
				<input type="hidden" name="msg_no" value="${MessageVo.msg_no}">
				<label>보낸이</label>
				<input type="text" class="form-control parsley-validated" name="msg_get" id="msg_get" value=" ${MessageVo.msg_send}" maxlength="100" readonly><br />
				<label>제목</label>
				<input type="text" class="form-control parsley-validated" name="msg_name" id="msg_name" value="${MessageVo.msg_name}" maxlength="100" readonly><br />
				<label>내용</label>
				<textarea class="form-control freeTextarea" maxlength="2000" name="msg_desc" id="msg_desc" readonly>${MessageVo.msg_desc}</textarea><br />
				<label>시간</label>
				<input type="text" class="form-control parsley-validated" name="msg_get" id="msg_get" value="${MessageVo.msg_regdate}" maxlength="100" readonly><br />
				<hr>
				<button type="button" class="btn btn-lg btn-danger btn-block" id="deleteBtn">삭제</button>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="sendDelete">목록으로 돌아가기</button>
			</form>
		</div>
	</div>
</div>
