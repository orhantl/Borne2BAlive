
package managers;

import java.util.Collection;
import javax.ejb.Local;
import order.Line;


@Local
public interface OrderManagerLocal {
    
    public Collection<Line> getLines();
    public boolean isEmpty();
    
}
