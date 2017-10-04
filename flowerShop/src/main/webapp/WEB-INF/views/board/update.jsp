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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변형 게시판 - 수정하기</title>
</head>
<body>
<form method="post" name="form1" action="updateOK?pageNo=${pageNo}&board_no=${vo.board_no}">
	제목 : <input type="text" name="board_title" size="80" value="${vo.board_title}"/> <br/>
	내용 : <textarea rows="10" cols="80" name="board_content">${vo.board_content}</textarea> <br/>
	<input type="submit" value="수정완료" />
	<input type="button" value="돌아가기" onclick="location.href='content_view?pageNo=${pageNo}&board_no=${vo.board_no}'"/>
</form>
<%@ include file="/WEB-INF/include/footer.jsp" %>