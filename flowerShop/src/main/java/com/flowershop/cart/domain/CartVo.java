package com.flowershop.cart.domain;

public class CartVo {
	
	private int cart_no; //장바구니 번호
	private int product_amount; //상품 수량
	private String user_id; //회원 아이디
	private int product_no; //상품번호
	private String product_name; //상품 이름
	private String product_url; //상품 사진경로
	private int product_price; //상품 가격
	
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	@Override
	public String toString() {
		return "CartVo [cart_no=" + cart_no + ", product_amount=" + product_amount + ", user_id=" + user_id
				+ ", product_no=" + product_no + ", product_name=" + product_name + ", product_url=" + product_url
				+ ", product_price=" + product_price + "]";
	}
	
}
