package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		
		int status = EmpDao.DeleteEmp(id);
		if(status > 0)
		{
			pw.print("<script> alert('Data has been successfully deleted'); </script>");
			RequestDispatcher rd = request.getRequestDispatcher("AllEmpInfo");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script> alert('Sorry!! Something went wrong '); </script>");
			RequestDispatcher rd = request.getRequestDispatcher("AllEmpInfo");
			rd.include(request, response);
		}
	}

}
