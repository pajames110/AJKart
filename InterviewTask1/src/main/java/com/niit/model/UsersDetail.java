package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class UsersDetail{
	
	
	

	@Id
    @GeneratedValue
    private int userId;

	@Size(min=3,max=30, message = "Size can be between 3 and 30")
	@NotEmpty (message = "User full name can not be empty.")
    private String userFullName;

	@Size(min=3,max=30, message="Username Size can be between 3 and 30")
	@NotEmpty (message = "Username can not be empty.")
	@Column(unique = true)
    private String username;
	
	@Pattern(regexp=".+@.+\\.[a-z]+", message = "email format abc@xyz.com")
	@NotEmpty (message = "Email can not be empty.")
	@Column(unique = true)
    private String userEmail;
	
	
	@Pattern(regexp="\\d{10}" , message = "Enter 10 digit phone number")
	@NotEmpty (message = "Phone can not be empty.")
	@Column(unique = true)
	private String userPhone;	
	
	
	
	 
	@NotEmpty (message = "Password can not be empty.")
    private String password;

	@NotEmpty (message = "Country can not be empty.")
   private String Country;
	@NotEmpty (message = "City can not be empty.")
   private String City;
	@NotEmpty (message = "State can not be empty.")
   private String State;
	@NotEmpty (message = "Interests can not be empty.")
   private String Interests;
    
  

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
			return userPhone;
	}

	public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
	}

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

  
   
    public int getUserId() {
  		return userId;
  	}

  	public void setUserId(int userId) {
  		this.userId = userId;
  	}
  	 public String getUserFullName() {
 		return userFullName;
 	}

 	public void setUserFullName(String userFullName) {
 		this.userFullName = userFullName;
 	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getInterests() {
		return Interests;
	}

	public void setInterests(String interests) {
		Interests = interests;
	}
}