package com.niit.dao;

import java.util.List;

import com.niit.model.Employee;

public interface EmployeeDAO {
	
	 public int addEmployee(Employee employee);  
	 
	 public List<Employee> getList();  
	  
	 public Employee getRowById(int id);  
	  
	 public int updateEmployee(Employee employee);  
	  
	 public int deleteEmployee(int id);  

}
