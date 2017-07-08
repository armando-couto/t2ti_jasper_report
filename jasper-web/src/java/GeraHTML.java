/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

import java.sql.Connection;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Cláudio
 */
public class GeraHTML extends HttpServlet {

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
            ServletContext sc = getServletContext();
            String nomeArquivo = sc.getRealPath("/") + "produtos.html";
            JasperPrint jp = JasperFillManager.fillReport(sc.getRealPath("/jasper/Produtos.jasper"), parametros, con);            
            JasperExportManager.exportReportToHtmlFile(jp, nomeArquivo);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GeraHTML</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Relatório Gerado" + "</h1>");
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
