package com.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Admin;
import com.backend.Entity.User;
import com.backend.Repo.AdminRepo;
import com.backend.Repo.UserRepo;
@Service
public class AdminService {

	@Autowired
    AdminRepo adminRepo;
	
	
	
	
	
	
	
	public Admin save(Admin admin) {
		
	    return adminRepo.save(admin);
	}
    
    public Admin signIn(Admin admin) {
        
       
        return adminRepo.signIn(admin.getId(), admin.getPassword());

       
    }
    
    
public Admin getUserById(Integer adminId) {
        
    	
    	
        if(adminRepo.findById(adminId).isPresent()) {
            return adminRepo.findById(adminId).get();
        }
        
        
        throw new Error("User not found");
        
    }


public void deleteAdminById(Integer id) {

    adminRepo.deleteById(id);
    
}



public Admin updateAdmin(Admin admin) throws Exception {

    if(admin.getId() == null) {
        throw new Exception("error...");
    }
    return adminRepo.save(admin);
    
}
}
