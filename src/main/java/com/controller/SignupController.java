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
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		String phone = request.getParameter("phone");
		String desg = request.getParameter("desg");
		String doj = request.getParameter("doj");
		String dob = request.getParameter("dob");
		int salary =Integer.parseInt(request.getParameter("salary"));
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		Emp e1 = new Emp(name,password,email,phone,desg,doj,dob,salary,city,state,zipcode,country);
			
		int status = EmpDao.addEmp(e1);
		
		if(status > 0)
		{
			pw.print("Your data has been successfully inserted...");
			RequestDispatcher rd = request.getRequestDispatcher("AllEmpInfo");
			rd.include(request, response);
		}
		else
		{
			pw.print("Sorry something went wrong");
		}
		

	}

}
