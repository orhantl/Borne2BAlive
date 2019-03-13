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
import managers.CatalogManagerLocal;
import managers.MenuManagerLocal;
import managers.OrderManagerLocal;
import order.Line;
import order.OrderInfo;

public class DetailProductCtrl implements Serializable, SubControllerInterface {

    MenuManagerLocal menuManager = lookupMenuManagerLocal();
    OrderManagerLocal orderManager = lookupOrderManagerLocal();

    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Long idProduct = Long.valueOf(request.getParameter("product"));
        Long idCat = Long.valueOf(request.getParameter("category"));
        OrderInfo order = (OrderInfo) session.getAttribute("order");

        String zone = request.getParameter("zone");
        String step = request.getParameter("step");

        String url = "/WEB-INF/catalog/categoryDetail.jsp";

        Product p = catalogManager.getProduct(idProduct);

        String categoryName = catalogManager.getCategory(idCat).getName();

        OrderInfo currentOrder = (OrderInfo) session.getAttribute("currentOrder");
        if (currentOrder == null) {
            currentOrder = orderManager.createOrder();
        }

        if ("1".equals(step)) {

            
            

            session.setAttribute("allergens", menuManager.getAllergens(idProduct));

            session.setAttribute("product", catalogManager.getProduct(idProduct));
            session.setAttribute("category", catalogManager.getCategory(idCat));
        }
        
        if ("2".equals(step)) {
            Line l = new Line();
            l.setProduct(catalogManager.getProduct(idProduct));
        }

        //session? ou request?
        

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

    private MenuManagerLocal lookupMenuManagerLocal() {
        try {
            Context c = new InitialContext();
            return (MenuManagerLocal) c.lookup("java:global/Borne2BAlive/Borne2BAlive-ejb/MenuManager!managers.MenuManagerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
