
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


public class CashCheckOutCtrl implements Serializable, SubControllerInterface{
    
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
        OrderInfo order = (OrderInfo) session.getAttribute("order");
        float preTaxPrice = (float) session.getAttribute("preTaxPrice");
        float priceVAT = (float) session.getAttribute("priceVAT");
        
        String queueNumber = orderManager.getCashCheckOutNumber();
        orderManager.finalizeCashOrder(order, queueNumber);
        session.setAttribute("queueNumber", queueNumber);
        
        
        return "/WEB-INF/order/cashCheckOut.jsp";
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
