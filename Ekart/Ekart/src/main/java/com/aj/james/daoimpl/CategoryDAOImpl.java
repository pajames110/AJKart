package com.aj.james.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.aj.james.dao.CategoryDAO;
import com.aj.james.model.Category;

@Component
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public Category get(String id) {

		String hql = "from Category where category_id='" + id + "'";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;
	}

	@Transactional
	public Category getByName(String name) {

		String hql = "from Category where category_name='" + name + "'";

		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();

		if (listCategory != null && !listCategory.isEmpty()) {

			return listCategory.get(0);
		}
		return null;
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {

		try {
			System.out.println("inside save or update");
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(category); 
			session.flush();
					
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean delete(String id) {
		
		try {
			Category categoryToDelete = new Category();
			categoryToDelete.setCategory_id(id);;
			Session session = sessionFactory.openSession();
			session.delete(categoryToDelete);
			session.flush();
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> list() {
		

		String hql = "from Category ORDER BY category_id ASC";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		if (list == null || list.isEmpty()) {
		System.out.println("list is empty");
		}
		
		return list;
	}

	// @Transactional
	// public boolean save(Category category) {
	// // TODO Auto-generated method stub
	//
	// try {
	// sessionFactory.openSession().saveOrUpdate(category);
	// return true;
	// } catch (HibernateException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return false;
	// }
	//
	// }
	//
	// //@Transactional
	// public boolean update(Category category) {
	//
	// try {
	// sessionFactory.openSession().update(category);
	// return true;
	// } catch (HibernateException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return false;
	// }
	//
	// }
	//
	// @Transactional
	// public boolean delete(Category category) {
	// // TODO Auto-generated method stub
	//
	// try {
	// sessionFactory.openSession().delete(category);
	// return true;
	// } catch (HibernateException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return false;
	// }
	//
	// }
	// @Transactional
	// public boolean delete(String id) {
	// try {
	// Category categoryToDelete = new Category();
	// categoryToDelete.setCategory_id(id);
	// Session session = sessionFactory.openSession();
	// session.delete(categoryToDelete);
	// session.flush();
	//
	// return true;
	// } catch (HibernateException e) {
	// // TODO Auto-generated catch block
	//
	// e.printStackTrace();
	// return false;
	// }
	// }
	//
	// @Transactional
	// public Category get(String id) {
	// // TODO Auto-generated method stub
	// return (Category) sessionFactory.openSession().get(Category.class, id);
	// }
	//
	// @Transactional
	// public List<Category> list() {
	//
	// String hql = "from Category";
	//
	//
	// Query query = sessionFactory.openSession().createQuery(hql);
	// return query.list();
	// }

}
