package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hp.dao.IEmployeeDao;
import com.hp.model.Employee;
import com.hp.util.ConUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	ConUtil conUtil = new ConUtil();
	
	
	
	@Override
	public int saveEmployee(Employee emp) {
		int status = 0;
		
		try{
			Connection con = conUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into usertab (id, name, password, email, country) values(user_seq.nextVal, ?,?,?,?)");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getCountry());

			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	
	@Override
	public int updateEmployee(Employee emp) {
		int status = 0;
		
		try{
		      Connection con = conUtil.getConnection();
		      PreparedStatement ps = con.prepareStatement("update usertab set name=?, password=?, email=?, country=? where id=?");
		      ps.setString(1, emp.getName());
		      ps.setString(2, emp.getPassword());
		      ps.setString(3, emp.getEmail());
		      ps.setString(4, emp.getCountry());
		      ps.setInt(5, emp.getId());
		      
		      status = ps.executeUpdate();
		      con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}


	
	@Override
	public int deleteEmployee(int empId) {
		int status = 0;
		
		try{
		      Connection con = conUtil.getConnection();
		      PreparedStatement ps = con.prepareStatement("delete from usertab where id=?");
		      ps.setInt(1, empId);
		      
		      status = ps.executeUpdate();
		      con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}

	
	
	
	@Override
	public Employee getEmployeeById(int empId) {
	
		Employee e = new Employee();
		
		try{
			Connection con = conUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usertab where id=?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return e;
	}

	
	
	
	@Override
	public List<Employee> getAllEmployees() {
	
		List<Employee> list = new ArrayList<Employee>();
		
		try{
			Connection con = conUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usertab");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setCountry(rs.getString(5));
				
				list.add(emp);
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
