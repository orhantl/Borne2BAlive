
package managers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import order.Line;


@Stateless
public class OrderManager implements OrderManagerLocal {

    @PersistenceContext(unitName = "Borne2BAlive-ejbPU")
    private EntityManager em;
    
    private HashMap<Integer, Line> order;
    
    @PostConstruct
    public void init(){
        order = new HashMap<>();
    }
    
    @Override
    public Collection<Line> getLines(){
        return order.values();
    }
    
    @Override
    public boolean isEmpty(){
        return order.isEmpty();
    }
    
    
    
    
}
