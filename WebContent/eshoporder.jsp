<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList,edu.bc.bean.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">      
 <html>
 <head>
  <title>order</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="scripts/jquery.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script> 
</head>
 <body>
      <table class = "table table-hover">
      
  	 <caption>Hover Table Layout</caption>
      <tr><th>AUTHOR</th><th>TITLE</th><th>PRICE</th><th>QTY</th></tr>
      
      <%
	ArrayList orders = (ArrayList)session.getAttribute("bookorder");
     ArrayList qtys = (ArrayList)session.getAttribute("qtyOrder");
      int i;
  	Order order = new Order();
  	Order qty = new Order();
  	float Total = 0f;
  	float Price;
  	int Quality;
  	
  for (i = 0; i < orders.size(); i++) {
  	System.out.println(orders.get(i));
  	order = (Order)orders.get(i);
  	qty   = (Order)qtys.get(i);
  	
  	 Price = order.getPrice();
  	 Quality = qty.getQtyOrdered();
  	 
  	 Total = Total + (Price*Quality);

%>         	        	
               <tr>
               <td><%=  order.getAuthor() %></td>
               <td><%=  order.getTitle() %></td>
               <td><%=  order.getPrice() %></td>
               <td><%=  qty.getQtyOrdered() %></td>
               </tr> 
 

 <% } %> 
 

   <table class = "table table-hover">
      <tr><th>TOTALPRICE</th><td><%= Total %></td></tr>
        
       </table>
 </table>
 </table>
</body>
</html>