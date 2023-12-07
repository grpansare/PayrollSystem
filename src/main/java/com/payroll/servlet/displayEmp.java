package com.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payrol.bean.Employee;
import com.payrol.dao.PayrollDao;


public class displayEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	ServletContext ctx;
    Connection con;
    public displayEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

public void init(ServletConfig config) throws ServletException {
        ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PayrollDao p1=new PayrollDao();
	ArrayList<Employee> emplist=p1.getEmployees(con);
	
	
	PrintWriter out=response.getWriter();
	response.setContentType("style/css");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"	https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\">\r\n"
			+ "	<script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>");
	
	out.println("<style>.table{ width:60%; margin:100px auto; } h3{ border:1px solid black; border-radius:23px; padding:20px;margin-top:30px; margin-left:550px;  width:400px;  }</style>");
	response.setContentType("text/html");
	out.println("<h3 class=\"btn btn-primary\">Employee List</h3>");
	out.println("<table class=\"table table-hover table-bordered \" border=\"2\" align=\"center\">");
	
	out.println("<thead class=\"thead table-dark\"><tr class=\"text-center\"><th>Employee's Name</th><th>Employee ID</th>"
	+"<th>Gender</th><th>Email</th><th>Address</th><th>Phone</th><th>Basic salary</th></thead>");
	Iterator<Employee> it=emplist.iterator();

	while(it.hasNext()) {
		Employee e=it.next();
		
		out.println("<tr class=\"text-center\"><td>"+e.getName()+"</td><td>"+e.getEmpid()+"</td><td>"+
	              e.getGender()+"</td><td>"+
			        e.getEmail()+"</td><td>"+e.getAddress()+"</td><td>"+e.getPhone()+"</td><td>"+e.getBasicSal()+"</td></tr>");
	}
	   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
