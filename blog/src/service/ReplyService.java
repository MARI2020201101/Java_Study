package service;

import domain.reply.ReplyDao;
import domain.reply.dto.WriteDto;

public class ReplyService {
	ReplyDao replyDao = new ReplyDao();
	
	public int save(WriteDto writeDto) {
		return replyDao.save(writeDto);
	}
}
