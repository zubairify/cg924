package com.cg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.cg.pojo.Employee;
import com.cg.util.InvalidEmployeeException;

/**
 * This class is persistence layer class for employee domain.
 * @author zubair
 * @version 1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> emps;
	
	public EmployeeDaoImpl() {
		emps = new ArrayList<Employee>();
	}

	@Override
	public boolean save(Employee e) {
		emps.add(e);
		return true;
	}

	@Override
	public List<Employee> list() {
		return emps;
	}

	@Override
	public Employee findById(int empNo) throws InvalidEmployeeException {
		return emps.stream().filter(e -> e.getEmpNo() == empNo).findFirst().orElseThrow(() -> 
				new InvalidEmployeeException("Employee not found with No:" + empNo));
	}

	@Override
	public boolean deleteById(int empNo) throws InvalidEmployeeException {
		Employee e = findById(empNo);
		emps.remove(e);
		return true;
	}
}
