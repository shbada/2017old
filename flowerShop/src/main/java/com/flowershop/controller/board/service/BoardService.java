package com.flowershop.controller.board.service;

import javax.servlet.http.HttpServletRequest;

import com.flowershop.controller.board.domain.BoardVo;

public interface BoardService {

	void insert(BoardVo vo) throws Exception;

	
}
