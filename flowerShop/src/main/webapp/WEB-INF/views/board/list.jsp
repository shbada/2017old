<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<script>

</script>
<!-- 여기서부터 jsp 소스넣기  -->
<table width="90%" border="1" align="center">
	<tr>
		<th colspan="5"><h2>게시판 목록보기</h2></th>
	</tr>
	<tr>
		<td colspan="5" align="right">
			${R.totalCount}개
			(${R.currentPage}/${R.totalPage}Page)
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>

<c:forEach var="vo" items="${R.list}">
	<tr>
		<td align="center">${vo.board_no}</td>
		<td align="center">${vo.board_writer}</td>
		<td>
		<c:if test="${vo.board_lev > 0}">
			<c:forEach var="i" begin="0" end="${vo.board_lev}" step="1">
				&nbsp;&nbsp;&nbsp;
			</c:forEach>
			RE :&nbsp;
		</c:if>
		<a href="increment?pageNo=${pageNo}&board_no=${vo.board_no}">${vo.board_title}</a>
		(${vo.commentCount})</td>
		<td align="center">${vo.board_regdate}</td>
		<td align="center">${vo.board_viewcnt}</td>
	</tr>
</c:forEach>
	
	<tr>
		<td colspan="5" align="center">	
		
<c:if test="${R.startPage > 10}">
		[<a href='?page=${R.startPage - 1}'>이전</a>]
</c:if>
<c:forEach var="i" begin="${R.startPage}" end="${R.endPage}" step="1">
	<c:if test="${R.currentPage == i}">
		[<span id='currentPage'>${i}</span>]
	</c:if>		
	<c:if test="${R.currentPage != i}">
		[<a href='?page=${i}'>${i}</a>]
	</c:if>
</c:forEach>

<c:if test="${R.endPage < R.totalPage}">
		[<a href='?page=${R.endPage + 1}'>이후</a>]
</c:if>	
		</td>
	</tr>
	<tr>
		<td colspan="5" align="right">
			<input type="button" onclick="location.href='insert'" value="쓰기"/>
		</td>
	</tr>
</table>
<%@ include file="/WEB-INF/include/footer.jsp" %>