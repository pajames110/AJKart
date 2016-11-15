package com.aj.james.backendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aj.james.backendproject.config.ApplicationConfig;
import com.aj.james.backendproject.model.Product;
import com.aj.james.backendproject.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("AppcOntext");
		
		annotationApplication.scan("com.aj.james.backendproject");

		System.out.println("refresh");
		
		Supplier supplier =  (Supplier) annotationApplication.getBean("supplier");

	}

}
