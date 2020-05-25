package com.assignmentfullstackhire.dao;

public class AssignmentMySQLQueries {
	
	public static final String createTable_USER = "Create table USER(id INTEGER NOT NULL AUTO_INCREMENT, username VARCHAR(16) BINARY NOT NULL UNIQUE, PRIMARY KEY (id))";
	
	public static final String createUser = "Insert into USER(username) VALUES (?)";

	public static final String isUserExist = "SELECT id from USER where username = ?";
	
	public static final String findById = "SELECT * FROM USER WHERE id = ?";
	
	public static final String updateUser = "UPDATE USER SET username = ? WHERE id = ?";
	
	public static final String deleteUser = "DELETE FROM USER WHERE id = ?";
	
	public static final String readUser = "SELECT username FROM USER WHERE id = ?";	
	
}
