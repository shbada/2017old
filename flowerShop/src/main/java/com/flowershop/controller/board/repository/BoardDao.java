package com.flowershop.controller.board.repository;

import com.flowershop.controller.board.domain.BoardVo;

public interface BoardDao {

	void insert(BoardVo vo)throws Exception;
}
