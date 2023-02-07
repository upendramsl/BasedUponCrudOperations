package com.techpalle;

import java.sql.*;

public class A 
{
private static final String url="jdbc:mysql://localhost:3306/palle";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	//private static ResultSet rs=null;
	
	
	
	public void Creating()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","upendra");
			s=con.createStatement();
			s.executeUpdate("create table employee(eno int primary key,ename varchar(80),esal int)");
			
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(s!=null)
				{
				s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	public void inserting(int no,String name,int sal)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","upendra");
			ps=con.prepareStatement("insert into employee(eno,ename,esal) values(?,?,?)");
			
			ps.setInt(1,no);
			ps.setString(2, name);
			ps.setInt(3, sal);
			
			ps.executeUpdate();
			System.out.println("inserting values into table succesfully done");
			
			
			
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
				ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	

}
	public void updating(String name,int sal)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","upendra");
			ps=con.prepareStatement("update employee set esal=? where ename=?");
			
			
			ps.setInt(1, sal);
			ps.setString(2, name);
			
			ps.executeUpdate();
			System.out.println("Updating values sucessfully");
			
			
			
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
				ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}
	public void delete(int no)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","upendra");
			ps=con.prepareStatement("delete from employee where eno=?");
			
			ps.setInt(1, no);
			
			ps.executeUpdate();
			System.out.println("delte rows sucessfully");
			
			
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
				ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}
	public void exit()
	{
	System.exit(0);	
	}
	

	}
	
