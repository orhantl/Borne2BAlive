
package managers;

import Product.Allergen;
import Product.Menu;
import Product.Optional;
import Product.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MenuManagerLocal {

    public Menu getMenu(long id);

    public Product getSandwich(long menuId);

    public List<Allergen> getAllergens(long sandwichId);

    public List<Optional> getOptionsFromProduct(long productId);

    public List<Product> getSidesFromMenu();

    public Product getProduct(long id);
    
}
