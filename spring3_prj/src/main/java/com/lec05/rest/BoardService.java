package com.lec05.rest;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface BoardService {
    
    // 게시물 삽입
    int svcBoardInsert(@ModelAttribute BoardVO bvo);

    // 게시물 목록 조회
    ArrayList<BoardVO> svcBoardList();

    // 게시물 상세 조회
    Map svcBoardDetail(@RequestParam("seq") int seq);

    // 게시물 삭제
    int svcBoardDelete(@RequestParam("seq") int seq);
    int svcboardUpdate(@ModelAttribute BoardVO bvo);

    // 댓글 목록 조회 (REST)
    ArrayList<ReplyVO> svcReplyListForRest(@RequestParam("seq") int seq);

    // 댓글 등록 (REST)
    String svcReplyInsertForRest(@ModelAttribute ReplyVO rvo);

    // 댓글 삭제 (REST)
    String svcReplyDeleteForRest(@ModelAttribute ReplyVO rvo);

    // 검색을 통한 댓글 목록 조회 (REST)
    ArrayList<BoardVO> svcReplySearchForRest(@RequestParam("search_str") String str);
}
