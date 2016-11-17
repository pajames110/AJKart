package com.james.ajkartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.james.ajkartbackend.dao.SupplierDAO;
import com.james.ajkartbackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean update(Supplier supplier) {

		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public Supplier get(String id) {
		// TODO Auto-generated method stub
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}
	
	@Transactional
	public List<Supplier> list() {

		String hql = "from Supplier";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
