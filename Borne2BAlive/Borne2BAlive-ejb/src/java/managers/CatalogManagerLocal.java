
package managers;

import Product.Category;
import Product.Menu;
import Product.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CatalogManagerLocal {

    public List<Menu> getMenus();

    public List<Menu> getAvailableMenus();

    public List<Menu> getUnavailableMenus();

    public float getFullPrice(Menu m, float tva);

    public List<Product> getAllProducts();

    public List<Category> getNavBar();

    public Product getProduct(Long id);
    
}
