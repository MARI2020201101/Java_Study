package domain.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import org.h2.jdbcx.JdbcConnectionPool;

import config.DB;
import domain.user.dto.LoginDto;
import domain.user.dto.RegisterDto;

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
	System.out.println("database connection successed.................");
	
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
public void findUserbyUsername(LoginDto loginDto) {	
	try {
	cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
	conn = cp.getConnection();
	String sql = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?"; 
	PreparedStatement ps = conn.prepareStatement(sql);
	System.out.println("database connection successed.................");
	
	ps.setString(1, loginDto.getUsername());
	ps.setString(2, loginDto.getPassword());
	rs = ps.executeQuery();
	while(rs.next()) {
		User user = User
	}
	System.out.println("select user by username login successed.................");
	
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		   db.close(conn, cp, rs);
	}
}
}
