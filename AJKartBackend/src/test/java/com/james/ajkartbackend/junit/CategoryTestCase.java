package com.james.ajkartbackend.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.james.ajkartbackend.dao.CategoryDAO;
import com.james.ajkartbackend.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context; 
	@Autowired
	static Category category;
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init(){
		System.out.println("Entering init");
		context = new AnnotationConfigApplicationContext();
		context.scan("com.james.ajkartbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		
		}
	
	@Test
	public void createCategoryTestCase(){
		
		category.setCategory_id("GUI_12");
		category.setCategory_name("Guitar");
		category.setDescription("Happy guitar");

		
		boolean status = categoryDAO.save(category);
		Assert.assertEquals("update catgories", true, status);
	}
	
//	@Test
//	public void deleteCategoryTestCase(){
//		
//		category.setCategory_id("GUI_03");
//		
//		boolean status = categoryDAO.delete(category);
//		
//		Assert.assertEquals("Delete Category test", true,status);
//		
//	}
//	
	@Test
	public void updateCategoryTestCase(){
		
		category.setCategory_id("GUI_05");
		category.setDescription("Guitar with Strings");
		
		boolean status = categoryDAO.update(category);
		
		Assert.assertEquals("Update category", true, status);
	}
	
	@Test
	public void getCategoryTestCase(){
		
		Assert.assertEquals("Get category test case",null , categoryDAO.get("3"));
	}
	
	@Test
	public void getAllTestCase(){
		Assert.assertEquals("GetAllTest case", 11, categoryDAO.list().size());
	}
	

}






	
	
	

	


