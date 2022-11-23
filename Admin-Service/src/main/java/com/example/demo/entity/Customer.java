package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="users")
public class Customer  {



//USER ID AUTOMATIC GENERATED
    



@Id
private String id;



//USER NAME unique
//@Indexed(unique = true)
private String firstname;



private String lastname;



//USER PASSWORD
private String password;



//USER EMAIL unique
//@Indexed(unique = true)
private String email;
public Customer()
{
	
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
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


public Customer(String id, String firstname, String lastname, String password, String email) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.password = password;
	this.email = email;
}


@Override
public String toString() {
	return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
			+ ", email=" + email + "]";
}

}



