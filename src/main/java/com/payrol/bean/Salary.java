package com.payrol.bean;

public class Salary {
   int empid;
   int hra;
   int da;
   int pf;
   int basic_sal;
   int gross_sal;
	public Salary() {
		// TODO Auto-generated constructor stub
	}
	public Salary(int empid, int hra, int da, int pf, int basic_sal,int gross_sal) {
		super();
		this.empid = empid;
		this.hra = hra;
		this.da = da;
		this.pf = pf;
		this.basic_sal = basic_sal;
		this.gross_sal=gross_sal;
	}
	
	public int getGross_sal() {
		return gross_sal;
	}
	public void setGross_sal(int gross_sal) {
		this.gross_sal = gross_sal;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getDa() {
		return da;
	}
	public void setDa(int da) {
		this.da = da;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public int getBasic_sal() {
		return basic_sal;
	}
	public void setBasic_sal(int basic_sal) {
		this.basic_sal = basic_sal;
	}
	public Salary(int empid, int hra, int da, int pf, int basic_sal) {
		super();
		this.empid = empid;
		this.hra = hra;
		this.da = da;
		this.pf = pf;
		this.basic_sal = basic_sal;
	}

	
	
}
