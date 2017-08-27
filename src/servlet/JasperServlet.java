/**
 * Servlet class to handle request from JSP and generate report.
 */
package servlet;

import com.data.JasperData;
import com.data.JasperDataBean;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Vikas Verma
 */
public class JasperServlet extends HttpServlet {

  /**
   * Downloaded file name.
   */
  private String DOWNLOAD_FILE_NAME = "REPORT.pdf";
  /**
   * File type.
   */
  private String FILE_TYPE = "application/pdf";

  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    try {

      /**
       * Generate and download pdf report.
       */
      generateReport(request, response);

    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }

  /**
   * This method is used to Generate and download JasperReport in pdf format.
   *
   * @param HttpServletResponse object
   */
  private void generateReport(HttpServletRequest request,
      HttpServletResponse response) {

    /**
     * Variable Declaration.
     */
    List<JasperDataBean> dataList;
    String reportPath;
    OutputStream outStream;
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JRDataSource reportSource;
    JasperData jasperData;
    String logoFilePath;
    Map reportParameters;

    try {
      /**
       * Get report and logo file path.
       */
      reportPath = request.getServletContext().
          getRealPath("reports") + "\\JasperReport.jrxml";

      logoFilePath = request.getServletContext().
          getRealPath("reports") + "\\leaf_banner_gray.png";

      /**
       * Set report parameters
       */
      reportParameters = new HashMap();
      reportParameters.put("paramLogFilePath", logoFilePath);

      /**
       * Compile Jasper Report.
       */
      jasperDesign = JRXmlLoader.load(reportPath);
      jasperReport = JasperCompileManager.compileReport(jasperDesign);

      /**
       * Get report DataSource.
       */
      jasperData = new JasperData();
      dataList = jasperData.getData();
      reportSource = new JRBeanCollectionDataSource(dataList);

      /**
       * Get byteStream for generated Stream.
       */
      byte[] byteStream;
      byteStream = JasperRunManager.runReportToPdf(jasperReport,
          reportParameters, reportSource);

      /**
       * Set output Stream in response.
       */
      outStream = response.getOutputStream();
      response.setHeader("Content-Disposition", "inline, filename=" + DOWNLOAD_FILE_NAME);
      response.setContentType(FILE_TYPE);
      response.setContentLength(byteStream.length);
      outStream.write(byteStream, 0, byteStream.length);

    } catch (JRException ex) {
      Logger.getLogger(JasperServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}