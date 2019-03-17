package managers;

import Product.Optional;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;
import order.OrderInfo;

@Stateless
public class BasketManager implements BasketManagerLocal {

    @EJB
    private MenuManagerLocal menuManager;
    @EJB
    private CatalogManagerLocal catalogManager;

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;

    @Override
    public Line getLine(Long id, float f) {
        Line l = new Line();

        l.setProduct(catalogManager.getProduct(id));
        l.setQty(1);

        if (f > 0) {
            l.setOptionPriceApplied(f);
            l.setPreTaxPrice(catalogManager.getProduct(id).getPrice() + f);
        } else {
            l.setOptionPriceApplied(0);
            l.setPreTaxPrice(catalogManager.getProduct(id).getPrice());
        }
        return l;
    }

    // retourne le prix des options choisies pour une ligne, pour un achat au détail
    @Override
    public float getOptionPriceApplied(String optionId[]) {
        float f = 0;
        if (optionId != null) {
            for (String s : optionId) {
                Optional o = menuManager.getOptional(Integer.valueOf(s));
                f += o.getPrice();
            }
        }
        return f;
    }
    
    @Override
    public float mergeOptionPriceApplied (float a, float b){
        float f = a + b;
        return f;
    }

    // retourne un tableau d'option pour un achat au détail
    @Override
    public ArrayList<Optional> getOptionList(String optionId[]) {
        ArrayList<Optional> options = new ArrayList();
        if (optionId != null) {
            for (String s : optionId) {
                options.add(menuManager.getOptional(Integer.valueOf(s)));
            }
        }
        return options;
    }
    
    @Override
    public ArrayList<Optional> mergeOptionList(ArrayList <Optional> a, ArrayList <Optional> b) {
        ArrayList<Optional> options = new ArrayList();
        if (! a.isEmpty() ) {
            for (Optional o : a) {
                options.add(o);
            }
        }
        if (! b.isEmpty() ) {
            for (Optional o : b) {
                options.add(o);
            }
        }
        return options;
    }

    @Override
    public float getVATTotal(OrderInfo o) {

        float preTaxSum = 0;
        for (Line l : o.getLineList()) {
            preTaxSum += ((l.getPreTaxPrice() * l.getDiscount() / 100 + l.getPreTaxPrice()) 
                    + l.getOptionPriceApplied())* l.getQty();
        }
        return (preTaxSum * o.getAppliedVAT()) / 100 + preTaxSum;
    }

    @Override
    public OrderInfo emptyBasket(OrderInfo o) {
        o.getLineList().clear();
        return o;
    }

    @Override
    public OrderInfo removeLine(OrderInfo o, int index) {
        ArrayList<Line> modifiedOrder = (ArrayList) o.getLineList();
        modifiedOrder.remove(index);
        o.setLineList(modifiedOrder);
        return o;
    }
    
    @Override
    public OrderInfo minusItem (OrderInfo o, int index){
        ArrayList<Line> modifiedOrder = (ArrayList) o.getLineList();
        int qty = modifiedOrder.get(index).getQty();
    
        if (qty > 1){
            qty -= 1;
        } else {
            qty = 1;
        }
        modifiedOrder.get(index).setQty(qty);
        o.setLineList(modifiedOrder);
        return o;
    }
    
    @Override
    public OrderInfo plusItem (OrderInfo o, int index){
        ArrayList<Line> modifiedOrder = (ArrayList) o.getLineList();
        int qty = modifiedOrder.get(index).getQty();
    
        if (qty < 10){
            qty += 1;
        } else {
            qty = 10;
        }
        modifiedOrder.get(index).setQty(qty);
        o.setLineList(modifiedOrder);
        return o;
    }

   // est ce que Bob en a besoin?  sinon on efface
    // est ce que Bob en a besoin? sinon on efface
    @Override
    public int getItemNumber(OrderInfo o) {
        int number = 0;

        for (Line l : o.getLineList()) {
            number += l.getQty();
        }
        return number;
    }
}
