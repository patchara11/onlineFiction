package edu.bc.dao;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import edu.bc.jdbc.*;
import edu.bc.bean.*;


public class OrderDao  {
	String Name;
	String Email;
	String Phone;
   
	public ArrayList  find(String[] ids,Member member,ArrayList orders){	
		Connection conn = null;
		Statement stmt = null;
		Order order = new Order();
		ArrayList memberData = new ArrayList();		
		
		 int qtyAvailable = 0 ;
         int qtyOrdered = 0;
         String title = null ;
         String author = null;
         float price = 0;
		 
			try {
				// Step 1: Create a database "Connection" object
				// For MySQL
				conn = EshopConnection.getConnection();
				stmt = conn.createStatement();
		
				float totalPrice = 0f;  
		         
				for (String id : ids) {
	            	String sqlStr = "SELECT * FROM books WHERE id = " + id;
	               //System.out.println(sqlStr);  // for debugging
	            	ResultSet rset = stmt.executeQuery(sqlStr);
	 
	               // Expect only one row in ResultSet
	            	   while(rset.next()) {
	            		   qtyAvailable = rset.getInt("qty");
	               title = rset.getString("title");
	               author = rset.getString("author");
	               price = rset.getFloat("price");
	               
	               order = new Order();
	               order.setOrderId(Integer.parseInt(id));
	               order.setQtyOrdered(qtyOrdered);
	               order.setQtyAvailable(qtyAvailable);
	               order.setAuthor(author);
	               order.setTitle(title);
	               order.setPrice(price);
	               
	               memberData.add(order);
	            	   }
				}
	            int i ;
	            for (i = 0; i < orders.size(); i++) {
            		System.out.println(orders.get(i));
            		 
            		order = (Order)orders.get(i);
			 
	 

	              String sqlStr = "UPDATE books SET qty = qty - " + order.getQtyOrdered() + " WHERE id = " + order.getOrderId();
	               //System.out.println(sqlStr);  // for debugging
	               stmt.executeUpdate(sqlStr);
	 
	               sqlStr = "INSERT INTO order_records values ("
	                       + order.getOrderId() + ", " + order.getQtyOrdered() + ", '" + member.getName() + "', '"
	                       + member.getEmail() + "', '" + member.getPhone() + "')";
	               //System.out.println(sqlStr);  // for debugging
	               stmt.executeUpdate(sqlStr);
	 
	
	              
	               
	               
	               
//	               memberData.add(order);
	               
	               
	               
	             /*  session.setAttribute("Author",author);
	               session.setAttribute("Title",title);
	               session.setAttribute("Price",price);
	               session.setAttribute("Order",qtyOrdered);
	               */
	              
	               //session.setAttribute("Total",totalPrice);
	            }

	           return memberData;
		
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
	 return memberData;
	}
	public Member getData(Member mem){
		Name  = mem.getName();
		Email = mem.getEmail();
		Phone = mem.getPhone();
		System.out.println(Name+"Hello");
		return mem;
	}
	}

