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
        String url = "/WEB-INF/composeMenu/1sandwichMain.jsp";
        String zone = request.getParameter("zone");
        String step = request.getParameter("step");
        String action = request.getParameter("action");

        /*
        STEP 1 : Sandwich + infos
        */
        if ("1".equals(step)) {
            if (request.getParameter("selectedMenu") != null) {
                Menu currentMenu = menuManager.getMenu(Long.valueOf(request.getParameter("selectedMenu")));
                Line line = orderManager.createLine(currentMenu);
                OrderInfo order = (OrderInfo) session.getAttribute("currentOrder");
                orderManager.addLineToOrder(line, order);
                session.setAttribute("currentOrder", order);
                session.setAttribute("currentLine", line);
                request.setAttribute("currentSandwich", menuManager.getSandwich(currentMenu.getId()));
                request.setAttribute("sandwichAllergens", menuManager.getAllergens(menuManager.getSandwich(currentMenu.getId()).getId()));

                url = "/WEB-INF/composeMenu/1sandwichMain.jsp";
            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/1header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/1footer.jsp";
            }
        }

        /*
        STEP 2 : Sandwich options
        */
        if ("2".equals(step)) {
            url = "/WEB-INF/composeMenu/2sandwichOpt.jsp";
            
            if ("back".equals(action)) {
                url = "/WEB-INF/composeMenu/1sandwichMain.jsp";
            }
            
            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/2header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/2footer.jsp";
            }

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
