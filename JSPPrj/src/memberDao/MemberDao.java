package memberDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MemberDao {
	
	public List<Member> MemberSelect(){
		
		List<Member> members = null;
		String url = "jdbc:mysql://localhost:3306/membermanagementproject";
		String user = "root";
		String password = "mari2020";
		String sql = "select * from user";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("ok");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String userID = rs.getString(1);
				String userPassword = rs.getString(2);
				String userName = rs.getString(3);
				int userAge = rs.getInt(4);
				
				Member member = new Member(userID, userPassword, userName, userAge);
				members.add(member);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}return members;
		
	}


}
