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
import com.payrol.bean.Salary;
import com.payrol.dao.PayrollDao;


/**
 * Servlet implementation class updateSal2
 */
public class updateSal2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
    Connection con;
    public updateSal2() {
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
		Salary s1=p1.getSalary(con,eid);
		response.setContentType("style/css");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"	https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\">\r\n"
				+ "	<script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>");
		out.println("<style>");
		out.println("form{ width:40%; margin:100px auto; } input{border:1px solid black;} .btn{ margin:0 auto;}</style>");
		response.setContentType("text/html");
		out.println("<form action=\"UpdateSal\">");
		out.println("<h3 class=\"text-center mb-3\">Update Salary</h3>");
		out.println("<div class=\"form-floating \">");
		out.println(" <input type=\"text\" class=\"form-control\" id=\"floatingInput\" name=\"empid\" value=\""+s1.getEmpid()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"floatingInput\"> Id</label></div>");
		out.println("<div class=\"form-floating \">");
		out.println(" <input type=\"text\" class=\"form-control\" name=\"hra\" id=\"floatingPassword\" value=\""+s1.getHra()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"floatingPassword\">HRA</label></div>");
		out.println("<div class=\"form-floating \">");
		out.println(" <input type=\"text\" class=\"form-control\"id=\"email\" name=\"da\" value=\""+s1.getDa()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"email\">DA</label></div>");
		out.println("<div class=\"form-floating \">");
		
		out.println(" <input type=\"text\" class=\"form-control\" name=\"pf\" id=\"phone\" value=\""+s1.getPf()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"phone\">PF</label></div>");
		out.println("<div class=\"form-floating mb-3\">");
		out.println(" <input type=\"text\" class=\"form-control\" name=\"basic_sal\" id=\"state\" value=\""+s1.getBasic_sal()+"\" placeholder=\"\"><br>");
		out.println(" <label for=\"state\">Basic Salary</label></div>");
		out.println(" <input type=\"submit\" class=\"btn btn-primary  btn-lg btn-block\"  value=\"Submit\" placeholder=\"\"><br>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
