package com.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Entity.Admin;
import com.backend.Entity.User;
import com.backend.Service.AdminService;
import com.backend.Service.UserService;
@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/admin")
public class AdminRestController {
	
	

		
		
		

	 @Autowired
	 AdminService adminService;

	 // Configures my endpoint, /signup in the end url, accepts JSON data, Produces JSON data, accessed with a post
	 
	 
	 
	 
	 
	 @RequestMapping(
	 		value = "/signUp",
	 		consumes = MediaType.APPLICATION_JSON_VALUE,
	 		produces = MediaType.APPLICATION_JSON_VALUE,
	 		method = RequestMethod.POST
	 		)
	 // We return a ResponseEntity<Object> because the object returned may vary, could be user, could be an error
	 // The RequestBody is the information sent to us to process, post and put has request body, get and delete do not
	 // Request body is encrypted, always send password through a post request
	 public ResponseEntity<Object> signUp(@RequestBody Admin admin) {
	 	// Wrap your endpoints in a try catch, if an error happens at any points, you return that error to the client
	     try {
	         Admin signedInAdmin = adminService.save(admin);
	 
	         // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
	         return new ResponseEntity<>(signedInAdmin, HttpStatus.OK);
	     } catch(Exception e) {
	         return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	     } catch(Error e) {
	         return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }

	 @RequestMapping(value = "/signIn",
	         consumes = MediaType.APPLICATION_JSON_VALUE,
	         produces = MediaType.APPLICATION_JSON_VALUE,
	         method = RequestMethod.POST
	         )
	 public ResponseEntity<Object> signIn(@RequestBody Admin admin) {

	     try {
	         Admin signedInAdmin = adminService.signIn(admin);
	         
	         if(signedInAdmin == null) {
	             
	             throw new Error("No user found");
	             
	         }
	 
	         return new ResponseEntity<>(signedInAdmin, HttpStatus.OK);
	         
	     } catch(Exception e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     } catch(Error e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }
	 
	 
	 
	 
	 @RequestMapping(
		        value="/update",
		        consumes = MediaType.APPLICATION_JSON_VALUE,
		        produces = MediaType.APPLICATION_JSON_VALUE,
		        method = RequestMethod.POST
		    )
		    public ResponseEntity<Object> updateAdmin(@RequestBody Admin admin) {

		        try {

		            Admin updatedAdmin = adminService.updateAdmin(admin);
		            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
		        
		        } catch(Exception e) {
		            System.out.println(e.getMessage());
		            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		        } catch(Error e) {
		            System.out.println(e.getMessage());
		            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		    }
	 
	 
	 @RequestMapping(
	    value="/deleteAdminById/{adminId}",
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    method = RequestMethod.DELETE
	)
	public ResponseEntity<Object> deleteById(@PathVariable Integer adminId) {

	    try {

	        adminService.deleteAdminById(adminId);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    } catch(Exception e) {
	        System.out.println(e.getMessage());
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    } catch(Error e) {
	        System.out.println(e.getMessage());
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	}


