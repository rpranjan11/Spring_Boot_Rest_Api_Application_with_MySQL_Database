package com.assignmentfullstackhire.delegate;

import org.springframework.stereotype.Service;

import com.assignmentfullstackhire.dao.AssignmentFullStackHireDAO;

@Service
public class AssignmentFullStackHireDelegate {
	
    private AssignmentFullStackHireDAO assignmentFullStackHireDAO = new AssignmentFullStackHireDAO();
	
	public boolean isUserExist(String user) {
		System.out.println("AssignmentFullStackHireDelegate : isUserExist");
		return assignmentFullStackHireDAO.isUserExist(user);
	}
	
	public String createUser(String user) {
		System.out.println("AssignmentFullStackHireDelegate : createUser");
		if(validateString(user)) {
			assignmentFullStackHireDAO.createUser(user);
			return "User Successfully Created";
		}
		return "User is invalid";
	}
	
	public boolean findById(int id) {
		System.out.println("AssignmentFullStackHireDelegate : findById");
		return assignmentFullStackHireDAO.findById(id);
		
	}

	public String updateUser(int id, String user) {
		System.out.println("AssignmentFullStackHireDelegate : updateUser");
		if(validateString(user)) {
			assignmentFullStackHireDAO.updateUser(id, user);
			return "User Successfully Updated";
		}
		return "User is invalid";
	}

	public void deleteUser(int id) {
		System.out.println("AssignmentFullStackHireDelegate : deleteUser");
		assignmentFullStackHireDAO.deleteUser(id);		
	}

	public String readUser(int id) {
		System.out.println("AssignmentFullStackHireDelegate : readUser");
		return assignmentFullStackHireDAO.readUser(id);
	}
	
	private static boolean validateString(String user) {
		System.out.println("AssignmentFullStackHireDelegate : validateString");

	    String specialCharacter = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
	    char currentCharacter;
	    boolean numberInString = false;
	    boolean upperCaseInString = false;
	    boolean lowerCaseInString = false;
	    boolean specialCharacterInString = false;
	    int length = user.length();
	    
	    if(length < 6 || length > 16)
	    	return false;
	 
	    for (int i = 0; i < user.length(); i++) {
	        currentCharacter = user.charAt(i);
	        if (Character.isDigit(currentCharacter)) {
	            numberInString = true;
	        } else if (Character.isUpperCase(currentCharacter)) {
	            upperCaseInString = true;
	        } else if (Character.isLowerCase(currentCharacter)) {
	            lowerCaseInString = true;
	        } else if (specialCharacter.contains(String.valueOf(currentCharacter))) {
	            specialCharacterInString = true;
	        }
	    }
	 
	    return numberInString && upperCaseInString && lowerCaseInString && specialCharacterInString;
	}

}
