package domain.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardwithUserDto {
	
	private int boardId;
	private String title;
	private String content;
	private int count;
	private int userId;
	private String writeDate;
	private String username;

}
