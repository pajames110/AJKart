package com.james.ajkartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.james.ajkartbackend.dao.UserDAO;
import com.james.ajkartbackend.model.User;
import com.james.ajkartbackend.model.UserRole;

@Repository("userDAO")
public class UserDaoImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean save(User user) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.openSession().save(user);
			UserRole userRole = new UserRole();
			userRole.setUserRole_id(user.getUser_id());
			userRole.setUser_role("ROLE_USER");
			userRole.setUsername(user.getUsername());
			try{
				System.out.println("Entering try of save userrole");
			sessionFactory.openSession().save(userRole);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean update(User user) {

		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public User get(String id) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	@Transactional
	public List<User> list() {

		String hql = "from User";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
