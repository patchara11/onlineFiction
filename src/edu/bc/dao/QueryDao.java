package edu.bc.dao;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import javax.servlet.http.HttpSession;

import edu.bc.jdbc.*;
import edu.bc.bean.Book;
import edu.bc.bean.Member;;


public class QueryDao  {
	
   
	public ArrayList  find(String[] authors){	
		Connection conn = null;
		Statement stmt = null;
		ArrayList books = new ArrayList();
			try {
				// Step 1: Create a database "Connection" object
				// For MySQL
				conn = EshopConnection.getConnection();
				stmt = conn.createStatement();
				String sqlStr = "SELECT * FROM books WHERE author IN (";
		         sqlStr += "'" + authors[0] + "'";  // First author
		         for (int i = 1; i < authors.length; ++i) {
		            sqlStr += ", '" + authors[i] + "'";  // Subsequent authors need a leading commas
		         }
		         sqlStr += ") AND qty > 0 ORDER BY author ASC, title ASC";
		         ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the server
		         
		         
		      while(rset.next()) {
		    	  int id 		= rset.getInt("id");
		          String author = rset.getString("author");
		          String title  = rset.getString("title");
		          String pictures  = rset.getString("picture");
		          float price   = rset.getFloat("price");
		          int quantity   = rset.getInt("qty");
		          
		          Book book = new Book();
		          
		          book.setBookId(id);
		          book.setAuthor(author);
		          book.setTitle(title);
		          book.setPictures(pictures);
		          book.setPrice(price);
		          book.setQuantity(quantity);
		          
		          books.add(book);
		          
		      }

		   
	           return books;
		
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
	 return books;
	}
}
