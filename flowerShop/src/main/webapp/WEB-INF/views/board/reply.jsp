<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<script type="text/javascript">
	function chk(){
		f = document.form1;
		if(!f.board_title.value || f.board_title.value.trim().length == 0) {
			alert('제목넣어!!!');
			f.board_title.value = "";
			f.board_title.focus();
			return false;
		}
		if(!f.board_content.value || f.board_content.value.trim().length == 0) {
			alert('내용넣어!!!');
			f.board_content.value = "";
			f.board_content.focus();
			return false;
		}
		return true;
	}
</script>
<form action="replyOK?pageNo=${pageNo}&board_no=${vo.board_no}" method="post" onsubmit="return chk();" name="form1">
	<input type="hidden" name="board_ref" value="${vo.board_ref}"/>
	<input type="hidden" name="board_lev" value="${vo.board_lev}"/>
	<input type="hidden" name="board_seq" value="${vo.board_seq}"/>
	제목 : <input type="text" name="board_title" size="80"/><br/>
	내용 : <textarea rows="10" cols="80" name="board_content"></textarea><br/>
	<input type="submit" value="글쓰기">
</form>
<!-- 여기서부터 jsp 소스넣기  -->
<%@ include file="/WEB-INF/include/footer.jsp" %>