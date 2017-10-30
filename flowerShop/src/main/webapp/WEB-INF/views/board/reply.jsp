<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<jsp:include page="${pageContext.request.contextPath }/top" />
<script type="text/javascript">
	function chk(){
		f = document.form1;
		if(!f.board_title.value || f.board_title.value.trim().length == 0) {
			alert('제목을 넣어 주세요');
			f.board_title.value = "";
			f.board_title.focus();
			return false;
		}
		if(!f.board_content.value || f.board_content.value.trim().length == 0) {
			alert('내용을 넣어 주세요');
			f.board_content.value = "";
			f.board_content.focus();
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
<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<a href="/list"><h3>목록으로 돌아가기</h3></a><br/>
			<form action="replyOK?pageNo=${pageNo}&board_no=${vo.board_no}" method="post" onsubmit="return chk();" name="form1">
				<input type="hidden" name="board_start_ref" value="${vo.board_start_ref}"/>
				<input type="hidden" name="board_lev" value="${vo.board_lev}"/>
				<input type="hidden" name="board_seq" value="${vo.board_seq}"/>
				<input type="hidden" name="board_writer" value="${userVo.user_name}">
			 	<input type="hidden" name="user_id" value="${userVo.user_id}">
			 	<table class="shop_table cart">
			 		<tr>
			 			<td>
							<input type="text" name="board_title" size="81" placeholder="제목을 입력해주세요."/><br/>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td>
							<textarea rows="10" cols="80" name="board_content" placeholder="내용을 입력해주세요."></textarea><br/>
			 			</td>
			 		</tr>
			 		<tr align="right">
			 			<td>
							<input type="submit" class="btn btn-lg btn-warning btn-block" value="등록하기">
			 			</td>
			 		</tr>
				</table>
			</form>
		</div>
	</div>
</div>			
	<!-- 여기서부터 jsp 소스넣기  -->
<%@ include file="/WEB-INF/include/footer.jsp" %>
