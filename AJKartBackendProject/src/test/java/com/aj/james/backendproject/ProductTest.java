package com.aj.james.backendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aj.james.backendproject.config.ApplicationConfig;
import com.aj.james.backendproject.model.Category;
import com.aj.james.backendproject.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("AppcOntext");
		
		annotationApplication.scan("com.aj.james.backendproject");

		System.out.println("refresh");
		
		Product product =  (Product) annotationApplication.getBean("product");
		System.out.println(""+product);
		System.out.println("category");

	}

}
