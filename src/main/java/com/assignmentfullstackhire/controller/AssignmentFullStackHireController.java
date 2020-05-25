package com.assignmentfullstackhire.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignmentfullstackhire.delegate.AssignmentFullStackHireDelegate;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssignmentFullStackHireController 
{
    private AssignmentFullStackHireDelegate assignmentFullStackHireDelegate = new AssignmentFullStackHireDelegate();
    
    @PostMapping(value = "/createUser", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<?> createUser(@RequestBody String user) {
    	System.out.println("AssignmentFullStackHireController : createUser");
    	System.out.println("Checking & Creating User by name : " + user);
    	
        if (assignmentFullStackHireDelegate.isUserExist(user)) {
        	System.out.println("Unable to create an user. An User already exist with name : " + user);
            return new ResponseEntity<String>("Unable to create. An User already exist with name : " + user, HttpStatus.CONFLICT);
        }
        
        String response = assignmentFullStackHireDelegate.createUser(user);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
  
    @PostMapping(value = "/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody String user) {
    	System.out.println("AssignmentFullStackHireController : updateUser");
    	System.out.println("Checking & Updating User by id : " + id);
 
    	if (!assignmentFullStackHireDelegate.findById(id)) {
        	System.out.println("Unable to update user. User does not exist with id : " + id);
            return new ResponseEntity<String>("Unable to updateuser. User does not exist with id : " + id, HttpStatus.NOT_FOUND);
        }
 
    	String response = assignmentFullStackHireDelegate.updateUser(id, user);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
  
    @DeleteMapping(value = "/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
    	System.out.println("AssignmentFullStackHireController : deleteUser");
    	System.out.println("Checking & deleting User by id : " + id);
 
    	if (!assignmentFullStackHireDelegate.findById(id)) {
    		System.out.println("Unable to delete user. User does not exist with id : " + id);
            return new ResponseEntity<String>("Unable to delete user. User does not exist with id : " + id, HttpStatus.NOT_FOUND);
        }
    	assignmentFullStackHireDelegate.deleteUser(id);
        return new ResponseEntity<String>("User successfully deleted", HttpStatus.OK);
    }
        
    @PostMapping(value = "/readUser/{id}")
    public ResponseEntity<?> readUser(@PathVariable("id") int id) {
    	System.out.println("AssignmentFullStackHireController : readUser");
    	System.out.println("Reading User by id : " + id);
 
    	String user = assignmentFullStackHireDelegate.readUser(id);
    	if(user != null)
    		return new ResponseEntity<String>("User with id " + id + " is : " + user, HttpStatus.OK);
    	else
    		return new ResponseEntity<String>("User does not exist with id : " + id, HttpStatus.NOT_FOUND);
    }
    
}
