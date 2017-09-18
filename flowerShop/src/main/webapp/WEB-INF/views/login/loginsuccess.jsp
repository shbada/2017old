<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

</head>
<body>

    <h1>Login Success!!!</h1>
    <h2>${user.user_name} 님 환영합니다. </h2>
    <p></p>
    <h3><a href="/home">home</a></h3>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <h3><a href="javascript:alert('관리자군요.')";>관리자만 보임</a></h3>
    </sec:authorize>
    <h3><a href="/logout">logout</a></h3>

</body>
</html>