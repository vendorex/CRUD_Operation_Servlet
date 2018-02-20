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

@WebServlet("/EditServlet")
public class EmployeeEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IEmployeeService service = new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<h1>Update Employee </h1>");
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee emp = service.getEmployeeById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+emp.getId()+"'></td></tr>");
		out.print("<tr><td>NAME :</td><td><input type='text' name='name' value='"+emp.getName()+"'></td></tr>");
		out.print("<tr><td>PASSWORD : </td><td><input type='password' name='password' value='"+emp.getPassword()+"'> </td></tr>");
		out.print("<tr><td>Email : </td><td><input type='email' name='email' value='"+emp.getEmail()+"'> </td></tr>");
		
		out.print("<tr><td>Country</td><td>");
		out.print("<select name='country'>");
		out.print("<option value='"+emp.getCountry()+"'>India</option>");
		out.print("<option value='"+emp.getCountry()+"'>China</option>");
		out.print("<option value='"+emp.getCountry()+"'>USA</option>");
		out.print("</select>");
		out.print("</td></tr>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'> </td></tr>");
		
		out.print("</table>");
		out.print("</form>");
	
		out.close();
	}
	
	
	

}
