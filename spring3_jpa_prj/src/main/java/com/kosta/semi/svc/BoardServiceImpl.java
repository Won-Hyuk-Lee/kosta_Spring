package com.kosta.semi.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kosta.semi.repository.BoardRepository;
import com.kosta.semi.repository.ReplyRepository;
import com.kosta.semi.entity.BoardEntity;
import com.kosta.semi.entity.ReplyEntity;
@Service
public class BoardServiceImpl implements BoardService {

	/**
	카운트	:	count();
	삭제		: 	delete(Long id);   		delete(UserEntity entity);   deleteAll();
	레코드유무	: 	exists(Long id);
	목록		:	findAll() 				findAll(Pageable);			findAll(Sort)
	상세		: 	*findOne(Long id);		getOne(Long id);
	저장/수정	:	save(UserEntity entity);
	사용자정의	:	findByUserIdAndUserPw(String, Stirng);    
	 */
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public List<BoardEntity> svcBoardSelect() {
		return boardRepository.findAll();
	}

	@Override
	public void svcBoardInsert(BoardEntity bvo) {
		boardRepository.save(bvo);
	}

	@Override
	public BoardEntity svcBoardSelectOne(Long seq) {
		return boardRepository.findOne(seq);
	}

//	@Override
//	public List<ReplyEntity> svcReplySelect(Long seq) {
//		return replyRepository.findAll(seq);
//	}

	@Override
	public void svcReplyInsert(ReplyEntity rvo) {
		replyRepository.save(rvo);
	}

	@Override
	public void svcBoardUpdate(BoardEntity bvo) {
		boardRepository.save(bvo);
	}

	@Override
	public void svcBoardDelete(Long seq) {
		boardRepository.delete(seq);
	}

	@Override
	public void svcReplyDelete(Long rseq) {
		replyRepository.delete(rseq);
	}

}
