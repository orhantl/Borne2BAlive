

package managers;


import Product.Menu;
import Product.MenuItem;
import Product.Product;
import javax.ejb.Local;
import order.Line;
import order.OrderInfo;

@Local
public interface OrderManagerLocal {

    public OrderInfo createOrder();


    public Line createLine(Menu m);

    public void addLineToOrder(Line l, OrderInfo o);


    public OrderInfo createOrderFinal();

    


    
}
