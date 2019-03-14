
package managers;



import Product.Menu;
import Product.MenuItem;
import Product.Product;
import company.CashRegister;
import company.Kiosk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import order.OrderStatus;


@Stateless
public class OrderManager implements OrderManagerLocal {
    @EJB
    private BasketManagerLocal basketManager;

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    private static int cashQueueNumber = 0;
    private static int creditQueueNumber = 0;
    
  
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
        String queueNumber = "ESP";
        cashQueueNumber++;
        if(cashQueueNumber > 100){
            cashQueueNumber = 1;
        }
        if(cashQueueNumber < 10){
            queueNumber += "0";
        }
        queueNumber += cashQueueNumber;        
        return queueNumber;
    }
    
    @Override
    public String getCreditCardCheckOutNumber(){
        String queueNumber = "CB";
        creditQueueNumber++;
        if(creditQueueNumber > 100){
            creditQueueNumber = 1;
        }
        if(creditQueueNumber < 10){
            queueNumber += "0";
        }
        queueNumber += creditQueueNumber;
        return queueNumber;
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
        
        TypedQuery<OrderStatus> qr3 = em.createNamedQuery("order.OrderStatus.findOS", OrderStatus.class);
        qr3.setParameter("paramId", 1L);
        try{
            OrderStatus os = qr3.getSingleResult();
            o.setStatus(os);
        }catch(NoResultException ex){
            System.err.println("Statut erronné");
        }
        
        o.setQueueNumber(queueNumber);
        
        String fileName = "D:\\"+ queueNumber + ".ord";
        
        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.flush();
        }catch(FileNotFoundException ex){
            System.out.println("Erreur à l'écriture du fichier : "+ex);
            ex.printStackTrace();
        }catch(IOException ex){
            System.out.println("Erreur E/S : "+ex);
            ex.printStackTrace();
        }
        
        
        em.persist(o);
    }
    
    @Override
    public void finalizeCreditOrder(OrderInfo o, String queueNumber){
        
        o.setDateOfOrder(new GregorianCalendar().getTime());
        
        TypedQuery<CashRegister> qr = em.createNamedQuery("company.CashRegister.findCR", CashRegister.class);
        qr.setParameter("paramId", 1L);
        try{
            CashRegister cashier = qr.getSingleResult();
            o.setCashier(cashier);
        }catch(NoResultException ex){
            System.err.println("Caisse inexistante : "+ex);
        }
        
        TypedQuery<Kiosk> qr2 = em.createNamedQuery("company.Kiosk.findKiosk", Kiosk.class);
        qr2.setParameter("paramId", 2L);
       try{
           Kiosk kiosk = qr2.getSingleResult();
           o.setKiosk(kiosk);
       }catch(NoResultException ex){
           System.err.println("Borne inexistante : "+ex);
       }
        
       TypedQuery<OrderStatus> qr3 = em.createNamedQuery("order.OrderStatus.findOS", OrderStatus.class);
       qr3.setParameter("paramId", 4L);
       try{
           OrderStatus os = qr3.getSingleResult();
           o.setStatus(os);
       }catch(NoResultException ex){
           System.err.println("Statut erronné : "+ex);
       }
       
       o.setQueueNumber(queueNumber);
       
       String fileName = "D:\\" + queueNumber + ".ord";
       
       try{
           FileOutputStream fos = new FileOutputStream(fileName);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(o);
           oos.flush();
       }catch(FileNotFoundException ex){
           System.err.println("Erreur à l'écriture du fichier : "+ex);
           ex.printStackTrace();
       }catch(IOException ex){
           System.out.println("Erreur d'E/S : "+ex);
           ex.printStackTrace();
       }
       
    }
    

}
