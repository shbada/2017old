package com.flowershop.cart.domain;

public class CartVo {
	
	private int CartNo; //장바구니 번호
	private int proudctAmount; //상품 수량
	private String userId; //회원 아이디
	private int productNo; //상품번호
	private String productName; //상품 이름
	private String productUrl; //상품 사진경로
	private int productPrice; //상품 가격
	
	public int getCartNo() {
		return CartNo;
	}
	public void setCartNo(int cartNo) {
		CartNo = cartNo;
	}
	public int getProudctAmount() {
		return proudctAmount;
	}
	public void setProudctAmount(int proudctAmount) {
		this.proudctAmount = proudctAmount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "CartVo [CartNo=" + CartNo + ", proudctAmount=" + proudctAmount + ", userId=" + userId + ", productNo="
				+ productNo + ", productName=" + productName + ", productUrl=" + productUrl + ", productPrice="
				+ productPrice + "]";
	}
	
}
