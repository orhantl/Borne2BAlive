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
import managers.CatalogManagerLocal;
import managers.OrderManagerLocal;
import order.Location;
import order.OrderInfo;

public class CatalogCtrl implements Serializable, SubControllerInterface {

    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String zone = request.getParameter("zone");
        String url = "/WEB-INF/catalog/catalog.jsp";


        
        // Order creation with VAT & location
        
//        OrderInfo order = orderManager.initializeOrder((String) request.getParameter("location"));
//        session.setAttribute("order", order);


        // fake order de LO - code à supprimer plus tard (ici et dans orderManager)
            //OrderInfo order = (OrderInfo) session.getAttribute("order");
            //order = order == null ? orderManager.createOrder() : order;
            //session.setAttribute("order", order);



        if ("pageHead".equals(zone)) {
            url = "/WEB-INF/catalog/header.jsp";
        }

        if ("navBar".equals(zone)) {
            url = "/WEB-INF/catalog/navBar.jsp";
            request.setAttribute("navBar", catalogManager.getNavBar());
        }

        if ("mainDisplay".equals(zone)) {
            url = "/WEB-INF/catalog/mainDisplay.jsp";
            // fake order de LO - code à supprimer plus tard (ici et dans orderManager)
            OrderInfo order = (OrderInfo) session.getAttribute("order");
            order = order == null ? orderManager.createOrder() : order;
            session.setAttribute("order", order);
            request.setAttribute("products", catalogManager.getAllProducts());

            request.setAttribute("products", catalogManager.getAllProducts());         
        }      
        
        if ("cart".equals(zone)) {
            url = "/WEB-INF/catalog/cart.jsp";

        }

        return url;
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
