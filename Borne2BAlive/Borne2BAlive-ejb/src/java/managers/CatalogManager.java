
package managers;

import Product.Category;
import Product.Menu;
import Product.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CatalogManager implements CatalogManagerLocal {
    
    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    
    // Get all menus
    @Override
    public List<Menu> getMenus() {
        TypedQuery<Menu> qr = em.createNamedQuery("Product.Menu.FindAll", Menu.class);
        return qr.getResultList();
    }
    
    // Get all available menus
    @Override
    public List<Menu> getAvailableMenus() {
        TypedQuery<Menu> qr = em.createNamedQuery("Product.Menu.FindAllAvailable", Menu.class);
        return qr.getResultList();
    }    
    
    // Get all unavailable menus
    @Override
    public List<Menu> getUnavailableMenus() {
        TypedQuery<Menu> qr = em.createNamedQuery("Product.Menu.FindAllUnavailable", Menu.class);
        return qr.getResultList();
    }
    
    // Get Full price of one menu
    @Override
    public float getFullPrice(Menu m, float tva) {       
        return m.getPrice() * (100 + tva) / 100;
    }
    
    // Get All products
    @Override
    public List<Product> getAllProducts() {       
        TypedQuery<Product> qr = em.createNamedQuery("Product.Product.findAllProducts", Product.class);
        return qr.getResultList();
    }
    
    // Instanciate nav bar
    @Override
    public List<Category> getNavBar() {
        TypedQuery<Category> qr = em.createNamedQuery("Product.Category.findAll", Category.class);
        
        return qr.getResultList();
        
    }
    
    @Override
    public Product getProduct(Long id){    
        Product p = em.find(Product.class, id);       
        return p;
    }

    
    
    
    
    
    
    
}
