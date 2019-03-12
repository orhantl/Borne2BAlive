
package managers;



import Product.Menu;
import Product.MenuItem;
import Product.Product;
import company.CashRegister;
import company.Kiosk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import order.Line;
import order.OrderInfo;


@Stateless
public class OrderManager implements OrderManagerLocal {
    @EJB
    private BasketManagerLocal basketManager;

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    private static int queueNumber = 1;
    
    
  
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
       
    @Override
    public String getCashCheckOutNumber(){
        String cashQueueNumber = "ESP";
        queueNumber++;
        if(queueNumber > 100){
            queueNumber = 1;
        }
        if(queueNumber < 10){
            cashQueueNumber += "0";
        }
        cashQueueNumber += queueNumber;        
        return cashQueueNumber;
    }
    
    @Override
    public void finalizeCashOrder(OrderInfo o, String queueNumber){
        
        o.setDateOfOrder(new GregorianCalendar().getTime());
        
        TypedQuery<CashRegister> qr = em.createNamedQuery("company.CashRegister.findCR", CashRegister.class);
        qr.setParameter("paramId", 2L);
        try{
            CashRegister cashier = qr.getSingleResult();
            o.setCashier(cashier);
        }catch(NoResultException ex){
            System.err.println("Caisse inexistante"+ex.getMessage());
        }
        
        TypedQuery<Kiosk> qr2 = em.createNamedQuery("company.Kiosk.findKiosk", Kiosk.class);
        qr2.setParameter("paramId", 1L);
        try{
            Kiosk kiosk = qr2.getSingleResult();
            o.setKiosk(kiosk);
        }catch(NoResultException ex){
            System.err.println("Borne inexistante"+ex.getMessage());
        }
        
        
        
    }

}
