 import java.io.*;
import java.util.*;
import java.util.logging.*;

import edu.bc.bean.Member;
import edu.bc.bean.Order;
import edu.bc.model.LoginModel;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
 
public class LoginServlet extends HttpServlet {
	 // The doGet() runs once per HTTP GET request to this servlet.
	   @Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      // Set the MIME type for the response message
	      response.setContentType("text/html");
	      // Get a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	         
	         String username = request.getParameter("username");
	         boolean hasusername = username != null && ((username = username.trim()).length() > 0);
	         String password = request.getParameter("password");
	         boolean haspassword = password != null && ((password = password.trim()).length() > 0);
	         
	         String register = "eshopregister.html";
	         
	        Member member = new Member();
	 		member.setUsername(username);
	 		member.setPassword(password);
	 		
	 		LoginModel login = new LoginModel();
	 		Member user = login.validateUser(member);
	         
	         if (!hasusername) {
	             out.println("<h3>Please Check Your Username&Password!</h3>");
	             out.println("<p><a href='javascript:ajaxLoad'('eshopregister.html')''>You can register here!!</a></p>");
	             out.println("<p><a href='eshoplogin.jsp'>Back to login menu</a></p");
	          } else if (!haspassword) {
	             out.println("<h3>Please Check Your Username&Password!</h3>");
	             out.println("<p><a href='javascript:ajaxLoad('eshopregister.html')'>You can register here!!</a></p>"); 
	             out.println("<p><a href='eshoplogin.jsp'>Back to login menu</a></p");           
	          } 
//	   		  } else  ((!hasusername) && (!haspassword)) {
//           out.println("<h3>Please Check Your Username&Password! 222</h3>");
//           out.println("<p><a href='register.html'>You can register here!!</a></p>");             
//	   		  } 
	          else if (!validUser(username, password)) {
	             out.println("<html>");
	             out.println("<title>Invalid User</title>");
	             out.println("<body><h2>" + "Please Check Your Username&Password!!</h2><br>");
	             out.println("<p>"
	             		+ 		"<a href='javascript:ajaxLoad(&#39;"+ register + "&#39;)'>You can register here!!</a>"
	             		+ 	"</p>");
	             out.println("<p><a href='eshoplogin.html'>Back to login menu</a></p");
	             out.println("</body></html>");
	             out.flush();
	          }  else {
//	              out.println("<table>");
//	              out.println("<tr><td>username:</td><td>" + username + "</td></tr>");
//	              out.println("<tr><td>password</td><td>" + password + "</td></tr>");
	 

//	            out.println("<br />");
//	            out.println("<table border='1' cellpadding='7'>");
//	            out.println("<tr><th>ID</th><th>USERNAME</th><th>PASSWORD</th><th>NAME</th><th>LASTNAME</th><th>EMAIL</th><th>PHONENUMBER</th></tr>");
//	     
	               
	        	  	  out.println(" <form id= 'form5'>");
	              out.println("<form method='get' action='eshophome'>"); 
	         
	                
	 //------------------------------------------------------------------------------------------------------------------------------------------------------------            
	                String Name=user.getName();
	                String Email=user.getEmail() ; 
	                String Phone=user.getPhone();
	 //----------------------------------------------------------------------------------------------------------------------------------------------------------------                
	                HttpSession session=request.getSession();  
	                	session.setAttribute("Sname",Name);  
	               	session.setAttribute("Semail",Email);
	               	session.setAttribute("Sphone",Phone);
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------
//	                out.println("<tr>");
//	                out.println("<td>" + user.getMemid() + "</td>");
//	                out.println("<td>" + user.getUsername() + "</td>");
//	                out.println("<td>" + user.getPassword() + "</td>");
//	                out.println("<td>" + user.getName() + "</td>");
//	                out.println("<td>" + user.getLastname()+ "</td>");
//	                out.println("<td>" + user.getEmail() + "</td>"); 
//	                out.println("<td>" + user.getPhone() + "</td></tr>");
//	                out.println("</table>");
	                
		            out.println("<h3>Login Success</h3>");
//		            out.println("<p><a href='eshophome.html'>Go to shopping</a></p>");
		            
		            out.println("<button id = 'send' class = 'btn btn-default' >Continue</button>");
		            out.println("</form>");
		            out.println("<script>");
		            out.println("$(document). ready(function(){");
		            out.println("$('#send').click(function(event){");
		            out.println("event.preventDefault();");
		            out.println("$.ajax({");
		            out.println("type: 'GET',");
		            
		            out.println("url: '/ebookshop/eshopquery.html',");
		            
		            out.println("data: $('#form5').serialize(),");
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
	   protected boolean validUser(String username, String password) {
		    boolean valid = false;
		    if ((username != null) && (username.length() > 0)) {
		      valid = username.equals(password);
		    }

		    return valid;
	   }
}