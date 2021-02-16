package config;

import java.sql.*;
import java.sql.DriverManager; 


public class DB {  
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:tcp://localhost/~/blog";  
   static final String USER = "sa"; 
   static final String PASS = ""; 
  
   public static void main(String[] args) { 
      Connection conn = null; 
      try { 
         Class.forName(JDBC_DRIVER); 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         conn.close(); 
      } catch(Exception e) { e.printStackTrace(); 
      } 
      } 
 
   } 
