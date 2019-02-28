
package dataCreation;

import Product.Allergen;
import Product.Category;
import Product.CategoryType;
import Product.Ingredient;
import Product.Labelling;
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
                + "Quoi ? Oui, c'est de la roquette", "/WEB-INF/Img/Ingredient/Ingredient/salade.jpg");
        Ingredient tomato = new Ingredient("Tomate", "Et une Roundup, une !", "/WEB-INF/Img/Ingredient/Ingredient/tomate.jpg");
        Ingredient bread = new Ingredient("Pain", "Pétri sous les aisselles", "/WEB-INF/Img/Ingredient/pain-kebab.jpg");
        Ingredient onion = new Ingredient("Oignon", "Il est carré mon oignon, il est carré !", 
                "/WEB-INF/Img/Ingredient/oignon.jpg");
        Ingredient beef = new Ingredient("Bœuf", "On l'a choyé du pis à l'abattoir", "/WEB-INF/Img/Ingredient/boeuf.jpg");
        Ingredient lamb = new Ingredient("Agneau", "Le bébé du canard", "/WEB-INF/Img/Ingredient/agneau.jpg");
        Ingredient chicken = new Ingredient("Poulet", "Run Chicken, run !", "/WEB-INF/Img/Ingredient/poulet.jpg");
        Ingredient merguez = new Ingredient("Merguez", "Comment ça elle est fluo ma guezmer ?", 
                "/WEB-INF/Img/Ingredient/merguez.jpg");
        Ingredient fries = new Ingredient("Frites", "Sauce blanche avec les frites ?", "/WEB-INF/Img/Ingredient/frites.jpg");
        Ingredient potatoes = new Ingredient("Potatoes", "Aussi grasses que les vraies", 
                "/WEB-INF/Img/Ingredient/potatoes.jpg");
        Ingredient cheese = new Ingredient("Fromage", "Du bon fromage végétal pour "
                + "les amoureux de la nature", "/WEB-INF/Img/Ingredient/fromage.jpg");
        Ingredient iceCubes = new Ingredient("Glaçons", "À la Neuf semaines et demi", "/WEB-INF/Img/Ingredient/Glaçons.jpg");
        Ingredient coke = new Ingredient("Cola", "Du diabète en boîte", "/WEB-INF/Img/Ingredient/cola.jpg");
        Ingredient dietCoke = new Ingredient("Cola", "De l'aspartame pour le pancréas",
                "/WEB-INF/Img/Ingredient/cola.jpg");
        Ingredient orangeSoda = new Ingredient("Soda à l'orange", "Du diabète en boîte",
                "/WEB-INF/Img/Ingredient/orangeSoda.jpg");
        Ingredient teaSoda = new Ingredient("Soda au thé", "Du diabète en boîte", "/WEB-INF/Img/Ingredient/tea.png");
        Ingredient carbWater = new Ingredient("Eau gazeuse", "C'est de l'eau qui pique",
                "/WEB-INF/Img/Ingredient/eauGazeuse.jpg");
        Ingredient stillWater = new Ingredient("Eau plate", "C'est de l'eau qui ne pique pas",
                "/WEB-INF/Img/Ingredient/eauPlate.jpg");
        Ingredient hotChocolate = new Ingredient("Chocolat chaud", "On dit pain au chocolat chaud"
                + " et pas chocolatine chaude", "/WEB-INF/Img/Ingredient/chocolatChaud.jpg");
        Ingredient coffee = new Ingredient("Café", "Fait avec amour par nos esclaves "
                + "de Java", "/WEB-INF/Img/Ingredient/coffee.jpg");
        Ingredient hotTea = new Ingredient("Thé", "Fait avec amour par nos esclaves "
                + "de Java", "/WEB-INF/Img/Ingredient/tea.jpg");
        Ingredient ketchup = new Ingredient("Ketchup", "Des tomates et du sucre", "/WEB-INF/Img/Ingredient/ketchup.png");
        Ingredient mayonnaise = new Ingredient("Mayonnaise", "De la bonne graisse industrielle",
                "/WEB-INF/Img/Ingredient/mayonnaise.jpg");
        Ingredient samuraiSauce = new Ingredient("Sauce samouraï", "Elle donne envie de se plonger "
                + "un sabre dans le ventre", "/WEB-INF/Img/Ingredient/samourai.jpg");
        Ingredient pitaBread = new Ingredient("Pain pita", "Comme il y a moins de pain, "
                + "ça coûte plus cher", "/WEB-INF/Img/Ingredient/pita.jpg");
        Ingredient harissa = new Ingredient("Harissa", "Dié-té-tique !", "/WEB-INF/Img/Ingredient/harissa.jpg");
        Ingredient sauceBlanche = new Ingredient("Sauce blanche", "Saviez-vous que le cornichon "
                + "est un bébé concombre ?", "/WEB-INF/Img/Ingredient/sauceBlanche.jpg");
        Ingredient baklava = new Ingredient("Baklava", "Dié-té-tique !", "/WEB-INF/Img/Ingredient/baklava.jpg");
        Ingredient chocolateIceCream = new Ingredient ("Glace au chocolat", 
                "Dié-té-tique", "/WEB-INF/Img/Ingredient/glaceChocolat.jpg");
        Ingredient vanillaIceCream = new Ingredient("Glace à la vanille", 
                "Dié-té-tique", "/WEB-INF/Img/Ingredient/vanilla.jpg");
        Ingredient tiramisu = new Ingredient("Tiramisu", "Dié-té-tique",
                "/WEB-INF/Img/Ingredient/tiramisu.jpg");
        Ingredient pickle = new Ingredient("Cornichon", "Le bébé du concombre !",
                "/WEB-INF/Img/Ingredient/cornichon.jpg");
        
        // Allergen
        
        Allergen gluten = new Allergen("Gluten");
        Allergen sesame = new Allergen("Graines de sésame");
        Allergen nut = new Allergen("Fruits à coque");
        Allergen sulphite = new Allergen("Sulfites");
        Allergen peanut = new Allergen("Arachide");
        Allergen celery = new Allergen("Céleri");
        Allergen shellfish = new Allergen("Crustacés et mollusques");
        Allergen milk = new Allergen("Lait");
        Allergen mustard = new Allergen("Moutarde");
        Allergen egg = new Allergen("Oeufs");
        Allergen fish = new Allergen("Poissons");
        Allergen soy = new Allergen("Soja");
        Allergen lupinus = new Allergen("Lupin");
        Allergen glutenOne = new Allergen("Gluten");
        Allergen glutenTwo = new Allergen("Gluten");
        Allergen glutenThree = new Allergen("Gluten");
        
        // Labelling
        
        Labelling defConOne = new Labelling("Possibilité de traces", 1);
        Labelling defConTwo = new Labelling("Contient des traces", 2);
        Labelling defConThree = new Labelling("Est présent dans le produit", 3);
        
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
            allerBread.add(glutenThree);
            allerBread.add(sesame);
            allerBread.add(soy); // possible traces
            allerBread.add(egg);
        Collection<Allergen> allerPitaBread = pitaBread.getAllergens();
            allerPitaBread.add(glutenThree);
            allerPitaBread.add(sesame);
            allerPitaBread.add(soy); // possible traces
            allerPitaBread.add(egg);
        Collection<Allergen> allerBeef = beef.getAllergens();
            allerBeef.add(glutenOne); // possible traces
            allerBeef.add(soy);
            allerBeef.add(egg); // possible traces
            allerBeef.add(milk);
        Collection<Allergen> allerLamb = lamb.getAllergens();
            allerLamb.add(glutenOne); // possible traces
            allerLamb.add(soy);
            allerLamb.add(egg); // possible traces
            allerLamb.add(milk);
        Collection<Allergen> allerChicken = chicken.getAllergens();
            allerChicken.add(glutenOne); // possible traces
            allerChicken.add(soy);
            allerChicken.add(egg); // possible traces
            allerChicken.add(milk);
        Collection<Allergen> allerMerguez = merguez.getAllergens();
            allerMerguez.add(glutenOne); // possible traces
            allerMerguez.add(soy);
            allerMerguez.add(egg); // possible traces
            allerMerguez.add(milk);
        Collection<Allergen> allerFries = fries.getAllergens();
            allerFries.add(sulphite);
            allerFries.add(glutenThree);
            allerFries.add(soy); // possible traces
        Collection<Allergen> allerPotatoes = potatoes.getAllergens();
            allerPotatoes.add(sulphite);
            allerPotatoes.add(glutenThree);
            allerPotatoes.add(soy); // possible traces
        Collection<Allergen> allerCheese = cheese.getAllergens();
            allerCheese.add(milk);
            allerCheese.add(soy);
            allerCheese.add(egg);
        Collection<Allergen> allerChoco = hotChocolate.getAllergens();
            allerChoco.add(milk);
            allerChoco.add(lupinus);
        Collection<Allergen> allerKetchup = ketchup.getAllergens();
            allerKetchup.add(sulphite);
            allerKetchup.add(milk);
        Collection<Allergen> allerMayonnaise = mayonnaise.getAllergens();
            allerMayonnaise.add(sulphite);
            allerMayonnaise.add(milk);
            allerMayonnaise.add(mustard);
            allerMayonnaise.add(egg);
        Collection<Allergen> allerSamurai = samuraiSauce.getAllergens();
            allerSamurai.add(sulphite);
            allerSamurai.add(milk);
            allerSamurai.add(mustard);
            allerSamurai.add(egg);
        Collection<Allergen> allerSauceBlanche = sauceBlanche.getAllergens();
            allerSauceBlanche.add(sulphite);
            allerSauceBlanche.add(milk);
        Collection<Allergen> allerBaklava = baklava.getAllergens();
            allerBaklava.add(sulphite);
            allerBaklava.add(glutenTwo);
            allerBaklava.add(nut);
            allerBaklava.add(lupinus);
            allerBaklava.add(egg);
        Collection<Allergen> allerChocoIce = chocolateIceCream.getAllergens();
            allerChocoIce.add(milk);
            allerChocoIce.add(egg);
            allerChocoIce.add(glutenOne);
            allerChocoIce.add(nut);
            allerChocoIce.add(lupinus);
        Collection<Allergen> allerVanillaIce = vanillaIceCream.getAllergens();
            allerVanillaIce.add(milk);
            allerVanillaIce.add(egg);
            allerVanillaIce.add(glutenOne);
            allerVanillaIce.add(nut);
            allerVanillaIce.add(lupinus);
        Collection<Allergen> allerTiramisu = tiramisu.getAllergens();
            allerTiramisu.add(milk);
            allerTiramisu.add(egg);
            allerTiramisu.add(sulphite);
            allerTiramisu.add(glutenTwo);
            allerTiramisu.add(soy);
            allerTiramisu.add(nut);
        Collection<Allergen> allerPickle = pickle.getAllergens();
            allerPickle.add(mustard);
            allerPickle.add(sulphite);
            
        Collection<Labelling> labelGluten = gluten.getLabellings();
            labelGluten.add(defConThree);
            labelGluten.add(defConTwo);
            labelGluten.add(defConOne);
        Collection<Labelling> labelSulphite = sulphite.getLabellings();
            labelSulphite.add(defConTwo);
        Collection<Labelling> labelSesame = sesame.getLabellings();
            labelSesame.add(defConThree);
        Collection<Labelling> labelNut = nut.getLabellings();
            labelNut.add(defConThree);
        Collection<Labelling> labelPeanut = peanut.getLabellings();
            labelPeanut.add(defConThree);
        Collection<Labelling> labelCelery = celery.getLabellings();
            labelCelery.add(defConOne);
        Collection<Labelling> labelShellfish = shellfish.getLabellings();
            labelShellfish.add(defConOne);
        Collection<Labelling> labelMilk = milk.getLabellings();
            labelShellfish.add(defConThree);
        Collection<Labelling> labelMustard = mustard.getLabellings();
            labelMustard.add(defConTwo);
        Collection<Labelling> labelEgg = egg.getLabellings();
            labelEgg.add(defConThree);
        Collection<Labelling> labelFish = fish.getLabellings();
            labelEgg.add(defConOne);
        Collection<Labelling> labelLupinus = lupinus.getLabellings();
            labelLupinus.add(defConTwo);
        Collection<Labelling> labelSoy = soy.getLabellings();
            labelSoy.add(defConTwo);
        Collection<Labelling> labelGlutenOne = glutenOne.getLabellings();
            labelGlutenOne.add(defConOne);
        Collection<Labelling> labelGlutenTwo = glutenTwo.getLabellings();
            labelGlutenTwo.add(defConTwo);
        Collection<Labelling> labelGlutenThree = glutenThree.getLabellings();
            labelGlutenThree.add(defConThree);
        
            
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
        em.persist(sulphite);
        em.persist(peanut);
        em.persist(celery);
        em.persist(shellfish);
        em.persist(milk);
        em.persist(mustard);
        em.persist(egg);
        em.persist(fish);
        em.persist(soy);
        em.persist(lupinus);
        em.persist(glutenOne);
        em.persist(glutenTwo);
        em.persist(glutenThree);
        
        // Labelling
        
        em.persist(defConOne);
        em.persist(defConTwo);
        em.persist(defConThree);
        
        em.flush();
        
    }

    
    
    
    
    
    
}
