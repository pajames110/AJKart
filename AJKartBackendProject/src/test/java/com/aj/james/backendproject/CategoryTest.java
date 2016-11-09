package com.aj.james.backendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aj.james.backendproject.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext();
		System.out.println("AppcOntext");
		
		annotationApplication.scan("com.aj.james.backendproject");
		annotationApplication.refresh();
		System.out.println("refresh");
		
		Category category =  (Category) annotationApplication.getBean("category");
		System.out.println(""+category);
		System.out.println("category");
	}

}
