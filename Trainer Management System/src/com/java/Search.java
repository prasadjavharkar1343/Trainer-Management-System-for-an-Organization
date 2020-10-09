package com.java;

import java.io.*;


import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.*;

public class Search extends HttpServlet {

       public void doGet(HttpServletRequest request, HttpServletResponse response)

                     throws ServletException, IOException {

              response.setContentType("text/html");

              PrintWriter out = response.getWriter();        

              String name1=request.getParameter("name");
              //--------------------
              String name2=request.getParameter("secu");

              try{

                     Class.forName("oracle.jdbc.driver.OracleDriver");

                     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");               

                     PreparedStatement ps=con.prepareStatement("select * from userlogin where name=? and privecy=?");

                     ps.setString(1,name1);
                     //
                     ps.setString(2,name2);

                     

                     ResultSet rs=ps.executeQuery();                

                     /* Printing column names */

                     ResultSetMetaData rsmd=rs.getMetaData();
//============================================================================================
//if(name1.equals(rs.getString(1)) && name2.equals(rs.getString(2)))
//{
                   //  System.out.println("===" +rs);
                     try
                     { 
	if(rs!=null) 
	{
	
//============================================================================================                     
                     
                    	 //while(rs.next())
						if(rs.next())
                    		 //System.out.println("in 2nd if" +rs.next());
                        {
						
							if(name1.contains("PM"))
							{
								System.out.println("in PM");
								response.sendRedirect("Form.html");
							}
							else if(name1.contains("TM"))
							{
								System.out.println("in TM");
								response.sendRedirect("welcome2.html");
							}
							else if(name1.contains("EX"))
							{
								System.out.println("in EX");
								response.sendRedirect("exec.html");
							}
							
								  
								
							
							
							
							
							/*
							out.print("<table width=25% border=1>");

		                     out.print("<center><h1>Result:</h1></center>");
                          System.out.println("succsessfully Login");
                     out.print("<tr>");

                     out.print("<td>"+rsmd.getColumnName(1)+"</td>");

                        out.print("<td>"+rs.getString(1)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");

                        out.print("<td>"+rs.getString(2)+"</td></tr>");

                           */       

                     }
						else
						 {
							out.print("<center><h1>Invalid</h1></center>");

							 
						 }
                    	//-----
                     //}
                     
             		out.print("</table>");
}
	 
                     }
                     
                     finally{out.close();}
              
                   /* catch(Exception e)
                                          
                     	{
                         System.out.println("ethe sean zhala ahe "+e);


                     	}
*/

              }catch (Exception e2)

                {

                    e2.printStackTrace();

                }

 

              finally{out.close();

                }

       }

 

} 
