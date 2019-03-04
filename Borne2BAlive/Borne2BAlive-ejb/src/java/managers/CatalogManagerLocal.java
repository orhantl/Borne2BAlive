
package managers;

import Product.Menu;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CatalogManagerLocal {

    public List<Menu> getMenus();
    
}
