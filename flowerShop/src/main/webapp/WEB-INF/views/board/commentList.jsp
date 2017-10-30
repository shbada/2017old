<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>

function isbtnChk(obj) {
	if(obj.checked) {
        //클릭되었으면
        document.getElementById("ismsg").innerHTML = "비밀글은 게시글의 글쓴이와 자신만 볼 수 있습니다.";
        document.getElementById("comment_scryn").value = -1;
            //클릭이 안되있으면
	} else {
		document.getElementById("ismsg").innerHTML = "";
		document.getElementById("comment_scryn").value = 0;
	}
}

function AddPage(){ 
	listReply();
}

function commentDelete(comment_no, board_no, comment_reply_count){ 
	if(confirm("댓글을 삭제하시겠습니까?") == true){
		$.ajax({
			type : "patch",
			url : "/commentDelete?comment_no="+comment_no+"&board_no="+board_no+"&comment_reply_count="+comment_reply_count,
			success : function(){
				listReply();
			}
		});
	}
}

function commentOneUpdate(comment_no){
	
	listReply();
	
	if (confirm("댓글을 수정하시겠습니까?") == true){
		document.getElementById("comment_content").value = $('#comment_content').val().replace(/\n/g, "<br>"); 
		$.ajax({
			type : 'put',
			url : "/commentUpdate?comment_no=" + comment_no + "&comment_content=" + $("#comment_content").val() + "&comment_scryn=" + $("#comment_scryn").val(),
			success : function(){
				listReply();
			}
		});
	}else{
		return;
	}
}


function commentReplyInsert(comment_no) {
	
	
	
	if(confirm("댓글을 등록하시겠습니까?")==true){
		document.getElementById("comment_contentT").value = $('#comment_contentT').val().replace(/\n/g, "<br>");
		$.ajax({
			type : 'put',
			url : "/commentReplyInsert?comment_no=" + comment_no + "&comment_content=" + $("#comment_contentT").val() + "&comment_scryn=" + $("#comment_scryn").val(),
			success : function(){ 
				listReply();
			}
		});
	}
	return;
}
function commentReply(comment_no){
	var tag = "<textarea class='form-control replyTextarea' maxlength='20000' name='comment_contentT' id='comment_contentT' placeholder='내용을 입력하세요'></textarea>";
	tag += "<button type='button' class='btn btn-sm btn-success btnReplySuccess' onclick='javascript:commentReplyInsert("+ comment_no+");'>등록</button>";
	tag += "<button type='button' class='btn btn-sm btn-danger btnReplyCancle' onclick='javascript:AddPage();'>취소</button>";
	tag += "비밀글 &nbsp; <input type='checkbox' id='comment_scryn' name='comment_scryn' value='0' onclick='isbtnChk(this)'/>";
	tag += "<p type='text' class='ismsg' id='ismsg' name='ismsg' value='' readonly='readonly' style='width:400px;color:red;' />";
	$("." + comment_no + " .commentReplyPoint").html(tag); //.은 클레스
}


function commentUpdate(comment_no, paramText, comment_scryn){
	
	
	var comment_content = paramText.replace(/<br>/g, '\n');
	var tag = "<textarea class='form-control replyTextarea' maxlength='20000' name='comment_content' id='comment_content'>" + comment_content + "</textarea>";
	tag += "<button type='button' class='btn btn-sm btn-success btnReplySuccess' onclick='javascript:commentOneUpdate(" + comment_no + ");'>수정확인</button>";
	tag += "<button type='button' class='btn btn-sm btn-danger btnReplyCancle' onclick='javascript:AddPage();'>취소</button>";
	if(comment_scryn == 0) {
		tag += "비밀글 &nbsp; <input type='checkbox' id='comment_scryn' name='comment_scryn' value='0' onclick='isbtnChk(this)'/>";
		tag += "<p type='text' class='ismsg' id='ismsg' name='ismsg' value='' readonly='readonly' style='width:400px;color:red;' />";
	}else{
		tag += "비밀 &nbsp; <input type='checkbox' checked='checked' id='comment_scryn' name='comment_scryn' value='0' onclick='isbtnChk(this)'/>";
		tag += "<p type='text' class='ismsg' id='ismsg' name='ismsg' value='' readonly='readonly' style='width:400px;color:red;' />";
	}
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
					${co.user_id} (${co.comment_regdate})
					<c:set var="content" value="${co.comment_content}"/>
					<c:set var="content" value="${fn:replace(comment_content, '>', '&gt;')}"/>
					<c:set var="content" value="${fn:replace(comment_content, '<', '&lt;')}"/>
					<c:set var="rn" value="${rn}"/>
					<c:set var="content" value="${fn:replace(comment_content, rn, '<br/>')}"/>
					<c:if test="${userVo.user_id == co.user_id}">
						<input type="button" class="btn btn-sm btn-success btnReplyDelete" name="co_delete" value="삭제" onclick="javascript:commentDelete('${co.comment_no}','${board_no }', '${co.comment_reply_count }');"/>
						<input type="button" class="btn btn-sm btn-primary btnReplyUpdate" name="co_update" value="수정" onclick="javascript:commentUpdate('${co.comment_no }', '${co.comment_content }','${co.comment_scryn}');"/>
					</c:if>
					<input type="button" class="btn btn-sm btn-danger btnReplyDelete" name="comment_reply" value="답글" onclick="javascript:commentReply('${co.comment_no}');"/>
				</div>
				<c:if test="${co.comment_scryn == 0 || (userVo.user_id == co.user_id || userVo.user_id == board_no_userId)}">
					<c:forEach var="i" begin="1" end="${co.comment_lev}" step="1">
							&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${co.comment_scryn == -1 }">	
					<sapn class="link" style="color:red;">${co.comment_content}</sapn>
					</c:if>
					<c:if test="${co.comment_scryn != -1 }">	
					${co.comment_content}
					</c:if>
				</c:if>
				<c:if test="${co.comment_scryn == -1 && userVo.user_id != co.user_id && userVo.user_id != board_no_userId}">	
					<p style="color:red;">비밀 댓글은 댓글 작성자와 게시글 작성자만 볼 수 있습니다.</p>
				</c:if>
				<div class="commentReplyPoint"></div>
				<hr/>
			</div>
		</c:forEach>
		</div>
	</c:if> 
</table>
