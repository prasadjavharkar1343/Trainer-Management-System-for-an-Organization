package com.java;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Skill extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String tn=request.getParameter("trainname");  
String typn=request.getParameter("typname");  
String mal=request.getParameter("email");  
String totno=request.getParameter("totalno");  
String dat=request.getParameter("date");
String src1=request.getParameter("source");
String itr=request.getParameter("inttrain");
String typ=request.getParameter("type");
String Src=request.getParameter("Source");
String sklr=request.getParameter("skilre");
try{  
	System.out.println("connection done here!!");
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","password");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into skill values(?,?,?,?,?,?,?,?,?,?)");  
  
ps.setString(1,tn);  
ps.setString(2,typn);  
ps.setString(3,mal);  
ps.setString(4,totno);
ps.setString(5,dat);
ps.setString(6,src1);
ps.setString(7,itr);
ps.setString(8,typ);
ps.setString(9,Src);
ps.setString(10,sklr);
int i=ps.executeUpdate();

if(i>0)
{
	response.sendRedirect("record.html");

}     
          
}catch (Exception e2) {System.out.println("ha problem ahe--> "+e2);}  
          
out.close();  
}  
  
}  