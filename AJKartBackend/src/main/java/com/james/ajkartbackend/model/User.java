package com.james.ajkartbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@Component
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@NotEmpty(message="Name should not be empty")
    @Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
	private String username;
   
    @NotEmpty(message="Password should not be empty")
    @Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	private String password;
	
    @NotEmpty(message="Email should not be empty")
    @Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String userEmail;
    
    @NotEmpty(message="Mobile Number should not be empty")
    //@Pattern(regexp="(^$|[0-9]{10})")
    private String user_mobile_number;
	private String user_address;
	
	
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
	public String getUser_mobile_number() {
		return user_mobile_number;
	}
	public void setUser_mobile_number(String user_mobile_number) {
		this.user_mobile_number = user_mobile_number;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setUser_email(String string) {
		// TODO Auto-generated method stub
		
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
