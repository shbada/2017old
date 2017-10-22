<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/include/header.jsp" %>
    <jsp:include page="${pageContext.request.contextPath }/top" />    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>메일 보내기</title> 
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h4>메일 보내기</h4>
  <form action="${pageContext.request.contextPath}/mailSending" method="post">  	
    <div align="center"><!-- 받는 사람 이메일 -->
      <input type="text" name="tomail" size="120" style="width:100%" placeholder="상대의 이메일" class="form-control" >
    </div>     
    <div align="center"><!-- 제목 -->
      <input type="text" name="request_title" size="120" style="width:100%" placeholder="제목을 입력해주세요" class="form-control" >
    </div>    
    <div align="center"><!-- 내용 --> 
      <textarea name="request_content" cols="120" rows="12" style="width:100%; resize:none" placeholder="내용을 입력해주세요" class="form-control"></textarea>
    </div>
    <div align="center"><!-- 내용 --> 
      <input type="text" name="user_id" size="120" style="width:100%" placeholder="아이디를 입력해주세요" class="form-control" >
    </div>      
    <div align="center">
      <input type="submit" value="전송" class="btn btn-warning">
    </div>
  </form>
</div>	
</body>
</html>