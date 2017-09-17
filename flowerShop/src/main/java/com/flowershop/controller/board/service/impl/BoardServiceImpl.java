package com.flowershop.controller.board.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.controller.board.domain.BoardVo;
import com.flowershop.controller.board.repository.BoardDao;
import com.flowershop.controller.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public void insert(BoardVo vo) throws Exception {
		boardDao.insert(vo);
	}
	
	

	
}
