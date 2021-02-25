package domain.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.h2.jdbcx.JdbcConnectionPool;
import config.DB;
import domain.reply.dto.WriteDto;

public class ReplyDao {
	JdbcConnectionPool cp = null;
	Connection conn = null;
	ResultSet rs = null;
	DB db = new DB();
	int result = 0;
	
	public int save(WriteDto writeDto) {	
		try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "INSERT INTO REPLY VALUES (hibernate_sequence.nextval,?,?,?)"; 
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, writeDto.getContent());
		ps.setInt(2, writeDto.getBoardId());
		ps.setInt(3, writeDto.getUserId());
		result = ps.executeUpdate();
		
		System.out.println("insert reply succeessed............");
		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp);
		}
		return result;
	}
}
