package com.payrol.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.payrol.bean.Employee;
import com.payrol.bean.Salary;


public class PayrollDao {

	public PayrollDao() {
		// TODO Auto-generated constructor stub
	}
	public  int insertData(Connection con,Employee e) {
		String sq1="Insert into employee values(?,?,?,?,?,?,?,?)";
		int rows=0;
		
		try {
			PreparedStatement pstat=con.prepareStatement(sq1);
			pstat.setString(1,e.getName() );
			pstat.setString(2, e.getGender());
			pstat.setString(3, e.getAddress());
			pstat.setString(4, e.getCity());
			pstat.setString(5, e.getState());
			pstat.setString(6,e.getEmail());
			pstat.setString(7, e.getPhone());
			pstat.setString(8, e.getEmpid());
			rows=pstat.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     return rows;
	}
	public ArrayList<String> getEid(Connection con){
		ArrayList<String> li=new ArrayList<String>();
		String sql="select empid from employee";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				li.add(rs.getString("empid"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
	public int insertSalary(int eid,int hra,int da,int pf,int basicsal,int grosssal,Connection con) {
		String sq1="insert into salary1 values(?,?,?,?,?,?)";
		int rows=0;
		
		try {
			PreparedStatement pstat=con.prepareStatement(sq1);
			pstat.setInt(1,eid );
			pstat.setInt(2, hra);
			pstat.setInt(3, da);
			pstat.setInt(4, pf);
			pstat.setInt(5, basicsal);
			pstat.setInt(6, grosssal);
		
			rows=pstat.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     return rows;
	
	}
	public ArrayList<Employee> getEmployees(Connection con){
		String sql="select * from employee";
		
		Employee e1=null;
		ArrayList<Employee> li=li=new ArrayList<Employee>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			
				
			 e1=new Employee();
				e1.setGender(rs.getString("gender"));
				e1.setEmail(rs.getString("email"));
				e1.setAddress(rs.getString("address"));
				e1.setCity(rs.getString("city"));
				e1.setName(rs.getString("name"));
				e1.setPhone(rs.getString("phone"));
				e1.setState(rs.getString("state"));
				e1.setEmpid(rs.getString("empid"));
				e1.setBasicSal(getBasicSal(rs.getString("empid"),con));
//				System.out.println(e1.getBasicSal());
				li.add(e1);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
	public int getBasicSal(String empid,Connection con) {
		String sql="select basic_salary from salary1 where empid=?";
		int basicSal=0;
		try {
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setString(1, empid);
			ResultSet rs=pstat.executeQuery();
		  while(rs.next()) {
			 basicSal=rs.getInt("basic_salary");
			 System.out.println(basicSal);
		  }
		  
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return  basicSal;
	}
	public int getGrossSal(String empid,Connection con) {
		String sql="select gross_sal from salary1 where empid=?";
		int grossSal=0;
		try {
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setString(1, empid);
			ResultSet rs=pstat.executeQuery();
		  while(rs.next()) {
			  grossSal=rs.getInt("gross_sal");
			 System.out.println(grossSal);
		  }
		  
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return  grossSal;
	}
  public Employee getEmployees(Connection con,String eid) {
	  String sql="select * from employee where empid=?";
	  Employee e1=new Employee();
	  try {
		PreparedStatement ps=con.prepareStatement(sql);
		  ps.setString(1, eid);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
			  e1.setGender(rs.getString("gender"));
				e1.setEmail(rs.getString("email"));
				e1.setAddress(rs.getString("address"));
				e1.setCity(rs.getString("city"));
				e1.setName(rs.getString("name"));
				e1.setPhone(rs.getString("phone"));
				e1.setState(rs.getString("state"));
				e1.setEmpid(rs.getString("empid"));
				e1.setBasicSal(getBasicSal(rs.getString("empid"),con));
			    e1.setGrossSal(getGrossSal(rs.getString("empid"),con));
		  }
		 
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return e1;
	  
	  
  }
  public int updateEmp(Employee e1,Connection con) {
	  int row=0;
	   String sql="update employee set name=? ,email=? , phone=? ,address=?, state=? where name=?";
	   try {
		PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1, e1.getName());
		   ps.setString(2,e1.getEmail());
		   ps.setString(3, e1.getPhone());
		   ps.setString(4, e1.getAddress());
		   ps.setString(5, e1.getState());
		   ps.setString(6, e1.getName());
		    row=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return row;
  }
  
  public Salary getSalary(Connection con,String eid) {
	  Salary s1=new Salary();
	   String sql="select * from salary1 where empid=?";
	   try {
		PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1,eid);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   s1.setDa(rs.getInt("da"));
			   s1.setHra(rs.getInt("hra"));
			   s1.setPf(rs.getInt("pf"));
			   s1.setBasic_sal(rs.getInt("basic_salary"));
			   s1.setEmpid(rs.getInt("empid"));
			   s1.setGross_sal(rs.getInt("gross_sal"));
			   
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return s1;
  }
  public int updateSalary(Salary e1,Connection con) {
	  int row=0;
	   String sql="update salary1 set da=? ,hra=? , pf=? ,basic_salary=? where empid=?";
	 
	   try {
		PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, e1.getDa());
		   ps.setInt(2,e1.getHra());
		   ps.setInt(3, e1.getPf());
		   ps.setInt(4, e1.getBasic_sal());
		   ps.setInt(5, e1.getEmpid());
		  
		    row=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return row;
  }
}
