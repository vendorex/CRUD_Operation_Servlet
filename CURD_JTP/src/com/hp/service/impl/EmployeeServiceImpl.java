package com.hp.service.impl;

import java.util.List;

import com.hp.dao.IEmployeeDao;
import com.hp.dao.impl.EmployeeDaoImpl;
import com.hp.model.Employee;
import com.hp.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public int saveEmployee(Employee emp) {
		return dao.saveEmployee(emp);
	}

	@Override
	public int updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}

	@Override
	public int deleteEmployee(int empId) {
		return dao.deleteEmployee(empId);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return dao.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
