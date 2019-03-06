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
import managers.MenuManagerLocal;

public class ComposeMenuCtrl implements Serializable, SubControllerInterface {
    
    MenuManagerLocal menuManager = lookupMenuManagerLocal();

    

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String url = "/WEB-INF/composeMenu/composeMenu.jsp";
        String zone = request.getParameter("zone");
        
        if (request.getParameter("selectedMenu") != null) {
            long menuId = Long.valueOf(request.getParameter("selectedMenu"));
            request.setAttribute("MenuToCreate", menuManager.getMenu(menuId));
            request.setAttribute("currentSandwich", menuManager.getSandwich(menuId));
            url = "/WEB-INF/composeMenu/composeMenu.jsp";
        }
        
        if ("header".equals(zone)) {
            url = "/WEB-INF/composeMenu/header.jsp";
        }
        
        if ("footer".equals(zone)) {
            url = "/WEB-INF/composeMenu/footer.jsp";
        }
        
        
        
        
        return url;
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
