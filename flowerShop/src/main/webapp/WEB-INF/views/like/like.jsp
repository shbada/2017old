<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<script>
function LikeSelect(){
	$.ajax({
		type : "GET",
		url : "<c:url value='/likeSelect.do?productNo=${productVo.productNo}' />",
		success : function(result){
			$("#추천수 id값").html(result); 
		}
	});
}
	
$(document).ready(function(){
	$("#LikeUp").click(function(){ 
		if(confirm("추천 하시겠습니까?")==true){
			//ajax통신 끝나면 리스트 페이지 이동
			var formData = $("form[name=frm]").serialize(); //값을 다가지고와서 변수에 담는다 (리스트형식으로 값이 들어감)
			$.ajax({
				type:"POST",
				url: "<c:url value='/LikeUpSelect.do'/>",
				dataType:"text",
				data: formData,
				success: function(result){
					if(result == 'ok'){
						alert("추천이 완료되었습니다.");
						LikeSelect();
					}
					if(result == 'fal'){
						alert("이미 추천한 상품입니다.");
					}
				},
				error: function(result){
					alert('에러가 발생하였습니다.');
					return;
				},
			});
		}
	});
});
</script>
<!-- 여기서부터 jsp 소스넣기  -->
<button type="button" class="btn btn-success btn-s-xs" id="LikeUp">추천</button>
<%@ include file="/WEB-INF/include/footer.jsp" %>