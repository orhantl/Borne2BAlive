package controllers;

import Product.Optional;
import Product.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.BasketManager;
import managers.BasketManagerLocal;
import managers.CatalogManagerLocal;
import managers.MenuManagerLocal;
import managers.OrderManagerLocal;
import order.Line;
import order.OrderInfo;

public class DetailProductCtrl implements Serializable, SubControllerInterface {

    BasketManagerLocal basketManager = lookupBasketManagerLocal();
    MenuManagerLocal menuManager = lookupMenuManagerLocal();
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long idProduct = Long.valueOf(request.getParameter("product"));
        OrderInfo order = (OrderInfo) session.getAttribute("order");
        String step = request.getParameter("step");

        String url = "/WEB-INF/catalog/productDetail.jsp";

        Product p = catalogManager.getProduct(idProduct);


        if ("1".equals(step)) {

            request.setAttribute("allergens", menuManager.getAllergens(idProduct));
            request.setAttribute("product", catalogManager.getProduct(idProduct));
            request.setAttribute("option", menuManager.getOptionsExcSize(idProduct));
            request.setAttribute("size", menuManager.getSizeOptionsFromProduct(idProduct));
        }

        if ("2".equals(step)) {
            Line l = basketManager.getLine(idProduct, 0);
            
            float f = basketManager.getOptionPriceApplied(request.getParameterValues("size")) 
                    + basketManager.getOptionPriceApplied(request.getParameterValues("options"));
            
            ArrayList <Optional> a = basketManager.getOptionList(request.getParameterValues("size"));
            ArrayList <Optional> b = basketManager.getOptionList(request.getParameterValues("options"));
            
            // options + size
            l.setOptionList(basketManager.mergeOptionList(a, b));
            l.setOptionPriceApplied(f);

            order.getLineList().add(l);

            System.out.println("lines" + order.getLineList().toString());

            url = "/WEB-INF/catalog/catalog.jsp";
        }

        float prixTTC = basketManager.getVATTotal(order);
        session.setAttribute("prixTTC", prixTTC);
        session.setAttribute("order", order);
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
