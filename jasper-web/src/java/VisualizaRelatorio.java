/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

import java.sql.Connection;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cláudio
 */
public class VisualizaRelatorio extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Connection con = new ConexaoMySQL().getConnection();
            HashMap parametros = new HashMap();
            parametros.put("DATA_INICIO", "2007/07/01");
            parametros.put("DATA_FIM", "2007/07/07");
            ServletContext sc = getServletContext();
            JasperPrint jp = JasperFillManager.fillReport(sc.getRealPath("/jasper/Grafico.jasper"), parametros, con);
            JasperViewer jrv = new JasperViewer(jp);
            jrv.setVisible(true);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VisualizaRelatorio</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VisualizaRelatorio at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
