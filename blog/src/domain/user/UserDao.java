package domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import org.h2.jdbcx.JdbcConnectionPool;

import config.DB;
import domain.user.dto.LoginDto;
import domain.user.dto.RegisterDto;
import domain.user.dto.UpdateDto;
import domain.user.dto.UserDto;

public class UserDao {
	JdbcConnectionPool cp = null;
	Connection conn = null;
	ResultSet rs = null;
	DB db = new DB();
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	
public void save(RegisterDto registerDto) {	
	try {
	cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
	conn = cp.getConnection();
	String sql = "INSERT INTO USER VALUES (hibernate_sequence.nextval,?,?,?,?,?,?)"; 
	PreparedStatement ps = conn.prepareStatement(sql);	
	ps.setString(1, registerDto.getAddress());
	ps.setString(2, registerDto.getEmail());
	ps.setObject(3, ts);
	ps.setString(4, registerDto.getPassword());
	ps.setString(5, "User");
	ps.setString(6, registerDto.getUsername());
	ps.execute();
	
	System.out.println("insert user succeessed............");
	
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		   db.close(conn, cp);
	}
}
public UserDto findbyUsernameAndPassword(LoginDto loginDto) {	
	try {
	cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
	conn = cp.getConnection();
	String sql = "SELECT USERID,ADDRESS,EMAIL,JOINDATE,ROLE,USERNAME FROM USER WHERE USERNAME = ? AND PASSWORD = ?"; 
	PreparedStatement ps = conn.prepareStatement(sql);
	UserDto user = null;
	
	
	ps.setString(1, loginDto.getUsername());
	ps.setString(2, loginDto.getPassword());
	rs = ps.executeQuery();
	
	while(rs.next()) {
		user = UserDto.builder()
				.userId(rs.getInt("USERID"))
				.address(rs.getString("ADDRESS"))
				.email(rs.getString("EMAIL"))
				.joinDate(rs.getString("JOINDATE"))
				.role(rs.getString("ROLE"))
				.username(rs.getString("USERNAME")).build();
	}
	System.out.println("select user by username login successed.................");
	System.out.println(user);
	return user;
	
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		   db.close(conn, cp, rs);		   
	}
	return null;	
}

public void update(UpdateDto updateDto) {	
	try {
	cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
	conn = cp.getConnection();
	String sql = "UPDATE USER U SET U.USERNAME = ?, U. PASSWORD = ?, U.ADDRESS = ? , U.EMAIL = ? WHERE U.USERID = ? "; 
	PreparedStatement ps = conn.prepareStatement(sql);

	ps.setString(1, updateDto.getUsername());
	ps.setString(2, updateDto.getPassword());
	ps.setString(3, updateDto.getAddress());
	ps.setString(4, updateDto.getEmail());
	ps.setInt(5, updateDto.getUserId());
	ps.execute();
	
	System.out.println("update user succeessed............");
	
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		   db.close(conn, cp);
	}
}
public boolean selectbyUsername(String username) {
	try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "SELECT * FROM USER WHERE USERNAME = ?"; 
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		rs = ps.executeQuery();
		System.out.println("query done...........................");
		if(rs.next()) {
			//username ม฿บน
			System.out.println("select username true.................");
			return true;	
		}

		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp, rs);		   
		}
		return false;	
}
}
