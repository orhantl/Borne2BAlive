
package managers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;
import order.OrderInfo;

@Stateless
public class BasketManager implements BasketManagerLocal {
    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;
    

   public void modifyItemQty (Line l, int qty) {
       l = em.merge(l);
       l.setQty(qty);
       
       // gérer ajout
       // gérer suppression
       
       // interdire les quantités inférieures à 0
       // si quantité = 0 = enlever l'article du panier
   }
   
//   public void removeItem (String ref) {
//       
//   }
   
   public OrderInfo emptyBasket (OrderInfo o){
       o = em.merge(o);
       o.getLineList().clear();
       return o;
   }
   
   public boolean isEmpty (OrderInfo o){
       boolean b;
       o = em.merge(o);
       b = o.getLineList().isEmpty();
       return b;
   }
   
   public float getVATTotal (OrderInfo o) {
       
       /*
       to calculate the VAT Total of an order
       for each line we retrieve the preTax price of each item and the given discount if applied
       and we add the total price of selected option
       */
       
       o = em.merge(o);
       
       float preTaxSum = 0;
       for (Line l : o.getLineList()){
           preTaxSum += (l.getPreTaxPrice() * l.getDiscount() + l.getPreTaxPrice()) + l.getOptionPriceApplied();
       }   
       
       return (preTaxSum * o.getAppliedVAT()) + preTaxSum;
   }
   
   public float getPreTaxeTotal (OrderInfo o) {
       o = em.merge(o);
             
       float preTaxSum = 0;
       for (Line l : o.getLineList()){
           preTaxSum += (l.getPreTaxPrice() * l.getDiscount() + l.getPreTaxPrice()) + l.getOptionPriceApplied();
       }      
       return preTaxSum;
   }
   
   public int getItemNumber (OrderInfo o){
       int number = 0;
       
       for (Line l : o.getLineList()){
           number += l.getQty();
       }
       return number;
   }

    
}
