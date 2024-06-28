//package com.lec05.rest;
//
//import org.springframework.stereotype.Controller; //@Controller
//import org.springframework.ui.Model;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired; //@Autowired
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ModelAttribute; //@ModelAttribute	
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping
//import org.springframework.web.bind.annotation.RequestMethod; //@RequestMapping
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class BoardController {
//
//	@Autowired
//	private BoardService boardService;// 타입 부모인터페이스 = new 자식();
//
//	@RequestMapping(value = "/board_insert", method = RequestMethod.POST)
//	public String ctlBoardInsert(@ModelAttribute BoardVO bvo) {
//		int insertRows = boardService.svcBoardInsert(bvo);
//		return "redirect:/board_list"; // /board_list
//	}
//
//	@RequestMapping(value = "/board_list")
//	public String ctlBoardList(Model model) {
//		ArrayList<BoardVO> list = boardService.svcBoardList();
//		model.addAttribute("KEY_BOARDLIST", list);
//		return "lec05_board/board_list"; // / lec05_board/board_list .jsp
//	}
//
//	@RequestMapping(value = "/board_delete")
//	public String boardDelete(@RequestParam int seq, Model model) {
//		int insertRows = boardService.svcBoardDelete(seq);
//		return "redirect:/board_list";
//	}
//
//	@RequestMapping(value = "/board_update")
//	public String boardUpdate(@ModelAttribute BoardVO bvo, Model model) {
//		int insertRows = boardService.svcboardUpdate(bvo);
//		return "redirect:/board_list";
//	}
//
//	@RequestMapping(value = "/board_detail")
//	public String scvBoardDetail(Model model, @RequestParam("seq") int seq) {
//		// ------------------------------------------------------
//		// 상세만 가져가고 ,댓글목록은 (REST)로 출력
//		// 트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록)
//		// 게시물상세 EL : ${KEY_BOARDVO} ()
//		// 댓글목록 EL : ${KEY_REPLYLIST}
//		// ------------------------------------------------------
//		Map map = boardService.svcBoardDetail(seq);
//		model.addAttribute("KEY_BOARDVO", (BoardVO) map.get("my_bvo"));
//		// model.addAttribute("KEY_BOARDVO", (ArrayList<ReplyVO>)map.get("my_rlist"));
//		// ArrayList<ReplyVO> rlist = boardDAO.replySelect(seq);
//		// model.addAttribute("KEY_REPLYLIST", rlist);
//
//		return "lec05_board/board_detail"; // / lec05_board/board_detail .jsp
//	}
//
//	// 댓글목록 : REST
//	@RequestMapping(value = "/reply_list_rest", method = RequestMethod.POST, produces = "application/json")
//	@ResponseBody
//	public ResponseEntity<ArrayList<ReplyVO>> ctlReplyListForRest(Model model, @RequestParam("seq") int seq) {
//		System.out.println(seq);
//
//		ArrayList<ReplyVO> rlist = boardService.svcReplyListForRest(seq);
//		return new ResponseEntity<>(rlist, HttpStatus.OK);
//	}
//
//	// 댓글등록 : REST
//	@RequestMapping(value = "/reply_insert_rest", method = RequestMethod.POST)
//	@ResponseBody
//	public String ctlReplyInsertForRest(Model model, @ModelAttribute ReplyVO rvo) {
//		System.out.println("입력 " + rvo.getReply());
//
//		String res = boardService.svcReplyInsertForRest(rvo);
//
//		return res;
//	}
//
//	// 댓글삭제 : REST
//	@RequestMapping(value = "/reply_delete_rest", method = RequestMethod.POST)
//	@ResponseBody
//	public String ctlReplyDeleteForRest(Model model, @ModelAttribute ReplyVO rvo) {
//		System.out.println("삭제 " + rvo.getRseq());
//
//		String res = boardService.svcReplyDeleteForRest(rvo);
//		return res;
//	}
//
//	// 댓글목록 : REST
//	@RequestMapping(value = "/board_search", method = RequestMethod.POST, produces = "application/json")
//	@ResponseBody
//	public ResponseEntity<ArrayList<BoardVO>> ctlReplyListForRest(Model model, @RequestParam("search_str") String str) {
//		System.out.println(str);
//
//		ArrayList<BoardVO> rlist = boardService.svcReplySearchForRest(str);
//		return new ResponseEntity<>(rlist, HttpStatus.OK);
//	}
//
//}
