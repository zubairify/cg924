package com.cg.service;

import java.util.List;

import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;
import com.cg.pojo.Employee;
import com.cg.util.InvalidEmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao;
	
	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl();
	}
	
	@Override
	public boolean save(Employee e) {
		return dao.save(e);
	}

	@Override
	public List<Employee> list() {
		return dao.list();
	}

	@Override
	public Employee findById(int empNo) throws InvalidEmployeeException {
		return dao.findById(empNo);
	}

	@Override
	public boolean deleteById(int empNo) throws InvalidEmployeeException {
		return dao.deleteById(empNo);
	}
}
