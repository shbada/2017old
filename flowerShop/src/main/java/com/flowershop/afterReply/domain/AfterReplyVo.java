package com.flowershop.afterReply.domain;

public class AfterReplyVo extends ReplyPageVo{
	
	private int after_no; //후기 댓글 번호
	private int after_level; //후기 평점
	private String after_content; //후기댓글 내용
	private int product_no; //상품 번호 
	private String product_name; //상품 이름
	private String product_url; //상품 사진경로
	private String user_id; //작성자 아이디
	private String user_name; //작성자 이름
	private String product_id;
	private String pageCnt;
	
	public int getAfter_no() {
		return after_no;
	}
	public void setAfter_no(int after_no) {
		this.after_no = after_no;
	}
	public int getAfter_level() {
		return after_level;
	}
	public void setAfter_level(int after_level) {
		this.after_level = after_level;
	}
	public String getAfter_content() {
		return after_content;
	}
	public void setAfter_content(String after_content) {
		this.after_content = after_content;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	
	public String getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}
	
	@Override
	public String toString() {
		return "AfterReplyVo [after_no=" + after_no + ", after_level=" + after_level + ", after_content="
				+ after_content + ", product_no=" + product_no + ", product_name=" + product_name + ", product_url="
				+ product_url + ", user_id=" + user_id + ", user_name=" + user_name + ", product_id=" + product_id
				+ ", pageCnt=" + pageCnt + "]";
	}
	
}
