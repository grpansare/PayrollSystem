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

import com.payrol.dao.PayrollDao;
import com.payrol.bean.*;
import com.payrol.bean.Salary;

public class paySleep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext ctx;
    Connection con;
    public paySleep() {
        super();
        
    }

    public void init(ServletConfig config) throws ServletException {
		ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		PayrollDao p1=new PayrollDao();
		Employee e1=p1.getEmployees(con, eid);
		PrintWriter out=response.getWriter();
		Salary s1=p1.getSalary(con, eid);
		response.setContentType("style/css");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"	https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\">\r\n"
				+ "	<script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>");
		out.println("<style> ");
		out.println(".table{ width:60%;height:500px; margin:100px auto; } h3{ border:1px solid black; border-radius:23px; padding:20px;margin:10px auto;  width:400px; background-color:sky-blue} </style>");
		response.setContentType("text/html");
		out.println("<h3 class=\"text-center mb-3 bg-warning\">Payment Sleep</h3>");
		out.println("<table class=\"table table-hover table-bordered \" border=\"2\" align=\"center\">");
	
		out.println("<tr class=\"text-center\">");
		out.println("<td >Employee Name</td><td>"+e1.getName()+"</td</tr>");
		out.println("<tr class=\"text-center\"><td>Employee Id</td><td>"+e1.getEmpid()+"</td></tr>");
		out.println("<tr class=\"text-center\"><td>HRA</td><td>"+s1.getHra()+"</td></tr>");
		out.println("<tr class=\"text-center\"><td>DA</td><td>"+s1.getDa()+"</td></tr>");
		out.println("<tr class=\"text-center\"><td>PF</td><td>"+s1.getPf()+"</td></tr>");
		out.println("<tr class=\"text-center\"><td>Basic Salary</td><td>"+s1.getBasic_sal()+"</td></tr>");
		out.println("<tr class=\"text-center\"><td>Total Salary</td><td>"+s1.getGross_sal()+"</td></tr>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
