package com.lec04.di.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public int svcBoardInsert(BoardVO bvo) {
		int insertRows = boardDAO.boardInsert(bvo);
		return insertRows;			
	}
	
	public ArrayList<BoardVO> svcBoardList(){
		ArrayList<BoardVO> list = boardDAO.boardSelect();
		return list;     				  
	}
	
	public Map ctlBoardDetail(int seq){
		//------------------------------------------------------
		//상세,댓글목록 각각 사용할 경우
		//	트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} () 
		//	댓글목록 EL  : ${KEY_REPLYLIST}
		//------------------------------------------------------
		BoardVO bvo              = boardDAO.boardSelectOne(seq);
		ArrayList<ReplyVO> rlist = boardDAO.replySelect(seq);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("my_bvo",   bvo);
		map.put("my_rlist", rlist);
		
		//------------------------------------------------------
		//조인을 사용할 경우
		//	트랜잭션 : SELECT JOIN(게시물상세 + 댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} 
		//	댓글목록 EL  : ${KEY_BOARDVO.replies}
		//------------------------------------------------------
//		BoardVO bvo = boardDAO.boardReplySelect(seq);
		return map;	
	}
	
	
	public int svcBoardInsert(ReplyVO rvo){
		System.out.println("댓글등록--");
		int insertRows = boardDAO.replyInsert(rvo);
		return insertRows;	
	}

	
	public int svcReplyDel(ReplyVO rvo){
		int deleteRows = boardDAO.replyDelete(rvo.getRseq());
		//상세보기파라미터 : seq
		return deleteRows;
	}
	
	public int svcBoardUpdate(BoardVO bvo){
		int updateRows = boardDAO.boardUpdate(bvo);
		//상세보기파라미터 : seq
		return updateRows;
	}
	
	public int svcBoardDel(int seq){
		int deleteRows = boardDAO.boardDelete(seq);
		return deleteRows;							
	}
	
	
}
