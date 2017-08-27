import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;

import edu.bc.bean.Member;
import edu.bc.bean.Order;
import edu.bc.jdbc.EshopConnection;
import edu.bc.model.OrderModel;
 
public class EshopOrderServlet extends HttpServlet {  // JDK 6 and above only
 
   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
   
     
        
         //----------------------------------------------------------------------------------------
         HttpSession session=request.getSession(false);  
         String Name=(String)session.getAttribute("Sname");
         String Email=(String)session.getAttribute("Semail");
         String Phone=(String)session.getAttribute("Sphone");

            ArrayList orders = new ArrayList();  
            
            String[] ids = request.getParameterValues("id");  // Possibly more than one values            
            Member mem = new Member();
            mem.setName(Name);
            mem.setEmail(Email);
            mem.setPhone(Phone);
            
            OrderModel memorder = new OrderModel();
            
            out.print("Your Name:"+Name);
            out.print("Your E-mail:"+Email);
            out.print("Your Phone:"+Phone);

            out.println("<br />");
            out.println("<table border='1' cellpadding='6'>");
            out.println("<tr><th>AUTHOR</th><th>TITLE</th><th>PRICE</th><th>QTY</th></tr>");
            
            float totalPrice = 0f; 
            int qtyOrdered = 0;
                            
            
            for (String id : ids) {
            Order ordermenu = new Order();
            qtyOrdered = Integer.parseInt(request.getParameter("qty"+id));
                    

            ordermenu.setQtyOrdered(qtyOrdered);
            ordermenu.setOrderId(Integer.parseInt(id));
                    
                    orders.add(ordermenu);                     
            } 
            
            ArrayList memberData = memorder.memberData(ids, mem, orders);

            session.setAttribute("bookorder", memberData);
            session.setAttribute("qtyOrder", orders);
            
            String nextJSP = "/eshoporder.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
            
            
            out.println("<h3>Thank you.</h3>");
            //out.println("<p><a href='start'>Back to Select Menu</a></p>");
//         }
         out.println("</body></html>");
      } 
} 