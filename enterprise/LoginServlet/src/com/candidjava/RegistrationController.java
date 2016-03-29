package com.candidjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		String name = request.getParameter("fullname");
		String Addr = request.getParameter("address");
		String language = request.getParameter("language");
		String Year = request.getParameter("yop");
		
		
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/dbuser", "root", "root");
	 
	            PreparedStatement ps = con.prepareStatement("insert into USERDETAILS(name,address,language,Year)  values(?,?,?,?)");
	           
	            ps.setString(1, name);
	            ps.setString(2, Addr);
	            ps.setString(3, language);
	            ps.setString(4, Year);
	 
	            int i = ps.executeUpdate();
	            if (i > 0)
	            	
	            	
	            	response.sendRedirect("https://backoffice.iveri.co.za/Lite/Transactions/New/EasyAuthorise.aspx");
	            
	            else{
	            	
	            	response.sendRedirect("success.jsp");
	            	
	            }
		
		
	
		
		 }
		 
		 catch(Exception e){
			 
		 e.printStackTrace();
		 }
		 }
}