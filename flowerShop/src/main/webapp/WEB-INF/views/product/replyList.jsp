<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
function AddPage(pageCnt){ //더보기 클릭 시!
	listReply(pageCnt);
}

function AfterReplyDelete(idx){ 
	if(confirm("댓글을 삭제하시겠습니까?") == true){
		$.ajax({
			type : "patch",
			url : "/AfterReplyDelete?after_no="+idx,
			success : function(){
				AddPage($("#pageCnt").val()); 
				alert("정상적으로 삭제되었습니다.");
			}
		});
	}
}

function replyOneUpdate(after_no){
	if (confirm("댓글을 수정하시겠습니까?") == true){
		document.getElementById("after_content").value = $('#after_content').val().replace(/\n/g, "<br>"); 
		$.ajax({
			type : 'put',
			
			url : "/AfterReplyUpdate?after_no=" + after_no + "&after_content=" + $("#after_content").val(),
			success : function(){
				AddPage($("#pageCnt").val());
				alert("정상적으로 수정 되었습니다.");
			}
		});
	}else{
		return;
	}
}

function replyOneBack(){
	AddPage($("#pageCnt").val());
}

function AfterReplyUpdate(after_no, paramText){
	var after_content = paramText.replace(/<br>/g, '\n');
	
	var tag = "<textarea class='form-control replyTextarea' maxlength='20000' name='after_content' id='after_content'>" + after_content + "</textarea>";
	tag += "<button type='button' class='btn btn-sm btn-success btnReplySuccess' onclick='javascript:replyOneUpdate(" + after_no + ");'>수정확인</button>";
	tag += "<button type='button' class='btn btn-sm btn-danger btnReplyCancle' onclick='javascript:replyOneBack();'>취소</button>";
	$("." + after_no).html(tag); //.은 만약에 20번 댓글이면 20번 댓글을 찾음
}

</script>
<table study = 'width:100%'>
	<c:forEach var="row" items="${replyList }">
		<tr>
			<td class="replyId ${row.after_no }">
				${row.user_id }님의 리뷰
				&nbsp;
				<c:if test="${row.after_level == 5}">
				★★★★★ 
				</c:if>
				<c:if test="${row.after_level == 4}">
				★★★★☆
				</c:if>
				<c:if test="${row.after_level == 3}">
				★★★☆☆ 
				</c:if>
				<c:if test="${row.after_level == 2}">
				★★☆☆☆ 
				</c:if>
				<c:if test="${row.after_level == 1}">
				★☆☆☆☆ 
				</c:if>
				<br /><br />
				<span>${row.after_content }</span>
				<c:if test="${row.user_id == sessionUser_id }"> <!-- 댓글 작성자와 접속중인 아이디가 같으면 -->
					<button type="button" class="btn btn-sm btn-primary btnReplyUpdate" onclick="javascript:AfterReplyUpdate('${row.after_no }', '${row.after_content }');">수정</button>
					<%-- <button type="button" class="btn btn-sm btn-primary btnReplyUpdate" onclick="javascript:AfterReplyUpdate('${row.after_no }', ${row.after_level }', '${row.after_content }');">수정</button> --%>
					<button type="button" class="btn btn-sm btn-success btnReplyDelete" onclick="javascript:AfterReplyDelete('${row.after_no }');">삭제</button>
				</c:if>
				<hr>
			</td>
		</tr>
	</c:forEach>
</table>
<c:choose>
	<c:when test="${fn:length(replyList) != 0 }">
		<div class="text-center">
			<c:if test="${pageVO.totalCount > fn:length(replyList)}">
				<button type="button" class="btn btn-info btn-s-xs btnList" onclick="javascript:AddPage('${fn:length(replyList)+5 }')">더보기</button> <!-- 5개씩 더 보이게하겠다 -> +5한 이유 -->
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		<span>등록된 댓글이 없습니다.</span>
	</c:otherwise>
</c:choose>
<input type="hidden" id="pageCnt" value="${pageVO.pageCnt }" />
