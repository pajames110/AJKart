package com.aj.james.backendproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@Component
public class User {

	@Id
	private String user_id;
	private String user_name;
	private String user_address;
	private String user_mobile_number;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_mobile_number() {
		return user_mobile_number;
	}

	public void setUser_mobile_number(String user_mobile_number) {
		this.user_mobile_number = user_mobile_number;
	}

}
