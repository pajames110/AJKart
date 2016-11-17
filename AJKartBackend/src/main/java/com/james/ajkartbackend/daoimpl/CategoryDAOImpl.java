package com.james.ajkartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.james.ajkartbackend.dao.CategoryDAO;
import com.james.ajkartbackend.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Category category) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean update(Category category) {

		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public Category get(String id) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}
	
	@Transactional
	public List<Category> list() {

		String hql = "from Category";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
