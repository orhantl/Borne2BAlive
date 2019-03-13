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
import managers.CatalogManagerLocal;
import order.Line;
import order.OrderInfo;

public class CartCtrl implements Serializable, SubControllerInterface {

    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();
    BasketManagerLocal basketManager = lookupBasketManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        OrderInfo o = (OrderInfo) session.getAttribute("order");

        String zone = request.getParameter("zone");
        String url = "/WEB-INF/catalog/catalog.jsp";

        if ("add".equals(zone)) {            
            Long id = Long.valueOf(request.getParameter("item"));           
            o.getLineList().add(basketManager.getLine(id,0));
            url = "/WEB-INF/catalog/catalog.jsp";
        }
        
        if ("empty".equals(zone)) {
            basketManager.emptyBasket(o);
        }
        
        if ("remove".equals(zone)) {
            int index = Integer.valueOf(request.getParameter("count")); 
            System.out.println("index value = " +index);
            basketManager.removeLine(o, index);
        }

        float prixTTC = basketManager.getVATTotal(o);
        session.setAttribute("prixTTC", prixTTC);
        session.setAttribute("order", o);
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

    private CatalogManagerLocal lookupCatalogManagerLocal() {
        try {
            Context c = new InitialContext();
            return (CatalogManagerLocal) c.lookup("java:global/Borne2BAlive/Borne2BAlive-ejb/CatalogManager!managers.CatalogManagerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
