package com.lec05.rest;

import org.springframework.stereotype.Controller;              //@Controller
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired; //@Autowired
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute; //@ModelAttribute	
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;  //@RequestMapping
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController  {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping(value = "/board_insert", method = RequestMethod.POST)
	public String ctlBoardInsert(@ModelAttribute BoardVO bvo) {
		int insertRows = boardDAO.boardInsert(bvo);
		return "redirect:/board_list";						//   /board_list
	}
	
	@RequestMapping(value = "/board_list")
	public String ctlBoardList(Model model){
		ArrayList<BoardVO> list = boardDAO.boardSelect();
		model.addAttribute("KEY_BOARDLIST", list);
		return "lec05_board/board_list";     				//   /  lec05_board/board_list  .jsp  
	}
	
	@RequestMapping(value = "/board_detail")
	public String ctlBoardDetail(Model model, @RequestParam("seq") int seq){
		//------------------------------------------------------
		//상세만 가져가고 ,댓글목록은 (REST)로 출력
		//	트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} () 
		//	댓글목록 EL  : ${KEY_REPLYLIST}
		//------------------------------------------------------
		BoardVO bvo = boardDAO.boardSelectOne(seq);
		model.addAttribute("KEY_BOARDVO", bvo);
		//ArrayList<ReplyVO> rlist = boardDAO.replySelect(seq);
		//model.addAttribute("KEY_REPLYLIST", rlist);
		
		
		return "lec05_board/board_detail";						//   /   lec05_board/board_detail  .jsp
	}
	
	
	

	//댓글목록 : REST
	@RequestMapping(value = "/reply_list_rest" , method = RequestMethod.POST, produces = "application/json" )
	@ResponseBody 
	public ResponseEntity<ArrayList<ReplyVO>> ctlReplyListForRest(Model model
			, @RequestParam("seq") int seq){
		System.out.println(seq);
		
		ArrayList<ReplyVO> rlist = boardDAO.replySelect(seq);
		return new ResponseEntity<>(rlist, HttpStatus.OK);	
	}
	
	//댓글등록 : REST
	@RequestMapping(value = "/reply_insert_rest" , method = RequestMethod.POST)
	@ResponseBody 
	public String ctlReplyInsertForRest(Model model
			, @ModelAttribute ReplyVO rvo){
		System.out.println(rvo.getReply());
		
		int res = boardDAO.replyInsert(rvo);
		String msg = "입력에러";
		if(res > 0) {
			msg = "입력성공";
		}
		//return String.valueOf(res);	
		return String.valueOf(msg);
	}
	
		
	//댓글삭제 : REST
	@RequestMapping(value = "/reply_delete_rest" , method = RequestMethod.POST)
	@ResponseBody 
	public String ctlReplyDeleteForRest(Model model
			, @ModelAttribute ReplyVO rvo){
		System.out.println(rvo.getRseq());
		
		int deleteRows = boardDAO.replyDelete(rvo.getRseq());
		String msg = "삭제에러";
		if(deleteRows > 0) {
			msg = "삭제성공";
		}
		//return String.valueOf(res);	
		return String.valueOf(msg);
	}
	
	//검색어 자동완성
	@RequestMapping(value = "/board_search" , method = RequestMethod.POST, produces = "application/json" )
	@ResponseBody 
	public ResponseEntity<ArrayList<BoardVO>> ctlSearchForRest(Model model
			, @RequestParam("search_str") String search_str){
		System.out.println(search_str);
		
		ArrayList<BoardVO> list = boardDAO.boardSelectBySearch(search_str);
		return new ResponseEntity<>(list, HttpStatus.OK);	
	}

	
	
	
	
	@RequestMapping(value = "/board_update", method = RequestMethod.POST)
	public String ctlBoardUpdate(Model model, @ModelAttribute BoardVO bvo){
		int updateRows = boardDAO.boardUpdate(bvo);
		//상세보기파라미터 : seq
		return "redirect:/board_detail?seq="+bvo.getSeq();						//   /board_detail?seq=3
	}
	
	@RequestMapping(value = "/board_delete", method = RequestMethod.POST)
	public String ctlBoardDel(Model model, @RequestParam("seq") int seq){
		int deleteRows = boardDAO.boardDelete(seq);
		return "redirect:/board_list";											//   /board_list
	}
	
	
}
