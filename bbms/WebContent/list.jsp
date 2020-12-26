<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% 
String name;
String mobileNumber;
String email;
String bloodGroup;
String status;

String sql = "select * from bloodrequest";

try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "mari2020");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
while(rs.next()){
name = rs.getString("name");
mobileNumber = rs.getString("mobileNumber");
email = rs.getString("email");
bloodGroup = rs.getString("bloodGroup");
status = rs.getString("status");%>

<%=name%>
<%=mobileNumber%>
<%=email %>
<%=bloodGroup %>
<%=status%>

<%}
}catch(Exception e){
	out.println(e);
}%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>


</body>
</html>