package domain.reply.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReplyDto {
	
	private int replyId;
	private String content;
	private int userId;
	private int boardId;
}
