<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<script type="text/javascript">
	function chk() {
		f = document.form1;
		if(!f.title.value || f.title.value.trim().length == 0) {
			alert('제목넣어!!!');
			f.title.value = "";
			f.title.focus();
			return false;
		}
		if(!f.content.value || f.content.value.trim().length == 0) {
			alert('내용넣어!!!');
			f.content.value = "";
			f.content.focus();
			return false;
		}
		return true;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력</title>
</head>
<body>
<form action="writeOK" method="post" onsubmit="return chk();" >
	제목 : <input type="text" name="board_title" size="80"/><br/>
	내용 : <textarea rows="10" cols="80" name="board_content"></textarea><br/>
	<input type="submit" value="저장하기">
</form>
<!-- 여기서부터 jsp 소스넣기  -->
<%@ include file="/WEB-INF/include/footer.jsp" %>