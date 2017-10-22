package com.flowershop.point.domain;

public class PointVo {
	private String point_yn;
	private String point_regdate;
	private Integer point;
	
	public PointVo(){
		this.point = 0;
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
	@Override
	public String toString() {
		return "PointVo [point_yn=" + point_yn + ", point_regdate=" + point_regdate + ", point=" + point + "]";
	}
	
	
}
