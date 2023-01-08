package com.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

@Column(name="password", nullable = false)
String password;

public Admin(){
	super();
}

public Admin(Integer id,  String password) {
    super();
    this.id = id;
    this.password = password;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Admin [id=" + id + ", password=" + password + "]";
}



}