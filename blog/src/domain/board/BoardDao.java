package domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;

import config.DB;
import domain.board.dto.BoardDto;
import domain.board.dto.BoardwithUserDto;
import domain.board.dto.Pagination;
import domain.board.dto.UpdateDto;
import domain.board.dto.WriteDto;
import domain.user.dto.RegisterDto;

public class BoardDao {
	JdbcConnectionPool cp = null;
	Connection conn = null;
	ResultSet rs = null;
	DB db = new DB();
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	int result = 0;
	
	public List<BoardDto> findAll(){
		List<BoardDto> boards = new ArrayList<BoardDto>();
		BoardDto board = null;
		
		try {
			cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
			conn = cp.getConnection();
			String sql = "SELECT * FROM BOARD"; 
			PreparedStatement ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

				while(rs.next()) {
					board = BoardDto.builder()
							.boardId(rs.getInt(1))
							.content(rs.getString(2))
							.count(rs.getInt(3))
							.title(rs.getString(4))
							.writeDate(rs.getString(5))
							.userId(rs.getInt(6)).build();
					boards.add(board);
				}

			System.out.println("Board list successed.................");
			
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				   db.close(conn, cp, rs);		   
			}
		return boards;
		}
public int save(WriteDto writeDto) {	
		try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "INSERT INTO BOARD VALUES (hibernate_sequence.nextval,?,?,?,?,?)"; 
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, writeDto.getContent());
		ps.setInt(2, 0);
		ps.setString(3, writeDto.getTitle());
		ps.setObject(4, ts);
		ps.setInt(5, writeDto.getUserId());
		result = ps.executeUpdate();
		
		System.out.println("insert board succeessed............");
		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp);
		}
		return result;
	}	
public List<BoardDto> findAllwithPage(Pagination pagination){
	int currentPage = pagination.getCurrentPage();
	List<BoardDto> boards = new ArrayList<BoardDto>();
	BoardDto board = null;
	
	try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "SELECT * FROM BOARD ORDER BY BOARDID DESC LIMIT ? , ?"; 
		PreparedStatement ps = conn.prepareStatement(sql);		
		//0 -> 3 -> 6 -> 9....
		ps.setInt(1, (currentPage-1)*3);
		ps.setInt(2, pagination.getCriteria());
		rs = ps.executeQuery();

			while(rs.next()) {
				board = BoardDto.builder()
						.boardId(rs.getInt(1))
						.content(rs.getString(2))
						.count(rs.getInt(3))
						.title(rs.getString(4))
						.writeDate(rs.getString(5))
						.userId(rs.getInt(6)).build();
				boards.add(board);
			}

		System.out.println("Board list with page successed.................");
		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp, rs);		   
		}
	return boards;
	}
	
public BoardDto findbyBoardId(int boardId){
	  
	  BoardDto board = null;
	  
	  try { 
		  cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", ""); 
		  conn = cp.getConnection(); 
		  String sql = "SELECT * FROM BOARD WHERE BOARDID = ?"; 
		  PreparedStatement ps = conn.prepareStatement(sql);
		  ps.setInt(1, boardId); rs = ps.executeQuery();
	  
		  while(rs.next()) { 
			  board = BoardDto.builder() 
					  .boardId(rs.getInt(1))
					  .content(rs.getString(2)) 
					  .count(rs.getInt(3)) 
					  .title(rs.getString(4))
					  .writeDate(rs.getString(5)) 
					  .userId(rs.getInt(6)).build(); 
			  }
		  System.out.println("Board detail successed................."); 
	  
	  	  }catch(Exception e) { 
	  		System.out.println(e); 
	  	  }finally { 
	  			db.close(conn, cp, rs); 
	  			}
	return board;
	  
	  }
	 
public int countAll(){
	int count = 0;
	try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "SELECT COUNT(BOARDID) FROM BOARD"; 
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		System.out.println("Board count successed.................");
		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp, rs);		   
		}
	return count;
		
	}
public BoardwithUserDto findbyBoardIdwithUser(int boardId){
	  
	BoardwithUserDto board = null;
	  
	  try { 
		  cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", ""); 
		  conn = cp.getConnection(); 
		  String sql = "SELECT 	B.*,U.USERNAME FROM BOARD B INNER JOIN USER U ON B.USERID = U.USERID WHERE B.BOARDID = ?"; 
		  PreparedStatement ps = conn.prepareStatement(sql);
		  ps.setInt(1, boardId); rs = ps.executeQuery();
	  
		  while(rs.next()) { 
			  board = BoardwithUserDto.builder() 
					  .boardId(rs.getInt(1))
					  .content(rs.getString(2)) 
					  .count(rs.getInt(3)) 
					  .title(rs.getString(4))
					  .writeDate(rs.getString(5)) 
					  .userId(rs.getInt(6))
					  .username(rs.getString(7)).build(); 
			  }
		  System.out.println("Board detail WITH USER JOIN successed................."); 
	  
	  	  }catch(Exception e) { 
	  		System.out.println(e); 
	  	  }finally { 
	  			db.close(conn, cp, rs); 
	  			}
	return board;
	  
	  }
public int update(int boardId, UpdateDto updateDto) {	
	try {
	cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
	conn = cp.getConnection();
	String sql = "UPDATE BOARD B SET B.TITLE = ?, B.CONTENT = ?, B.WRITEDATE = ? WHERE BOARDID = ? "; 
	PreparedStatement ps = conn.prepareStatement(sql);	
	ps.setString(1, updateDto.getTitle());
	ps.setString(2, updateDto.getContent());
	ps.setObject(3, ts);
	ps.setInt(4, boardId);
	result = ps.executeUpdate();
	
	System.out.println("update board succeessed............");
	
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		   db.close(conn, cp);
	}
	return result;
}
public int delete(int boardId) {	
	try {
	cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
	conn = cp.getConnection();
	String sql = "DELETE FROM BOARD WHERE BOARDID = ?"; 
	PreparedStatement ps = conn.prepareStatement(sql);
	
	ps.setInt(1, boardId);
	result = ps.executeUpdate();
	
	System.out.println("DELETE board succeessed............");
	
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		   db.close(conn, cp);
	}
	return result;
}
}
