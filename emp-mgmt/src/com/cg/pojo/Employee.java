package com.cg.pojo;

/**
 * This object represents an employee.
 * @author zubair
 * @version 1.0
 */
public class Employee {
	private int empNo;
	private String empName;
	private double salary;
	
	/** Default constructor. */
	public Employee() {
	}
	public Employee(int empNo, String empName, double salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp No: " + empNo + "\tEmp Name: " + empName + "\tSalary: " + salary;
	}
}
