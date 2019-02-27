
package dataCreation;

import Product.Allergen;
import Product.Category;
import Product.CategoryType;
import Product.Ingredient;
import java.util.Collection;
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
        
        // Ingredient
        Ingredient salade = new Ingredient("Salade", "Et une salade Gaza pour la gazelle ? "
                + "Quoi ? Oui, c'est de la roquette", "/WEB-INF/Img/salade.jpg");
        Ingredient tomato = new Ingredient("Tomate", "Et une Roundup, une !", "/WEB-INF/Img/tomate.jpg");
        Ingredient bread = new Ingredient("Pain", "Pétri sous les aisselles", "/WEB-INF/Img/pain-kebab.jpg");
        Ingredient onion = new Ingredient("Oignon", "Il est carré mon oignon, il est carré !", 
                "/WEB-INF/Img/oignon.jpg");
        Ingredient beef = new Ingredient("Bœuf", "On l'a choyé du pis à l'abattoir", "/WEB-INF/Img/boeuf.jpg");
        Ingredient lamb = new Ingredient("Agneau", "Le bébé du canard", "/WEB-INF/Img/agneau.jpg");
        Ingredient chicken = new Ingredient("Poulet", "Run Chicken, run !", "/WEB-INF/Img/poulet.jpg");
        Ingredient merguez = new Ingredient("Merguez", "Comment ça elle est fluo ma guezmer ?", 
                "/WEB-INF/Img/merguez.jpg");
        Ingredient fries = new Ingredient("Frites", "Sauce blanche avec les frites ?", "/WEB-INF/Img/frites.jpg");
        Ingredient potatoes = new Ingredient("Potatoes", "Aussi grasses que les vraies", 
                "/WEB-INF/Img/potatoes.jpg");
        Ingredient cheese = new Ingredient("Fromage", "Du bon fromage végétal pour "
                + "les amoureux de la nature", "/WEB-INF/Img/fromage.jpg");
        Ingredient iceCubes = new Ingredient("Glaçons", "À la Neuf semaines et demi", "/WEB-INF/Img/Glaçons.jpg");
        Ingredient coke = new Ingredient("Cola", "Du diabète en boîte", "/WEB-INF/Img/cola.jpg");
        Ingredient dietCoke = new Ingredient("Cola", "De l'aspartame pour le pancréas",
                "/WEB-INF/Img/cola.jpg");
        Ingredient orangeSoda = new Ingredient("Soda à l'orange", "Du diabète en boîte",
                "/WEB-INF/Img/orangeSoda.jpg");
        Ingredient teaSoda = new Ingredient("Soda au thé", "Du diabète en boîte", "/WEB-INF/Img/tea.png");
        Ingredient carbWater = new Ingredient("Eau gazeuse", "C'est de l'eau qui pique",
                "/WEB-INF/Img/eauGazeuse.jpg");
        Ingredient stillWater = new Ingredient("Eau plate", "C'est de l'eau qui ne pique pas",
                "/WEB-INF/Img/eauPlate.jpg");
        Ingredient hotChocolate = new Ingredient("Chocolat chaud", "On dit pain au chocolat chaud"
                + " et pas chocolatine chaude", "/WEB-INF/Img/chocolatChaud.jpg");
        Ingredient coffee = new Ingredient("Café", "Fait avec amour par nos esclaves "
                + "de Java", "/WEB-INF/Img/coffee.jpg");
        Ingredient hotTea = new Ingredient("Thé", "Fait avec amour par nos esclaves "
                + "de Java", "/WEB-INF/Img/tea.jpg");
        Ingredient ketchup = new Ingredient("Ketchup", "Des tomates et du sucre", "/WEB-INF/Img/ketchup.png");
        Ingredient mayonnaise = new Ingredient("Mayonnaise", "De la bonne graisse industrielle",
                "/WEB-INF/Img/mayonnaise.jpg");
        Ingredient samuraiSauce = new Ingredient("Sauce samouraï", "Elle donne envie de se plonger "
                + "un sabre dans le ventre", "/WEB-INF/Img/samourai.jpg");
        Ingredient pitaBread = new Ingredient("Pain pita", "Comme il y a moins de pain, "
                + "ça coûte plus cher", "/WEB-INF/Img/pita.jpg");
        Ingredient harissa = new Ingredient("Harissa", "Dié-té-tique !", "/WEB-INF/Img/harissa.jpg");
        Ingredient sauceBlanche = new Ingredient("Sauce blanche", "Saviez-vous que le cornichon "
                + "est un bébé concombre ?", "/WEB-INF/Img/sauceBlanche.jpg");
        Ingredient baklava = new Ingredient("Baklava", "Dié-té-tique !", "/WEB-INF/Img/baklava.jpg");
        Ingredient chocolateIceCream = new Ingredient ("Glace au chocolat", 
                "Dié-té-tique", "/WEB-INF/Img/glaceChocolat.jpg");
        Ingredient vanillaIceCream = new Ingredient("Glace à la vanille", 
                "Dié-té-tique", "/WEB-INF/Img/vanilla.jpg");
        Ingredient tiramisu = new Ingredient("Tiramisu", "Dié-té-tique",
                "/WEB-INF/Img/tiramisu.jpg");
        
        // Allergen
        
        Allergen gluten = new Allergen("Gluten");
        Allergen sesame = new Allergen("Graines de sésame");
        Allergen nut = new Allergen("Fruits à coque");
        
         
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
        
        Collection<Allergen> allerBread = bread.getAllergens();
        allerBread.add(gluten);
        allerBread.add(sesame);
        
        
        /*
        PERSISTS
        */
        
        // Category
        
        em.persist(coldDrinks);
        em.persist(hotDrinks);
        em.persist(sandwiches);
        em.persist(sides);
        em.persist(desserts);
        em.persist(sauces);
        em.persist(menuDrinks);
        em.persist(menuSandwiches);
        em.persist(menuSides);
        
        
        // Ingredient
        
        em.persist(bread);
        em.persist(salade);
        em.persist(tomato);
        em.persist(onion);
        em.persist(beef);
        em.persist(lamb);
        em.persist(chicken);
        em.persist(merguez);
        em.persist(fries);
        em.persist(potatoes);
        em.persist(cheese);
        em.persist(iceCubes);
        em.persist(coke);
        em.persist(dietCoke);
        em.persist(orangeSoda);
        em.persist(teaSoda);
        em.persist(carbWater);
        em.persist(stillWater);
        em.persist(hotChocolate);
        em.persist(hotTea);
        em.persist(coffee);
        em.persist(ketchup);
        em.persist(mayonnaise);
        em.persist(samuraiSauce);
        em.persist(pitaBread);
        em.persist(harissa);
        em.persist(sauceBlanche);
        em.persist(baklava);
        em.persist(chocolateIceCream);
        em.persist(vanillaIceCream);
        em.persist(tiramisu);
        
        // Allergen
        
        em.persist(gluten);
        em.persist(sesame);
        em.persist(nut);
        
        em.flush();
        
    }

    
    
    
    
    
    
}
