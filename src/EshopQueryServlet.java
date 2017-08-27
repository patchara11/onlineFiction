import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import edu.bc.bean.Book;
import edu.bc.model.QueryModel;
 
public class EshopQueryServlet extends HttpServlet {  // JDK 6 and above only
 
   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      
      String[] authors = request.getParameterValues("author");
      
      QueryModel query = new QueryModel();
      ArrayList order = query.select(authors);
      
      if (authors == null) {
          out.println("<h2>Please go back and select an author</h2>");
          out.println("<p><a href='eshopquery.html'>Back to register Menu</a></p>");
          return; // Exit doGet()
       } 
 
        
         out.println("<html><head><title>Query Results</title></head><body>");
         out.println("<h2>Thank you for your query.</h2>");
         out.println(" <form id= 'form1'>");
         // Process the query result
         out.println("<form method='get' action='eshoporder'>");
         
     
         out.println("<table border = 1 ><tr><th></th><th>AUTHOR</th><th>PICTURE</th><th>TITLE</th><th>PRICR</th><th>QTY</th><th>ORDER</th></tr>");
         int i;
         for (i = 0; i < order.size(); i++) {
      		System.out.println(order.get(i));
      		Book book = (Book)order.get(i);
      		int id = book.getBookId();
         out.println("<tr><td><input type='checkbox' name='id' value="+ "'" + book.getBookId() + "' /></td>"      		
        	               +"<td>"+ book.getAuthor() + "</td> "
        	            	   +"<td>"+ ("<img src='"+book.getPictures()+"' alt='Room' style='width:200px;height:130px;'>") +"</td> "
        	               +"<td>"+ book.getTitle() + "</td>"
        	            	   +"<td>"+"<input type='text' name='price' value="+"'"+book.getPrice()+"'/>" +"</td>"
        	               +"<td>"+"<input type='text' name='qty' value="+"'"+ book.getQuantity()+"'/>" +"</td>"
        	               +"<td>"+ ("<input type='text' value='1' name='qty" + id + "' />") +"</td></tr>");
         }            
 
     
        
         out.println("</table>");
         
         //----------------------------------------------------------------------------------------
         HttpSession session=request.getSession(false);  
         String Name=(String)session.getAttribute("Sname");
         String Email=(String)session.getAttribute("Semail");
         String Phone=(String)session.getAttribute("Sphone");
        
//         out.print("Your Name:"+Name);
//         out.print("Your E-mail:"+Email);
//         out.print("Your Phone:"+Phone);
       //---------------------------------------------------------------------------------------- 
         
//        	 // totalPrice += price * qtyOrdered;  
//        	 // Print the submit button and </form> end-tag
//        	 out.println("<p><input type='submit' value='ORDER' />");
//        	 out.println("</form>");
         out.println("<button id = 'send' class = 'btn btn-default' >Continue</button>");
         out.println("</form>");
         out.println("<script>");
         out.println("$(document). ready(function(){");
         out.println("$('#send').click(function(event){");
         out.println("event.preventDefault();");
         out.println("$.ajax({");
         out.println("type: 'GET',");
         
         out.println("url: '/ebookshop/eshoporder',");
         
         out.println("data: $('#form1').serialize(),");
         out.println("success: function (data) {");
         out.println(" $('#content').html(data);");
         out.println(" $('.loading').hide();");
         out.println(" },");
         out.println(" error: function (xhr, status, error) {");
         out.println(" alert(xhr.responseText);");
         out.println(" },");
         out.println("});");
         out.println("});");
         out.println("});");
         
         out.println("</script>");
        	 
         }
      }
   
