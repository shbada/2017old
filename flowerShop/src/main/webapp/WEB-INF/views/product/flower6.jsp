<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<br>
	<div align="center">	
		<table border="1">
			<tr>
				<td rowspan="4">
					<img src="/resources/flowers/flower6.png" alt="꽃6" width="250" height="250">	
				</td>
				<td colspan="2">
					<h4 align="center">꽃6</h4>
				</td>				
			</tr>
			<tr>
				<td colspan="2">
					<h5 align="center">6900원</h5>
				</td>
			</tr>
			<tr>
				<td rowspan="2" class="count">
					<h5 align="center">수량</h5>
					<input type="number" name="count">
				</td>
				<td class="cart">					
					<a href="${path }/cartList"><input type="button" value="장바구니"></a>
				</td>
			</tr>			
			<tr>
				<td class="buy_now">
					<a href="${path }/buyForm"><input type="button" value="바로구매"></a>
				</td>
			</tr>
		</table>				
	</div>
<br>
<%@ include file="/WEB-INF/include/footer.jsp" %>