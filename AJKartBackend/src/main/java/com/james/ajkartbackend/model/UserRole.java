package com.james.ajkartbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER_ROLE")
@Component
public class UserRole {
	@Id
	@GeneratedValue
	private int userRole_id;
	private String user_role;
	private String username;
	
	public int getUserRole_id() {
		return userRole_id;
	}
	public void setUserRole_id(int userRole_id) {
		this.userRole_id = userRole_id;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
