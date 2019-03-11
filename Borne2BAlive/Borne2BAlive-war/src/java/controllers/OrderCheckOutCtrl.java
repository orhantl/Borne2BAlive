
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.OrderManagerLocal;
import order.OrderInfo;



public class OrderCheckOutCtrl implements Serializable, SubControllerInterface {
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    
    
    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
        
        OrderInfo order = (OrderInfo) session.getAttribute("order");
        float priceVAT = (float) session.getAttribute("priceVAT");
        float preTaxPrice = (float) session.getAttribute("preTaxPrice");
        
        session.setAttribute("order", order);
        session.setAttribute("preTaxPrice", preTaxPrice);
        session.setAttribute("priceVAT", priceVAT);
        
        return "/WEB-INF/order/orderCheckOut.jsp";
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
