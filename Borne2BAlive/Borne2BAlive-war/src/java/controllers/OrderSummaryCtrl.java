
package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.OrderManager;
import managers.OrderManagerLocal;
import order.Line;
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
         
        //OrderInfo order = (OrderInfo) session.getAttribute("order");
        
        
        OrderInfo order = new OrderInfo();
        order = orderManager.createOrderFinal();
        System.out.println(order.getQueueNumber());
        Collection<Line> lineList = order.getLineList();        
        for(Line l : lineList){
            System.out.println(l.toString());
            System.out.println(l.getProduct().getName());
            System.out.println(l.getQty());
        }
        
        
        request.setAttribute("order", order);
        request.setAttribute("lines", order.getLineList());
        
        return "/WEB-INF/order/orderSummary.jsp";
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
