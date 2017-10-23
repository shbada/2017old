<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<!-- 여기서부터 jsp 소스넣기  -->
<jsp:include page="${pageContext.request.contextPath }/top" />
<script type="text/javascript">
	function commentChk() {
		f = document.commentform;
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
	function del_comment(comment_no) {
		if(confirm("댓글을 삭제 하시겠습니까?")) {
			document.commentform.comment_no.value = comment_no;
			document.commentform.method="POST";   		
			document.commentform.action="<c:url value='/del_comment' />";   		
			document.commentform.submit();
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
<div class="row m-n">
	<div class="col-md-4 col-md-offset-4 m-t-lg">
		<form name="form1" action="reply?pageNo=${pageNo}&board_no=${vo.board_no}" method="post">
			<input type="hidden" name="board_start_ref" value="${vo.board_start_ref}"/>
			<input type="hidden" name="board_lev" value="${vo.board_lev}"/>
			<input type="hidden" name="board_seq" value="${vo.board_seq}"/>
			<input type="hidden" name="board_reply_count" value="${vo.board_reply_count}"/>
		<table width="100%" border="1" align="center">
			<tr>
				<td>
					${vo.board_title}
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
				<td colspan="2" align="right">
					<input style="width: 151px; height: 45px;" type="button" onclick="location.href='list?pageNo=${pageNo}'" value="리스트로"/>
					<input type="submit" style="width: 152px; margin: 0; border: 0;" value="답글달기"/>
					<c:if test="${userVo.user_id == vo.user_id}">
					<input style="width: 151px; height: 45px;" type="button" onclick="location.href='update?pageNo=${pageNo}&board_no=${vo.board_no}'" value="수정하기"/>
					<input style="width: 151px; height: 45px;" type="button" onclick="return delete_content();" value="삭제하기"/>
					</c:if>
				</td>	
			</tr>
		</table>
		</form>
		<hr></br>
		<form action="commentOK" name="commentform" method="post" onsubmit="return commentChk();">
			<input type="hidden" name="board_no" value="${vo.board_no}"/>   
			<input type="hidden" name="pageNo" value="${pageNo}"/>
			<input type="hidden" name="user_id" value="${userVo.user_id}">
			<input type="hidden" name="comment_no" value="-1">
			<!-- 댓글 리스트 -->
			<c:if test="${commentList.size() == 0}">
				<div width="90%" style="border:1px solid gray; text-align: center;">
					등록된 댓글이 없습니다.
				</div>
			</c:if>
			<c:if test="${commentList.size() > 0}">
				<div width="90%" style="border:1px solid gray;">
				<c:forEach var="co" items="${commentList}">
					<div width="95%" style="border:1px solid;">
						<div width="90%">
							<c:if test="${co.comment_lev > 0}">
								<c:forEach var="i" begin="1" end="${co.comment_lev}" step="1">
									&nbsp;&nbsp;&nbsp;
								</c:forEach>
								RE :&nbsp;&nbsp;
							</c:if>
							ID&nbsp; ${co.user_id} (${co.comment_regdate})
							<c:set var="content" value="${co.comment_content}"/>
							<c:set var="content" value="${fn:replace(comment_content, '>', '&gt;')}"/>
							<c:set var="content" value="${fn:replace(comment_content, '<', '&lt;')}"/>
							<c:set var="rn" value="${rn}"/>
							<c:set var="content" value="${fn:replace(comment_content, rn, '<br/>')}"/>
							<c:if test="${userVo.user_id == co.user_id}">
								<input type="button" name="co_delete" value="삭제" onclick="javacscript:del_comment('${co.comment_no}')"/>
								<input type="button" name="co_update" value="수정" onclick=""/>
							</c:if>
								<input type="button" name="comment_reply" value="답글" onclick=""/>
						</div>
						<c:if test="${co.comment_scryn == 0 || (userVo.user_id == co.user_id || userVo.user_id == vo.user_id)}">
							<c:forEach var="i" begin="1" end="${co.comment_lev}" step="1">
									&nbsp;&nbsp;&nbsp;
							</c:forEach>
							${co.comment_content}
						</c:if>
						<c:if test="${co.comment_scryn == -1 && userVo.user_id != co.user_id && userVo.user_id != vo.user_id}">	
							비밀 댓글 입니다.
						</c:if>
					</div>
				</c:forEach>
				</div>
			</c:if>
			<!--  댓글폼 -->
			<textarea class="form-control freeReplTextarea" maxlength="2000" name="comment_content" placeholder="내용을 입력하세요"></textarea>
			비밀글 &nbsp; <input type="checkbox" name="comment_scryn" value="-1"/>
			<button type="submit" class="btn btn-lg btn-warning btn-block">댓글 등록</button>		
		</form>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>