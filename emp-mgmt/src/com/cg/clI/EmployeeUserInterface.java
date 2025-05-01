package com.cg.clI;

import java.util.Scanner;

import com.cg.pojo.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;
import com.cg.util.InvalidEmployeeException;

public class EmployeeUserInterface {
	private EmployeeService service;

	public EmployeeUserInterface() {
		service = new EmployeeServiceImpl();
	}

	public void add() {
		Scanner console = new Scanner(System.in);
		int eno = 0;
		String ename = "";
		double sal = 0.0;
		
		System.out.print("Enter Emp No: ");
		eno = console.nextInt();
		System.out.print("Enter Emp Name: ");
		ename = console.next();
		
		System.out.print("Enter Salary: ");
		sal = console.nextDouble();
		
		Employee e = new Employee(eno, ename, sal);
		service.save(e);
		
		System.out.println("Employee added..");
	}

	public void find() {
		Scanner console = new Scanner(System.in);
		int eno = 0;
		System.out.print("Enter Emp No: ");
		eno = console.nextInt();
		
		try {
			System.out.println(service.findById(eno));
		} catch (InvalidEmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		System.out.println("List of employees");
		service.list().forEach(System.out::println);
	}

	public void delete() {
		Scanner console = new Scanner(System.in);
		int eno = 0;
		System.out.print("Enter Emp No: ");
		eno = console.nextInt();
		
		try {
			service.deleteById(eno);
			System.out.println("Employee deleted with No: " + eno);
		} catch (InvalidEmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		EmployeeUserInterface ui = new EmployeeUserInterface();

		int option = 0;
		Scanner console = new Scanner(System.in);
		
		while(true) {
			System.out.println("1- Add\n2- List\n3- Find\n4- Delete\n5- Exit");
			System.out.print("Select option: ");
			option = console.nextInt();
			switch(option) {
			case 1 : ui.add(); break;
			case 2 : ui.list(); break;
			case 3 : ui.find(); break;
			case 4 : ui.delete(); break;
			case 5 : System.exit(0);
			default : System.out.println("Invalid option");
			}
		}
	}
}
