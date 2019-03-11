
package managers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;
import order.OrderInfo;

@Stateless
public class BasketManager implements BasketManagerLocal {
    @EJB
    private CatalogManagerLocal catalogManager;
    
    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;
   
    @Override
   public Line getLine (Long id, float f) {
       Line l = new Line ();
       
        l.setProduct(catalogManager.getProduct(id));
        l.setQty(1);
        
        if (f > 0) {
        l.setOptionPriceApplied(f);
            l.setPreTaxPrice(catalogManager.getProduct(id).getPrice()+ f);
        } else {
            l.setOptionPriceApplied(0);
            l.setPreTaxPrice(catalogManager.getProduct(id).getPrice());
        }
       return l;
   }
   
    @Override
   public float getVATTotal (OrderInfo o) {
       
       float preTaxSum = 0;
       for (Line l : o.getLineList()){
           preTaxSum += (l.getPreTaxPrice() * l.getDiscount()/100 + l.getPreTaxPrice()) + l.getOptionPriceApplied();
       }   
       return (preTaxSum * o.getAppliedVAT())/100 + preTaxSum;
   }
   
    @Override
   public OrderInfo emptyBasket (OrderInfo o){
       o.getLineList().clear();
       return o;
   }
   
   // est ce que Bob en a besoin?  sinon on efface
   
   
   // est ce que Bob en a besoin? sinon on efface
    @Override
   public int getItemNumber (OrderInfo o){
       int number = 0;
       
       for (Line l : o.getLineList()){
           number += l.getQty();
       }
       return number;
   }

    public void persist(Object object) {
        em.persist(object);
    }

    
}
