package com.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.Entity.User;

@Repository         // Between the <,> first put the type of object, next the type of the primary key
public interface UserRepo extends JpaRepository<User, Integer>{
    
	// You make these to query your DB on non primary key columns
	// The ?1 is to represent the arguments in the function, first argument goes first, then second etc...
	// Annotate and give value= and nativeQuery=true so you can use easy SQL syntax
    @Query(value="select * from user where email = ?1 && password=?2", nativeQuery=true)
    public User signIn(String email, String password);
    
    @Query(value="select * from user where email = ?1", nativeQuery=true)
    public User getByEmail(String email);
}

