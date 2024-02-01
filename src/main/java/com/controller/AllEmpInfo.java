package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Emp;
import com.dao.EmpDao;

/**
 * Servlet implementation class AllEmpInfo
 * padding: 8px; text-align: left; border-bottom: 1px solid #ddd;
 */
@WebServlet("/AllEmpInfo")
public class AllEmpInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmpInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response .getWriter();
		List<Emp> list = EmpDao.getAllEmployee();
			
		pw.print("<h1 style='  background-color:#27374D; color: white; text-align: center; height: 40px;'>All Employee Information </h1>");
		pw.print("<table style='background-color:#d5e1e3; border-collapse: collapse; border:1px solid black; margin:10px;' width='100%'>");
		pw.print("<tr><th style='padding:10px;'>id</th><th>Name</th><th>Password</th><th>Email</th><th>Phone</th><th>Designation</th><th>Date_Of_Joining</th><th>Date_Of_Birth</th><th>Salary</th><th>City</th><th>State</th><th>Zip_Code</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list) 
		{
			pw.print(" <tr><td style=' padding:10px;'>"+e.getId() +"</td> <td>"+
			e.getName()+"</td><td>"+e.getPassword()+"</td> <td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getDesgnation()+"</td><td>"+e.getDoj()+"</td><td>"+e.getDob() +"</td><td>"+e.getSalary()+"</td><td>"+e.getCity()+"</td><td>"+e.getState()+"</td><td>"+e.getZip_code()+"</td><td>"+e.getCountry()+"</td><td>"+"<a href='EditController?id="+e.getId()+"'>Edit</a></td><td>"+"<a href='DeleteController?id="+e.getId()+"'>Delete</a></td></tr>");
		
		}
		
		pw.print("</table>");	
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
