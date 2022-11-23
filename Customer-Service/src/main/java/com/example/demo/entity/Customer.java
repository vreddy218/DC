package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="Security")
public class Customer  {

//USER ID AUTOMATIC GENERATED
	
@Id
private String id;
//USER NAME

@Field(name = "username")
private String username;

//USER PASSWORD

private String password;

//USER EMAIL

@Field(name = "email")
private String email;
//EMPTY CONSTRUCTOR
public Customer()
{
	
}
/*
 * SETTERS AND GETTERS
 */
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Customer(String username, String password, String email) {

	this.username = username;
	this.password = password;
	this.email = email;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
 

}
