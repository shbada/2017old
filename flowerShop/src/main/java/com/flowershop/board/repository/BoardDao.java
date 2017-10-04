package com.flowershop.board.repository;

import java.util.ArrayList;
import java.util.Map;

import com.flowershop.board.domain.BoardVo;

public interface BoardDao {

	void insert(BoardVo vo)throws Exception;

	int totalCount()throws Exception;

	ArrayList<BoardVo> getBoardlist(Map<String, Integer> map) throws Exception;

	void increment(int board_no) throws Exception;

	Object selectContent(int board_no)throws Exception;

	void incrementSeq(BoardVo vo)throws Exception;

	void replyInsert(BoardVo vo)throws Exception;

	int getReplyCount(BoardVo vo)throws Exception;

	void update(BoardVo vo)throws Exception;
	
	
}
