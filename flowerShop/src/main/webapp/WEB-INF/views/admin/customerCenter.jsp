<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<form action="" method="post">
		<table class="table table-bordered">
	    	<caption>문의글</caption>
	    	<tbody>        
	            <tr>
	                <th>제목: </th>
	                <td><input type="text" placeholder="제목을 입력하세요. " name="subject" class="form-control"/></td>
	            </tr>
	            <tr>
	                <th>내용: </th>
	                <td><textarea cols="10" placeholder="내용을 입력하세요. " name="content" class="form-control"></textarea></td>
	            </tr>
	            <tr>
	                <th>첨부파일: </th>
	                <td><input type="text" placeholder="파일을 선택하세요. " name="filename" class="form-control"/></td>
	            </tr>
	            <tr>
	                <th>비밀번호: </th>
	                <td><input type="password" placeholder="비밀번호를 입력하세요" class="form-control"/></td>
	            </tr>
	            <tr>
	                <td colspan="2">
	                    <input type="button" value="등록" onclick="" class="btn btn-success"/>
	                    <input type="button" value="reset" class="btn btn-default"/>
	                    <input type="button" value="글 목록으로... " class="btn btn-primary" onclick=""/>                    
	                </td>
	            </tr>        
	    	</tbody>
		</table>
	</form>
</div>
</body>
</html>
<%@ include file="/WEB-INF/include/footer.jsp" %>