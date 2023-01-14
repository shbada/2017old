package com.flowershop.board.domain;

import java.util.ArrayList;

public class BoardList {

	private ArrayList<BoardVo> list;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private int currentPage;
	private int startNo;
	private int endNo;
	private int currentBlock;
	private int startPage;
	private int endPage;

	public BoardList(int pageNo, int totalCount) {
		pageSize = 10;
		this.totalCount = totalCount;
		totalPage = (totalCount-1) / pageSize + 1;
		currentPage = pageNo;
		if(currentPage>totalPage) currentPage = totalPage;
		startNo = (currentPage-1) * pageSize + 1;
		endNo = startNo + pageSize - 1;
		if(endNo > totalCount) endNo = totalCount;
		currentBlock = (currentPage-1) / pageSize + 1;		// 현재블록
		startPage = (currentBlock-1) * pageSize+1;			// 페이지 시작번호
		endPage = startPage + pageSize -1;
		if(endPage > totalPage) endPage = totalPage;		// 경계검사
	}

	public ArrayList<BoardVo> getList() {
		return list;
	}

	public void setList(ArrayList<BoardVo> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	

}
