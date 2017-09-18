package com.flowershop.afterReply.domain;

public class AfterReplyVo {
	
	private int afterNo; //후기 댓글 번호
	private int afterLevel; //후기 평점
	private String afterContent; //후기댓글 내용
	private int productNo; //상품 번호 
	private String productName; //상품 이름
	private String productUrl; //상품 사진경로
	private String userId;
	private String userName;
	
	public int getAfterNo() {
		return afterNo;
	}
	public void setAfterNo(int afterNo) {
		this.afterNo = afterNo;
	}
	public int getAfterLevel() {
		return afterLevel;
	}
	public void setAfterLevel(int afterLevel) {
		this.afterLevel = afterLevel;
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
	public String getAfterContent() {
		return afterContent;
	}
	public void setAfterContent(String afterContent) {
		this.afterContent = afterContent;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "AfterReplyVo [afterNo=" + afterNo + ", afterLevel=" + afterLevel + ", afterContent=" + afterContent
				+ ", productNo=" + productNo + ", productName=" + productName + ", productUrl=" + productUrl
				+ ", userId=" + userId + ", userName=" + userName + "]";
	}
	
}
