package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.List;

import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.FileVO;
import com.kosta.semi.vo.ReplyVO;

public interface BoardService {
	
	public BoardVO svcBoardReplySelect(int seq);
	public List<BoardVO> svcBoardSelect();
	
	//첨부파일 + 게시글 저장
	//public int svcBoardInsert(BoardVO bvo, FileVO fvo);
	public int svcBoardInsert(BoardVO bvo, ArrayList<FileVO> fvoList);
	
	public BoardVO svcBoardSelectOne(int seq);
	public List<ReplyVO> svcReplySelect(int seq);
	public int svcReplyInsert(ReplyVO rvo);
	public int svcBoardUpdate(BoardVO bvo);
	public int svcBoardDelete(int seq);
	public int svcReplyDelete(int rseq);
}
