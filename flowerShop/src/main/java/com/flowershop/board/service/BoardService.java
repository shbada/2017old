package com.flowershop.board.service;

import com.flowershop.board.domain.BoardList;
import com.flowershop.board.domain.BoardVo;

public interface BoardService {

	void insert(BoardVo vo) throws Exception;

	BoardList getBoardList(int pageNo) throws Exception;

	void increment(int board_no) throws Exception;

	BoardVo selectContent(int board_no) throws Exception;

	void replyInsert(BoardVo vo)throws Exception;

	void update(BoardVo vo)throws Exception;

	


}
