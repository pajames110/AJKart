package com.james.ajkartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.james.ajkartbackend.model.Category;

@Repository
public interface CategoryDAO {

	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category get(String i);
	
	public List<Category> list();
}
