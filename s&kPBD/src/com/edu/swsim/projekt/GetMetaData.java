package com.edu.swsim.projekt;

import java.sql.*;

public class GetMetaData{
	
	private Connection con;
	
	public static void main(String[] args){
		GetMetaData get = new GetMetaData();
		get.getMeta();
	}
	
	public void getMeta(){
		DBConect connector = new DBConect();
		con = connector.getConnection();
		try {
						
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs;
			rs=dbmd.getCatalogs(); //databases
			System.out.println("\n------------Bazy danych--------------");
			showRS(rs);
			
			rs=dbmd.getSchemas(); //users
			System.out.println("\n------------U¿ytkownicy--------------");
			showRS(rs);
			
			rs=dbmd.getTableTypes();
			System.out.println("\n-------------Typy tabel--------------");
			showRS(rs);
			
			String[] ttp={"TABLE","VIEW"};
			rs=dbmd.getTables("bazadanych","%","%",ttp);
			System.out.println("\n---------------Tabele----------------");
			showRS(rs);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void showRS(ResultSet rs) throws SQLException {
		int noOfCols = rs.getMetaData().getColumnCount();
		String colNames="";
		for (int i=1;i<=noOfCols;i++)
			colNames = colNames + '|' + rs.getMetaData().getColumnName(i);
		System.out.println(colNames);
		while(rs.next())
		{
			String row="";
			for (int i=1;i<=noOfCols;i++)
				row = row + '|' + rs.getString(i);
			System.out.println(row);
		}
	}
}