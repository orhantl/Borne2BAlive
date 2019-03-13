
package order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries(
        {
            @NamedQuery(name="order.OrderStatus.findOS", query="select c from OrderStatus c where c.id= :paramId")
        }
)


@Entity
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable=false, length=50)
    private String name;
    
    @OneToMany(mappedBy="status")
    private Collection <OrderInfo> orderList;

    public OrderStatus() {
        this.orderList = new ArrayList();
    }

    public OrderStatus(String name) {
        this();
        this.name = name;
    }

    public Collection<OrderInfo> getOrderList() {
        return orderList;
    }

    public void setOrderList(Collection<OrderInfo> orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
