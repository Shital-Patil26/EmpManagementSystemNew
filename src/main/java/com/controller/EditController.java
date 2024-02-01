package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Emp;
import com.dao.EmpDao;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		  PrintWriter pw=response.getWriter();
		  
		  int id = Integer.parseInt(request.getParameter("id"));
		  
		    Emp em = EmpDao.getEmployeeById(id);
		
		    pw.print("<form  action='UpdateController' method='get'> ");
			
		    pw.print("<table style='background-color:#d5e1e3;  padding:20px; margin-left:auto;'>");
		    pw.print("<tr><td colspan=2><h2 style='background-color:#27374D; color: white; text-align: center; height: 30px;'>Edit Employee Information </h2></td></tr>");
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+em.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+em.getName()+"'/></td></tr>");
		   	pw.print("<tr><td>Password: </td> <td><input type='password' name='password' value='"+em.getPassword()+"'/></td></tr>");
		   	pw.print("<tr><td>Email:</td> <td><input type='text' name='email' value='"+em.getEmail()+"'/></td></tr>");
			pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+em.getPhone()+"'/></td></tr>");
			pw.print("<tr><td>Designation:</td> <td><input type='text' name='desg' value='"+em.getDesgnation()+"'/></td></tr>");
			pw.print("<tr><td>Date-Of-Joining:</td> <td><input type='text' name='doj' value='"+em.getDoj()+"'/></td></tr>");
			pw.print("<tr><td>Date-Of-Birth:</td> <td><input type='text' name='dob' value='"+em.getDob()+"'/></td></tr>");
			pw.print("<tr><td>Salary:</td> <td><input type='text' name='salary' value='"+em.getSalary()+"'/></td></tr>");
			pw.print("<tr><td>City:</td> <td><input type='text' name='city' value='"+em.getCity()+"'/></td></tr>");
			pw.print("<tr><td>State:</td> <td><input type='text' name='state' value='"+em.getState()+"'/></td></tr>");
			pw.print("<tr><td>Zip-Code:</td> <td><input type='text' name='zipcode' value='"+em.getZip_code()+"'/></td></tr>");
			pw.print("<tr><td>Country:</td> <td><input type='text' name='country' value='"+em.getCountry()+"'/></td></tr>");
		    pw.print("<tr><td><input type='submit' value='Update' style='height:30px; background-color:#27374D; color: white; margin-left:150px;' /></td></tr>"); 
		  
		    pw.print("</table>");
			pw.print("</form>");
	}

}
