package com.assignmentfullstackhire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class AssignmentFullStackHireDAO extends BaseDAO
{
	
	public void createUserTable() {
		System.out.println("AssignmentFullStackHireDAO : createUserTable");
		Connection conn = null;
		
		try {
			conn = getDatabaseConnection();
			
			String sqlQuery = AssignmentMySQLQueries.createTable_USER;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDatabaseConnection();
		}
	}
	
	public boolean isUserExist(String user) {
		System.out.println("AssignmentFullStackHireDAO : isUserExist");
		Connection conn = null;
		boolean isExist = false;
		ResultSet rs = null;
		
		try {
			conn = getDatabaseConnection();
			
			String sqlQuery = AssignmentMySQLQueries.isUserExist;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if(rs.next())
				isExist = true;
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDatabaseConnection();
		}
		return isExist;
	}

	public void createUser(String user) {
		System.out.println("AssignmentFullStackHireDAO : createUser");
		Connection conn = null;
		
		try {
			conn = getDatabaseConnection();
			
			String sqlQuery = AssignmentMySQLQueries.createUser;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, user);
			int rowsAffected = ps.executeUpdate();
			System.out.println("No. of rows inserted : " + rowsAffected);
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDatabaseConnection();
		}
	}

	public boolean findById(int id) {
		System.out.println("AssignmentFullStackHireDAO : findById");
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = getDatabaseConnection();
			String sqlQuery = AssignmentMySQLQueries.findById;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				rs.close();
				ps.close();
				return true;
			}
			else {
				rs.close();
				ps.close();
				return false;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeDatabaseConnection();
		}
	}

	public void updateUser(int id, String user) {
		System.out.println("AssignmentFullStackHireDAO : updateUser");
		Connection conn = null;
		
		try {
			conn = getDatabaseConnection();
			String sqlQuery = AssignmentMySQLQueries.updateUser;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, user);
			ps.setInt(2, id);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeDatabaseConnection();
		}		
	}

	public void deleteUser(int id) {
		System.out.println("AssignmentFullStackHireDAO : deleteUser");
		Connection conn = null;
		
		try {
			conn = getDatabaseConnection();
			String sqlQuery = AssignmentMySQLQueries.deleteUser;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeDatabaseConnection();
		}			
	}

	public String readUser(int id) {
		System.out.println("AssignmentFullStackHireDAO : readUser");
		Connection conn = null;
		ResultSet rs = null;
		String user = null;
		
		try {
			conn = getDatabaseConnection();
			String sqlQuery = AssignmentMySQLQueries.readUser;
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = rs.getString("username");
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeDatabaseConnection();
		}
		return user;
	}
    
}
