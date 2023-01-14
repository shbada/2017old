package com.flowershop.buy.domain;

public class BuyVo {

	private int buy_no;
	private int buy_totalPrice;
	private String buy_regDate;
	private String buy_name;
	private String buy_phone;
	private String buy_addr1;
	private String buy_addr2;
	private String buy_addr3;
	private String buy_addr4;
	private int buy_addPoint;
	private int buy_usePoint;
	private String user_id;
	private int product_amount;
	private int product_no;
	private int product_price;
	private String product_name; 
    private String product_url; 
	
	
	public String getBuy_addr4() {
		return buy_addr4;
	}
	public void setBuy_addr4(String buy_addr4) {
		this.buy_addr4 = buy_addr4;
	}
	public int getBuy_no() {
		return buy_no;
	}
	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}
	public int getBuy_totalPrice() {
		return buy_totalPrice;
	}
	public void setBuy_totalPrice(int buy_totalPrice) {
		this.buy_totalPrice = buy_totalPrice;
	}
	public String getBuy_regDate() {
		return buy_regDate;
	}
	public void setBuy_regDate(String buy_regDate) {
		this.buy_regDate = buy_regDate;
	}
	public String getBuy_name() {
		return buy_name;
	}
	public void setBuy_name(String buy_name) {
		this.buy_name = buy_name;
	}
	public String getBuy_phone() {
		return buy_phone;
	}
	public void setBuy_phone(String buy_phone) {
		this.buy_phone = buy_phone;
	}
	public String getBuy_addr1() {
		return buy_addr1;
	}
	public void setBuy_addr1(String buy_addr1) {
		this.buy_addr1 = buy_addr1;
	}
	public String getBuy_addr2() {
		return buy_addr2;
	}
	public void setBuy_addr2(String buy_addr2) {
		this.buy_addr2 = buy_addr2;
	}
	public String getBuy_addr3() {
		return buy_addr3;
	}
	public void setBuy_addr3(String buy_addr3) {
		this.buy_addr3 = buy_addr3;
	}
	public int getBuy_addPoint() {
		return buy_addPoint;
	}
	public void setBuy_addPoint(int buy_addPoint) {
		this.buy_addPoint = buy_addPoint;
	}
	public int getBuy_usePoing() {
		return buy_usePoint;
	}
	public void setBuy_usePoing(int buy_usePoing) {
		this.buy_usePoint = buy_usePoing;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public int getBuy_usePoint() {
		return buy_usePoint;
	}
	public void setBuy_usePoint(int buy_usePoint) {
		this.buy_usePoint = buy_usePoint;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
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
	@Override
	public String toString() {
		return "BuyVo [buy_no=" + buy_no + ", buy_totalPrice=" + buy_totalPrice + ", buy_regDate=" + buy_regDate
				+ ", buy_name=" + buy_name + ", buy_phone=" + buy_phone + ", buy_addr1=" + buy_addr1 + ", buy_addr2="
				+ buy_addr2 + ", buy_addr3=" + buy_addr3 + ", buy_addr4=" + buy_addr4 + ", buy_addPoint=" + buy_addPoint
				+ ", buy_usePoint=" + buy_usePoint + ", user_id=" + user_id + ", product_amount=" + product_amount
				+ ", product_no=" + product_no + ", product_price=" + product_price + ", product_name=" + product_name
				+ ", product_url=" + product_url + "]";
	}

	
}
