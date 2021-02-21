package service;

import java.util.List;

import domain.board.BoardDao;
import domain.board.dto.BoardDto;
import domain.board.dto.Pagination;
import domain.board.dto.WriteDto;

public class BoardService {
	BoardDao boardDao = new BoardDao();
	
	public List<BoardDto> list(){
		List<BoardDto> boards = boardDao.findAll();
		return boards;
	}
	public void save(WriteDto writeDto) {
		boardDao.save(writeDto);
	}
	
	public List<BoardDto> listwithPage(Pagination pagination) {
		List<BoardDto> boards = boardDao.findAllwithPage(pagination);
		return boards;
	}
	/*
	 * public BoardDto findbyBoardId() { boardDao.findbyBoardId(); }
	 */
	public int countAll() {
		int count = boardDao.countAll();
		return count;
	}

}
