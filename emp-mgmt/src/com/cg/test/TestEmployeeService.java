package com.cg.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.cg.pojo.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;
import com.cg.util.InvalidEmployeeException;

public class TestEmployeeService {
	
	private static EmployeeService service;
	
	@BeforeAll
	public static void init() {
		service = new EmployeeServiceImpl();
	}

	@Disabled
	@Test
	public void testSave() {
		Employee e = new Employee(123, "Jack", 2300);
		assertTrue(service.save(e));
	}
	
	@Test
	public void testList() {
		assertEquals(service.list().size(), 10);
	}
	
	@Test
	public void testFindById() {
		try {
			assertNotNull(service.findById(123));
		} catch (InvalidEmployeeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByInvalidId() {
		assertThrows(InvalidEmployeeException.class, () -> service.findById(999));
	}
	
	@Test
	public void testDeleteById() {
		
	}
	
	@Test
	public void testDeleteByInvalidId() {
		
	}
}
