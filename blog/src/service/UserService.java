package service;

import domain.user.UserDao;
import domain.user.dto.LoginDto;
import domain.user.dto.RegisterDto;

public class UserService {
	UserDao userDao = new UserDao();
	//로그인login
	//회원가입register
	public void login(LoginDto loginDto) {
		userDao.findUserbyUsername(loginDto);
	}
	public void register(RegisterDto registerDto) {
		userDao.save(registerDto);
	}

}
