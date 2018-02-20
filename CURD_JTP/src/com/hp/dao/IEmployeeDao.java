package com.hp.dao;

import java.util.List;

import com.hp.model.Employee;

public interface IEmployeeDao {

	public int saveEmployee(Employee emp);
	public int updateEmployee(Employee emp);
	public int deleteEmployee(int empId);
	
	public Employee  getEmployeeById(int empId);
	public List<Employee> getAllEmployees();
}
