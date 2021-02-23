package service;

import java.util.List;

import domain.board.BoardDao;
import domain.board.dto.BoardDto;
import domain.board.dto.BoardwithUserDto;
import domain.board.dto.Pagination;
import domain.board.dto.UpdateDto;
import domain.board.dto.WriteDto;

public class BoardService {
	BoardDao boardDao = new BoardDao();
	
	public List<BoardDto> list(){
		List<BoardDto> boards = boardDao.findAll();
		return boards;
	}
	public int save(WriteDto writeDto) {
		return boardDao.save(writeDto);
	}
	
	public List<BoardDto> listwithPage(Pagination pagination) {
		List<BoardDto> boards = boardDao.findAllwithPage(pagination);
		return boards;
	}
	
	public BoardDto findbyBoardId(int boardId) { 
		return boardDao.findbyBoardId(boardId); 
		}
	 
	public int countAll() {
		int count = boardDao.countAll();
		return count;
	}
	public BoardwithUserDto findbyBoardIdwithUser(int boardId) {
		return boardDao.findbyBoardIdwithUser(boardId);
	}
	public int update(int boardId, UpdateDto updateDto) {
		return boardDao.update(boardId, updateDto);
	}
	public int delete(int boardId) {
		return boardDao.delete(boardId);
	}

}
