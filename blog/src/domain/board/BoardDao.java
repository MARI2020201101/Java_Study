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
import domain.board.dto.WriteDto;
import domain.user.dto.RegisterDto;

public class BoardDao {
	JdbcConnectionPool cp = null;
	Connection conn = null;
	ResultSet rs = null;
	DB db = new DB();
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	
	public List<BoardDto> findAll(){
		List<BoardDto> boards = new ArrayList<BoardDto>();
		BoardDto board = null;
		
		try {
			cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
			conn = cp.getConnection();
			String sql = "SELECT * FROM BOARD"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("database connection successed.................");

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
public void save(WriteDto writeDto) {	
		try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "INSERT INTO BOARD VALUES (hibernate_sequence.nextval,?,?,?,?,?)"; 
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("database connection successed.................");
		
		ps.setString(1, writeDto.getContent());
		ps.setInt(2, 0);
		ps.setString(3, writeDto.getTitle());
		ps.setObject(4, ts);
		ps.setInt(5, writeDto.getUserId());
		ps.execute();
		
		System.out.println("insert board succeessed............");
		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp);
		}
	}	
public BoardDto findbyBoardId(){

	BoardDto board = null;
	
	try {
		cp = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/blog", "sa", "");
		conn = cp.getConnection();
		String sql = "SELECT * FROM BOARD WHERE BOARDID = ?"; 
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("database connection successed.................");
		
		ps.setString(1, username);
		rs = ps.executeQuery();

			while(rs.next()) {
				board = BoardDto.builder()
						.boardId(rs.getInt(1))
						.content(rs.getString(2))
						.count(rs.getInt(3))
						.title(rs.getString(4))
						.writeDate(rs.getString(5))
						.userId(rs.getInt(6)).build();
			}

		System.out.println("Board list successed.................");
		return board;
		
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			   db.close(conn, cp, rs);		   
		}

	}
}
