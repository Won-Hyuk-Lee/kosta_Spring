package com.lec05.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec04.di.board.BoardDAO;
import com.lec04.di.board.BoardVO;
import com.lec04.di.board.ReplyVO;

@Controller
public class BoardRestController {
	
	@Autowired
	private BoardDAO boardDAO;
		
	
	
	// http://localhost:8088/_ctxpath_/board_detail_rest?seq=3
	@RequestMapping(value = "/board_detail_rest")
	public String ctlBoardDetail(Model model, @RequestParam("seq") int seq){
		//------------------------------------------------------
		//상세,댓글목록 각각 사용할 경우
		//	트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} () 
		//	댓글목록 EL  : ${KEY_REPLYLIST}
		//------------------------------------------------------
		BoardVO bvo = boardDAO.boardSelectOne(seq);
		model.addAttribute("KEY_BOARDVO", bvo);
		ArrayList<ReplyVO> rlist = boardDAO.replySelect(seq);
		model.addAttribute("KEY_REPLYLIST", rlist);
		
		//------------------------------------------------------
		//조인을 사용할 경우
		//	트랜잭션 : SELECT JOIN(게시물상세 + 댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} 
		//	댓글목록 EL  : ${KEY_BOARDVO.replies}
		//------------------------------------------------------
//		BoardVO bvo = boardDAO.boardReplySelect(seq);
//		model.addAttribute("KEY_BOARDVO", bvo);
		
		return "lec04_board/board_detail";						//   /   lec04_board/board_detail  .jsp
	}
}
