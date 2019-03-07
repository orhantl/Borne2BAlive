
package managers;

import Product.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
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
        o.setAppliedVAT(10);
        return o;
    }
    
  // temp
     @Override
     public OrderInfo createOrderFinal(){
         Date date = new Date();
         Product p01 = new Product();
         Product p05 = new Product();
         Line l01 = new Line(0.2f, 1, 7, 0);
         l01.setProduct(p01);
         Line l05 = new Line(0, 1, 4.5f, 0);
         Collection<Line> lineList = new ArrayList();
         lineList.add(l01);
         lineList.add(l05);
         
         OrderInfo order = new OrderInfo();
         order.setAppliedVAT(10);
         order.setLineList(lineList);
         order.setDateOfOrder(date);
         order.setQueueNumber("CB23");
         
         return order;
     }
    

}
