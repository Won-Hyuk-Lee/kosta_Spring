package com.lec08.dao;

import java.util.ArrayList;
import java.util.Map;


public interface BoardService {

	public int svcBoardInsert(BoardVO bvo);
	
	public ArrayList<BoardVO> svcBoardList();
	
	public Map ctlBoardDetail(int seq);
	
	
	public int svcBoardInsert(ReplyVO rvo);

	
	public int svcReplyDel(ReplyVO rvo);
	
	public int svcBoardUpdate(BoardVO bvo);
	
	public int svcBoardDel(int seq);
}
