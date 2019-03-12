package dataCreation;

import Account.Account;
import Account.AccountStatus;
import company.CashRegister;
import company.Kiosk;
import company.Restaurant;
import Product.Allergen;
import Product.Category;
import Product.CategoryType;
import java.util.ArrayList;
import java.util.Date;
import Product.Ingredient;
import Product.Labelling;
import java.util.Collection;
import Product.Menu;
import Product.MenuItem;
import Product.NutritionFacts;
import Product.Offer;
import Product.Optional;
import Product.Product;
import Product.ProductStatus;
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
         ****************** INSTANCIATION OF OBJECTS ******************
         */
        // CategoryType
        CategoryType typeCarte = new CategoryType("A la carte");
        CategoryType typeMenus = new CategoryType("Menus");
        CategoryType typeSandwichMenus = new CategoryType("SandwichMenus");

        // Category
        Category coldDrinks = new Category("Boissons Fraîches", "Désaltérez-vous avec nos boissons rafraichissantes", "Img/Categories/coldDrinks.jpg", 4);
        Category hotDrinks = new Category("Boissons Chaudes", "Pour bien finir le repas", "Img/Categories/hotDrinks.jpg", 6);
        Category sandwiches = new Category("Sandwichs", "Tous nos sandwichs à la carte et personnalisables", "Img/Categories/sandwiches.png", 2);
        Category sides = new Category("Accompagnements", "Pour les petites faims", "Img/Categories/sides.jpg", 3);
        Category desserts = new Category("Desserts", "Pour tous les gourmands", "Img/Categories/desserts.jpg", 5);
        Category sauces = new Category("Sauce", "Pour rajouter un peu de pep's à vos plats", "Img/Categories/sauces.png", 7);
        Category menuDrinks = new Category("Boissons du Menu", "Désaltérez-vous avec nos boissons rafraichissantes", "Img/Categories/coldDrinks.jpg");
        Category menuSandwiches = new Category("Sandwichs du Menu", "Le plat de résistance", "Img/Categories/sandwiches.png");
        Category menuSides = new Category("Accompagnements du Menu", "Au choix", "Img/Categories/sides.jpg");
        Category menuAdanaCat = new Category("Sandwich Menu Adana", "", "");
        Category menuKofteCat = new Category("Sandwich Menu Kofte", "", "");
        Category menuChickenCat = new Category("Sandwich Menu Chicken", "", "");
        Category menuMerguezCat = new Category("Sandwich Menu Merguez", "", "");
        Category menuAmericanCat = new Category("Sandwich Menu Americain", "", "");
        Category menus = new Category("Menus", "Composez votre menu", "Img/Categories/menus.jpg", 1);
        Category offers = new Category("Offres", "Nos offres du moment", "Img/Categories/offres.png", 8);

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
        Product adana = new Product("Adana Kebab", "Img/Products/adana.jpg", 5, "Plat issu de la cuisine turque qui vient de la ville d'Adana, plus épicé que le kebab standard");
        Product kofte = new Product("Kofte Kebab", "Img/Products/kofte.jpg", 5, "Boulette de viande hachée aux épices. C'est la préparation la plus cuisinée en Turquie.");
        Product chickenSandwich = new Product("Chicken Kebab", "Img/Products/chicken.jpg", 5, "Le traditionnel kebab en version poulet");
        Product merguezSandwich = new Product("Merguez Kebab", "Img/Products/merguez.jpg", 5, "Le traditionnel kebab en version merguez");
        Product american = new Product("American Kebab", "Img/Products/american.png", 5.5f, "Le traditionnel kebab en version steak haché");

        Product friesPack = new Product("Frites", "Img/Products/fries.jpg", 2.5f, "Délicieuses et croustillantes");
        Product potatoesPack = new Product("Potatoes", "Img/Products/potatoes.png", 2.5f, "Savoureuses et croustillantes");
        Product saladSmall = new Product("Petite Salade", "Img/Products/salad.jpg", 2.0f, "Un instant frais et léger");

        Product ketchupPack = new Product("Ketchup", "Img/Products/ketchup.jpg", 0.5f, "Aux bonnes tomates gouteuses");
        Product mayo = new Product("Mayo", "Img/Products/mayo.jpg", 0.5f, "Aux oeufs frais");
        Product mustardPack = new Product("Moutarde", "Img/Products/mustard.jpg", 0.5f, "De Dijon");
        Product samourai = new Product("Samouraï", "Img/Products/samourai.jpg", 0.5f, "Epicée");
        Product curry = new Product("Curry", "Img/Products/curry.png", 0.5f, "Saveur des indes");

        Product coca = new Product("Cocal-Cola", "Img/Products/coca.jpg", 2f, "Always Coca-Cola");
        Product cocaLight = new Product("Cocal-Cola Light", "Img/Products/cocaLight.png", 2f, "Always Coca-Cola");
        Product cocaZero = new Product("Cocal-Cola Zero", "Img/Products/cocaZero.jpg", 2f, "Always Coca-Cola");
        Product perrier = new Product("Perrier", "Img/Products/perrier.png", 2f, "Des bulles désaltérantes");
        Product water = new Product("Cristaline", "Img/Products/cristaline.jpg", 1.5f, "A la Cliarefontaine, j'ai bu l'eau Cristaline");
        Product orangina = new Product("Orangina", "Img/Products/orangina.jpg", 2f, "Bien secouer !");
        Product nestea = new Product("Nestea", "Img/Products/nestea.png", 2f, "Goût pêche");
        Product coffeePack = new Product("Café", "Img/Products/coffee.jpg", 1.5f, "Wake up !");
        Product tea = new Product("Thé", "Img/Products/tea.png", 1.5f, "English breakfast");
        Product hotChocolatePack = new Product("Chocolat Chaud", "Img/Products/hotChocolate.png", 2f, "Au lait chaud");

        Product tiramisuPack = new Product("Tiramisu", "Img/Products/tiramisu.jpg", 4.5f, "Un savoureux mélange café/chocolat");
        Product iceCreamChocolate = new Product("Glace Chocolat", "Img/Products/chocolateMuffin.jpg", 4, "Chocotastic !");
        Product iceCreamVanilla = new Product("Glace Vanille", "Img/Products/blueberryMuffin.jpg", 4, "Yummay");

        // Menu
        Menu menuAdana = new Menu("Menu Adana", "", "Img/Menus/menu.jpg", 7.0f);
        Menu menuKofte = new Menu("Menu Kofte", "", "Img/Menus/menu.jpg", 7.0f);
        Menu menuChicken = new Menu("Menu Chicken", "", "Img/Menus/menu.jpg", 7.0f);
        Menu menuMerguez = new Menu("Menu Merguez", "", "Img/Menus/menu.jpg", 7.0f);
        Menu menuAmerican = new Menu("Menu American", "", "Img/Menus/menu.jpg", 7.5f);

        // MenuItem
        MenuItem menuSandwich01 = new MenuItem();
        MenuItem menuDrink01 = new MenuItem();
        MenuItem menuSide01 = new MenuItem();
        menuSandwich01.setProduct(kofte);
        menuDrink01.setProduct(coca);
        menuSide01.setProduct(friesPack);
        
        // VAT 
        VAT normale = new VAT(10, "TVA normale");
        VAT reduite = new VAT(5.5f, "TVA réduite");

        // Location
        Location resto = new Location("sur place");
        Location takeAway = new Location("à emporter");

        //restaurant
        Restaurant restaurant = new Restaurant("borne2Alive", "17 rue CDG Paris 75012", "0185252525", "123456789", "1234567890123", "borne2Alive@gmail.com");

        //cashRegister
        CashRegister cr01 = new CashRegister("Comptoir 1", "toto24");
        CashRegister cr02 = new CashRegister("Comptoir 2", "toto23");

        //kiosk
        Kiosk kiosk01 = new Kiosk("Kiosk 01", "kv01");
        Kiosk kiosk02 = new Kiosk("Kiosk 02", "kv02");
                
        //Account
        Account acc01 = new Account("toto@gmail.com", "dassauld", "toto", "toto1234",
                "0690123456", new GregorianCalendar(2018, 02, 28).getTime(), new GregorianCalendar(1985, 03, 24).getTime(),
                "H", "25 rue jean 94400 Vitry");

        //AccountStatus
        AccountStatus actif = new AccountStatus("actif");

        //Payment type        
        PaymentType cb = new PaymentType("carte bancaire");
        PaymentType esp = new PaymentType("espèces");
        PaymentType tresto = new PaymentType("ticket restaurant");

        //Order status        
        OrderStatus os01 = new OrderStatus("en cours de préparation");
        OrderStatus os02 = new OrderStatus("en attente de règlement");
        OrderStatus os03 = new OrderStatus("payée");
        OrderStatus os04 = new OrderStatus("prête");
        OrderStatus os05 = new OrderStatus("retirée");

        // OrderInfo       
        Date d01 = new GregorianCalendar(2019, 02, 21).getTime();
        Date d02 = new GregorianCalendar(2019, 02, 22).getTime();
        Date d03 = new GregorianCalendar(2019, 02, 23).getTime();
        Date d04 = new GregorianCalendar(2019, 02, 24).getTime();
        Date d05 = new GregorianCalendar(2019, 02, 25).getTime();

        OrderInfo o01 = new OrderInfo("CB21", d01, 10f);
        OrderInfo o02 = new OrderInfo("CB22", d01, 5.5f);
        OrderInfo o03 = new OrderInfo("CB24", d01, 5.5f);
        OrderInfo o04 = new OrderInfo("ESP49", d01, 10f);
        OrderInfo o05 = new OrderInfo("ESP30", d01, 10f);

        // Line        
        Line l01 = new Line(0.2f, 1, 7, 0);
        Line l05 = new Line(0, 1, 4.5f, 0);
        Line l06 = new Line(0, 1, 2, 0);
        Line l07 = new Line(0, 1, 2.5f, 0);
        Line l08 = new Line(0, 1, 5.5f, 20);
        Line l09 = new Line(0, 1, 4, 0);
        Line l10 = new Line(0, 1, 2.5f, 0);
        Line l11 = new Line(0, 2, 0.5f, 0);

        // Ingredient
        Ingredient salade = new Ingredient("Salade", "Et une salade Gaza pour la gazelle ? "
                + "Quoi ? Oui, c'est de la roquette", "Img/Ingredient/salade.jpg");
        Ingredient mixedSalad = new Ingredient("Salade mélangée", "En accompagnement", "Img/Ingredient/salade.jpg");
        Ingredient tomato = new Ingredient("Tomate", "Et une Roundup, une !", "Img/Ingredient/tomate.jpg");
        Ingredient bread = new Ingredient("Pain", "Pétri sous les aisselles", "Img/Ingredient/pain-kebab.jpg");
        Ingredient onion = new Ingredient("Oignon", "Il est carré mon oignon, il est carré !",
                "Img/Ingredient/oignon.jpg");
        Ingredient beef = new Ingredient("Bœuf", "On l'a choyé du pis à l'abattoir", "Img/Ingredient/boeuf.jpg");
        Ingredient lamb = new Ingredient("Agneau", "Le bébé du canard", "Img/Ingredient/agneau.jpg");
        Ingredient chicken = new Ingredient("Poulet", "Run Chicken, run !", "Img/Ingredient/poulet.jpg");
        Ingredient merguez = new Ingredient("Merguez", "Comment ça elle est fluo ma guezmer ?",
                "Img/Ingredient/merguez.jpg");
        Ingredient fries = new Ingredient("Frites", "Sauce blanche avec les frites ?", "Img/Ingredient/frites.jpg");
        Ingredient potatoes = new Ingredient("Potatoes", "Aussi grasses que les vraies",
                "Img/Ingredient/potatoes.jpg");
        Ingredient cheese = new Ingredient("Fromage", "Du bon fromage végétal pour "
                + "les amoureux de la nature", "Img/Ingredient/fromage.jpg");
        Ingredient iceCubes = new Ingredient("Glaçons", "À la Neuf semaines et demi", "Img/Ingredient/Glaçons.jpg");
        Ingredient coke = new Ingredient("Cola", "Du diabète en boîte", "Img/Ingredient/cola.jpg");
        Ingredient dietCoke = new Ingredient("Cola light", "De l'aspartame pour le pancréas",
                "Img/Ingredient/cola.jpg");
        Ingredient cokeZero = new Ingredient("Cola zero", "Le goût original, sans sucre",
                "Img/Ingredient/cola.jpg");
        Ingredient orangeSoda = new Ingredient("Soda à l'orange", "Du diabète en boîte",
                "Img/Ingredient/orangeSoda.jpg");
        Ingredient teaSoda = new Ingredient("Soda au thé", "Du diabète en boîte", "Img/Ingredient/tea.png");
        Ingredient carbWater = new Ingredient("Eau gazeuse", "C'est de l'eau qui pique",
                "Img/Ingredient/eauGazeuse.jpg");
        Ingredient stillWater = new Ingredient("Eau plate", "C'est de l'eau qui ne pique pas",
                "Img/Ingredient/eauPlate.jpg");
        Ingredient hotChocolate = new Ingredient("Chocolat chaud", "On dit pain au chocolat chaud"
                + " et pas chocolatine chaude", "Img/Ingredient/chocolatChaud.jpg");
        Ingredient coffee = new Ingredient("Café", "Fait avec amour par nos esclaves "
                + "de Java", "Img/Ingredient/coffee.jpg");
        Ingredient hotTea = new Ingredient("Thé", "Fait avec amour par nos esclaves "
                + "de Java", "Img/Ingredient/tea.jpg");
        Ingredient ketchup = new Ingredient("Ketchup", "Des tomates et du sucre", "Img/Ingredient/ketchup.png");
        Ingredient mayonnaise = new Ingredient("Mayonnaise", "De la bonne graisse industrielle",
                "Img/Ingredient/mayonnaise.jpg");
        Ingredient samuraiSauce = new Ingredient("Sauce samouraï", "Elle donne envie de se plonger "
                + "un sabre dans le ventre", "Img/Ingredient/samourai.jpg");
        Ingredient pitaBread = new Ingredient("Pain pita", "Comme il y a moins de pain, "
                + "ça coûte plus cher", "Img/Ingredient/pita.jpg");
        Ingredient harissa = new Ingredient("Harissa", "Dié-té-tique !", "Img/Ingredient/harissa.jpg");
        Ingredient sauceBlanche = new Ingredient("Sauce blanche", "Saviez-vous que le cornichon "
                + "est un bébé concombre ?", "Img/Ingredient/sauceBlanche.jpg");
        Ingredient baklava = new Ingredient("Baklava", "Dié-té-tique !", "Img/Ingredient/baklava.jpg");
        Ingredient chocolateIceCream = new Ingredient("Glace au chocolat",
                "Dié-té-tique", "Img/Ingredient/glaceChocolat.jpg");
        Ingredient vanillaIceCream = new Ingredient("Glace à la vanille",
                "Dié-té-tique", "Img/Ingredient/vanilla.jpg");
        Ingredient tiramisu = new Ingredient("Tiramisu", "Dié-té-tique",
                "Img/Ingredient/tiramisu.jpg");
        Ingredient pickle = new Ingredient("Cornichon", "Le bébé du concombre !",
                "Img/Ingredient/cornichon.jpg");

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

        // Offer
        Offer bestSellers = new Offer("Meilleures Ventes", "Une sélection de vos produits préférés", new GregorianCalendar(2019, 01, 26).getTime(), null, 0, "/WEB-INF/Img/Offers/meilleuresVentes.jpg");
        Offer promo = new Offer("Promo du jour", "La promo du jour", new GregorianCalendar(2019, 01, 26).getTime(), null, 20, null);
                
                
        // Optional
        Optional noIce = new Optional("Sans glaçons", 1, 0);
        Optional extraPickles = new Optional("Extra Cornichons", 3, 0.2f);
        Optional noSalad = new Optional("Sans Salade", 1, 0);
        Optional noTomato = new Optional("Sans Tomate", 1, 0);
        Optional noOnion = new Optional("Sans Oignons", 1, 0);
        Optional mediumFries = new Optional("Taille M", 1, 0.00f);
        Optional largeFries = new Optional("Taille L", 1, 0.80f);
        Optional xLargeFries = new Optional("Taille XL", 1, 1.50f);
        Optional mediumPotatoes = new Optional("Taille M", 1, 0.00f);
        Optional largePotatoes = new Optional("Taille L", 1, 0.80f);
        Optional xLargePotatoes = new Optional("Taille XL", 1, 1.50f);
        Optional mediumSalad = new Optional("Taille M", 1, 0.00f);
        Optional largeSalad = new Optional("Taille L", 1, 0.80f);
        Optional xLargeSalad = new Optional("Taille XL", 1, 1.50f);
        Optional mediumCoke = new Optional("Taille M", 1, 0.00f);
        Optional largeCoke = new Optional("Taille L", 1, 0.70f);
        Optional xLargeCoke = new Optional("Taille XL", 1, 1.20f);
        Optional mediumDietCoke = new Optional("Taille M", 1, 0.00f);
        Optional largeDietCoke = new Optional("Taille L", 1, 0.70f);
        Optional xLargeDietCoke = new Optional("Taille XL", 1, 1.20f);
        Optional mediumCokeZero = new Optional("Taille M", 1, 0.00f);
        Optional largeCokeZero = new Optional("Taille L", 1, 0.70f);
        Optional xLargeCokeZero = new Optional("Taille XL", 1, 1.20f);
        Optional mediumOrangina = new Optional("Taille M", 1, 0.00f);
        Optional largeOrangina = new Optional("Taille L", 1, 0.70f);
        Optional xLargeOrangina = new Optional("Taille XL", 1, 1.20f);
        Optional mediumPerrier = new Optional("Taille M", 1, 0.00f);
        Optional largePerrier = new Optional("Taille L", 1, 0.70f);
        Optional xLargePerrier = new Optional("Taille XL", 1, 1.20f);
        Optional mediumWater = new Optional("Taille M", 1, 0.00f);
        Optional largeWater = new Optional("Taille L", 1, 0.70f);
        Optional xLargeWater = new Optional("Taille XL", 1, 1.20f);
        Optional mediumNestea = new Optional("Taille M", 1, 0.00f);
        Optional largeNestea = new Optional("Taille L", 1, 0.70f);
        Optional xLargeNestea = new Optional("Taille XL", 1, 1.20f);
        
        
        /*
         ****************** ASSOCIATIONS ******************
         */
        
        // Option > ingredient
        noIce.setIngredient(iceCubes);
        extraPickles.setIngredient(pickle);
        noSalad.setIngredient(salade);
        noTomato.setIngredient(tomato);
        noOnion.setIngredient(onion);
        mediumFries.setIngredient(fries);
        largeFries.setIngredient(fries);
        xLargeFries.setIngredient(fries);
        mediumPotatoes.setIngredient(potatoes);
        largePotatoes.setIngredient(potatoes);
        xLargePotatoes.setIngredient(potatoes);
        mediumSalad.setIngredient(mixedSalad);
        largeSalad.setIngredient(mixedSalad);
        xLargeSalad.setIngredient(mixedSalad);
       
        mediumCoke.setIngredient(coke);
        mediumDietCoke.setIngredient(dietCoke);
        mediumCokeZero.setIngredient(cokeZero);
        mediumPerrier.setIngredient(carbWater);
        mediumNestea.setIngredient(teaSoda);
        mediumOrangina.setIngredient(orangeSoda);
        mediumWater.setIngredient(stillWater);
        largeCoke.setIngredient(coke);
        largeDietCoke.setIngredient(dietCoke);
        largeCokeZero.setIngredient(cokeZero);
        largeOrangina.setIngredient(orangeSoda);
        largePerrier.setIngredient(carbWater);
        largeNestea.setIngredient(teaSoda);
        largeWater.setIngredient(stillWater);
        xLargeCoke.setIngredient(coke);
        xLargeDietCoke.setIngredient(dietCoke);
        xLargeCokeZero.setIngredient(cokeZero);
        xLargeOrangina.setIngredient(orangeSoda);
        xLargePerrier.setIngredient(carbWater);
        xLargeNestea.setIngredient(teaSoda);
        xLargeWater.setIngredient(stillWater);
        
        
        // Account > Status
        acc01.setStatus(actif);

        // CashRegister > Restaurant
        cr01.setRestaurant(restaurant);
        cr02.setRestaurant(restaurant);

        // Kiosk > Restaurant
        kiosk01.setRestaurant(restaurant);
        kiosk02.setRestaurant(restaurant);

        // Category > CategoryType
        coldDrinks.setType(typeCarte);
        hotDrinks.setType(typeCarte);
        sandwiches.setType(typeCarte);
        sides.setType(typeCarte);
        desserts.setType(typeCarte);
        sauces.setType(typeCarte);
        menuDrinks.setType(typeMenus);
        menuSides.setType(typeMenus);
        menuAdanaCat.setType(typeSandwichMenus);
        menuChickenCat.setType(typeSandwichMenus);
        menuKofteCat.setType(typeSandwichMenus);
        menuMerguezCat.setType(typeSandwichMenus);
        menuAmericanCat.setType(typeSandwichMenus);
        menus.setType(typeCarte);
        offers.setType(typeCarte);

        // Location > VAT
        resto.setAppliedVAT(normale);
        takeAway.setAppliedVAT(reduite);

        // Order > Location
        o01.setPlace(resto);
        o02.setPlace(takeAway);
        o03.setPlace(takeAway);
        o04.setPlace(resto);
        o05.setPlace(resto);

        // Order > Payment type
        ArrayList<PaymentType> p01 = new ArrayList();
        p01.add(cb);

        ArrayList<PaymentType> p02 = new ArrayList();
        p02.add(cb);
        p02.add(esp);
        p02.add(tresto);

        o01.setPaymentList(p01);
        o02.setPaymentList(p01);
        o03.setPaymentList(p01);
        o04.setPaymentList(p01);
        o05.setPaymentList(p02);

        // Order > Status
        o01.setStatus(os01);
        o02.setStatus(os02);
        o03.setStatus(os03);
        o04.setStatus(os04);
        o05.setStatus(os05);

        // Line > Order        
        l01.setSelectedOrder(o01);
        l05.setSelectedOrder(o02);
        l06.setSelectedOrder(o03);
        l07.setSelectedOrder(o03);
        l08.setSelectedOrder(o04);
        l09.setSelectedOrder(o04);
        l10.setSelectedOrder(o05);
        l11.setSelectedOrder(o05);
        

        // Order > Account
        
        o01.setAccountSelected(acc01);
        o02.setAccountSelected(acc01);
        
        // Order > Kiosk
        
        o01.setKiosk(kiosk01);
        o02.setKiosk(kiosk01);
        o03.setKiosk(kiosk02);
        o04.setKiosk(kiosk02);
        
        // Order > CashRegister
        o05.setCashier(cr02);
                

        // Line > Product
        l01.setMenu(menuKofte);
        l01.getMenuItems().add(menuSandwich01);
        l01.getMenuItems().add(menuDrink01);
        l01.getMenuItems().add(menuSide01);
        l05.setProduct(tiramisuPack);
        l06.setProduct(orangina);
        l07.setProduct(potatoesPack);
        l08.setProduct(american);
        l09.setProduct(iceCreamVanilla);
        l10.setProduct(friesPack);
        l11.setProduct(samourai);

        // Line > Option
        l06.getOptionList().add(noIce);
        l01.getOptionList().add(extraPickles);
        

        // Labelling > Allergen
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

        // Product > ProductStatus
        adana.setStatus(available);
        kofte.setStatus(available);
        chickenSandwich.setStatus(available);
        merguezSandwich.setStatus(outOfStock);
        american.setStatus(available);
        friesPack.setStatus(available);
        potatoesPack.setStatus(available);
        saladSmall.setStatus(available);
        ketchupPack.setStatus(available);
        mayo.setStatus(available);
        mustardPack.setStatus(available);
        samourai.setStatus(available);
        curry.setStatus(delisted);
        coca.setStatus(available);
        cocaLight.setStatus(outOfStock);
        cocaZero.setStatus(available);
        perrier.setStatus(available);
        water.setStatus(available);
        orangina.setStatus(available);
        nestea.setStatus(available);
        coffeePack.setStatus(available);
        tea.setStatus(available);
        hotChocolatePack.setStatus(available);
        tiramisuPack.setStatus(available);
        iceCreamChocolate.setStatus(available);
        iceCreamVanilla.setStatus(available);

        // Product > NutritionFacts
        adana.setFacts(adanaFacts);
        kofte.setFacts(kofteFacts);
        chickenSandwich.setFacts(chickenFacts);
        merguezSandwich.setFacts(merguezFacts);
        american.setFacts(americanFacts);
        friesPack.setFacts(friesFacts);
        potatoesPack.setFacts(popatoesFacts);
        ketchupPack.setFacts(ketchupFacts);
        mayo.setFacts(mayoFacts);
        mustardPack.setFacts(mustardFacts);
        samourai.setFacts(samouraiFacts);
        curry.setFacts(curryFacts);
        coca.setFacts(cocaFacts);
        cocaLight.setFacts(cocaLightFacts);
        cocaZero.setFacts(cocaZeroFacts);
        orangina.setFacts(oranginaFacts);
        nestea.setFacts(nesteaFacts);
        hotChocolatePack.setFacts(hotChocolateFacts);
        tiramisuPack.setFacts(tiramisuFacts);
        iceCreamChocolate.setFacts(chocolateMuffinFacts);
        iceCreamVanilla.setFacts(blueberryMuffinFacts);
        
        // Product > Ingredient
        adana.getIngredients().add(beef);
        adana.getIngredients().add(salade);
        adana.getIngredients().add(tomato);
        adana.getIngredients().add(onion);
        adana.getIngredients().add(bread);
        adana.getIngredients().add(pickle);
        
        kofte.getIngredients().add(lamb);
        kofte.getIngredients().add(salade);
        kofte.getIngredients().add(tomato);
        kofte.getIngredients().add(onion);
        kofte.getIngredients().add(bread);
        kofte.getIngredients().add(pickle);
        
        chickenSandwich.getIngredients().add(chicken);
        chickenSandwich.getIngredients().add(salade);
        chickenSandwich.getIngredients().add(tomato);
        chickenSandwich.getIngredients().add(onion);
        chickenSandwich.getIngredients().add(bread);
        chickenSandwich.getIngredients().add(pickle);
        
        merguezSandwich.getIngredients().add(merguez);
        merguezSandwich.getIngredients().add(salade);
        merguezSandwich.getIngredients().add(tomato);
        merguezSandwich.getIngredients().add(onion);
        merguezSandwich.getIngredients().add(bread);
        merguezSandwich.getIngredients().add(pickle);
        
        american.getIngredients().add(beef);
        american.getIngredients().add(salade);
        american.getIngredients().add(tomato);
        american.getIngredients().add(onion);
        american.getIngredients().add(bread);
        american.getIngredients().add(pickle);
        
        friesPack.getIngredients().add(fries);
        potatoesPack.getIngredients().add(potatoes);
        saladSmall.getIngredients().add(mixedSalad);

        coca.getIngredients().add(coke);
        coca.getIngredients().add(iceCubes);
        cocaLight.getIngredients().add(dietCoke);
        cocaLight.getIngredients().add(iceCubes);
        cocaZero.getIngredients().add(cokeZero);
        cocaZero.getIngredients().add(iceCubes);
        orangina.getIngredients().add(orangeSoda);
        orangina.getIngredients().add(iceCubes);
        perrier.getIngredients().add(carbWater);
        perrier.getIngredients().add(iceCubes);
        water.getIngredients().add(stillWater);
        water.getIngredients().add(iceCubes);
        nestea.getIngredients().add(teaSoda);
        nestea.getIngredients().add(iceCubes);
        
        tiramisuPack.getIngredients().add(tiramisu);
        iceCreamChocolate.getIngredients().add(chocolateIceCream);
        iceCreamVanilla.getIngredients().add(vanillaIceCream);
        
        // MenuItem > Ingredient
        menuSandwich01.setIngredients(menuSandwich01.getProduct().getIngredients());
        menuDrink01.setIngredients(menuDrink01.getProduct().getIngredients());
        menuSide01.setIngredients(menuSide01.getProduct().getIngredients());
        
        // Category > Product
        coldDrinks.getProducts().add(coca);
        coldDrinks.getProducts().add(cocaLight);
        coldDrinks.getProducts().add(cocaZero);
        coldDrinks.getProducts().add(orangina);
        coldDrinks.getProducts().add(nestea);
        coldDrinks.getProducts().add(water);
        coldDrinks.getProducts().add(perrier);
        hotDrinks.getProducts().add(coffeePack);
        hotDrinks.getProducts().add(tea);
        hotDrinks.getProducts().add(hotChocolatePack);
        sandwiches.getProducts().add(adana);
        sandwiches.getProducts().add(kofte);
        sandwiches.getProducts().add(chickenSandwich);
        sandwiches.getProducts().add(merguezSandwich);
        sandwiches.getProducts().add(american);
        sides.getProducts().add(friesPack);
        sides.getProducts().add(potatoesPack);
        sides.getProducts().add(saladSmall);
        sauces.getProducts().add(ketchupPack);
        sauces.getProducts().add(mayo);
        sauces.getProducts().add(mustardPack);
        sauces.getProducts().add(samourai);
        sauces.getProducts().add(curry);
        menuDrinks.getProducts().add(coca);
        menuDrinks.getProducts().add(cocaLight);
        menuDrinks.getProducts().add(cocaZero);
        menuDrinks.getProducts().add(orangina);
        menuDrinks.getProducts().add(nestea);
        menuDrinks.getProducts().add(water);
        menuDrinks.getProducts().add(perrier);
        menuSides.getProducts().add(friesPack);
        menuSides.getProducts().add(potatoesPack);
        menuSides.getProducts().add(saladSmall);
        desserts.getProducts().add(tiramisuPack);
        desserts.getProducts().add(iceCreamChocolate);
        desserts.getProducts().add(iceCreamVanilla);
        menuAdanaCat.getProducts().add(adana);
        menuKofteCat.getProducts().add(kofte);
        menuChickenCat.getProducts().add(chickenSandwich);
        menuMerguezCat.getProducts().add(merguezSandwich);
        menuAmericanCat.getProducts().add(american);

        // Product > Offer
        kofte.getOffers().add(bestSellers);
        friesPack.getOffers().add(bestSellers);
        coca.getOffers().add(bestSellers);
        iceCreamChocolate.getOffers().add(bestSellers);
        chickenSandwich.getOffers().add(bestSellers);
        american.getOffers().add(bestSellers);
        american.getOffers().add(promo);

        // Menu > Category
        menuAdana.getCategories().add(menuDrinks);
        menuAdana.getCategories().add(menuSides);
        menuAdana.getCategories().add(menuAdanaCat);
        menuKofte.getCategories().add(menuDrinks);
        menuKofte.getCategories().add(menuSides);
        menuKofte.getCategories().add(menuKofteCat);
        menuChicken.getCategories().add(menuDrinks);
        menuChicken.getCategories().add(menuSides);
        menuChicken.getCategories().add(menuChickenCat);
        menuMerguez.getCategories().add(menuDrinks);
        menuMerguez.getCategories().add(menuSides);
        menuMerguez.getCategories().add(menuMerguezCat);
        menuAmerican.getCategories().add(menuDrinks);
        menuAmerican.getCategories().add(menuSides);
        menuAmerican.getCategories().add(menuAmericanCat);

        /*
         ****************** PERSISTS ******************
         */
        // jAlex : je persiste uniquement les categories à la carte et les menus 
        // car il y a cascade vers les autres classes
        // Il faut juste être sûr d'avoir mis chaque produit dans une catégorie, chaque NutritionFacts dans un produit
        // et chaque catégorie de type 'Menu' dans un menu
        // Category  
        em.persist(coldDrinks);
        em.persist(hotDrinks);
        em.persist(sandwiches);
        em.persist(sides);
        em.persist(desserts);
        em.persist(sauces);
        em.persist(menuDrinks);
        em.persist(menuSides);
        em.persist(menuAdanaCat);
        em.persist(menuChickenCat);
        em.persist(menuKofteCat);
        em.persist(menuAmericanCat);
        em.persist(menuMerguezCat);
        em.persist(offers);
        em.persist(menus);
        
        em.flush();

        // Menu
        em.persist(menuAdana);
        em.persist(menuKofte);
        em.persist(menuChicken);
        em.persist(menuMerguez);
        em.persist(menuAmerican);

        // Order       
        em.persist(o01);
        em.persist(o02);
        em.persist(o03);
        em.persist(o04);
        em.persist(o05);

        // Line
        em.persist(l01);
        em.persist(l05);
        em.persist(l06);
        em.persist(l07);
        em.persist(l08);
        em.persist(l09);
        em.persist(l10);
        em.persist(l11);

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
        em.persist(mixedSalad);
        em.persist(cheese);
        em.persist(iceCubes);
        em.persist(coke);
        em.persist(cokeZero);
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

        // Account
        em.persist(acc01);

        // Kioks
        em.persist(kiosk01);
        em.persist(kiosk02);

        // CashRegister
        em.persist(cr01);
        em.persist(cr02);
        
        // Option
        em.persist(noIce);
        em.persist(noOnion);
        em.persist(noSalad);
        em.persist(noTomato);
        em.persist(extraPickles);
        em.persist(mediumFries);
        em.persist(mediumPotatoes);
        em.persist(mediumSalad);
        em.persist(mediumCoke);
        em.persist(mediumDietCoke);
        em.persist(mediumCokeZero);
        em.persist(mediumDietCoke);
        em.persist(mediumOrangina);
        em.persist(mediumPerrier);
        em.persist(mediumWater);
        em.persist(mediumNestea);
        em.persist(largeFries);
        em.persist(largePotatoes);
        em.persist(largeSalad);
        em.persist(largeCoke);
        em.persist(largeDietCoke);
        em.persist(largeCokeZero);
        em.persist(largeDietCoke);
        em.persist(largeOrangina);
        em.persist(largePerrier);
        em.persist(largeWater);
        em.persist(largeNestea);
        em.persist(xLargeFries);
        em.persist(xLargePotatoes);
        em.persist(xLargeSalad);
        em.persist(xLargeCoke);
        em.persist(xLargeDietCoke);
        em.persist(xLargeCokeZero);
        em.persist(xLargeDietCoke);
        em.persist(xLargeOrangina);
        em.persist(xLargePerrier);
        em.persist(xLargeWater);
        em.persist(xLargeNestea);
        


    }

}
