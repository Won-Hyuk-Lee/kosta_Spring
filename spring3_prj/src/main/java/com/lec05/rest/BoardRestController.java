//package com.lec05.rest;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.lec05.board.BoardDAO;
//import com.lec05.board.BoardVO;
//
//@Controller
//@RequestMapping("/board2")
//public class BoardRestController {
//
//	@Autowired
//	private BoardDAO dao;
//	
//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//    public String boardListOne(@RequestParam int seq, Model model) {
//       BoardVO vo = dao.boardReplySelect(seq);  
//        model.addAttribute("KEY_BOARDVO", vo);
//        return "lec05_rest/board_detail";
//    }
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String boardDelete(@RequestParam int seq, Model model) {
//       BoardVO vo = dao.boardReplySelect(seq);  
//        model.addAttribute("KEY_BOARDVO", vo);
//        return "redirect:/board_detail?seq="+vo.getSeq();
//    }
//	@RequestMapping(value = "/insert",method = RequestMethod.POST)
//    public String boardInsert(@ModelAttribute BoardVO bvo, Model model) {
//       dao.boardInsert(bvo);
//        return "redirect:/board2/list";
//    }
//	@RequestMapping(value = "/update",method = RequestMethod.POST)
//	@ResponseBody
//	public String boardUpdate(@RequestParam("formData") String formData) {
//        System.out.println("formData: " + formData);
//        return "응답 " + formData;
//    }
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String boardList(Model model) {
//        ArrayList<BoardVO> list = dao.boardSelect();
//        model.addAttribute("KEY_BOARDLIST", list);
//        return "lec05_rest/board_list";
//    }
//	
//}
