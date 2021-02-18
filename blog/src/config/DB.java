package config;

import java.sql.*;

import org.h2.jdbcx.JdbcConnectionPool;


public class DB {  

	
public void close(Connection conn,JdbcConnectionPool cp) {
	try{
		  
		   conn.close();
		   cp.dispose();
	   }
	catch(Exception ee) {
		System.out.println(ee);
	}
}	

public void close(Connection conn,JdbcConnectionPool cp,ResultSet rs) {
	try{
		  
		   conn.close();
		   cp.dispose();
		   rs.close();
	   }
	catch(Exception ee) {
		System.out.println(ee);
	}
}	
   
}

   

