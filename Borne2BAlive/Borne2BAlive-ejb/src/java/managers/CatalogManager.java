
package managers;

import Product.Menu;
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

    
    
    
    
    
    
    
}
