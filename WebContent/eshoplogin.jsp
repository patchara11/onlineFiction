<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList,edu.bc.bean.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">      
 <head>
  <meta charset="UTF-8">
  <title>Login </title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="bootstrap/css/style.css">
 </head>
 <body>
  <!-- <h2>Login</h2> -->
  <form id= "form2">
  <!-- <table>
    <tr>
      <td>username:</td>
      <td><input type='text' name='username' /></td>
    </tr>
    <tr>
      <td>password:</td>
      <td><input type='password' name='password' /></td>
    </tr>
  </table> -->
   <div class="wrap">
		<div class="avatar">
      <img src="http://icons.iconarchive.com/icons/martz90/circle/512/books-icon.png">
		</div>
		<input type="text" placeholder="username" required name='username'>
		<div class="bar">
			<i></i>
		</div>
		<input type="password" placeholder="password" required name='password'>
  <br />
   <button id = "send" class = "btn btn-default" >Login</button>
   </div>
    <script src="bootstrap/js/index.js"></script>
  </form> 
</body>
<script>   

$(document). ready(function(){
	$("#send").click(function(event){
		event.preventDefault();
		$.ajax({
	         type: "GET",
	         url: "/ebookshop/login",
	         data: $('#form2').serialize(),
	       //  contentType: false,
	         success: function (data) {
	             $("#content").html(data);
	             $('.loading').hide();
	            
	         },
	         error: function (xhr, status, error) {
	             alert(xhr.responseText);
	         }
	     });
	});
	
});
      </script>  
