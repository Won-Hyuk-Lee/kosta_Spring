package com.kosta.semi.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.semi.mappers.BoardMapper;
import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.FileVO;
import com.kosta.semi.vo.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public BoardVO svcBoardReplySelect(int seq) {
		return boardMapper.boardReplySelect(seq);
	}

	@Override
	public List<BoardVO> svcBoardSelect() {
		return boardMapper.boardSelect();
	}

	
	//첨부파일 + 게시글 저장
	@Override
	public int svcBoardInsert(BoardVO bvo, List<FileVO> fvos) {
		boardMapper.boardInsert(bvo); // 저장된 게시물의 시퀀스 값
		System.out.println("KEYGEN selectKey:" + bvo.getSeq());
		
		
		for (fvos ) {
	        if (fvo != null) {
				// 첨부파일 저장
		        //for (FileVO fileVO : boardVO.getFileVO()) {
		        fvo.setSeq(bvo.getSeq());  //방금 입력한 게시물의 자동증가seq : 게시물 입력 후 확인할 수 있다.
		        boardMapper.boardFileInsert(fvo);
	        }
        }
		return 1;
	}
	
	//게시물 상세보기 + 첨부파일 목록
	@Override
	public BoardVO svcBoardSelectOne(int seq) {
		//return boardMapper.boardSelectOne(seq);
		return boardMapper.boardFileSelectOne(seq);
	}

	@Override
	public List<ReplyVO> svcReplySelect(int seq) {
		return boardMapper.replySelect(seq);
	}

	@Override
	public int svcReplyInsert(ReplyVO rvo) {
		return boardMapper.replyInsert(rvo);
	}

	@Override
	public int svcBoardUpdate(BoardVO bvo) {
		return boardMapper.boardUpdate(bvo);
	}

	@Override
	public int svcBoardDelete(int seq) {
		return boardMapper.boardDelete(seq);
	}

	@Override
	public int svcReplyDelete(int rseq) {
		return boardMapper.replyDelete(rseq);
	}

}
