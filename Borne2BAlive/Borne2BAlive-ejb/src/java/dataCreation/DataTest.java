
package dataCreation;

import Product.Category;
import Product.CategoryType;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;
import order.Location;
import order.OrderInfo;
import order.OrderStatus;
import order.PaymentType;
import order.VAT;


@Stateless
public class DataTest implements DataTestLocal {
    
    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    @Override
    public void createData() {
        
         /*
        INSTANCIATION OF OBJECTS
        */
        
        // Category types
        CategoryType typeCarte = new CategoryType("A la carte");
        CategoryType typeMenus = new CategoryType("Menus");
        
        // Category
        Category coldDrinks = new Category("Boissons Fraîches", "Désaltérez-vous avec nos boissons rafraichissantes");
        Category hotDrinks = new Category("Boissons Chaudes", "Pour bien finir le repas");
        Category sandwiches = new Category("Sandwichs", "Tous nos sandwichs à la carte et personnalisables");
        Category sides = new Category("Accompagnements", "Pour les petites faims");
        Category desserts = new Category("Desserts", "Pour tous les gourmands");
        Category sauces = new Category("Sauce", "Pour rajouter un peu de pep's à vos plats");
        Category menuDrinks = new Category("Boissons du Menu", "Désaltérez-vous avec nos boissons rafraichissantes");
        Category menuSandwiches = new Category("Sandwichs du Menu", "Le plat de résistance");
        Category menuSides = new Category("Accompagnements du Menu", "Au choix");
        
       
        
        // VAT 
        
        VAT normale = new VAT(10, "TVA normale");
        VAT reduite = new VAT(5.5f, "TVA réduite");
        
        // LOCATION
        Location resto = new Location ("sur place");
        Location takeAway = new Location ("à emporter");
        
        
        //PAYMENT TYPE 
        
        PaymentType cb = new PaymentType ("carte bancaire");
        PaymentType esp = new PaymentType ("espèces");
        PaymentType tresto = new PaymentType("ticket restaurant");
        
        
        //ORDER STATUS
        
        OrderStatus os01 = new OrderStatus ("en cours de préparation");
        OrderStatus os02 = new OrderStatus ("en attente de règlement");
        OrderStatus os03 = new OrderStatus ("payée");
        OrderStatus os04 = new OrderStatus ("prête");
        OrderStatus os05 = new OrderStatus ("retirée");
        
        
        // ORDER
        
        Date d01 = new GregorianCalendar(2019, 02, 21).getTime();
        Date d02 = new GregorianCalendar(2019, 02, 22).getTime();
        Date d03 = new GregorianCalendar(2019, 02, 23).getTime();
        Date d04 = new GregorianCalendar(2019, 02, 24).getTime();
        Date d05 = new GregorianCalendar(2019, 02, 25).getTime();
        System.out.println(d01);
        
        OrderInfo o01 = new OrderInfo ("CB21", d01, 10f);
        OrderInfo o02 = new OrderInfo ("CB22", d01, 5.5f);
        OrderInfo o03 = new OrderInfo ("CB24", d01, 5.5f);
        OrderInfo o04 = new OrderInfo ("ESP49", d01, 10f);
        OrderInfo o05 = new OrderInfo ("ESP30", d01, 10f);
        
        // LINE 
        
        Line l01 = new Line (0,0,0,0,0);
        Line l02 = new Line (0,0,0,0,0);
        Line l03 = new Line (0,0,0,0,0);
        Line l04 = new Line (0,0,0,0,0);
        Line l05 = new Line (0,0,0,0,0);
        Line l06 = new Line (0,0,0,0,0);
        Line l07 = new Line (0,0,0,0,0);
        Line l08 = new Line (0,0,0,0,0);
        Line l09 = new Line (0,0,0,0,0);
        Line l10 = new Line (0,0,0,0,0);
        Line l11 = new Line (0,0,0,0,0);
         /*
        ASSOCIATIONS
        */
        coldDrinks.setType(typeCarte);
        hotDrinks.setType(typeCarte);
        sandwiches.setType(typeCarte);
        sides.setType(typeCarte);
        desserts.setType(typeCarte);
        sauces.setType(typeCarte);
        menuDrinks.setType(typeMenus);
        menuSandwiches.setType(typeMenus);
        menuSides.setType(typeMenus);
        
        resto.setAppliedVAT(normale);
        takeAway.setAppliedVAT(reduite);
        
        o01.setPlace(resto);
        o02.setPlace(takeAway);
        o03.setPlace(takeAway);
        o04.setPlace(resto);
        o05.setPlace(resto);
        
        ArrayList <PaymentType> p01 = new ArrayList();
        p01.add(cb);
        
        ArrayList <PaymentType> p02 = new ArrayList();
        p02.add(cb);
        p02.add(esp);
        p02.add(tresto);
        
        o01.setPaymentList(p01);
        o02.setPaymentList(p01);
        o03.setPaymentList(p01);
        o04.setPaymentList(p01);
        o05.setPaymentList(p02);
        
        o01.setStatus(os01);
        o02.setStatus(os02);
        o03.setStatus(os03);
        o04.setStatus(os04);
        o05.setStatus(os05);
//        
//        o01.getLineList().add(l01);
//        o01.getLineList().add(l02);
//        o02.getLineList().add(l03);
//        o02.getLineList().add(l04);
//        o03.getLineList().add(l05);
//        o03.getLineList().add(l06);
//        o04.getLineList().add(l07);
//        o04.getLineList().add(l08);
//        o05.getLineList().add(l09);
//        o05.getLineList().add(l10);
//        o05.getLineList().add(l11);
        
        l01.setSelectedOrder(o01);
        l02.setSelectedOrder(o01);
        l03.setSelectedOrder(o01);
        l04.setSelectedOrder(o02);
        l05.setSelectedOrder(o02);
        l06.setSelectedOrder(o03);
        l07.setSelectedOrder(o03);
        l08.setSelectedOrder(o04);
        l09.setSelectedOrder(o04);
        l10.setSelectedOrder(o05);
        l11.setSelectedOrder(o05);
        
        
        
        /*
        PERSISTS
        */
        
        em.persist(coldDrinks);
        em.persist(hotDrinks);
        em.persist(sandwiches);
        em.persist(sides);
        em.persist(desserts);
        em.persist(sauces);
        em.persist(menuDrinks);
        em.persist(menuSandwiches);
        em.persist(menuSides);
               
        em.persist(o01);
        em.persist(o02);
        em.persist(o03);
        em.persist(o04);
        em.persist(o05);
        
        em.persist(l01);
        em.persist(l02);
        em.persist(l03);
        em.persist(l04);
        em.persist(l05);
        em.persist(l06);
        em.persist(l07);
        em.persist(l08);
        em.persist(l09);
        em.persist(l10);
        em.persist(l11);
        em.flush();
        
    }

    
    
    
    
    
    
}
