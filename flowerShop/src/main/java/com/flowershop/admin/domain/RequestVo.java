package com.flowershop.admin.domain;

import java.util.Date;

public class RequestVo {
	
	private String user_id;
	private int request_no;
	private String request_title;
	private String request_content;
	private String request_kind;
	private Date regdate;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getRequest_no() {
		return request_no;
	}
	public void setRequest_no(int request_no) {
		this.request_no = request_no;
	}
	public String getRequest_title() {
		return request_title;
	}
	public void setRequest_title(String request_title) {
		this.request_title = request_title;
	}
	public String getRequest_content() {
		return request_content;
	}
	public void setRequest_content(String request_content) {
		this.request_content = request_content;
	}
	public String getRequest_kind() {
		return request_kind;
	}
	public void setRequest_kind(String request_kind) {
		this.request_kind = request_kind;
	}	
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String toString() {
		return "RequestVo [user_id=" + user_id + ", request_no=" + request_no + ", request_title=" + request_title + ", request_content=" + 
					request_content + ", request_kind=" + request_kind + ", regdate=" + regdate + "]";
	}
		
}
