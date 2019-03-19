
package controllers;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private HashMap<String, SubControllerInterface> mp;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        
        mp = new HashMap<>();        
        mp.put("create", new CreateDataCtrl());
        mp.put("orderSummary", new OrderSummaryCtrl());
        mp.put("composeMenu", new ComposeMenuCtrl());
        mp.put("catalog", new CatalogCtrl());
        mp.put("cart", new CartCtrl());
        mp.put("welcomeScreen", new WelcomeScreenCtrl());
        mp.put("orderCheckOut", new OrderCheckOutCtrl());
        mp.put("cashCheckOut", new CashCheckOutCtrl());
        mp.put("kill", new Kill());
        mp.put("category", new CategoryCtrl());
        mp.put("detail", new DetailProductCtrl());
        mp.put("creditCardCheckOut", new CreditCardCheckOutCtrl());
        mp.put("consumChoice", new ConsumChoiceCtrl());
        mp.put("offers", new OffersCtrl());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
        String url = "/index.jsp";
        String section = request.getParameter("section");
        
        if(mp.containsKey(section)){
            SubControllerInterface ctrl = mp.get(section) ;
            url = ctrl.process(request, response);
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
