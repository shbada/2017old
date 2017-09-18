package com.flowershop.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.board.domain.BoardVo;
import com.flowershop.board.repository.BoardDao;
import com.flowershop.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public void insert(BoardVo vo) throws Exception {
		boardDao.insert(vo);
	}
	
	

	
}
