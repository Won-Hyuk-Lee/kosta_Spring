package com.kosta.semi.ctl;

import org.springframework.stereotype.Controller;              //@Controller
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.kosta.semi.svc.BoardService;
import com.kosta.semi.entity.BoardEntity;
import com.kosta.semi.entity.ReplyEntity;

@Controller
public class BoardController  {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board_insert", method = RequestMethod.POST)
	public String ctlBoardInsert(@ModelAttribute BoardEntity bvo) {
		boardService.svcBoardInsert(bvo);
		return "redirect:/board_list";						//   /board_list
	}
	
	@RequestMapping(value = "/board_list")
	public String ctlBoardList(Model model){
		ArrayList<BoardEntity> list = (ArrayList)boardService.svcBoardSelect();
		model.addAttribute("KEY_BOARDLIST", list);
		return "board/board_list";     				//   /  lec05_board/board_list  .jsp  
	}
	
	@RequestMapping(value = "/board_detail")
	public String ctlBoardDetail(Model model, @RequestParam("seq") Long seq){
		//------------------------------------------------------
		//상세만 가져가고 ,댓글목록은 (REST)로 출력
		//	트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} () 
		//	댓글목록 EL  : ${KEY_REPLYLIST}
		//------------------------------------------------------
		BoardEntity bvo = boardService.svcBoardSelectOne(seq);
		model.addAttribute("KEY_BOARDVO", bvo);
		return "board/board_detail";						//   /   lec05_board/board_detail  .jsp
	}
	
	//댓글목록 : REST
	@RequestMapping(value = "/reply_list_rest" , method = RequestMethod.POST, produces = "application/json" )
	@ResponseBody 
	public ResponseEntity<ArrayList<ReplyEntity>> ctlReplyListForRest(Model model
			, @RequestParam("seq") Long seq){
		System.out.println(seq);
		//수정수정*********************************************************************************
		//ArrayList<ReplyEntity> rlist = (ArrayList)boardService.svcReplySelect(seq);
		ArrayList<ReplyEntity> rlist = new ArrayList<ReplyEntity>();
		return new ResponseEntity<>(rlist, HttpStatus.OK);	
	}
	
	//댓글등록 : REST
	@RequestMapping(value = "/reply_insert_rest" , method = RequestMethod.POST)
	@ResponseBody 
	public String ctlReplyInsertForRest(Model model
			, @ModelAttribute ReplyEntity rvo){
		System.out.println(rvo.getReply());
		boardService.svcReplyInsert(rvo);
		String msg = "컨트롤러실행";
		return msg;
	}
	
	//댓글삭제 : REST
	@RequestMapping(value = "/reply_delete_rest" , method = RequestMethod.POST)
	@ResponseBody 
	public String ctlReplyDeleteForRest(Model model
			, @ModelAttribute ReplyEntity rvo){
		System.out.println(rvo.getRseq());
		boardService.svcReplyDelete(rvo.getRseq());
		String msg = "컨트롤러실행";	
		return msg;
	}
	
	@RequestMapping(value = "/board_update", method = RequestMethod.POST)
	public String ctlBoardUpdate(Model model, @ModelAttribute BoardEntity bvo){
		boardService.svcBoardUpdate(bvo);
		//상세보기파라미터 : seq
		return "redirect:/board_detail?seq="+bvo.getSeq();						//   /board_detail?seq=3
	}
	
	@RequestMapping(value = "/board_delete", method = RequestMethod.POST)
	public String ctlBoardDel(Model model, @RequestParam("seq") Long seq){
		boardService.svcBoardDelete(seq);
		return "redirect:/board_list";											//   /board_list
	}
	
	
}
