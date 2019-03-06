
package managers;

import Product.Menu;
import Product.Product;
import javax.ejb.Local;

@Local
public interface MenuManagerLocal {

    public Menu getMenu(long id);

    public Product getSandwich(long menuId);
    
}
