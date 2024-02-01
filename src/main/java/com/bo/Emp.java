package com.bo;

public class Emp 
{
	 private int id;
     private String name;
     private String password;
     private String email;
     private String phone;
     private String desgnation;
     private String doj;
     private String dob;
     private int salary;
     private String city;
     private String state;
     private String zip_code;
     private String country;
      
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(String name, String password, String email, String phone, String desgnation, String doj, String dob,
			int salary, String city, String state, String zip_code, String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.desgnation = desgnation;
		this.doj = doj;
		this.dob = dob;
		this.salary = salary;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getDesgnation() {
		return desgnation;
	}

	public void setDesgnation(String desgnation) {
		this.desgnation = desgnation;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
     
}
