package com.kosta.semi.mappers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.FileVO;
import com.kosta.semi.vo.ReplyVO;

@Repository
@Mapper
public interface BoardMapper {
	public BoardVO boardReplySelect(int seq);
	public List<BoardVO> boardSelect();
	
	//게시물저장
	public int boardInsert(BoardVO bvo);
	//첨부파일저장
	public int boardFileInsert(FileVO fvo);
	//게시물상세+첨부파일
	public BoardVO boardFileSelectOne(int seq);
	
	public BoardVO boardSelectOne(int seq);
	public List<ReplyVO> replySelect(int seq);
	public int replyInsert(ReplyVO rvo);
	public int boardUpdate(BoardVO bvo);
	public int boardDelete(int seq);
	public int replyDelete(int rseq);
	
}
