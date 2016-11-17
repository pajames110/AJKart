package com.james.ajkartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.james.ajkartbackend.dao.ProductDAO;
import com.james.ajkartbackend.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public Product get(String id) {
		// TODO Auto-generated method stub
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
	@Transactional
	public List<Product> list() {

		String hql = "from Product";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}


}
