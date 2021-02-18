package domain.user.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDto {
	
	private int userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private Role role;
	private Timestamp joinDate;


}
