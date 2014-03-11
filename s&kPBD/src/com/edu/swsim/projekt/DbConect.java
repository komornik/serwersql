package com.edu.swsim.projekt;

import java.sql.*;

class DBConect{
	
	private Connection con;
	
	public DBConect(){
		
	}
	
	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con =
			//DriverManager.getConnection("jdbc:mysql://localhost:6033/ankieta","root","adm123");
			DriverManager.getConnection("jdbc:mysql://localhost/ankieta","root","adm123");
			
		}
		catch(SQLException ec) {
			System.err.println(ec.getMessage()); 
		}
		catch(ClassNotFoundException ex) {
			System.err.println("Cannot find driver.");
		}
		return con;
	}
}