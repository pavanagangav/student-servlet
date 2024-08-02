<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
 <thead>
 <tr>
 <th>ID</th>
 <th>NAME</th>
 </tr>
 </thead>
 <tbody>
 <%@ %>----used for packages importing
 <% %>-----used for writing codes
 <%= %>----used to get the data
 
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
String sql="select * from student ";
PreparedStatement pmst = conn.prepareStatement(sql);
ResultSet rs =pmst.executeQuery();
while (rs.next()){
 %>
 <tr>
  <td> <%=rs.getInt("ID")%></td>
 <td><%= rs.getString("NAME") %> </td>
 </tr>
 
 <% } %>
 </tbody>
 
 </table>

</body>
</html>