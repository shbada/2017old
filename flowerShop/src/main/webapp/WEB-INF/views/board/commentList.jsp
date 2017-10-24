<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>

function AddPage(){ //더보기 클릭 시!
	listReply();
}

function commentDelete(comment_no, board_no, comment_reply_count){ 
	if(confirm("댓글을 삭제하시겠습니까?") == true){
		$.ajax({
			type : "patch",
			url : "/commentDelete?comment_no="+comment_no+"&board_no="+board_no+"&comment_reply_count="+comment_reply_count,
			success : function(){
				listReply();
				alert("정상적으로 삭제되었습니다.");
			}
		});
	}
}

function commentOneUpdate(comment_no){
	if (confirm("댓글을 수정하시겠습니까?") == true){
		document.getElementById("comment_content").value = $('#comment_content').val().replace(/\n/g, "<br>"); 
		$.ajax({
			type : 'put',
			
			url : "/commentUpdate?comment_no=" + comment_no + "&comment_content=" + $("#comment_content").val(),
			success : function(){
				listReply();
				alert("정상적으로 수정 되었습니다.");
			}
		});
	}else{
		return;
	}
}

function commentReply(comment_no){
	
	var tag = "<textarea class='form-control replyTextarea' maxlength='20000' name='comment_content' id='comment_content'></textarea>";
	tag += "<button type='button' class='btn btn-sm btn-success btnReplySuccess' onclick='javascript:commentOneUpdate(" + comment_no + ");'>등록</button>";
	tag += "<button type='button' class='btn btn-sm btn-danger btnReplyCancle' onclick='javascript:AddPage();'>취소</button>";
	$("." + comment_no + " .commentReplyPoint").html(tag); //.은 만약에 20번 댓글이면 20번 댓글을 찾음
}


function commentUpdate(comment_no, paramText){
	var comment_content = paramText.replace(/<br>/g, '\n');
	
	var tag = "<textarea class='form-control replyTextarea' maxlength='20000' name='comment_content' id='comment_content'>" + comment_content + "</textarea>";
	tag += "<button type='button' class='btn btn-sm btn-success btnReplySuccess' onclick='javascript:commentOneUpdate(" + comment_no + ");'>수정확인</button>";
	tag += "<button type='button' class='btn btn-sm btn-danger btnReplyCancle' onclick='javascript:AddPage();'>취소</button>";
	$("." + comment_no).html(tag); //.은 만약에 20번 댓글이면 20번 댓글을 찾음
}

</script>
<table study = 'width:100%' border="0">
	<c:if test="${commentList.size() == 0}">
		<div width="90%" style="border:0px solid gray; text-align: center;">
			등록된 댓글이 없습니다.
		</div>
	</c:if>
	<c:if test="${commentList.size() > 0}">
		<div width="90%" style="border:0px solid gray;">
		<c:forEach var="co" items="${commentList}">
			<div class="${co.comment_no }" width="95%" style="border:0;">
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
						<input type="button" class="btn btn-sm btn-success btnReplyDelete" name="co_delete" value="삭제" onclick="javascript:commentDelete('${co.comment_no}','${board_no }', '${co.comment_reply_count }');"/>
						<input type="button" class="btn btn-sm btn-primary btnReplyUpdate" name="co_update" value="수정" onclick="javascript:commentUpdate('${co.comment_no }', '${co.comment_content }');"/>
					</c:if>
						<input type="button" class="btn btn-sm btn-success btnReplyDelete" name="comment_reply" value="답글" onclick="javascript:commentReply('${co.comment_no}')"/>
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
				<div class="commentReplyPoint"></div>
				<hr/>
			</div>
		</c:forEach>
		</div>
	</c:if> 
	<%-- <c:forEach var="row" items="${replyList }">
		<tr>
			<td class="replyId ${row.after_no }">
				${row.user_id }님의 리뷰
				&nbsp;
				<br /><br />
				<span>${row.after_content }</span>
				<c:if test="${row.user_id == sessionUser_id }"> 
					<button type="button" class="btn btn-sm btn-primary btnReplyUpdate" onclick="javascript:AfterReplyUpdate('${row.after_no }', '${row.after_content }');">수정</button>
					<button type="button" class="btn btn-sm btn-success btnReplyDelete" onclick="javascript:AfterReplyDelete('${row.after_no }');">삭제</button>
					<button type="button" class="btn btn-sm btn-primary btnReplyUpdate" onclick="javascript:AfterReplyUpdate('${row.after_no }', ${row.after_level }', '${row.after_content }');">수정</button>
				</c:if>
				<c:if test="${row.user_id != sessionUser_id && userVo.isadmin == 'ROLE_ADMIN'}">
						<button type="button" class="btn btn-sm btn-success btnReplyDelete" onclick="javascript:AfterReplyDelete('${row.after_no }');">삭제</button>
				</c:if>
				<hr>
			</td>
		</tr>
	</c:forEach> --%>
</table>
