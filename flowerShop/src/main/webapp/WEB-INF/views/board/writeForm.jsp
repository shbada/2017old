<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
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
		<form action="writeOK" method="post" onsubmit="return chk();" >
		   <input type="hidden" name="board_writer" value="${userVo.user_name}">
		   <input type="hidden" name="user_id" value="${userVo.user_id}">
			<table width="100%" border="1" align="center">
				<tr>
				    <td>
						<input type="text" name="board_title" size="100" placeholder="제목"/><br/>
				    </td>
				</tr>
				<tr>
				    <td>
						 <textarea rows="10" cols="100" name="board_content" placeholder="내용"></textarea><br/>
				    </td>
				</tr>
				<tr>
				    <td align="right">
						<input type="submit" value="저장하기">
				    </td>
				</tr>
			</table>
		</form>
	</div>
</div>
<!-- 여기서부터 jsp 소스넣기  -->
<%@ include file="/WEB-INF/include/footer.jsp" %>