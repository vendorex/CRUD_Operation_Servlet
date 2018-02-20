package com.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.model.Employee;
import com.hp.service.IEmployeeService;
import com.hp.service.impl.EmployeeServiceImpl;

@WebServlet("/SaveServlet")
public class EmployeeSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	IEmployeeService service = new EmployeeServiceImpl();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

	
	   res.setContentType("text/html");
	   PrintWriter out = res.getWriter();
	   
	   String name = req.getParameter("name");
	   String password = req.getParameter("password");
	   String email = req.getParameter("email");
	   String country = req.getParameter("country");
	   
	   Employee emp = new Employee();
	   emp.setName(name);
	   emp.setPassword(password);
	   emp.setEmail(email);
	   emp.setCountry(country);
	   
	   int status = service.saveEmployee(emp);
	   if(status>0){
		   out.print("<p1> Record saved successfully..! </p>");
		   req.getRequestDispatcher("index.html").include(req, res);
	   }
	   else{
		   out.print("Sorry..! unable to save record");
	   }
	
	   out.close();
	}
}
