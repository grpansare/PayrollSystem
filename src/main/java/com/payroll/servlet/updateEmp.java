package com.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payrol.bean.Employee;
import com.payrol.dao.PayrollDao;

public class updateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
    Connection con;
    public updateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String eid=request.getParameter("eid");
		PayrollDao p1=new PayrollDao();
		PrintWriter out=response.getWriter();
		Employee e=p1.getEmployees(con,eid);
		response.setContentType("style/css");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"	https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\">\r\n"
				+ "	<script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>");
		out.println("<style>");
		out.println("form{ width:40%; margin:100px auto; } input{border:1px solid black;} .btn{ margin:0 auto;}</style>");
		response.setContentType("text/html");
		out.println("<form action=\"Update\">");
		out.println("<h3 class=\"text-center mb-3\">Update Employee</h3>");
		out.println("<div class=\"form-floating \">");
		out.println(" <input type=\"text\" class=\"form-control\" id=\"floatingInput\" name=\"name\" value=\""+e.getName()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"floatingInput\"> Name</label></div>");
		out.println("<div class=\"form-floating \">");
		out.println(" <input type=\"text\" class=\"form-control\" name=\"address\" id=\"floatingPassword\" value=\""+e.getAddress()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"floatingPassword\">Address</label></div>");
		out.println("<div class=\"form-floating \">");
		out.println(" <input type=\"text\" class=\"form-control\"id=\"email\" name=\"email\" value=\""+e.getEmail()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"email\">Email</label></div>");
		out.println("<div class=\"form-floating \">");
		
		out.println(" <input type=\"text\" class=\"form-control\" name=\"phone\" id=\"phone\" value=\""+e.getPhone()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"phone\">Phone</label></div>");
		out.println("<div class=\"form-floating mb-3\">");
		out.println(" <input type=\"text\" class=\"form-control\" name=\"state\" id=\"state\" value=\""+e.getState()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"state\">State</label></div>");
		out.println(" <input type=\"submit\" class=\"btn btn-primary  btn-lg btn-block\"  value=\"Submit\" placeholder=\"\"><br>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
