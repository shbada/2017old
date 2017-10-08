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

	void update(BoardVo vo)throws Exception;

	void deleteContent(Map map)throws Exception;

	void incrementBRC(int board_no)throws Exception;

	int getBefore_ref(int board_no)throws Exception;

	int getReply_count(int board_no)throws Exception;

	void fixContent(Map<String, String> map)throws Exception;

}
