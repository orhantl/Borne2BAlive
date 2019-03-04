
package controllers;

import dataCreation.DataTestLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.CatalogManagerLocal;

@WebServlet(name = "CreateDataController", urlPatterns = {"/CreateDataController"})
public class CreateDataController extends HttpServlet {
    @EJB
    private CatalogManagerLocal catalogManager;
    
    @EJB
    private DataTestLocal dataTest;

    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
        String url = "/index.jsp";
        String display = request.getParameter("display");
        
        if ( request.getParameter("creer") != null ) {
            dataTest.createData();
        }
        
        if ("menus".equals(display)) {
            url = "/WEB-INF/menus.jsp";
            request.setAttribute("MENUS", catalogManager.getMenus());
        }
        
        
        
        
        
        url = response.encodeURL(url);
        getServletContext().getRequestDispatcher(url).include(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
