package com.aj.james.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aj.james.model.Category;

@Repository
public interface CategoryDAO {

	public Category get(String id);

	public Category getByName(String name);

	public boolean saveOrUpdate(Category category);

	public boolean delete(String id);

	public List<Category> list();
}
