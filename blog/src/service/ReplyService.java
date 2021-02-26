package service;

import java.util.List;

import domain.reply.ReplyDao;
import domain.reply.dto.DetailDto;
import domain.reply.dto.ReplyDto;
import domain.reply.dto.WriteDto;

public class ReplyService {
	ReplyDao replyDao = new ReplyDao();
	
	public int save(WriteDto writeDto) {
		replyDao.save(writeDto);
		return replyDao.findMaxId();
	}
	
	public List<DetailDto> findAllbyBoardId(int boardId){
		return replyDao.findAllbyBoardId(boardId);
	}
	public DetailDto findbyId(int replyId){
		return replyDao.findbyId(replyId);
	}

	public int delete(int replyId) {
		return replyDao.delete(replyId);
	}
}
