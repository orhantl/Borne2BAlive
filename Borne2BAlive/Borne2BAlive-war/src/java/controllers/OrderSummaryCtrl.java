
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
import order.OrderInfo;

/**
 * This controller summarize all the order lines before
 * finalizing the order
 */
public class OrderSummaryCtrl implements Serializable, SubControllerInterface {
        
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    
    
    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        
        String url = "/WEB-INF/order/orderSummary.jsp";
        OrderInfo order = (OrderInfo) session.getAttribute("order");
        float priceVAT = (float) session.getAttribute("prixTTC");        
        float preTaxPrice = orderManager.getPreTaxTotal(order);
        
        session.setAttribute("preTaxPrice", preTaxPrice);
        session.setAttribute("priceVAT", priceVAT);
        session.setAttribute("order", order);
        session.setAttribute("lines", order.getLineList());
        
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
