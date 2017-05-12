package com.niit.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.EmployeeDAO;
import com.niit.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOimpl implements EmployeeDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional  
	public int addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();  
		  Transaction tx = session.beginTransaction();  
		  session.saveOrUpdate(employee);  
		  tx.commit();  
		  Serializable id = session.getIdentifier(employee);  
		  session.close();  
		  return (Integer) id;  
	}

	@Transactional
	public List<Employee> getList() {
		 Session session = sessionFactory.openSession();  
		  @SuppressWarnings("unchecked")  
		  List<Employee> employeeList = session.createQuery("from Employee")  
		    .list();  
		  session.close();  
		  return employeeList;  
	}

	@Transactional
	public Employee getRowById(int id) {
		Session session = sessionFactory.openSession();  
		  Employee employee = (Employee) session.load(Employee.class, id);  
		  return employee;  
	}

	
	@Transactional
	public int updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();  
		  Transaction tx = session.beginTransaction();  
		  session.saveOrUpdate(employee);  
		  tx.commit();  
		  Serializable id = session.getIdentifier(employee);  
		  session.close();  
		  return (Integer) id;  
	}

	@Transactional
	public int deleteEmployee(int id) {
		Session session = sessionFactory.openSession();  
		  Transaction tx = session.beginTransaction();  
		  Employee employee = (Employee) session.load(Employee.class, id);  
		  session.delete(employee);  
		  tx.commit();  
		  Serializable ids = session.getIdentifier(employee);  
		  session.close();  
		  return (Integer) ids;  	}

}
