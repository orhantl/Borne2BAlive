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
import order.OrderInfo;

public class OffersCtrl implements Serializable, SubControllerInterface {

    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String zone = request.getParameter("zone");
        String url = "/WEB-INF/catalog/catalog_offerContent.jsp";
        
        long id = Long.valueOf(request.getParameter("offerId"));

        if ("pageHead".equals(zone)) {
            url = "/WEB-INF/catalog/header.jsp";
        }

        if ("navBar".equals(zone)) {
            url = "/WEB-INF/catalog/navBar.jsp";
            request.setAttribute("navBar", catalogManager.getNavBar());
        }

        if ("mainDisplay".equals(zone)) {
            url = "/WEB-INF/catalog/offerProducts.jsp";
            request.setAttribute("offer", catalogManager.getOffer(id));
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
