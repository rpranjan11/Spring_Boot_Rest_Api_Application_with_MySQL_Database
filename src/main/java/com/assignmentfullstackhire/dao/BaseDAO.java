package com.assignmentfullstackhire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/AssignmentFullStackHire?useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "ranjan";
    private Connection connection = null;
	
	public Connection getDatabaseConnection() 
	{
		System.out.println("Method : getDatabaseConnection");
		
	    try 
	    {
	        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        System.out.println("Connection to database established!");
	        
	        return connection;
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	        System.out.println("Connection Failed! Check output console");
	        return null;
	    }
	}
	
	public void closeDatabaseConnection() 
	{
		System.out.println("Method : closeDatabaseConnection");
		
		try 
		{
            if(connection != null)
                connection.close();
            System.out.println("Connection closed !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
