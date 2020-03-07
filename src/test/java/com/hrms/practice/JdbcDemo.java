package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {
	
	String dbUsername= "syntax_hrm";
	String dbPassword= "syntaxhrm123";
	String dbUrl= "jdbc:mysql://54.167.125.15/syntaxhrm_mysql";
	
	
	@Test
	public void getDataFromDatabase() throws SQLException {
		
		Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		
		System.out.println("Connection is created");
		
		Statement st = connection.createStatement();
	    ResultSet rset= st.executeQuery("select * from ohrm_nationality");
	    
	    rset.next();
	    String firstRawData=rset.getString("name");
	    System.out.println(firstRawData);
	    
	    rset.next();
	    String secondRowData=rset.getObject("name").toString();
	    System.out.println(secondRowData);
	    
	    String data;
	    while(rset.next()) {
	    	data= rset.getObject("name").toString();
	    	System.out.println(data);
	    	
	    }
	    

	    rset.close();
	    st.close();
	    connection.close();
	}
	
	
}
