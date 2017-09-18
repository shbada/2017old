package com.flowershop.board.domain;

public class BoardVo {

	private int board_no;			// 입력되는 순서대로 부여되는 일련번호
	private int board_ref;			// 게시글의 글번호
	private int board_lev;			// 답변의 레벨
	private int board_seq;			// 답변글의 일련번호
	private String board_writer;		// 작성자 이름
	private String board_title;		// 글 제목
	private String board_content;		// 글 내용
	private int board_viewcnt;			//글 조회수
	private int commentCount;		//댓글의 개수
	private String board_regdate;			// 글 작성일
	private String board_modidate;		// 글 수정일
	private String board_deldate;			// 글 삭제날짜
	private String user_id;			// 회원 아이디
	
	
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getBoard_ref() {
		return board_ref;
	}
	public void setBoard_ref(int board_ref) {
		this.board_ref = board_ref;
	}
	public int getBoard_lev() {
		return board_lev;
	}
	public void setBoard_lev(int board_lev) {
		this.board_lev = board_lev;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_viewcnt() {
		return board_viewcnt;
	}
	public void setBoard_viewcnt(int board_viewcnt) {
		this.board_viewcnt = board_viewcnt;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getBoard_modidate() {
		return board_modidate;
	}
	public void setBoard_modidate(String board_modidate) {
		this.board_modidate = board_modidate;
	}
	public String getBoard_deldate() {
		return board_deldate;
	}
	public void setBoard_deldate(String board_deldate) {
		this.board_deldate = board_deldate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
/*board_no NUMBER NOT NULL,  글 번호 
board_title VARCHAR2(50),  글 제목 
board_writer VARCHAR2(50),  작성자 이름 
board_content VARCHAR2(1000),  글 내용 
board_viewcnt NUMBER,  글 조회수 
board_regdate VARCHAR2(50),  글 작성날짜 
board_modidate VARCHAR2(50),  글 수정날짜 
board_deldate VARCHAR2(50),  글 삭제날짜 
user_id VARCHAR2(20)  회원 아이디 */