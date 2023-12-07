package com.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payrol.dao.PayrollDao;


public class Salary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext ctx;
     Connection con;
    
    public Salary() {
        super();
       
    }
public void init(ServletConfig config) throws ServletException {
	
		
		ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PayrollDao p1=new PayrollDao();
	PrintWriter out=response.getWriter();
	 ArrayList<String> list=p1.getEid(con);
	 Iterator<String> it=list.iterator();
	 response.setContentType("text/html");
	 out.println("<select name=\"eid\" class=\"form-select \" aria-label=\" select \">");
	 out.println("<option selected>Select Id</option>");
	 while(it.hasNext()) {
		 String eid=it.next();
		 out.println(" <option  value='"+eid+"'>"+eid+"</option>");
	 }
	 out.println("</select>");
	 response.setContentType("text/html");
	 RequestDispatcher rs=request.getRequestDispatcher("salary.html");
	 rs.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
