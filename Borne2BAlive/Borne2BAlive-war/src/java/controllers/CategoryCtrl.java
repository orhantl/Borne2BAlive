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
import order.OrderInfo;

public class CategoryCtrl implements Serializable, SubControllerInterface {

    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Long id = Long.valueOf(request.getParameter("id"));
        OrderInfo order = (OrderInfo) session.getAttribute("order");

        String zone = request.getParameter("zone");
        String url = "/WEB-INF/catalog/catalog_category.jsp";

        String categoryName = catalogManager.getCategory(id).getName();

        if ("mainDisplay".equals(zone)) {
            switch (categoryName) {
                case "Menus":
                    url = "/WEB-INF/catalog/menus.jsp";
                    request.setAttribute("MenusAvailable", catalogManager.getAvailableMenus());
                    request.setAttribute("MenusUnavailable", catalogManager.getUnavailableMenus());
                    break;
                case "Offres":
                    // TODO
                    break;
                default:
                    url = "/WEB-INF/catalog/categoryDisplay.jsp";

                    request.setAttribute("Products", catalogManager.getAllAvailableProductsByCategory(id));
            }
       
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

}
