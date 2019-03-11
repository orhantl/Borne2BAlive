package controllers;

import Product.Menu;
import Product.MenuItem;
import Product.Optional;
import Product.Product;
import java.io.Serializable;
import java.util.Collection;
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
            url = "/WEB-INF/composeMenu/1sandwichMain.jsp";
            if (request.getParameter("selectedMenu") != null) {

//                OrderInfo order = (OrderInfo) session.getAttribute("currentOrder");
                Menu currentMenu = menuManager.getMenu(Long.valueOf(request.getParameter("selectedMenu")));
//                Line line = orderManager.createLine(currentMenu);
                Product currentSandwich = menuManager.getSandwich(currentMenu.getId());
//                MenuItem itemSandwich = menuManager.createMenuItem(currentSandwich);

//                menuManager.addItemToLine(itemSandwich, line);
//                orderManager.addLineToOrder(line, order);
//                session.setAttribute("currentOrder", order);
//                session.setAttribute("currentLine", line);
                session.setAttribute("currentSandwich", currentSandwich);
                session.setAttribute("sandwichAllergens", menuManager.getAllergens(currentSandwich.getId()));

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

            String remove = request.getParameter("remove");
            String add = request.getParameter("add");

            Product currentSandwich = (Product) session.getAttribute("currentSandwich");
            MenuItem itemSandwich = (MenuItem) session.getAttribute("currentItemSandwich");
            if (itemSandwich == null) {
                itemSandwich = menuManager.createMenuItem(currentSandwich);
            }

            Collection<Optional> removableOptions = (Collection<Optional>) session.getAttribute("currentSandwichOptions");
            if (removableOptions == null) {
                removableOptions = menuManager.getOptionsFromProduct(currentSandwich.getId());
            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/2header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/2footer.jsp";
            }

            if (remove != null) {
                Optional ingredientToRemove = menuManager.getOptional(Long.valueOf(remove));

                // pour éviter les options en double
                if (!itemSandwich.getOptions().contains(ingredientToRemove)) {
                    itemSandwich.getOptions().add(ingredientToRemove);
                }

                try {
                    removableOptions.remove(ingredientToRemove);
                } catch (NullPointerException ex) {
                    System.out.println("Exception in ComposeMenuCtrl > step 2 > option : " + ex);
                }

            }

            if (add != null) {
                Optional ingredientToAdd = menuManager.getOptional(Long.valueOf(add));

                // pour éviter les options en double
                if (!removableOptions.contains(ingredientToAdd)) {
                    removableOptions.add(ingredientToAdd);
                }

                try {
                    itemSandwich.getOptions().remove(ingredientToAdd);
                } catch (NullPointerException ex) {
                    System.out.println("Exception in ComposeMenuCtrl > step 2 > option : " + ex);
                }
            }

            session.setAttribute("currentItemSandwich", itemSandwich);
            session.setAttribute("currentSandwichOptions", removableOptions);

        }

        /*
         STEP 3 : Sides
         */
        if ("3".equals(step)) {
            session.setAttribute("menuSides", menuManager.getSidesFromMenu());

            url = "/WEB-INF/composeMenu/3sideMain.jsp";

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/3header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/3footer.jsp";
            }

        }

        /*
         STEP 4 : Sides options
         */
        if ("4".equals(step)) {
            url = "/WEB-INF/composeMenu/4sideOpt.jsp";

            if (request.getParameter("side") != null) {
                long currentSideId = Long.valueOf(request.getParameter("side"));
                MenuItem itemSide = menuManager.createMenuItem(menuManager.getProduct(currentSideId));

                session.setAttribute("currentItemSide", itemSide);
                session.setAttribute("currentSideOptions", menuManager.getOptionsFromProduct(currentSideId));
            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/4header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/4footer.jsp";
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
