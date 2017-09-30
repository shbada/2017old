<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<link href='/resources/css/productList.css' rel='stylesheet' type='text/css'>
<br>
<div align="center">
	<h3>상품 목록 리스트</h3>	
	<table>				
		<tr class="best">			
			<td>
				<a href="${path }/flower1"><img src="/resources/flowers/flower1.png" alt="꽃1" width="350" height="350"></a>
				<h5 class="name">꽃1</h5>
				<img src="/resources/flowers/best.png" width="50" height="25">				
			</td>
			<td>
				<a href="${path }/flower2"><img src="/resources/flowers/flower2.png" alt="꽃2" width="350" height="350"></a>
				<h5 class="name">꽃2</h5>
				<img src="/resources/flowers/best.png" width="50" height="25">
			</td>
			<td>
				<a href="${path }/flower3"><img src="/resources/flowers/flower3.png" alt="꽃3" width="350" height="350"></a>
				<h5 class="name">꽃3</h5>
				<img src="/resources/flowers/best.png" width="50" height="25">
			</td>
		</tr>
		<tr>
			<td>
				<a href="${path }/flower4"><img src="/resources/flowers/flower4.png" alt="꽃4" width="200" height="200"></a>
				<h5 class="name">꽃4</h5>
			</td>
			<td>
				<a href="${path }/flower5"><img src="/resources/flowers/flower5.png" alt="꽃5" width="200" height="200"></a>
				<h5 class="name">꽃5</h5>
			</td>
			<td>
				<a href="${path }/flower6"><img src="/resources/flowers/flower6.png" alt="꽃6" width="200" height="200"></a>
				<h5 class="name">꽃6</h5>
			</td>
		</tr>
		<tr>
			<td>
				<a href="${path }/flower7"><img src="/resources/flowers/flower7.png" alt="꽃7" width="200" height="200"></a>
				<h5 class="name">꽃7</h5>
			</td>
			<td>
				<a href="${path }/flower8"><img src="/resources/flowers/flower8.png" alt="꽃8" width="200" height="200"></a>
				<h5 class="name">꽃8</h5>
			</td>
			<td>
				<a href="${path }/flower9"><img src="/resources/flowers/flower9.png" alt="꽃9" width="200" height="200"></a>
				<h5 class="name">꽃9</h5>
			</td>
		</tr>		
	</table>
</div>
<br>
<%@ include file="/WEB-INF/include/footer.jsp" %>