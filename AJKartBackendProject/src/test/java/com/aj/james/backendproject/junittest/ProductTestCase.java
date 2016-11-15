package com.aj.james.backendproject.junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aj.james.backendproject.dao.ProductDAO;
import com.aj.james.backendproject.model.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context; 
	@Autowired
	static Product product;
	@Autowired
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void init(){
		System.out.println("Entering init");
		context = new AnnotationConfigApplicationContext();
		context.scan("com.aj.james.backendproject");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
		
		}
	
	//@Test
	public void createProductTestCase(){
		
		product.setProduct_id("GUI_11");
		product.setProduct_description("Guitar");
		product.setProduct_description("Happy guitar");

		
		boolean status = productDAO.save(product);
		Assert.assertEquals("update catgories", true, status);
	}
	
//	@Test
//	public void deleteProductTestCase(){
//		
//		product.setProduct_id("GUI_03");
//		
//		boolean status = productDAO.delete(product);
//		
//		
//	}
//	
	@Test
	public void updateProductTestCase(){
		
		product.setProduct_id("GUI_05");
		product.setProduct_description("Guitar with Strings");
		
		boolean status = productDAO.update(product);
		
		Assert.assertEquals("Update product", true, status);
	}
	
	@Test
	public void getProductTestCase(){
		
		Assert.assertEquals("Get product test case",null , productDAO.get("3"));
	}
	
	@Test
	public void getAllTestCase(){
		Assert.assertEquals("GetAllTest case", 11, productDAO.list().size());
	}

}
