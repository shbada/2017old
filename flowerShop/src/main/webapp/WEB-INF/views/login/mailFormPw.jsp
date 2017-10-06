<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h4>메일 보내기</h4>
  <form action="${pageContext.request.contextPath}/mailSendingPw" method="post">
    <div align="center"><!-- 받는 사람 이메일 -->
      아이디 :<input type="text" name="user_id" size="80" style="width:10%" placeholder="아이디를 입력해주세요." class="form-control" >
      이메일 :<input type="text" name="user_email" size="80" style="width:10%" placeholder="이메일을 입력해주세요." class="form-control" >
    </div>     
    <p>
    <div align="center">
      <input type="submit" value="비밀번호 찾기" class="btn btn-warning">   
    </div>
  </form><br>
  ${msg }
</div>
</body>
</html>