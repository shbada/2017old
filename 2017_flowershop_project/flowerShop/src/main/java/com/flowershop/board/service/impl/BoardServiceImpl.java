package com.flowershop.board.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.board.domain.BoardList;
import com.flowershop.board.domain.BoardVo;
import com.flowershop.board.repository.BoardDao;
import com.flowershop.board.service.BoardService;
import com.flowershop.login.domain.UserVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public void insert(BoardVo vo) throws Exception {
		boardDao.insert(vo);
	}

	@Override
	public BoardList getBoardList(int pageNo) throws Exception {
		int totalCount = boardDao.totalCount();					// 페이지 전체 글의 갯수 가져오기

		BoardList list = new BoardList(pageNo, totalCount); 	// 페이징 작업
		int startNo = list.getStartNo();
		int endNo = list.getEndNo();
		Map<String, Integer> map = new HashedMap();
		map.put("startNo", startNo);
		map.put("endNo", endNo);

		ArrayList<BoardVo> R = boardDao.getBoardlist(map);	// 실제 게시판 글 가져오
//		for (RboardVO vo : R) {
//			vo.setCommentCount(dao.commentCount(vo.getIdx())); // 각 글의 댓글 갯수를
//																// 불러온다.
//		}
		list.setList(R);
		return list;
	}

	@Override
	public void increment(int board_no) throws Exception{
		boardDao.increment(board_no);
	}

	@Override
	public BoardVo selectContent(int board_no) throws Exception {
		return (BoardVo) boardDao.selectContent(board_no);
	}

	@Override
	public void replyInsert(BoardVo vo) throws Exception {
//		System.out.println(vo.getBoard_no());
//		int replyCount = boardDao.getReplyCount(vo);			 //  해당글의 답변글이 몇개인지 가져온다.
//		vo.setBoard_seq(vo.getBoard_seq()+replyCount);			 //  해당글의 seq + replyCount 를 해준다 (이렇게 해야 댓글이 순서대로 들어간다.)
		int board_no = vo.getBoard_no();
		while(board_no != -1) {					//  해당글의 바로 전 부모글이 없으면(-1)  flase  
			boardDao.incrementBRC(board_no);							//  답변을 달려는 부모글(가지고 있는vo)의 board_no를 가져가서 board_reply_count 를 +1 해준다.
			board_no = boardDao.getBefore_ref(board_no);	//  getBefore_ref() 는 해당글의 before_ref를 리턴하는 메소드 입니다.  
		}														//  그 동시에 현재 vo.setBoard_no 에 넣어준다.
		vo.setBoard_reply_count(boardDao.getReply_count(vo.getBoard_no()));	// 해당글의 reply_count 를 가져와서 incrementSeq하는데 사용한다.
		boardDao.incrementSeq(vo);								 //  해당글의 답변이 들어갈 글의 위치를 비워두기 위해서 해당위치 의 글들에 board_seq + 1 을 모두 해준다.
		boardDao.replyInsert(vo);								 //  해당글의 답변글을 비워둔 자리에 넣어준다.
	}

	@Override
	public void updateContent(BoardVo vo) throws Exception {
		boardDao.updateContent(vo);
	}

	@Override
	public void deleteContent(BoardVo boardVo) throws Exception {
		
		if(boardVo.getBoard_reply_count() == 0) {
			int board_no = boardDao.getBefore_ref(boardVo.getBoard_no());
			if(board_no != -1){
				boardDao.subBRC(board_no);
				board_no = boardDao.getBefore_ref(board_no);
			}
			boardDao.deleteContent(boardVo.getBoard_no());
		} else {
			boardDao.fixContent(boardVo.getBoard_no());
		}
		
	}

	@Override
	public void incrementCommentCount(int board_no) throws Exception {
		boardDao.incrementCommentCount(board_no);
	}

	@Override
	public String getboard_no_userId(int board_no) throws Exception {
		return boardDao.getboard_no_userId(board_no);
	}
	
}
