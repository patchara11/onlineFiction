package edu.bc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.bc.bean.Book;
import edu.bc.bean.Member;
import edu.bc.jdbc.EshopConnection;

public class RegisterDao {
	
	
	public Member  find(Member membook){	
		Connection conn = null;
		Statement stmt = null;
			try {
				// Step 1: Create a database "Connection" object
				// For MySQL
				conn = EshopConnection.getConnection();
				stmt = conn.createStatement();
				
				String sqlStr =  "INSERT INTO member VALUES (Null,'"+membook.getUsername()+"','"+membook.getPassword()+"','"+membook.getName()+"','"+membook.getLastname()+"','"+membook.getEmail()+"','"+membook.getPhone()+"')";	            		
				 stmt.executeUpdate(sqlStr);
				sqlStr ="SELECT * FROM member WHERE username = '"+membook.getUsername()+"' AND password = '"+membook.getPassword()+"'";
		         ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the server
		         
		         Member beforeuser = new Member();
		           
		           while( rset.next()){
		               int ID = rset.getInt("id");
		               String username = rset.getString("username");
		               String Password = rset.getString("password");
		               String name = rset.getString("name");
		               String lastname = rset.getString("lastname");
		               String email = rset.getString("email");
		               String phone = rset.getString("phonenumber");
		               
		               beforeuser.setMemid(ID);
		               beforeuser.setUsername(username);
		               beforeuser.setPassword(Password);
		               beforeuser.setName(name);
		               beforeuser.setLastname(lastname);
		               beforeuser.setEmail(email);
		               beforeuser.setPhone(phone);
		               
		               
		           }
		           return beforeuser;
			
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
			return membook;
			
		}
	}