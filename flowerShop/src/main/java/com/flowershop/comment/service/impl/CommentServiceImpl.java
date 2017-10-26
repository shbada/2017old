package com.flowershop.comment.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.board.service.BoardService;
import com.flowershop.comment.domain.CommentVo;
import com.flowershop.comment.repository.CommentDao;
import com.flowershop.comment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Autowired
	BoardService boardService;

	@Override
	public void insertComment(CommentVo vo) throws Exception {
		commentDao.insertComment(vo);
	}

	@Override
	public void updateComment(Map<String, String> map) throws Exception {
		commentDao.updateComment(map);
	}

	@Override
	public ArrayList<CommentVo> selectComentList(int board_no) throws Exception {
		return commentDao.selectComentList(board_no);
	}

	@Override
	public void incrementCommentCount(int board_no) throws Exception {
		boardService.incrementCommentCount(board_no);
	}

	@Override
	public void del_comment(int comment_no, int board_no, int comment_reply_count) throws Exception {
		
		if(comment_reply_count == 0) {
			int comment_no2 = commentDao.getBefore_ref(comment_no);
			while(comment_no2 != -1) {					//  해당글의 바로 전 부모글이 없으면(-1)  flase
				commentDao.subCRC(comment_no2);							// 삭제하는 글의 부모글을 가져가서 자식숫자를 줄여준다. 
				comment_no2 = commentDao.getBefore_ref(comment_no2);	// 그리고 해당 글의 before_ref 를 가져와서 최상위 부모인지 확인해준다.
			}
			commentDao.del_comment(comment_no);
			commentDao.del_comment_count(board_no);						// 댓글을 지웠기 때문에 게시글의 comment_count도 -1 해준다.
		} else {
			commentDao.fix_comment(comment_no);							// 자식글이 있기 때문에 댓글은 삭제가 되지않고 수정된다.
		}
	}

	@Override
	public CommentVo getCommentVo(int comment_no) throws Exception {
		return commentDao.getCommentVo(comment_no);
	}

	@Override
	public void commentReplyInsert(CommentVo commentVo) throws Exception {
		int comment_no = commentVo.getComment_no();
		while(comment_no != -1) {					//  해당글의 바로 전 부모글이 없으면(-1)  flase  
			commentDao.incrementCRC(comment_no);							//  답변을 달려는 부모글(가지고 있는vo)의 comment_no를 가져가서 comment_reply_count 를 +1 해준다.
			comment_no = commentDao.getBefore_ref(comment_no);	//  getBefore_ref() 는 해당글의 before_ref를 리턴하는 메소드 입니다.  
		}														//  그 동시에 현재 vo.setBoard_no 에 넣어준다.
		commentVo.setComment_reply_count(commentDao.getReply_count(commentVo.getComment_no()));	// 해당글의 reply_count 를 가져와서 incrementSeq하는데 사용한다.
		commentDao.incrementCommentSeq(commentVo);								 //  해당글의 답변이 들어갈 글의 위치를 비워두기 위해서 해당위치 의 글들에 board_seq + 1 을 모두 해준다.
		commentDao.commentReplyInsert(commentVo);			
	}
	

	
}












