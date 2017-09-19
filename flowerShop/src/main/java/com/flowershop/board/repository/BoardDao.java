package com.flowershop.board.repository;

import java.util.ArrayList;
import java.util.Map;

import com.flowershop.board.domain.BoardVo;

public interface BoardDao {

	void insert(BoardVo vo)throws Exception;

	int totalCount()throws Exception;

	ArrayList<BoardVo> getBoardlist(Map<String, Integer> map) throws Exception;

}
