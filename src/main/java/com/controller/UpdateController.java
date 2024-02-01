package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Emp;
import com.dao.EmpDao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String desg = request.getParameter("desg");
		String doj = request.getParameter("doj");
		String dob = request.getParameter("dob");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String city = request.getParameter("city");
		String state= request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		
		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setPhone(phone);
		e.setDesgnation(desg);
		e.setDoj(doj);
		e.setDob(dob);
		e.setSalary(salary);
		e.setCity(city);
		e.setState(state);
		e.setZip_code(zipcode);
		e.setCountry(country);
		
		int status = EmpDao.updateemp(e);
		if(status > 0)
		{
			pw.print("<script> alert(' Data has been updated') </script>");
			RequestDispatcher rd = request.getRequestDispatcher("AllEmpInfo");
			rd.include(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
