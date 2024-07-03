package com.lec12.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void saveBoard(BoardVO board) {
        boardRepository.save(board);
    }
}
