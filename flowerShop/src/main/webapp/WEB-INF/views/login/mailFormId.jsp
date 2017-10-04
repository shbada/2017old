<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h4>메일 보내기</h4>
  <form action="${pageContext.request.contextPath}/mailSendingId" method="post">
      이메일 : <input type="text" name="user_email" placeholder="이메일을 입력해주세요." class="form-control" >   
      <input type="submit" value="아이디 찾기" class="btn btn-warning">
  </form><br>
  ${msg }
</body>
</html>