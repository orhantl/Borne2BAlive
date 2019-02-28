
package dataCreation;

import Account.Account;
import Account.AccountStatus;
import Product.Category;
import Product.CategoryType;
import company.CashRegister;
import company.Kiosk;
import company.Restaurant;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
        
        //restaurant
        Restaurant resto= new Restaurant
        ("borne2Alive","17 rue CDG Paris 75012","0185252525","123456789","1234567890123","borne2Alive@gmail.com");
        
        
         //cashRegister
        CashRegister caisse= new CashRegister("485","toto24");
        
        //kiosk
        Kiosk borne01= new Kiosk("485","kv01");
        
        //Account
        Account acc01 = new Account("toto@gmail.com","dassauld","toto","toto1234",
                "0690123456",new GregorianCalendar(2018, 02,28).getTime(),new GregorianCalendar(1985,03, 24).getTime(),
                "H","25 rue jean 94400 Vitry");
        
        //AccountStatus
        AccountStatus actif= new AccountStatus ("actif");
        
        
        /*
        ASSOCIATIONS
        */
        acc01.setStatus(actif);
        caisse.setRestaurant(resto);
        borne01.setRestaurant(resto);
        
        
        coldDrinks.setType(typeCarte);
        hotDrinks.setType(typeCarte);
        sandwiches.setType(typeCarte);
        sides.setType(typeCarte);
        desserts.setType(typeCarte);
        sauces.setType(typeCarte);
        menuDrinks.setType(typeMenus);
        menuSandwiches.setType(typeMenus);
        menuSides.setType(typeMenus);
        
        
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
        em.flush();
        em.persist(acc01);
        em.persist(borne01);
        em.persist(caisse);
        
    }

    
    
    
    
    
    
}
