package controllers;

import Product.Menu;
import Product.MenuItem;
import Product.Optional;
import Product.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

public class ComposeMenuCtrl implements Serializable, SubControllerInterface {

    CatalogManagerLocal catalogManager = lookupCatalogManagerLocal();
    OrderManagerLocal orderManager = lookupOrderManagerLocal();
    MenuManagerLocal menuManager = lookupMenuManagerLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String url = "/WEB-INF/composeMenu/1sandwichMain.jsp";
        String zone = request.getParameter("zone");
        String step = request.getParameter("step");
        String action = request.getParameter("action");
        String option = request.getParameter("option");

        OrderInfo currentOrder = (OrderInfo) session.getAttribute("currentOrder");
        if (currentOrder == null) {
            currentOrder = orderManager.createOrder();
        }

        Line currentLine = (Line) session.getAttribute("currentLine");

        /*
         STEP 1 : Sandwich + infos
         */
        if ("1".equals(step)) {
            url = "/WEB-INF/composeMenu/1sandwichMain.jsp";

            if (request.getParameter("selectedMenu") != null) {
                Menu currentMenu = menuManager.getMenu(Long.valueOf(request.getParameter("selectedMenu")));

                if (currentLine == null) {
                    currentLine = orderManager.createLine(currentMenu);
                    menuManager.addMenuToLine(currentMenu, currentLine);
                }

                Product currentSandwich = menuManager.getSandwich(currentMenu.getId());
                session.setAttribute("sandwichAllergens", menuManager.getAllergens(currentSandwich.getId()));
                session.setAttribute("currentSandwich", currentSandwich);

                MenuItem itemSandwich = (MenuItem) session.getAttribute("currentItemSandwich");
                if (itemSandwich == null) {
                    itemSandwich = menuManager.createMenuItem(currentSandwich);
                }

//                menuManager.addItemToLine(itemSandwich, currentLine);
//                orderManager.addLineToOrder(currentLine, currentOrder);
                session.setAttribute("currentItemSandwich", itemSandwich);
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

            MenuItem[] items = {itemSandwich};
            currentLine.setOptionPriceApplied(menuManager.getOptionsPrice(items));
            session.setAttribute("currentItemSandwich", itemSandwich);
            session.setAttribute("currentSandwichOptions", removableOptions);

        }

        /*
         STEP 3 : Sides
         */
        if ("3".equals(step)) {
            request.setAttribute("menuSides", menuManager.getSidesFromMenu());

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

            MenuItem itemSide = (MenuItem) session.getAttribute("currentItemSide");

            if (request.getParameter("side") != null) {
                long currentSideId = Long.valueOf(request.getParameter("side"));
                itemSide = menuManager.createMenuItem(menuManager.getProduct(currentSideId));

                session.setAttribute("currentSideOptions", menuManager.getOptionsFromProduct(currentSideId));
            }

            if (option != null) {
                Optional selectedOption = menuManager.getOptional(Long.valueOf(option));
                menuManager.addOptionToItemSide(selectedOption, itemSide);

                Collection<Product> sauces = catalogManager.getAllAvailableProductsFromCategory("Sauce");
                session.setAttribute("sauces", sauces);

                url = "/WEB-INF/composeMenu/5sauceMain.jsp";
            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/4header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/4footer.jsp";
            }

            MenuItem[] items = {(MenuItem) session.getAttribute("currentItemSandwich"), itemSide};
            currentLine.setOptionPriceApplied(menuManager.getOptionsPrice(items));
            session.setAttribute("currentItemSide", itemSide);
        }

        /*
         STEP 5 : Sauces
         */
        if ("5".equals(step)) {
            url = "/WEB-INF/composeMenu/5sauceMain.jsp";

            if (request.getParameter("selectedSauce") != null) {
                long selectedSauce = Long.valueOf(request.getParameter("selectedSauce"));
                if (selectedSauce > 0) {
                    MenuItem itemSauce = menuManager.createMenuItem(menuManager.getProduct(selectedSauce));

                    MenuItem[] items = {(MenuItem) session.getAttribute("currentItemSandwich"), (MenuItem) session.getAttribute("currentItemSide"), itemSauce};
                    currentLine.setOptionPriceApplied(menuManager.getOptionsPrice(items));
                    session.setAttribute("currentItemSauce", itemSauce);
                }
                url = "/WEB-INF/composeMenu/6drinkMain.jsp";
            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/5header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/5footer.jsp";
            }

        }

        /*
         STEP 6 : Drinks
         */
        if ("6".equals(step)) {
            url = "/WEB-INF/composeMenu/6drinkMain.jsp";
            request.setAttribute("menuDrinks", menuManager.getDrinksFromMenu());

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/6header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/6footer.jsp";
            }

        }

