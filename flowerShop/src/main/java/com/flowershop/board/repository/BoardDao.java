package com.flowershop.board.repository;

import com.flowershop.board.domain.BoardVo;

public interface BoardDao {

	void insert(BoardVo vo)throws Exception;
}
