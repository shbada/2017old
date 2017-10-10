package com.flowershop.product.domain;

import org.springframework.web.multipart.MultipartFile;

public class ProductVo{
	private int product_no;
    private String product_name; 
    private int product_price;
    private String product_desc; 
    private String product_url; 
    private MultipartFile product_photo;
	private String page_cnt;
	private String product_regdate;
	private int product_mod;
	private int product_buycnt;
	private String product_saleyn;
	private String user_id;
	private int like;
	private String sale_price;
	
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

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_url() {
		return product_url;
	}

	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}

	public MultipartFile getProduct_photo() {
		return product_photo;
	}

	public void setProduct_photo(MultipartFile product_photo) {
		this.product_photo = product_photo;
	}

	public String getPage_cnt() {
		return page_cnt;
	}

	public void setPage_cnt(String page_cnt) {
		this.page_cnt = page_cnt;
	}

	public String getProduct_regdate() {
		return product_regdate;
	}

	public void setProduct_regdate(String product_regdate) {
		this.product_regdate = product_regdate;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	

	public String getSale_price() {
		return sale_price;
	}

	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}

	@Override
	public String toString() {
		return "ProductVo [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_desc=" + product_desc + ", product_url=" + product_url + ", product_photo="
				+ product_photo + ", page_cnt=" + page_cnt + ", product_regdate=" + product_regdate + ", product_mod="
				+ product_mod + ", product_buycnt=" + product_buycnt + ", product_saleyn=" + product_saleyn
				+ ", user_id=" + user_id + ", like=" + like + ", sale_price=" + sale_price + "]";
	}
	
	
}
