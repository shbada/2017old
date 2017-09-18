package com.flowershop.board.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowershop.board.domain.BoardVo;
import com.flowershop.board.service.BoardService;

@Controller
public class BoardController {
	
	private Log log = LogFactory.getLog(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/write")
	private String writeFrom() throws Exception{
		return "board/writeForm";
	}
	
	@RequestMapping(value = "/writeOK", method = RequestMethod.POST)
	private String writeInBoard(BoardVo vo) throws Exception {
		boardService.insert(vo);
		return "board_list";
	}
}
