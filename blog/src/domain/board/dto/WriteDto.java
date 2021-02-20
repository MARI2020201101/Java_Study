package domain.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WriteDto {
	
	private int userId;
	private String title;
	private String content;

}
