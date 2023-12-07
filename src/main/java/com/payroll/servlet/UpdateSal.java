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
import com.payrol.bean.Salary;
import com.payrol.dao.PayrollDao;


public class UpdateSal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
    Connection con;
  
    public UpdateSal() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String da1=request.getParameter("da");
		String eid=request.getParameter("empid");
		
		String HRA=request.getParameter("hra");
		String pf=request.getParameter("pf");
		String basicSal=request.getParameter("basic_sal");
		PrintWriter out=response.getWriter();
		PayrollDao p1=new PayrollDao();
//		System.out.println(da1);
//		int eid=1;
		if(eid !=null){
		int eid1=Integer.parseInt(eid);
		int hra=Integer.parseInt(HRA);
		int da=Integer.parseInt(da1);
		int PF=Integer.parseInt(pf);
		int basicsal=Integer.parseInt(basicSal);
		Salary s1=new Salary(eid1,hra,da,PF,basicsal);
		
		int row=p1.updateSalary(s1, con);
		System.out.println(row);
		RequestDispatcher rs1=request.getRequestDispatcher("Home.html");
		 rs1.include(request, response);
		}
		
		else{
		
		ArrayList<String> list=p1.getEid(con);
		 Iterator<String> it=list.iterator();
		 response.setContentType("text/html");
		 out.println("<select name=\"eid\" class=\"form-select \" aria-label=\" select \">");
		 out.println("<option selected>Select Id to update</option>");
		 while(it.hasNext()) {
			 String eid3=it.next();
			 out.println(" <option  value='"+eid3+"'>"+eid3+"</option>");
		 }
		 out.println("</select>");
		 response.setContentType("text/html");
		 RequestDispatcher rs=request.getRequestDispatcher("updateSal.html");
		 rs.include(request, response);}

	
	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
