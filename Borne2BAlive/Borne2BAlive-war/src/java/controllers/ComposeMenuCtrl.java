package controllers;

import Product.Menu;
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
import managers.OrderManagerLocal;
import order.Line;
import order.OrderInfo;

public class ComposeMenuCtrl implements Serializable, SubControllerInterface {
   
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    MenuManagerLocal menuManager = lookupMenuManagerLocal();

    

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String url = "/WEB-INF/composeMenu/composeMenu.jsp";
        String zone = request.getParameter("zone");
        
        
        if (request.getParameter("selectedMenu") != null) {
            Menu currentMenu = menuManager.getMenu(Long.valueOf(request.getParameter("selectedMenu")));
            Line line = orderManager.createLine(currentMenu);
            OrderInfo order = (OrderInfo) session.getAttribute("currentOrder");
            orderManager.addLineToOrder(line, order);
            session.setAttribute("currentOrder", order);
            request.setAttribute("currentLine", line);
            request.setAttribute("currentSandwich", menuManager.getSandwich(currentMenu.getId()));
            
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
