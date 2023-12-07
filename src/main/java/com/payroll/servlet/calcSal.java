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

import com.payrol.dao.PayrollDao;


public class calcSal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
    Connection con;
    
    public calcSal() {
        super();
     
    }

	public void init(ServletConfig config) throws ServletException {
		ctx=config.getServletContext();
		con=(Connection)ctx.getAttribute("dbCon");// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String da1=request.getParameter("da");
		String eid=request.getParameter("eid");
		System.out.println(eid);
		String HRA=request.getParameter("hra");
		String pf=request.getParameter("pf");
		String basicSal=request.getParameter("basicsal");
        int eid1=Integer.parseInt(eid);
		int hra=Integer.parseInt(HRA);
		int da=Integer.parseInt(da1);
		int PF=Integer.parseInt(pf);
		int basicsal=Integer.parseInt(basicSal);
		int grosssal=hra+da+basicsal;
		PayrollDao pd=new PayrollDao();
		int row=pd.insertSalary(eid1,hra,da,PF,basicsal,grosssal,con);
		System.out.println(row);
		RequestDispatcher rs=request.getRequestDispatcher("Home.html");
		rs.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
