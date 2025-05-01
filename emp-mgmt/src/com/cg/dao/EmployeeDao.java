package com.cg.dao;

import java.util.List;

import com.cg.pojo.Employee;
import com.cg.util.InvalidEmployeeException;

public interface EmployeeDao {

	boolean save(Employee e);
	
	List<Employee> list();
	
	Employee findById(int empNo) throws InvalidEmployeeException;
	
	boolean deleteById(int empNo) throws InvalidEmployeeException;
}
