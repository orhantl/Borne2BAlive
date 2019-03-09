package managers;

import Product.Allergen;
import Product.Menu;
import Product.Optional;
import Product.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MenuManager implements MenuManagerLocal {

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    @Override
    public Menu getMenu(long id) {
        return em.find(Menu.class, id);
    }

    @Override
    public Product getSandwich(long menuId) {
        TypedQuery<Product> qr = em.createNamedQuery("Product.Menu.FindSandwich", Product.class);
        qr.setParameter("menuId", menuId);
        return qr.getSingleResult();
    }

    @Override
    public List<Allergen> getAllergens(long sandwichId) {
        TypedQuery<Allergen> qr = em.createNamedQuery("Product.Product.findAllergensOfProduct", Allergen.class);
        qr.setParameter("idProduct", sandwichId);
        return qr.getResultList();
    }

    @Override
    public List<Optional> getOptionsFromProduct(long productId) {
        TypedQuery<Optional> qr = em.createNamedQuery("Product.Optional.findAllOptionsFromProduct", Optional.class);
        qr.setParameter("idProduct", productId);
        return qr.getResultList();
    }

    @Override
    public List<Product> getSidesFromMenu() {
        TypedQuery<Product> qr = em.createNamedQuery("Product.Menu.FindAllAvailableSides", Product.class);
        return qr.getResultList();
    }

    @Override
    public Product getProduct(long id) {
        return em.find(Product.class, id);
    }

}
