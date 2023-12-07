package com.payroll.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payrol.bean.Employee;
import com.payrol.dao.PayrollDao;


public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServletContext ctx;
     Connection con;
   
    public AddEmp() {
        super();
      
    }
public void init(ServletConfig config) throws ServletException {
	   ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		System.out.println(gender);
		String email=request.getParameter("email");
		String address=request.getParameter("address")
;
	    String city=request.getParameter("city");
	    String state=request.getParameter("state");
	    String phone=request.getParameter("phone");
	    String empid= request.getParameter("empid");
	    Employee e=new Employee(name,gender,address,state,city,email,phone,empid);
	    PayrollDao pd=new PayrollDao();
	    int rows=pd.insertData(con, e);
	    System.out.println(rows);
	    response.setContentType("text/html");
	    RequestDispatcher rs=request.getRequestDispatcher("Home.html");
	    rs.include(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
