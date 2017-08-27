import java.io.*;
import java.util.UUID;

import javax.servlet.*;
	import javax.servlet.http.*;

	
public class EshopEditorServlet extends HttpServlet {
	 
	 
	   // The doGet() runs once per HTTP GET request to this servlet.
	   @Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	                     throws ServletException, IOException {
	      // Set the MIME type for the response message
	      response.setContentType("text/html");
	      // Get a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	            
	      String Writer = request.getParameter("editor1");
	      
	      	UUID uuid = UUID.randomUUID();
	        String randomUUIDString = uuid.toString();

	      try {
	          byte bWrite [] = Writer.getBytes();
	          OutputStream os = new FileOutputStream(randomUUIDString+".txt");
	          for(int x = 0; x < bWrite.length ; x++) {
	             os.write( bWrite[x] );   // writes the bytes
	          }
	          os.close();
	      
	          InputStream is = new FileInputStream(randomUUIDString+".txt");
	          int size = is.available();

	          for(int i = 0; i < size; i++) {
	             System.out.print((char)is.read() + "  ");
	          }
	          is.close();
	       }catch(IOException e) {
	          System.out.print("Exception");
	       }		     
	      BufferedReader br = new BufferedReader(new FileReader(randomUUIDString+".txt"));
	      String line = null;
	      while ((line = br.readLine()) != null) {
	        System.out.println(line);
	      }
	    }            
}
