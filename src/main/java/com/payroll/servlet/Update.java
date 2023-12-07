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

import com.payrol.bean.Employee;
import com.payrol.dao.PayrollDao;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
    Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String name=request.getParameter("name");
		    String email=request.getParameter("email");
		    String address=request.getParameter("address");
		    String phone=request.getParameter("phone");
		    String state=request.getParameter("state");
		    System.out.println(name);
			PayrollDao p1=new PayrollDao();
			Employee e1=null;
			PrintWriter out=response.getWriter();
			if(name==null) {
			 ArrayList<String> list=p1.getEid(con);
			 Iterator<String> it=list.iterator();
			 response.setContentType("text/html");
			 out.println("<select name=\"eid\" class=\"form-select \" aria-label=\" select \">");
			 out.println("<option selected>Select Id to update</option>");
			 while(it.hasNext()) {
				 String eid=it.next();
				 out.println(" <option  value='"+eid+"'>"+eid+"</option>");
			 }
			 out.println("</select>");
			 response.setContentType("text/html");
			 RequestDispatcher rs=request.getRequestDispatcher("updateEmp.html");
			 rs.include(request, response);}
			else {
			e1=new Employee(name,address,state,email,phone);
			int row=p1.updateEmp(e1,con);
			System.out.println(row);
			RequestDispatcher rs=request.getRequestDispatcher("Home.html");
			rs.forward(request, response);
			}
			}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
