

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
    
    public float getPreTaxTotal(OrderInfo o);
    
    public OrderInfo initializeOrder(String vatLoc);
    
    public String getCashCheckOutNumber();
    
    public String getCreditCardCheckOutNumber();
    
    public void finalizeCashOrder(OrderInfo o, String queueNumber);
    
    public void finalizeCreditOrder(OrderInfo o, String queueNumber);
    
}
