package com.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.service.IEmployeeService;
import com.hp.service.impl.EmployeeServiceImpl;

@WebServlet("/DeleteServlet")
public class EmployeeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IEmployeeService service = new  EmployeeServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/htm");
		PrintWriter out = res.getWriter();
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		service.deleteEmployee(id);
		res.sendRedirect("ViewServlet");
		
		out.close();

	
	}
}
