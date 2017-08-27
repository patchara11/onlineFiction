 import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

import edu.bc.bean.Member;
import edu.bc.jdbc.EshopConnection;
import edu.bc.model.LoginModel;
import edu.bc.model.RegisterModel;
 
public class RegisterServlet extends HttpServlet {
	 // The doGet() runs once per HTTP GET request to this servlet.
	   @Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      // Set the MIME type for the response message
	      response.setContentType("text/html");
	      // Get a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();

	      // Retrieve and process request parameters: id(s), cust_name, cust_email, cust_phone
	         String username = request.getParameter("username");
	         boolean hasusername = username != null && ((username = username.trim()).length() > 0);
	         String password = request.getParameter("password");
	         boolean haspassword = password != null && ((password = password.trim()).length() > 0);
	         String name = request.getParameter("name");
	         boolean hasname = name != null && ((name = name.trim()).length() > 0);
	         String lastname = request.getParameter("lastname");
	         boolean haslastname = lastname != null && ((lastname = lastname.trim()).length() > 0);
	         String email = request.getParameter("email");
	         boolean hasemail = email != null && ((email = email.trim()).length() > 0);
	         String phonenumber = request.getParameter("phonenumber");
	         boolean hasphonenumber = phonenumber != null && ((phonenumber = phonenumber.trim()).length() > 0);
	         
	         	Member membook = new Member();
	         	membook.setUsername(username);
	         	membook.setPassword(password);
	         	membook.setName(name);
	         	membook.setLastname(lastname);
		 		membook.setEmail(email);
		 		membook.setPhone(phonenumber);
		 		RegisterModel register = new RegisterModel();
		 		Member beforeuser = register.validateUser(membook);
	      
		 		
	         if (!hasusername) {
	             out.println("<h3>Please write Your Username!</h3>");
	             out.println("<p><a href='eshopregister.html'>Back to register Menu</a></p>");
	          } else if (!haspassword) {
	             out.println("<h3>Please write Your password!</h3>");
	             out.println("<p><a href='eshopregister.html'>Back to register Menu</a></p>");
	          } else if (!hasname) {
		         out.println("<h3>Please write Your name!</h3>");
		         out.println("<p><a href='eshopregister.html'>Back to register Menu</a></p>");
	          } else if (!haslastname) {
		         out.println("<h3>Please write Your lastname!</h3>");
		         out.println("<p><a href='eshopregister.html'>Back to register Menu</a></p>");
	          } else if (!hasemail) {
		         out.println("<h3>Please write Your email!</h3>");
		         out.println("<p><a href='eshopregister.html'>Back to register Menu</a></p>");
	          } else if (!hasphonenumber) {
		         out.println("<h3>Please write Your phonenumber!</h3>");
		         out.println("<p><a href='eshopregister.html'>Back to register Menu</a></p>");
	          } else {
	              out.println("<table>");
//	              out.println("<tr><td>Your user name is :</td><td>" + username + "</td></tr>");
//	              out.println("<tr><td>Your password is :</td><td>" + password + "</td></tr>");
//	              out.println("<tr><td>Your name is     :</td><td>" + name + "</td></tr>");
//	              out.println("<tr><td>Your last name is :</td><td>" + lastname + "</td></tr>");
//	              out.println("<tr><td>Your email is    :</td><td>" + email + "</td></tr>");
//	              out.println("<tr><td>Your phone number is    :</td><td>" + phonenumber + "</td></tr>");
	              out.println("<h3>Register Complete!</h3>");
	 
	              out.println("<html><head><title>Query Results</title></head><body>");
	              
	              out.println(" <form id= 'form3'>");
	              out.println("<form method='get' action='eshophome'>");
	              
	              
	            out.println("<br />");
	            out.println("<table class = \"table table-hover\">");
	            out.println("<tr><th>ID</th><th>USERNAME</th><th>PASSWORD</th><th>NAME</th><th>LASTNAME</th><th>EMAIL</th><th>PHONENUMBER</th></tr>");
	             
	            String Name=membook.getName();
                String Email=membook.getEmail() ; 
                String Phone=membook.getPhone();
 //----------------------------------------------------------------------------------------------------------------------------------------------------------------                
                HttpSession session=request.getSession();  
                	session.setAttribute("Sname",Name);  
               	session.setAttribute("Semail",Email);
               	session.setAttribute("Sphone",Phone);
	             // Display this book ordered
	                out.println("<tr>");
	                out.println("<td>" + beforeuser.getMemid() + "</td>");
	                out.println("<td>" + beforeuser.getUsername() + "</td>");
	                out.println("<td>" + beforeuser.getPassword() + "</td>");
                    out.println("<td>" + beforeuser.getName() + "</td>");
	                out.println("<td>" + beforeuser.getLastname() + "</td>");
	                out.println("<td>" + beforeuser.getEmail() + "</td>");    
	                out.println("<td>" + beforeuser.getPhone() + "</td></tr>");
	                
	                
	                
	                out.println("<table class = \"table table-hover\">");
	                out.println("</table>");
		            out.println("<h3>Thank you for register.</h3>");
//		            out.println("<p><a href='eshophome.html'>Back to Home Menu</a></p>");
		            
		            out.println("<button id = 'send' class = 'btn btn-default' >Continue</button>");
		            out.println("</form>");
		            out.println("<script>");
		            out.println("$(document). ready(function(){");
		            out.println("$('#send').click(function(event){");
		            out.println("event.preventDefault();");
		            out.println("$.ajax({");
		            out.println("type: 'GET',");
		            
		            out.println("url: '/ebookshop/eshoplogin.jsp',");
		            
		            out.println("data: $('#form3').serialize(),");
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
	                
	            
	         out.println("</body></html>");
	      } 
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	      doGet(request, response);
	   }
}
	   