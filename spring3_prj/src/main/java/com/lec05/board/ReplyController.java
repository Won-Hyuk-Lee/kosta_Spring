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
//@RequestMapping("/reply")
//public class ReplyController {   
//
//    @Autowired
//    private BoardDAO dao;
//    
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public String replyInsert(@ModelAttribute ReplyVO rvo, Model model) {
//    	int insertRows = dao.replyInsert(rvo.getSeq(), rvo.getReply());
//        // 댓글이 추가된 게시글의 seq를 가져와서 전달
//        return "redirect:/board/detail?seq=" + rvo.getSeq();
//    }
//    @RequestMapping(value = "/delete")
//    public String boardDelete(@RequestParam int seq,int rseq ,Model model) {
//        dao.replyDelete(rseq);
//        return "redirect:/board/detail?seq=" + seq;
//    }
//
//}