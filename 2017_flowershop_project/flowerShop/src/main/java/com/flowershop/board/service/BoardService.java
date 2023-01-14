package com.flowershop.board.service;

import com.flowershop.board.domain.BoardList;
import com.flowershop.board.domain.BoardVo;
import com.flowershop.login.domain.UserVo;

public interface BoardService {

	void insert(BoardVo vo) throws Exception;

	BoardList getBoardList(int pageNo) throws Exception;

	void increment(int board_no) throws Exception;

	BoardVo selectContent(int board_no) throws Exception;

	void replyInsert(BoardVo vo)throws Exception;

	void updateContent(BoardVo vo)throws Exception;

	void deleteContent(BoardVo boardVo)throws Exception;

	void incrementCommentCount(int board_no)throws Exception;

	String getboard_no_userId(int board_no)throws Exception;

}
