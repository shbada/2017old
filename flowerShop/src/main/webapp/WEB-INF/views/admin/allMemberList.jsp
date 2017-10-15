<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/include/header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>전체 회원 목록</title>
</head>
<body>
	<br>	
	<div align="center">
		<table border="1" width="1200px">
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>연락처</th>
			<th>주소1</th>
			<th>주소2</th>
			<th>주소3</th>
			<th>주소4</th>
			<th>회원등급</th>
			<th>가입날짜</th>
			<th>적립금</th>			
			<th>관리자여부</th>			
		</tr>
		<c:forEach var="member" items="${list }">
			<tr>
				<td>${member.user_no }</td>
				<td>${member.user_id }</td>				
				<td>${member.user_name }</td>
				<td>${member.user_email }</td>
				<td>${member.user_phone }</td>
				<td>${member.user_addr1 }</td>
				<td>${member.user_addr2 }</td>
				<td>${member.user_addr3 }</td>
				<td>${member.user_addr4 }</td>
				<td>${member.user_grade }</td>
				<td>${member.user_regdate }</td>
				<td>${member.user_point }</td>				
				<td>${member.isadmin }</td>				
			</tr>
		</c:forEach> <!-- 컨트롤러의 addAttribute의 list -->
	</table>
	</div>	
	<br>
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>