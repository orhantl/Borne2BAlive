
package dataCreation;

import Product.Category;
import Product.CategoryType;
import Product.NutritionFacts;
import Product.Product;
import Product.ProductStatus;
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
        Category coldDrinks = new Category("Boissons Fraîches", "Désaltérez-vous avec nos boissons rafraichissantes", "/WEB-INF/Img/Categories/coldDrinks.jpg");
        Category hotDrinks = new Category("Boissons Chaudes", "Pour bien finir le repas", "/WEB-INF/Img/Categories/hotDrinks.jpg");
        Category sandwiches = new Category("Sandwichs", "Tous nos sandwichs à la carte et personnalisables", "/WEB-INF/Img/Categories/sandwiches.png");
        Category sides = new Category("Accompagnements", "Pour les petites faims", "/WEB-INF/Img/Categories/sides.jpg");
        Category desserts = new Category("Desserts", "Pour tous les gourmands", "/WEB-INF/Img/Categories/desserts.jpg");
        Category sauces = new Category("Sauce", "Pour rajouter un peu de pep's à vos plats", "/WEB-INF/Img/Categories/sauces.png");
        Category menuDrinks = new Category("Boissons du Menu", "Désaltérez-vous avec nos boissons rafraichissantes", "/WEB-INF/Img/Categories/coldDrinks.jpg");
        Category menuSandwiches = new Category("Sandwichs du Menu", "Le plat de résistance", "/WEB-INF/Img/Categories/sandwiches.png");
        Category menuSides = new Category("Accompagnements du Menu", "Au choix", "/WEB-INF/Img/Categories/sides.jpg");
        
        // ProductStatus
        ProductStatus available = new ProductStatus("Disponible", "Le produit peut être commandé");
        ProductStatus delisted = new ProductStatus("Déréférencé", "Le produit n'est plus en vente");
        ProductStatus outOfStock = new ProductStatus("Indisponible", "Le produit n'est pas disponible actuellement");
        
        // NutritionFacts
        NutritionFacts friesFacts = new NutritionFacts(41, 15, 3.4f, 0.3f, 3.8f, 0.21f, 312);
        NutritionFacts popatoesFacts = new NutritionFacts(25, 8.8f, 3.5f, 0.3f, 2.8f, 1.1f, 194);
        NutritionFacts ketchupFacts = new NutritionFacts(26, 0.2f, 1.3f, 22, 0.3f, 0.9f, 112);
        NutritionFacts mayoFacts = new NutritionFacts(0.6f, 75, 1, 0.6f, 0.8f, 0.64f, 680);
        NutritionFacts mustardFacts = new NutritionFacts(5, 4, 4.4f, 0.9f, 3.3f, 1.13f, 66);
        NutritionFacts samouraiFacts = new NutritionFacts(7.2f, 26, 0.9f, 3.6f, 0.4f, 0.75f, 631);
        NutritionFacts curryFacts = new NutritionFacts(12, 9.73f, 1, 5.9f, 1, 0.8f, 203);
        
        NutritionFacts adanaFacts = new NutritionFacts(13.8f, 10.7f, 19.1f, 1.3f, 2, 1.3f, 233);
        NutritionFacts kofteFacts = new NutritionFacts(13.0f, 10.2f, 16.1f, 1.3f, 1.8f, 1.2f, 228);
        NutritionFacts chickenFacts = new NutritionFacts(13.7f, 10.3f, 17.1f, 1.5f, 2.1f, 1.1f, 212);
        NutritionFacts merguezFacts = new NutritionFacts(14.8f, 12.7f, 19.8f, 1.9f, 2, 1.4f, 278);
        NutritionFacts americanFacts = new NutritionFacts(13.3f, 9.7f, 18.1f, 1.2f, 1.9f, 1.0f, 253);
        
        NutritionFacts cocaFacts = new NutritionFacts(18.3f, 0, 0, 18.3f, 0, 0, 73);
        NutritionFacts cocaLightFacts = new NutritionFacts(0, 0, 0, 0, 0, 0, 0.2f);
        NutritionFacts cocaZeroFacts = new NutritionFacts(0, 0, 0, 0, 0, 0, 0.3f);
        NutritionFacts oranginaFacts = new NutritionFacts(16.9f, 0, 0, 16.9f, 0, 0, 71);
        NutritionFacts nesteaFacts = new NutritionFacts(4.5f, 0, 0, 4.5f, 0, 0, 18);
        NutritionFacts hotChocolateFacts = new NutritionFacts(10.7f, 2.3f, 3.5f, 9.5f, 1, 0, 77);
        
        NutritionFacts tiramisuFacts = new NutritionFacts(37.5f, 12.5f, 3.8f, 21.1f, 1, 0.5f, 280);
        NutritionFacts chocolateMuffinFacts = new NutritionFacts(54, 16, 4.5f, 33, 1, 0.34f, 377);
        NutritionFacts blueberryMuffinFacts = new NutritionFacts(55, 18, 4.6f, 35, 1.2f, 0.34f, 3927);
                
        // Product
        Product adana = new Product("Adana Kebab", "/WEB-INF/Img/Products/adana.jpg", 5, "Plat issu de la cuisine turque qui vient de la ville d'Adana, plus épicé que le kebab standard");
        Product kofte = new Product("Kofte Kebab", "/WEB-INF/Img/Products/kofte.jpg", 5, "Boulette de viande hachée aux épices. C'est la préparation la plus cuisinée en Turquie.");
        Product chicken = new Product("Chicken Kebab", "/WEB-INF/Img/Products/chicken.jpg", 5, "Le traditionnel kebab en version poulet");
        Product merguez = new Product("Merguez Kebab", "/WEB-INF/Img/Products/merguez.jpg", 5, "Le traditionnel kebab en version merguez");
        Product american = new Product("American Kebab", "/WEB-INF/Img/Products/american.png", 5, "Le traditionnel kebab en version steak haché");
        
        Product fries = new Product("Frites", "/WEB-INF/Img/Products/fries.jpg", 2.5f, "Délicieuses et croustillantes");
        Product potatoes = new Product("Potatoes", "/WEB-INF/Img/Products/potatoes.png", 2.5f, "Savoureuses et croustillantes");
        Product saladSmall = new Product("Petite Salade", "/WEB-INF/Img/Products/salad.jpg", 2.0f, "Un instant frais et léger");
        
        Product ketchup = new Product("Ketchup", "/WEB-INF/Img/Products/ketchup.jpg", 0.5f, "Aux bonnes tomates gouteuses");
        Product mayo = new Product("Mayo", "/WEB-INF/Img/Products/mayo.jpg", 0.5f, "Aux oeufs frais");
        Product mustard = new Product("Moutarde", "/WEB-INF/Img/Products/mustard.jpg", 0.5f, "De Dijon");
        Product samourai = new Product("Samouraï", "/WEB-INF/Img/Products/samourai.jpg", 0.5f, "Epicée");
        Product curry = new Product("Curry", "/WEB-INF/Img/Products/curry.png", 0.5f, "Saveur des indes");
        
        Product coca = new Product("Cocal-Cola", "/WEB-INF/Img/Products/coca.jpg", 2f, "Always Coca-Cola");
        Product cocaLight = new Product("Cocal-Cola Light", "/WEB-INF/Img/Products/cocaLight.png", 2f, "Always Coca-Cola");
        Product cocaZero = new Product("Cocal-Cola Zero", "/WEB-INF/Img/Products/cocaZero.jpg", 2f, "Always Coca-Cola");
        Product perrier = new Product("Perrier", "/WEB-INF/Img/Products/perrier.png", 2f, "Des bulles désaltérantes");
        Product water = new Product("Cristaline", "/WEB-INF/Img/Products/cristaline.jpg", 1.5f, "A la Cliarefontaine, j'ai bu l'eau Cristaline");
        Product orangina = new Product("Orangina", "/WEB-INF/Img/Products/orangina.jpg", 2f, "Bien secouer !");
        Product nestea = new Product("Nestea", "/WEB-INF/Img/Products/nestea.png", 2f, "Goût pêche");
        Product coffee = new Product("Café", "/WEB-INF/Img/Products/coffee.jpg", 1.5f, "Wake up !");
        Product tea = new Product("Thé", "/WEB-INF/Img/Products/tea.png", 1.5f, "English breakfast");
        Product hotChocolate = new Product("Chocolat Chaud", "/WEB-INF/Img/Products/hotChocolate.png", 2f, "Au lait chaud");
        
        Product tiramisu = new Product("Tiramisu", "/WEB-INF/Img/Products/tiramisu.jpg", 4.5f, "Un savoureux mélange café/chocolat");
        Product chocolateMuffin = new Product("Muffin au chocolat", "/WEB-INF/Img/Products/chocolateMuffin.jpg", 4, "Aux pépites de chocolat");
        Product blueberryMuffin = new Product("Muffin aux Myrtilles", "/WEB-INF/Img/Products/blueberryMuffin.jpg", 4, "Parfait avec un thé");
        
         
        /*
        ASSOCIATIONS
        */
        
        // Category > CategoryType
        coldDrinks.setType(typeCarte);
        hotDrinks.setType(typeCarte);
        sandwiches.setType(typeCarte);
        sides.setType(typeCarte);
        desserts.setType(typeCarte);
        sauces.setType(typeCarte);
        menuDrinks.setType(typeMenus);
        menuSandwiches.setType(typeMenus);
        menuSides.setType(typeMenus);
        
        // Product > ProductStatus
        adana.setStatus(delisted);
        kofte.setStatus(available);
        chicken.setStatus(available);
        merguez.setStatus(outOfStock);
        american.setStatus(available);
        fries.setStatus(available);
        potatoes.setStatus(available);
        saladSmall.setStatus(available);
        ketchup.setStatus(available);
        mayo.setStatus(available);
        mustard.setStatus(available);
        samourai.setStatus(available);
        curry.setStatus(outOfStock);
        coca.setStatus(available);
        cocaLight.setStatus(outOfStock);
        cocaZero.setStatus(available);
        perrier.setStatus(available);
        water.setStatus(available);
        orangina.setStatus(available);
        nestea.setStatus(available);
        coffee.setStatus(available);
        tea.setStatus(available);
        hotChocolate.setStatus(available);
        tiramisu.setStatus(available);
        chocolateMuffin.setStatus(available);
        blueberryMuffin.setStatus(available);
        
        // Product > NutritionFacts
        adana.setFacts(adanaFacts);
        kofte.setFacts(kofteFacts);
        chicken.setFacts(chickenFacts);
        merguez.setFacts(merguezFacts);
        american.setFacts(americanFacts);
        fries.setFacts(friesFacts);
        potatoes.setFacts(popatoesFacts);
        ketchup.setFacts(ketchupFacts);
        mayo.setFacts(mayoFacts);
        mustard.setFacts(mustardFacts);
        samourai.setFacts(samouraiFacts);
        curry.setFacts(curryFacts);
        coca.setFacts(cocaFacts);
        cocaLight.setFacts(cocaLightFacts);
        cocaZero.setFacts(cocaZeroFacts);
        orangina.setFacts(oranginaFacts);
        nestea.setFacts(nesteaFacts);
        hotChocolate.setFacts(hotChocolateFacts);
        tiramisu.setFacts(tiramisuFacts);
        chocolateMuffin.setFacts(chocolateMuffinFacts);
        blueberryMuffin.setFacts(blueberryMuffinFacts);
        
        // Category > Product
        coldDrinks.getProducts().add(coca);
        coldDrinks.getProducts().add(cocaLight);
        coldDrinks.getProducts().add(cocaZero);
        coldDrinks.getProducts().add(orangina);
        coldDrinks.getProducts().add(nestea);
        coldDrinks.getProducts().add(water);
        coldDrinks.getProducts().add(perrier);
        hotDrinks.getProducts().add(coffee);
        hotDrinks.getProducts().add(tea);
        hotDrinks.getProducts().add(hotChocolate);
        sandwiches.getProducts().add(adana);
        sandwiches.getProducts().add(kofte);
        sandwiches.getProducts().add(chicken);
        sandwiches.getProducts().add(merguez);
        sandwiches.getProducts().add(american);
        sides.getProducts().add(fries);
        sides.getProducts().add(potatoes);
        sides.getProducts().add(saladSmall);
        sauces.getProducts().add(ketchup);
        sauces.getProducts().add(mayo);
        sauces.getProducts().add(mustard);
        sauces.getProducts().add(samourai);
        sauces.getProducts().add(curry);
        menuDrinks.getProducts().add(coca);
        menuDrinks.getProducts().add(cocaLight);
        menuDrinks.getProducts().add(cocaZero);
        menuDrinks.getProducts().add(orangina);
        menuDrinks.getProducts().add(nestea);
        menuDrinks.getProducts().add(water);
        menuDrinks.getProducts().add(perrier);
        menuSandwiches.getProducts().add(adana);
        menuSandwiches.getProducts().add(kofte);
        menuSandwiches.getProducts().add(chicken);
        menuSandwiches.getProducts().add(merguez);
        menuSandwiches.getProducts().add(american);
        menuSides.getProducts().add(fries);
        menuSides.getProducts().add(potatoes);
        menuSides.getProducts().add(saladSmall);
        desserts.getProducts().add(tiramisu);
        desserts.getProducts().add(chocolateMuffin);
        desserts.getProducts().add(blueberryMuffin);
        
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
        
        em.persist(adana);
        em.persist(kofte);
        em.persist(chicken);
        em.persist(merguez);
        em.persist(american);
        em.persist(fries);
        em.persist(potatoes);
        em.persist(saladSmall);
        em.persist(ketchup);
        em.persist(mayo);
        em.persist(mustard);
        em.persist(samourai);
        em.persist(curry);
        em.persist(coca);
        em.persist(cocaLight);
        em.persist(cocaZero);
        em.persist(orangina);
        em.persist(nestea);
        em.persist(water);
        em.persist(perrier);
        em.persist(coffee);
        em.persist(tea);
        em.persist(hotChocolate);
        
        
    }

    
    
    
    
    
    
}
