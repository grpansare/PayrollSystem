package com.payrol.bean;

public class Employee {
      String name;
      String gender;
      String address;
      String state;
      String city;
      String email;
      String phone;
      String empid;
      int grossSal;
      public int getGrossSal() {
		return grossSal;
	}
	public void setGrossSal(int grossSal) {
		this.grossSal = grossSal;
	}
	int basicSal;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String gender, String address, String state, String city, String email, String phone,
			String empid) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.state = state;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.empid = empid;
	}
	
	public int getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(int basicSal) {
		this.basicSal = basicSal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", address=" + address + ", state=" + state + ", city="
				+ city + ", email=" + email + ", phone=" + phone + ", empid=" + empid + ", grossSal=" + grossSal
				+ ", basicSal=" + basicSal + "]";
	}
	public Employee(String name, String address, String state, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.email = email;
		this.phone = phone;
	}
	
	
	

}
