package service;

import java.util.List;

import domain.board.BoardDao;
import domain.board.dto.BoardDto;

public class BoardService {
	BoardDao boardDao = new BoardDao();
	
	public List<BoardDto> list(){
		List<BoardDto> boards = boardDao.findAll();
		return boards;
	}

}
