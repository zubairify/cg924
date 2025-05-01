package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.pojo.Employee;
import com.cg.util.JdbcUtil;
import com.cg.util.InvalidEmployeeException;

public class EmployeeJdbcDaoImpl implements EmployeeDao {
	
	@Override
	public boolean save(Employee e) {
		String sql = "insert into emp values (?,?,?)";	
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, e.getEmpNo());
			stmt.setString(2, e.getEmpName());
			stmt.setDouble(3, e.getSalary());
			if(stmt.executeUpdate() == 1)
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> list() {
		String sql = "select * from emp";
		List<Employee> emps = new ArrayList<Employee>();
		
		try {
			Connection conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				emps.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return emps;
	}

	@Override
	public Employee findById(int empNo) throws InvalidEmployeeException {
		String sql = "select * from emp where empno="+empNo;
		
		try {
			Connection conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				return e;
			} else
				throw new InvalidEmployeeException("Employee not found with No:" + empNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean deleteById(int empNo) throws InvalidEmployeeException {
		String sql = "delete from emp where empno=" + empNo;
		
		try {
			Connection conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) == 1)
				return true;
			else
				throw new InvalidEmployeeException("Employee not found with No:" + empNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
}
