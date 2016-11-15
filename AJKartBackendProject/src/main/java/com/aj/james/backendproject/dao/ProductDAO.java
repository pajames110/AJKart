package com.aj.james.backendproject.dao;

import java.util.List;

import com.aj.james.backendproject.model.Product;


public interface ProductDAO {
	
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public Product get(String i);
	
	public List<Product> list();

}
