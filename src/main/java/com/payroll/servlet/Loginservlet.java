package com.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Loginservlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user=request.getParameter("username");
		PrintWriter out=response.getWriter();
		String pass=request.getParameter("pass");
		if(user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin"))
		{
			RequestDispatcher rs=request.getRequestDispatcher("Home.html");
			rs.forward(request, response);
		}
		else {
		      out.println("<script>");
		      out.println("alert(\"login successful\")");
		      out.println("</script>");
			RequestDispatcher rs=request.getRequestDispatcher("Login.html");
			rs.include(request, response);
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
