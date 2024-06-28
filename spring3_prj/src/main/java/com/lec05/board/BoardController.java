//package com.lec05.board;
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
//
//@Controller
//@RequestMapping("/board")
//public class BoardController {   
//
//    @Autowired
//    private BoardDAO dao;
//    
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public String boardInsert(@ModelAttribute BoardVO bvo, Model model) {
//    	int insertRows = dao.boardInsert(bvo);
//    	return "redirect:/board/list"; 
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String boardList(Model model) {
//        ArrayList<BoardVO> list = dao.boardSelect();
//        model.addAttribute("KEY_BOARDLIST", list);
//        return "lec04_board/board_list";
//    }
//    
//    @RequestMapping(value = "/detail", method = RequestMethod.GET)
//    public String boardListOne(@RequestParam int seq, Model model) {
//       BoardVO vo = dao.boardReplySelect(seq);  
//        model.addAttribute("KEY_BOARDVO", vo);
//        return "lec04_board/board_detail";
//    }
//    
//    @RequestMapping(value = "/delete")
//    public String boardDelete(@RequestParam int seq,Model model) {
//        dao.boardDelete(seq);
//        return "redirect:/board/list";
//    }
//    @RequestMapping(value = "/update")
//    public String boardUpdate(@ModelAttribute BoardVO bvo,Model model) {
//        dao.boardUpdate(bvo);
//        return "redirect:/board/list";
//    }
//  
//}