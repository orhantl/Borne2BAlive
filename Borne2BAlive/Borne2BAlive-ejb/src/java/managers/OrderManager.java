
package managers;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.OrderInfo;


@Stateless
public class OrderManager implements OrderManagerLocal {

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

  
  // temporaire
    @Override
    public OrderInfo createOrder(){
        OrderInfo o = new OrderInfo();
        o.setAppliedVAT(10);
        return o;
    }


}
