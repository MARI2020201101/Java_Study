package domain.user.dto;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	
	private int userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String role;
	private String joinDate;


}
