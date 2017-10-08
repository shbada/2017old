<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<!-- 여기서부터 jsp 소스넣기  -->
<%-- <script src="<c:url value='/resources/js/board_setting.js'/>"/> --%>
<script type="text/javascript">
	function commentChk() {
		f = document.commentform;
		if(!f.comment_content.value || f.comment_content.trim().length == 0) {
			alert('내용넣어!!!');
			f.comment_content.value = "";
			f.content.focus();
			return false;
		}
		return true;
	}
	
	function delete_content() {
		if(confirm("정말 삭제 하시겠습니까?")) {
			document.location.href="delete?pageNo=${pageNo}&board_no=${vo.board_no}";
		} else {
			
		}
	}
	
	function setting(mode, comment_no, button_title, comment_content) {
		f = document.commentform;
		f.mode.value = mode;
		f.board_no.value = comment_no;
		f.commentBtn.value = button_title;
// 		while(comment_content.indexOf('<br/>') != -1) {
// 			comment_content = comment_content.replace("<br/>", "\r\n");
// 		}
		f.comment_content.value = comment_content;
	}
</script>
</head>
<body>
<form method="post" name="form1">
	이름 : <input type="text" name="board_writer" value="${vo.board_writer}" readonly="readonly"/><br/>
	작성일 : <input type="text" name="board_regdate" value="${vo.board_regdate}" readonly="readonly"/><br/>
	제목 : <input type="text" name="board_title" size="80" value="${vo.board_title}" readonly="readonly"/><br/>
	내용 : <textarea rows="10" cols="80" name="board_content" readonly="readonly">${vo.board_content}</textarea><br/>
</form>
<form action="reply?pageNo=${pageNo}&board_no=${vo.board_no}" method="post">
	<input type="hidden" name="board_start_ref" value="${vo.board_start_ref}"/>
	<input type="hidden" name="board_lev" value="${vo.board_lev}"/>
	<input type="hidden" name="board_seq" value="${vo.board_seq}"/>
	<input type="button" onclick="location.href='list?pageNo=${pageNo}'" value="리스트로"/>
	<input type="submit" value="답변달기"/>
	<c:if test="${userVo.user_id == vo.user_id}">
		<input type="button" onclick="location.href='update?pageNo=${pageNo}&board_no=${vo.board_no}'" value="수정하기"/>
		<input type="button" onclick="return delete_content();" value="삭제하기"/>
	</c:if>
	<br/>
</form>
<!--  댓글폼 -->
<form method="post" name="commentform" action="commentOK">
	<input type="hidden" name="board_no" value="${vo.board_no}"/>   
	<input type="hidden" name="pageNo" value="${pageNo}"/>
	<input type="hidden" name="mode" value="1"/>
	<input type="hidden" name="user_id" value="${userVo.user_id}">
	내용 : <br/><textarea rows="3" cols="50" name="comment_content"></textarea><br/>
	비밀글 &nbsp; <input type="checkbox" name="comment_scryn" value="-1"/>
	<input type="submit" value="댓글달기" name="commentBtn" onclick="return commentChk();"/>
	<input type="button" value="새로쓰기" onclick="setting(1, 0, '저장', '')"/>
<!-- 댓글 리스트 -->
	<c:if test="${commentList.size() == 0}">
		<div width="90%" style="border:1px solid gray;">
			등록된 댓글이 없습니다.
		</div>
	</c:if>
	<c:if test="${commentList.size() > 0}">
		<div width="90%" style="border:1px solid gray;">
		<c:forEach var="co" items="${commentList}">
			<div width="95%" style="border:1px solid silver;">
			<div width="90%" style="background-color:silver;">
			<c:if test="${co.comment_scryn == 0}">	
				ID: ${co.user_id} (${co.comment_regdate})
			</c:if>
			<c:if test="${co.comment_scryn == -1 && userVo.user_id != co.user_id && userVo.user_id != vo.user_id}">	
				비밀 댓글 입니다.
			</c:if>
				
			<c:set var="content" value="${co.comment_content}"/>
			<c:set var="content" value="${fn:replace(comment_content, '>', '&gt;')}"/>
			<c:set var="content" value="${fn:replace(comment_content, '<', '&lt;')}"/>
			<c:set var="rn" value="${rn}"/>
			<c:set var="content" value="${fn:replace(comment_content, rn, '<br/>')}"/>
			<input type="button" value="수정" onclick="setting(2, '${co.board_no}', '수정', '${comment_content}')"/>
			<input type="button" value="삭제" onclick="setting(3, '${co.board_no}', '삭제', '${comment_content}')"/>
			</div>
			${co.comment_content}
			</div>
		</c:forEach>
		</div>
	</c:if>		
</form>
<%@ include file="/WEB-INF/include/footer.jsp" %>