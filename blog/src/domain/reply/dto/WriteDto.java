package domain.reply.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WriteDto {
	
	private String content;
	private int userId;
	private int boardId;
}
