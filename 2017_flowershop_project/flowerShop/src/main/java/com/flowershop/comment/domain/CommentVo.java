package com.flowershop.comment.domain;

public class CommentVo {

	private int board_no;
	private int comment_no;
	private int comment_start_ref;
	private int comment_before_ref;
	private int comment_reply_count;
	private int comment_lev;
	private int comment_seq;
	private String comment_content;
	private String comment_regdate;
	private String comment_modidate;
	private int comment_scryn;
	private String user_id;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getComment_start_ref() {
		return comment_start_ref;
	}
	public void setComment_start_ref(int comment_start_ref) {
		this.comment_start_ref = comment_start_ref;
	}
	public int getComment_before_ref() {
		return comment_before_ref;
	}
	public void setComment_before_ref(int comment_before_ref) {
		this.comment_before_ref = comment_before_ref;
	}
	public int getComment_reply_count() {
		return comment_reply_count;
	}
	public void setComment_reply_count(int comment_reply_count) {
		this.comment_reply_count = comment_reply_count;
	}
	public int getComment_lev() {
		return comment_lev;
	}
	public void setComment_lev(int comment_lev) {
		this.comment_lev = comment_lev;
	}
	public int getComment_seq() {
		return comment_seq;
	}
	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_regdate() {
		return comment_regdate;
	}
	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}
	public String getComment_modidate() {
		return comment_modidate;
	}
	public void setComment_modidate(String comment_modidate) {
		this.comment_modidate = comment_modidate;
	}
	public int getComment_scryn() {
		return comment_scryn;
	}
	public void setComment_scryn(int comment_scryn) {
		this.comment_scryn = comment_scryn;
	}
	
	
}
