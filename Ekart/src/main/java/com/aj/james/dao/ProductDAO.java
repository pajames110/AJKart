package com.aj.james.dao;

import java.util.List;

import com.aj.james.model.Product;


public interface ProductDAO {
	

	public boolean update(Product product);

	public boolean saveOrUpdate(Product product);

	public boolean delete(String id);

	public Product get(String id);
	
	public Product getByName(String name);

	public List<Product> list();

}
