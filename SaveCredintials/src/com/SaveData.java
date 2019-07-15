package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class SaveData extends HttpServlet {
	Connection con;
	@Override
	public void init() throws ServletException {

System.out.println("init method");


   

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("service method");
	
	String uname=req.getParameter("name");
	System.out.println(uname);
	String upass=req.getParameter("pass");
	String query="insert into data(name,pas) values('"+uname+"','"+upass+"')";

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	try {
		
		 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		 Statement smt=con.createStatement();
     
		int i=smt.executeUpdate(query);
		PrintWriter pw=resp.getWriter();
		System.out.println(i+"Data save sucessfully");
		pw.println(i);
		smt.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}
@Override
public void destroy() {
	System.out.println("destroy method");
}
}
