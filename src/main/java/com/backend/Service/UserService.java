package com.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.User;
import com.backend.Repo.UserRepo;

@Service
public class UserService {
	
   
    @Autowired
    UserRepo userRepo;
	
    
    
	public List<User> getAll() {
		
	    return userRepo.findAll();
	}
	
	public User save(User user) {
		
	    return userRepo.save(user);
	}
    
    public User signIn(User user) {
        
       
        return userRepo.signIn(user.getEmail(), user.getPassword());

       
    }
    
    public User getUserById(Integer userId) {
        
    	
    	
        if(userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        }
        
        
        throw new Error("User not found");
        
    }
    
    public User getUserByEmail(String email) {
        
    	
        User foundUser = userRepo.getByEmail(email);
        
        if(foundUser == null) {
           throw new Error("User not found");
        }
        
        return foundUser;
        
    }
    
    public User updateUser(User user) throws Exception {

        if(user.getId() == null) {
            throw new Exception("error...");
        }
        return userRepo.save(user);
        
    }
    
    public void deleteUserById(Integer id) {

        userRepo.deleteById(id);
        
    }
	

}

