
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

    @Override
    public List<Menu> getMenus() {
        TypedQuery<Menu> qr = em.createNamedQuery("Product.Menu.FindAll", Menu.class);
        return qr.getResultList();
    }

    
    
    
    
    
    
    
}
