<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<!-- 여기서부터 jsp 소스넣기  -->
<%@ page session="true"%>
<jsp:include page="${pageContext.request.contextPath }/top" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
   
	$("#comment_scryn").click(function(){
        //클릭되었으면
        if($("#comment_scryn").prop("checked")){
            document.commentform.ismsg.value = "비밀글은 게시글의 글쓴이와 자신만 볼 수 있습니다.";
            //클릭이 안되있으면
        }else{
        	document.commentform.ismsg.value = " ";
        }
    });
	
	listReply();
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

	if(confirm("댓글을 등록하시 겠습니까?")) {
		document.commentform.method="POST";   		
		document.commentform.action="<c:url value='/commentOK' />";   		
		document.commentform.submit();
	} 
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
				<input type="button" class="btn btn-sm btn-primary btnReplyUpdate" onclick="location.href='update?pageNo=${pageNo}&board_no=${vo.board_no}'" value="수정하기"/>&nbsp;
				<input type="button" class="btn btn-sm btn-success btnReplyDelete" onclick="delete_content();" value="삭제하기"/>
			<%-- </c:if> --%>
			</div><br />
			<form name="form1" action="/reply" method="post">
				<input type="hidden" name="pageNo" value="${pageNo}"/>
				<input type="hidden" name="board_no" value="${vo.board_no}"/>
				<input type="hidden" name="board_start_ref" value="${vo.board_start_ref}"/>
				<input type="hidden" name="board_lev" value="${vo.board_lev}"/>
				<input type="hidden" name="board_seq" value="${vo.board_seq}"/>
				<input type="hidden" name="board_reply_count" value="${vo.board_reply_count}"/>
			<table class="shop_table cart">
				<tr>
					<td>
						작성자 : &nbsp; ${vo.board_writer} 
					</td>
					<td>
						작성시간: ${vo.board_regdate}
					</td>
				</tr>
				<tr>
					<td colspan="2">
						제목 &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;${vo.board_title}
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
			<form action="#" name="commentform" method="post" >
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
				비밀글 &nbsp; <input type="checkbox" id="comment_scryn" name="comment_scryn"  value="-1"/><input type="text" class="ismsg" name="ismsg" value="" readonly="readonly" style="border: 0; width: 400px; color: red;">
				<button type="button" onclick="commentChk();" class="btn btn-lg btn-warning btn-block">댓글 등록</button>		
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>