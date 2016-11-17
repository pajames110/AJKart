package com.james.ajkartbackend.dao;

import java.util.List;

import com.james.ajkartbackend.model.Product;


public interface ProductDAO {
	
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public Product get(String i);
	
	public List<Product> list();

}
