package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.Emp;

public class EmpDao 
{
	public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/april_may?useSSL=false&allowPublicKeyRetrieval=true", "root", "shital@26");			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static int addEmp(Emp e1)
	{
	
	  int status=0;
	  
	  try {
		
		  Connection con = EmpDao.getConnection();
		  
		  String sql="insert into regemp(name,password,email,phone,designation,doj,dob,salary,city,state,zip_code,country) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setString(1, e1.getName());
		  ps.setString(2, e1.getPassword());
		  ps.setString(3, e1.getEmail());
		  ps.setString(4, e1.getPhone());
		  ps.setString(5, e1.getDesgnation());
		  ps.setString(6, e1.getDoj());
		  ps.setString(7, e1.getDob());
		  ps.setInt(8, e1.getSalary());
		  ps.setString(9, e1.getCity());
		  ps.setString(10, e1.getState());
		  ps.setString(11, e1.getZip_code());
		  ps.setString(12, e1.getCountry());
		  status= ps.executeUpdate();
	  	 } 
	      catch (Exception e) 
	  		{
	  		 e.printStackTrace();
	  		}
	  	return status;
	}	
	public static List<Emp> getAllEmployee()
	{
		List<Emp> list = new ArrayList<Emp>();
		try 
		{
			Connection con = EmpDao.getConnection();
			String sql = "select * from regemp";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery(sql); 
		
			while(rs.next())
			{
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setDesgnation(rs.getString(6));
				e.setDoj(rs.getString(7));
				e.setDob(rs.getString(8));
				e.setSalary(rs.getInt(9));
				e.setCity(rs.getString(10));
				e.setState(rs.getString(11));
				e.setZip_code(rs.getString(12));
				e.setCountry(rs.getString(13));
				list.add(e);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	return list;
	}
	public static boolean userlogin(String email,String pwd )
	{
		boolean status = false;
		
		try 
		{
			Connection con = EmpDao.getConnection();
			String sql = "select * from regemp where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,pwd);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static Emp getEmployeeById(int id)
	{
		Emp e = new Emp();
		try
		{
			Connection con = EmpDao.getConnection();
			String sql = "select * from regemp where e_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setDesgnation(rs.getString(6));
				e.setDoj(rs.getString(7));
				e.setDob(rs.getString(8));
				e.setSalary(rs.getInt(9));
				e.setCity(rs.getString(10));
				e.setState(rs.getString(11));
				e.setZip_code(rs.getString(12));
				e.setCountry(rs.getString(13));
			}	
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return e;
	}
	public static int updateemp(Emp e1)
	{
		int status = 0;
		try 
		{
			Connection con = EmpDao.getConnection();
			String sql = "update regemp set name=?,password=?,email=?,phone=?,designation=?,doj=?,dob=?,salary=?,city=?,state=?,zip_code=?,country=? where e_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			  ps.setString(1, e1.getName());
			  ps.setString(2, e1.getPassword());
			  ps.setString(3, e1.getEmail());
			  ps.setString(4, e1.getPhone());
			  ps.setString(5, e1.getDesgnation());
			  ps.setString(6, e1.getDoj());
			  ps.setString(7, e1.getDob());
			  ps.setInt(8, e1.getSalary());
			  ps.setString(9, e1.getCity());
			  ps.setString(10, e1.getState());
			  ps.setString(11, e1.getZip_code());
			  ps.setString(12, e1.getCountry());
			  ps.setInt(13, e1.getId());
			
			status = ps.executeUpdate(); 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public static int DeleteEmp(int id)
	{
		int status = 0;
		
		try 
		{
			Connection con = EmpDao.getConnection();
			String sql = "delete from regemp where e_id = ?"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			status = ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	
}
