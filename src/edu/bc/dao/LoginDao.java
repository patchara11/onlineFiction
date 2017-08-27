package edu.bc.dao;
import java.io.*;
import java.sql.*;
import java.util.logging.*;

import edu.bc.bean.Member;
import edu.bc.jdbc.EshopConnection;


public class LoginDao  {
	
   
	public Member  find(Member member){	
		Connection conn = null;
		Statement stmt = null;
	
			try {
				// Step 1: Create a database "Connection" object
				// For MySQL
				conn = EshopConnection.getConnection();
				stmt = conn.createStatement();
		
			
				String sqlStr = "SELECT * FROM member WHERE username = '"+member.getUsername()+"' AND password = '"+member.getPassword()+"'"; 
	               //System.out.println(sqlStr);  // for debugging
	            	ResultSet rset = stmt.executeQuery(sqlStr);
	            	
	            Member user = new Member();
	           
	           while( rset.next()){
	               int ID = rset.getInt("id");
	               String username = rset.getString("username");
	               String Password = rset.getString("password");
	               String name = rset.getString("name");
	               String lastname = rset.getString("lastname");
	               String email = rset.getString("email");
	               String phone = rset.getString("phonenumber");
	               
	               user.setMemid(ID);
	               user.setUsername(username);
	               user.setPassword(Password);
	               user.setName(name);
	               user.setLastname(lastname);
	               user.setEmail(email);
	               user.setPhone(phone);
	               
	               
	           }
	           return user;
		
   }catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e){
	//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
	//finally block used to close resources
	try{
		if(stmt!=null)
			  conn.close();
		}catch(SQLException se){
		}// do nothing
	try{
		if(conn!=null)
			   conn.close();
		}catch(SQLException se){
			   se.printStackTrace();
		}//end finally try
		}//end try
		System.out.println("nice");
		return member;
		
	}
}
