<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/board.css">
<!-- 여기서부터 jsp 소스넣기  -->
<table width="60%" border="1" align="center">
	<tr>
		<th colspan="5"><h2 style="text-align:center;">자유 게시판</h2></th>
	</tr>
	<tr>
		<td colspan="5" align="right">
			${R.totalCount}개
			(${R.currentPage}/${R.totalPage}Page)
		</td>
	</tr>
	<tr class="board_header">
		<th>번호</th>
		<th >제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>

<c:forEach var="vo" items="${R.list}">
	<tr class="header_contents">
		<td class="board_no">${vo.board_no}</td>
		<td class="title">
		<c:if test="${vo.board_lev > 0}">
			<c:forEach var="i" begin="0" end="${vo.board_lev}" step="1">
				&nbsp;&nbsp;&nbsp;
			</c:forEach>
			RE :&nbsp;
		</c:if>
		<c:if test="${vo.board_deldate == 'deleted'}">
			${vo.board_title}
		</c:if>
		<c:if test="${vo.board_deldate != 'deleted'}">
			<a href="increment?pageNo=${pageNo}&board_no=${vo.board_no}">${vo.board_title}</a>[${vo.commentCount}]
		</c:if>
		</td>
		<td class="writer">${vo.board_writer}</td>
		<td class="regdate">${vo.board_regdate}</td>
		<td class="viewcnt">${vo.board_viewcnt}</td>
	</tr>
</c:forEach>
	
	<tr>
		<td colspan="5" align="center">	
		
<c:if test="${R.startPage > 10}">
		[<a href='?pageNo=${R.startPage - 1}'>이전</a>]
</c:if>
<c:forEach var="i" begin="${R.startPage}" end="${R.endPage}" step="1">
	<c:if test="${R.currentPage == i}">
		[<span id='currentPage'>${i}</span>]
	</c:if>		
	<c:if test="${R.currentPage != i}">
		[<a href='?pageNo=${i}'>${i}</a>]
	</c:if>
</c:forEach>

<c:if test="${R.endPage < R.totalPage}">
		[<a href='?pageNo=${R.endPage + 1}'>이후</a>]
</c:if>	
		</td>
	</tr>
	<tr>
		<td colspan="5" align="right">
			<input type="button" onclick="location.href='write'" value="쓰기"/>
		</td>
	</tr>
</table>
<%@ include file="/WEB-INF/include/footer.jsp" %>