
package managers;

import Product.Allergen;
import Product.Menu;
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

    
   
    
}
