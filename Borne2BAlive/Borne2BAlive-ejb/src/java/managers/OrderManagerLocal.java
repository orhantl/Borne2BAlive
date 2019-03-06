
package managers;


import javax.ejb.Local;
import order.OrderInfo;

@Local
public interface OrderManagerLocal {

    public OrderInfo createOrder();

    
}
