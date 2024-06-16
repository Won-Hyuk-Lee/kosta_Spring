package com.lec04.di.board;

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
		return "lec04_board/board_list";     				//   /  lec04_board/board_list  .jsp  
	}
	
	@RequestMapping(value = "/board_detail")
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
	
	
	@RequestMapping(value = "/reply_insert", method = RequestMethod.POST)
	public String ctlBoardInsert(Model model, @ModelAttribute ReplyVO rvo){
		System.out.println("댓글등록--");
		int insertRows = boardDAO.replyInsert(rvo);
		return "redirect:/board_detail?seq="+rvo.getSeq();						//   /board_detail?seq=3
		//return "forward:/board_detail";											//   /board_detail rvo객체가넘어간다.
	}
	
	@RequestMapping(value = "/reply_delete", method = RequestMethod.GET)
	public String ctlReplyDel(Model model, @ModelAttribute ReplyVO rvo){
		int deleteRows = boardDAO.replyDelete(rvo.getRseq());
		//상세보기파라미터 : seq
		return "redirect:/board_detail?seq="+rvo.getSeq();						//   /board_detail?seq=3
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
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------------------------------------------
	

	@RequestMapping(value = "/ctl_str_str", method = RequestMethod.POST) 
	@ResponseBody
	public String ctlBoardStrStr(Model model, @ModelAttribute BoardVO bvo){
		System.out.println(bvo.getSeq() + "," +  bvo.getRegid());
		//public String ctlBoardStrStr(@RequestParam("seq") int seq, @RequestParam("regid") String regid) {
		//System.out.println(seq +"," + regid);
		return "status 200 ok";
	}
	
	
	@RequestMapping(value = "/ctl_json_str", method = RequestMethod.POST,  consumes = "application/json")
	@ResponseBody
	public String ctlBoardJsonStr(Model model, @RequestBody BoardVO bvo){
		System.out.println(bvo.getSeq() + "," +  bvo.getRegid());
		return "status 200 ok";
	}
	
	@RequestMapping(value = "/ctl_json_json", method = RequestMethod.POST, consumes = "application/json") //, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ctlBoardJsonMap(Model model, @RequestBody BoardVO bvo){
		System.out.println(bvo.getSeq() + "," +  bvo.getRegid());
		
		Map<String, Object> response = new HashMap<String, Object>();
	    response.put("status", 200);
	    response.put("message", "ok");
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
