package service;

import domain.user.UserDao;
import domain.user.dto.LoginDto;
import domain.user.dto.RegisterDto;
import domain.user.dto.UpdateDto;
import domain.user.dto.UserDto;

public class UserService {
	UserDao userDao = new UserDao();

	public UserDto login(LoginDto loginDto) {
		UserDto user = userDao.findbyUsernameAndPassword(loginDto);
		return user;
	}
	public void register(RegisterDto registerDto) {
		userDao.save(registerDto);
	}
	public void update(UpdateDto updateDto) {
		userDao.update(updateDto);
	}

}
