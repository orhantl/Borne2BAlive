
package managers;


import Product.Menu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;
import order.OrderInfo;


@Stateless
public class OrderManager implements OrderManagerLocal {

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

  
  // temporaire
    @Override
    public OrderInfo createOrder(){
        OrderInfo o = new OrderInfo();
        o.setAppliedVAT(10.0f);
        return o;
    }
    
    @Override
    public Line createLine(Menu m){
        Line line = new Line();
        line.setMenu(m);
        line.setPreTaxPrice(m.getPrice());
        line.setQty(1);
        return line;
    }
    
    @Override
    public void addLineToOrder(Line l, OrderInfo o) {
        o.getLineList().add(l);
    }
    
    


}
