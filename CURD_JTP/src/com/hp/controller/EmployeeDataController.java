package com.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.model.Employee;
import com.hp.service.IEmployeeService;
import com.hp.service.impl.EmployeeServiceImpl;

@WebServlet("/ViewServlet")
public class EmployeeDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IEmployeeService service = new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		
		out.print("<a href='index.html'>Add New Employee</a>");
		out.print("<h1>Employee List</h1>");
		
		List<Employee> list = service.getAllEmployees();
		
		out.print("<table border='a'>");
		out.print("<tr><th>ID</th><th>NAME</th><th>PASSWORD</th><th>EMAIL</th><th>COUNTRY</th><th>EDIT</th><th>DELETE</th> </tr>");
		
		for(Employee e : list) {
		
			out.print("<tr><td>"+e.getId()+"</td> <td>"+e.getName()+"</td> <td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td>"
					+ "<td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td>"
							+ "<td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a> </td></tr>");
		}
		out.print("</table>");
		out.close();
	}
}
