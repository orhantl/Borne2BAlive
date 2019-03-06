package controllers;

import Product.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.BasketManagerLocal;
import order.Line;
import order.OrderInfo;

public class CartCtrl implements Serializable, SubControllerInterface {
    BasketManagerLocal basketManager = lookupBasketManagerLocal();

    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String zone = request.getParameter("zone");
        String url = "/WEB-INF/catalog/catalog.jsp";
        
        HttpSession session = request.getSession();
        
        if ("add".equals(zone)) {
            Line l = new Line ();
            l.setQty(1);
            Product p = (Product) request.getAttribute("item");            
            l.setProduct(p); 
            
            OrderInfo o = (OrderInfo) session.getAttribute("order");
            o.getLineList().add(l);
            request.setAttribute("order", o);
            request.setAttribute("lines", o.getLineList());
            url = "/WEB-INF/catalog/catalog.jsp";
            System.out.println("line l : "+ l);
            System.out.println("order o :"+ o);
        }
        return url;
    }
    

    private BasketManagerLocal lookupBasketManagerLocal() {
        try {
            Context c = new InitialContext();
            return (BasketManagerLocal) c.lookup("java:global/Borne2BAlive/Borne2BAlive-ejb/BasketManager!managers.BasketManagerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

