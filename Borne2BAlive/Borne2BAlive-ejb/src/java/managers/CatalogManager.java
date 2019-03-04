
package managers;

import Product.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

@Stateless
@NamedQueries(
        {
            @NamedQuery(name="Product.Menu.FindAllAvailable", query="select m from menu m where")
        }
)
public class CatalogManager implements CatalogManagerLocal {
    
//    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
//    private EntityManager em;
//
//    public List<Menu> displayMenus() {
//        
//    }

    
    
    
    
    
    
    
}
