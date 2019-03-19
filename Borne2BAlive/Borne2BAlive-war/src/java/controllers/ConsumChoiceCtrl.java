
package controllers;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.OrderManagerLocal;

public class ConsumChoiceCtrl implements Serializable, SubControllerInterface {
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String url = "/WEB-INF/consumerChoice/consumChoice.jsp";
        
        request.setAttribute("locations", orderManager.getLocations());
        
        if (request.getParameter("locationID") != null) {
            long locationID = Long.valueOf(request.getParameter("locationID"));
            session.setAttribute("order", orderManager.startNewOrder(locationID));
            url = "/WEB-INF/catalog/catalog.jsp";
        }
                
                
        return url;
    }

    private OrderManagerLocal lookupOrderManagerLocal() {
        try {
            Context c = new InitialContext();
            return (OrderManagerLocal) c.lookup("java:global/Borne2BAlive/Borne2BAlive-ejb/OrderManager!managers.OrderManagerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
