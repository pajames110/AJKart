package com.james.ajkartbackend.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.james.ajkartbackend.dao.UserDAO;
import com.james.ajkartbackend.model.User;
import com.james.ajkartbackend.model.UserRole;

import junit.framework.Assert;

public class UserTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context; 
	@Autowired
	static User user;
	@Autowired
	static UserDAO userDAO;
	@Autowired
	UserRole userRole;
	
	@BeforeClass
	public static void init(){
		System.out.println("Entering init");
		context = new AnnotationConfigApplicationContext();
		context.scan("com.james.ajkartbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
		
		}
	
	@Test
	public void createUserTestCase(){
		
		
		user.setUsername("Muneef");
		user.setUser_email("james.ajbtech@gmail.com");
		user.setUser_mobile_number("9000480992");
		
		boolean status = userDAO.save(user);
		Assert.assertEquals("update catgories", true, status);
	}
	
//	@Test
//	public void deleteUserTestCase(){
//		
//		user.setCategory_id("GUI_03");
//		
//		boolean status = userDAO.delete(user);
//		
//		Assert.assertEquals("Delete User test", true,status);
//		
//	}
//	
	//@Test
	public void updateUserTestCase(){
		
		user.setUsername("Noel");
		user.setUser_email("james");
		
		boolean status = userDAO.update(user);
		
		Assert.assertEquals("Update user", true, status);
	}
	
	//@Test
	public void getUserTestCase(){
		
		Assert.assertEquals("Get user test case",null , userDAO.get("3"));
	}
	
	//@Test
	public void getAllTestCase(){
		Assert.assertEquals("GetAllTest case", 11, userDAO.list().size());
	}
	

}
