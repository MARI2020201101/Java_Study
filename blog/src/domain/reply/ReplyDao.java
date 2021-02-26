package domain.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;
import config.DB;
import domain.board.dto.BoardDto;
import domain.reply.dto.DetailDto;
import domain.reply.dto.ReplyDto;
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
	
	public int findMaxId(){
		  
		  try { 
			  cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", ""); 
			  conn = cp.getConnection(); 
			  String sql = "SELECT MAX(REPLYID) FROM REPLY"; 
			  PreparedStatement ps = conn.prepareStatement(sql);
			  rs = ps.executeQuery();
		  
			  if(rs.next()) {
				  result = rs.getInt(1);
			  }
			  System.out.println("select max id successed................."); 
		  
		  	  }catch(Exception e) { 
		  		System.out.println(e); 
		  	  }finally { 
		  			db.close(conn, cp, rs); 
		  			}
		return result;
		  
		  }
	public List<DetailDto> findAllbyBoardId(int boardId){
		  
		  List<DetailDto> replyList = new ArrayList<DetailDto>();
		  DetailDto reply = null;
		  
		  try { 
			  cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", ""); 
			  conn = cp.getConnection(); 
			  String sql = "SELECT R.*,U.USERNAME FROM REPLY R INNER JOIN USER U ON R.USERID = U.USERID WHERE BOARDID = ? ORDER BY R.REPLYID DESC"; 
			  PreparedStatement ps = conn.prepareStatement(sql);
			  ps.setInt(1, boardId); 
			  rs = ps.executeQuery();
		  
			  while(rs.next()) { 
				  reply = DetailDto.builder()
						  			.replyId(rs.getInt(1))
				  					.content(rs.getString(2))
				  					.boardId(rs.getInt(3))
				  					.userId(rs.getInt(4))
				  					.username(rs.getString(5))
				  					.build();
				  replyList.add(reply);
				  }
			  System.out.println("reply list successed................."); 
		  
		  	  }catch(Exception e) { 
		  		System.out.println(e); 
		  	  }finally { 
		  			db.close(conn, cp, rs); 
		  			}
		return replyList;
		  
		  }
	public DetailDto findbyId(int replyId){
		  
		  DetailDto reply = null;
		  
		  try { 
			  cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", ""); 
			  conn = cp.getConnection(); 
			  String sql = "SELECT R.*,U.USERNAME FROM REPLY R INNER JOIN USER U ON R.USERID = U.USERID WHERE REPLYID = ? ORDER BY R.REPLYID DESC"; 
			  PreparedStatement ps = conn.prepareStatement(sql);
			  ps.setInt(1, replyId); 
			  rs = ps.executeQuery();
		  
			  while(rs.next()) { 
				  reply = DetailDto.builder()
						  			.replyId(rs.getInt(1))
				  					.content(rs.getString(2))
				  					.boardId(rs.getInt(3))
				  					.userId(rs.getInt(4))
				  					.username(rs.getString(5))
				  					.build();
				  }
			  System.out.println("reply find by Id successed................."); 
		  
		  	  }catch(Exception e) { 
		  		System.out.println(e); 
		  	  }finally { 
		  			db.close(conn, cp, rs); 
		  			}
		return reply;
		  
		  }

	public int delete(int replyId) {
		 try {
			cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
			conn = cp.getConnection();
			String sql = "DELETE FROM REPLY WHERE REPLYID = ?"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, replyId);
			result = ps.executeUpdate();
			
			System.out.println("DELETE REPLY succeessed............");
			
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				   db.close(conn, cp);
			}
			return result;
	}
}
