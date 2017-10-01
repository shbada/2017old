<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<script type="text/javascript">
	function chk() {
		f = document.form1;
		if(!f.name.value || f.name.value.trim().length == 0) {
			alert('이름넣어!!!');
			f.name.value = "";
			f.name.focus();
			return false;
		}
		if(!f.password.value || f.password.value.trim().length == 0) {
			alert('암호넣어!!!');
			f.password.value = "";
			f.password.focus();
			return false;
		}
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
	이름 : <input type="text" name="board_writer"/><br/>
	제목 : <input type="text" name="board_title" size="80"/><br/>
	내용 : <textarea rows="10" cols="80" name="board_content"></textarea><br/>
	<input type="submit" value="저장하기">
</form>
<!-- 여기서부터 jsp 소스넣기  -->
<%@ include file="/WEB-INF/include/footer.jsp" %>