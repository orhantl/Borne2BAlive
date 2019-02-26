
package dataCreation;

import Product.Category;
import Product.CategoryType;
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
        
    }

    
    
    
    
    
    
}
