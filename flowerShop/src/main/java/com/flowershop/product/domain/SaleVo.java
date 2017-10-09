package com.flowershop.product.domain;

public class SaleVo{
	
	private int product_no;
	private int sale_percent;
	private int product_price;
	private int sale_price;
	
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getSale_percent() {
		return sale_percent;
	}
	public void setSale_percent(int sale_percent) {
		this.sale_percent = sale_percent;
	}
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	@Override
	public String toString() {
		return "SaleVo [product_no=" + product_no + ", sale_percent=" + sale_percent + ", product_price="
				+ product_price + ", sale_price=" + sale_price + "]";
	}
	
}
