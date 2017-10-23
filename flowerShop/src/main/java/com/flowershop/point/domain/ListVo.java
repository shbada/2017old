package com.flowershop.point.domain;

public class ListVo {
	private int buy_no;
	private String point_yn;
	private String point_regdate;
	private Integer point;
	private int buy_addPoint;
	private int buy_usePoint;
	
	public int getBuy_no() {
		return buy_no;
	}
	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}
	public String getPoint_yn() {
		return point_yn;
	}
	public void setPoint_yn(String point_yn) {
		this.point_yn = point_yn;
	}
	public String getPoint_regdate() {
		return point_regdate;
	}
	public void setPoint_regdate(String point_regdate) {
		this.point_regdate = point_regdate;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public int getBuy_addPoint() {
		return buy_addPoint;
	}
	public void setBuy_addPoint(int buy_addPoint) {
		this.buy_addPoint = buy_addPoint;
	}
	public int getBuy_usePoint() {
		return buy_usePoint;
	}
	public void setBuy_usePoint(int buy_usePoint) {
		this.buy_usePoint = buy_usePoint;
	}
	@Override
	public String toString() {
		return "ListVo [buy_no=" + buy_no + ", point_yn=" + point_yn + ", point_regdate=" + point_regdate + ", point="
				+ point + ", buy_addPoint=" + buy_addPoint + ", buy_usePoint=" + buy_usePoint + "]";
	}
	
	
}