        /*
         STEP 7 : Drink size
         */
        if ("7".equals(step)) {
            url = "/WEB-INF/composeMenu/7drinkOpt.jsp";

            if (request.getParameter("drink") != null) {
                MenuItem itemMenuDrink = menuManager.createMenuItem(menuManager.getProduct(Long.valueOf(request.getParameter("drink"))));
                session.setAttribute("currentItemDrink", itemMenuDrink);

                session.setAttribute("currentDrinkOptions", menuManager.getSizeOptionsFromProduct(itemMenuDrink.getProduct().getId()));

            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/7header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/7footer.jsp";
            }

            if (request.getParameter("size") != null) {
                long sizeId = Long.valueOf(request.getParameter("size"));
                MenuItem itemMenuDrink = (MenuItem) session.getAttribute("currentItemDrink");
                menuManager.addOptionToItem(menuManager.getOptional(sizeId), itemMenuDrink);

                MenuItem[] items = {(MenuItem) session.getAttribute("currentItemSandwich"),
                    (MenuItem) session.getAttribute("currentItemSide"), (MenuItem) session.getAttribute("currentItemSauce"), itemMenuDrink};
                currentLine.setOptionPriceApplied(menuManager.getOptionsPrice(items));
                session.setAttribute("currentItemDrink", itemMenuDrink);
                url = "/WEB-INF/composeMenu/8iceOpt.jsp";
            }
        }

        /*
         STEP 8 : Drink ice option
         */
        if ("8".equals(step)) {
            url = "/WEB-INF/composeMenu/8iceOpt.jsp";

            MenuItem itemMenuDrink = (MenuItem) session.getAttribute("currentItemDrink");
            session.setAttribute("otherDrinkOptions", menuManager.getIceOptionsFromProduct(itemMenuDrink.getProduct().getId()));

            if (request.getParameter("ice") != null) {
                long iceOptionId = Long.valueOf(request.getParameter("ice"));
                url = "/WEB-INF/composeMenu/9review.jsp";

                if (iceOptionId > 0) {
                    menuManager.addOptionToItem(menuManager.getOptional(iceOptionId), itemMenuDrink);
                }
            }

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/8header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/8footer.jsp";
            }
            session.setAttribute("currentItemDrink", itemMenuDrink);
        }

        /*
         STEP 9 : Review
         */
        if ("9".equals(step)) {
            url = "/WEB-INF/composeMenu/9review.jsp";

            if ("header".equals(zone)) {
                url = "/WEB-INF/composeMenu/9header.jsp";
            }

            if ("footer".equals(zone)) {
                url = "/WEB-INF/composeMenu/9footer.jsp";
            }

            if (request.getParameter("add") != null) {
                MenuItem currentItemSandwich = (MenuItem) session.getAttribute("currentItemSandwich");
                MenuItem currentItemSide = (MenuItem) session.getAttribute("currentItemSide");
                MenuItem currentItemSauce = (MenuItem) session.getAttribute("currentItemSauce");
                MenuItem currentItemDrink = (MenuItem) session.getAttribute("currentItemDrink");
                menuManager.addItemToLine(currentItemSandwich, currentLine);
                menuManager.addItemToLine(currentItemSide, currentLine);
                menuManager.addItemToLine(currentItemSauce, currentLine);
                menuManager.addItemToLine(currentItemDrink, currentLine);
                orderManager.addLineToOrder(currentLine, currentOrder);
                url = "/WEB-INF/catalog/catalog.jsp";
            }
        }

        
        session.setAttribute("currentLine", currentLine);
        session.setAttribute("order", currentOrder);

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
