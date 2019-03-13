
package managers;

import Product.Allergen;
import Product.Menu;
import Product.MenuItem;
import Product.Optional;
import Product.Product;
import java.util.List;
import javax.ejb.Local;
import order.Line;

@Local
public interface MenuManagerLocal {

    public Menu getMenu(long id);

    public Product getSandwich(long menuId);

    public List<Allergen> getAllergens(long sandwichId);

    public List<Optional> getOptionsFromProduct(long productId);

    public List<Product> getSidesFromMenu();

    public Product getProduct(long id);

    public MenuItem createMenuItem(Product p);

    public void addItemToLine(MenuItem item, Line l);

    public Optional getOptional(long id);

    public void addOptionToItem(Optional option, MenuItem item);

    public void addOptionToItemSide(Optional option, MenuItem item);

    public List<Product> getDrinksFromMenu();

    public List<Optional> getSizeOptionsFromProduct(long productId);

    public List<Optional> getIceOptionsFromProduct(long productId);

    public float getOptionsPrice(MenuItem[] items);

    public void addMenuToLine(Menu m, Line l);
    
}
