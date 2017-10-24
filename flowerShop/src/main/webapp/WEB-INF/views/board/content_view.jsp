<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<!-- 여기서부터 jsp 소스넣기  -->
<%@ page session="true"%>
<jsp:include page="${pageContext.request.contextPath }/top" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	listReply();
	
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

function listReply(){
	$.ajax({
		type:"POST",
		data: $("form[name=commentform]").serialize(),
		url: "<c:url value='/commentList'/>",
		success: function(result){
			$("#listReply").html(result);
		}
	});
}
function commentChk() {
	f = document.commentform;c
	if(!f.comment_content.value || f.comment_content.trim().length == 0) {
		alert('내용을 넣어 주세요');
		f.comment_content.value = "";
		f.comment_content.focus();
		return false;
	}
	return true;
}

function delete_content() {
	if(confirm("게시글을 삭제 하시겠습니까?")) {
		document.form1.method="POST";   		
		document.form1.action="<c:url value='/del_content' />";   		
		document.form1.submit();
	} 
}
	
</script>
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>자유 게시판</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<a href="list?pageNo=${pageNo}"><h3>목록으로 돌아가기</h3></a>
			<hr/>
			<div align="right">
			<%-- <c:if test="${userVo.user_id == vo.user_id}"> --%>
				<input type="button" class="btn btn-sm btn-primary btnReplyUpdate" onclick="location.href='update?pageNo=${pageNo}&board_no=${vo.board_no}'" value="수정하기"/>
				<input type="button" class="btn btn-sm btn-success btnReplyDelete" onclick="return delete_content();" value="삭제하기"/>
			<%-- </c:if> --%>
			</div>
			<form name="form1" action="reply?pageNo=${pageNo}&board_no=${vo.board_no}" method="post">
				<input type="hidden" name="board_start_ref" value="${vo.board_start_ref}"/>
				<input type="hidden" name="board_lev" value="${vo.board_lev}"/>
				<input type="hidden" name="board_seq" value="${vo.board_seq}"/>
				<input type="hidden" name="board_reply_count" value="${vo.board_reply_count}"/>
			<table width="100%" border="1" align="center">
				<tr>
					<td>
						제목 &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;${vo.board_title}
					</td>
					<td style="text-align:right;">
						${vo.board_regdate}
					</td>
				</tr>
				<tr>
					<td colspan="2">
						작성자 : &nbsp; ${vo.board_writer} 
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="15" cols="96" name="board_content" readonly="readonly">${vo.board_content}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="btn btn-lg btn-warning btn-block" value="답글달기"/>
					</td>
				</tr>
			</table>
			</form>
			<hr/><br/>
			<form action="commentOK" name="commentform" method="post" onsubmit="return commentChk();">
				<input type="hidden" name="board_no" value="${vo.board_no}"/>   
				<input type="hidden" name="pageNo" value="${pageNo}"/>
				<input type="hidden" name="user_id" value="${userVo.user_id}">
				<input type="hidden" name="comment_no" value="-1">
				 <!-- 댓글 리스트 -->
				<div class="related-products-wrapper">
	            	 <h2 class="related-products-title">Member Review</h2>
	              	<div>
						<div class="table-responsive" id="listReply"></div>
					</div>
	            </div>
				<hr/>
				<!--  댓글폼 -->
				<textarea class="form-control freeReplTextarea" maxlength="2000" name="comment_content" placeholder="내용을 입력하세요"></textarea>
				비밀글 &nbsp; <input type="checkbox" name="comment_scryn" value="-1"/>
				<button type="submit" class="btn btn-lg btn-warning btn-block">댓글 등록</button>		
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>