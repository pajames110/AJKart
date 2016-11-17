package com.james.ajkartbackend.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.james.ajkartbackend.dao.SupplierDAO;
import com.james.ajkartbackend.model.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context; 
	@Autowired
	static Supplier supplier;
	@Autowired
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init(){
		System.out.println("Entering init");
		context = new AnnotationConfigApplicationContext();
		context.scan("com.james.ajkartbackend");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
		
		}
	
	@Test
	public void createSupplierTestCase(){
		
		supplier.setSupplier_id("SUP_06");
		supplier.setSupplier_name("James");
		supplier.setSupplier_description("Supplies Guitars");

		
		boolean status = supplierDAO.save(supplier);
		Assert.assertEquals("update catgories", true, status);
	}
	
//	@Test
//	public void deleteSupplierTestCase(){
//		
//		supplier.serSupplier_id("GUI_03");
//		
//		boolean status = supplierDAO.delete(supplier);
//		
//		Assert.assertEquals("Delete Supplier test", true,status);
//		
//	}
//	
	//@Test
	public void updateSupplierTestCase(){
		
		supplier.setSupplier_id("SUP_02");
		supplier.setSupplier_description("Supplies Keyboard");
		supplier.setSupplier_address("Bangalore");
		supplier.setSupplier_contact_number("12345");
		boolean status = supplierDAO.update(supplier);
		
		Assert.assertEquals("Update supplier", true, status);
	}
	
	//@Test
	public void getSupplierTestCase(){
		
		Assert.assertEquals("Get supplier test case",null , supplierDAO.get("2"));
	}
	
	@Test
	public void getAllTestCase(){
		Assert.assertEquals("GetAllTest case", 3, supplierDAO.list().size());
	}
	

}
