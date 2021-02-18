package domain.user.dto;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {

	private String username;
	private String password;
	private String email;
	private String address;

}
