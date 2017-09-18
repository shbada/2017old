package com.flowershop.board.repository;

import java.util.ArrayList;

import com.flowershop.board.domain.BoardList;
import com.flowershop.board.domain.BoardVo;

public interface BoardDao {

	void insert(BoardVo vo)throws Exception;

	int totalCount()throws Exception;

	ArrayList list(BoardList list) throws Exception;

}
