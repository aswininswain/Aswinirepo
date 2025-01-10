package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDao 
{
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addUser(UserDetails user)
	{
		boolean f = false;
		try {
			String query = "insert into user(name,email,password) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3,user.getPassword());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return f;
	}
	public  UserDetails loginUser(UserDetails user)
	{
		UserDetails us=null;
		try
		{
			String query = "select * from user where email=? and password=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				us=new UserDetails();
				us.setId(rs.getInt("id"));
				us.setName(rs.getString("name"));
				us.setEmail(rs.getString("email"));
				us.setPassword("password");
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return us;
	}
	

}
