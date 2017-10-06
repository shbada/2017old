package com.flowershop.product.domain;

public class ProductVo {
	private int product_no;
	private String product_name;
	private int product_price;
	private String product_comment;
	private String product_regdate;
	private String product_url;
	private int product_mod;
	private int product_buycnt;
	private String product_saleyn;
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
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_comment() {
		return product_comment;
	}
	public void setProduct_comment(String product_comment) {
		this.product_comment = product_comment;
	}
	public String getProduct_regdate() {
		return product_regdate;
	}
	public void setProduct_regdate(String product_regdate) {
		this.product_regdate = product_regdate;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	public int getProduct_mod() {
		return product_mod;
	}
	public void setProduct_mod(int product_mod) {
		this.product_mod = product_mod;
	}
	public int getProduct_buycnt() {
		return product_buycnt;
	}
	public void setProduct_buycnt(int product_buycnt) {
		this.product_buycnt = product_buycnt;
	}
	public String getProduct_saleyn() {
		return product_saleyn;
	}
	public void setProduct_saleyn(String product_saleyn) {
		this.product_saleyn = product_saleyn;
	}
	@Override
	public String toString() {
		return "ProductVo [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_comment=" + product_comment + ", product_regdate=" + product_regdate
				+ ", product_url=" + product_url + ", product_mod=" + product_mod + ", product_buycnt=" + product_buycnt
				+ ", product_saleyn=" + product_saleyn + "]";
	}
	
}
