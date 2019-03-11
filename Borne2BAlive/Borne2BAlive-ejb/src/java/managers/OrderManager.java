
package managers;



import Product.Menu;
import Product.MenuItem;
import Product.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;
import order.OrderInfo;


@Stateless
public class OrderManager implements OrderManagerLocal {
    @EJB
    private BasketManagerLocal basketManager;

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    
    
    
  
  // temporaire
    @Override
    public OrderInfo createOrder(){
        OrderInfo o = new OrderInfo();
        o.setAppliedVAT(10.0f);
        this.getPreTaxTotal(o);
        basketManager.getVATTotal(o);
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
    
    @Override
    public float getPreTaxTotal (OrderInfo o) {            
       float preTaxSum = 0;
       for (Line l : o.getLineList()){
           preTaxSum += (l.getPreTaxPrice() * l.getDiscount() + l.getPreTaxPrice()) + l.getOptionPriceApplied();
       }      
       
       return preTaxSum;
   }
       
     

}
