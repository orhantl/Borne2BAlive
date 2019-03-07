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

public class MenusCtrl implements Serializable, SubControllerInterface {

    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String zone = request.getParameter("zone");
        String url = "/WEB-INF/catalog/catalog_menus.jsp";
        
        if ("mainDisplay".equals(zone)) {
            url = "/WEB-INF/catalog/menus.jsp";
            request.setAttribute("MenusAvailable", catalogManager.getAvailableMenus());
            request.setAttribute("MenusUnavailable", catalogManager.getUnavailableMenus());
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
