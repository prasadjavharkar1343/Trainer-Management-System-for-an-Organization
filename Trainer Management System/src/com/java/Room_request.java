package com.java;


import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Room_request extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String tn=request.getParameter("Training_Name");  
String psdn=request.getParameter("Proposed_No");  
String psddatfrm=request.getParameter("Proposed_Date_from");  
String psddatto=request.getParameter("Proposed_Date_to");
try{  
	System.out.println("connection done here!!");
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","password");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into room values(?,?,?,?)");  
  
ps.setString(1,tn);  
ps.setString(2,psdn);  
ps.setString(3,psddatfrm);  
ps.setString(4,psddatto);
int i=ps.executeUpdate();

if(i>0)
{
	response.sendRedirect("record.html");

}     
          
}catch (Exception e2) {System.out.println("ha problem ahe--> "+e2);}  
          
out.close();  
}  
  
}  