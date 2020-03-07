package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JdbcJobTitles {
		
	String dbUsername= "syntax_hrm";
	String dbPassword= "syntaxhrm123";
	String dbUrl= "jdbc:mysql://54.167.125.15/syntaxhrm_mysql";
	
	
	@Test
	public void getDataFromDatabase() throws SQLException {
		
		Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		
		System.out.println("Connection is created");
		
		Statement st = connection.createStatement();
	    ResultSet rset= st.executeQuery("select * from ohrm_job_title");
	    
	    
	   List <String> jobList= new ArrayList<>();
	    while(rset.next()) {
	    String data=rset.getString("job_title");
	    jobList.add(data);
	    }
	    
	    for(String jList:jobList) {
	    	System.out.println(jList);
	    	
	    	
	    }
	    System.out.println(jobList.size());
	    
	    rset.close();
	    st.close();
	    connection.close();
	}
}
