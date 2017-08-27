package edu.bc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.bc.bean.StoryAct;
import edu.bc.bean.StoryContent;
import edu.bc.jdbc.EshopConnection;

public class StoryActDao {
	public StoryAct  find(StoryAct act){	
		Connection conn = null;
		Statement stmt = null;
			try {
				// Step 1: Create a database "Connection" object
				// For MySQL
				conn = EshopConnection.getConnection();
				stmt = conn.createStatement();
				
//				String sqlStr =  "INSERT INTO member VALUES (Null,'"+act.getStoryID()+"','"+act.setStoryName()+"')";	            		
//				 stmt.executeUpdate(sqlStr);
				String sqlStr = "SELECT * FROM storyAct";
		        ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the server
		         
		        StoryContent storycontent = new StoryContent();
		           
		           while( rset.next()){
		               int contentID = rset.getInt("id");
		               String content = rset.getString("storname");
		             	
		               storycontent.setContentID(contentID);
		               storycontent.setContent(content);
		             
		               
		               
		           }
		           return act;
			
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
			return act;
			
		}

}
