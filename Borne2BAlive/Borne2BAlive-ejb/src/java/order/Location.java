
package order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries(
        {
            @NamedQuery(name="order.Location.findLocation", query="select l from Location l where l.id= :paramId"),
            @NamedQuery(name="order.Location.findAll", query="select l from Location l")
        }
)

@Entity
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable = false, length= 50, unique=true)
    private String name;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    private VAT appliedVAT;
    
    @OneToMany (mappedBy= "place")
    private Collection <OrderInfo> orderList;

    public Location() {
        this.orderList = new ArrayList();
    }

    public Location(String name) {
        this.name = name;
        
    }


    public Collection<OrderInfo> getOrderList() {
        return orderList;
    }

    public void setOrderList(Collection<OrderInfo> orderList) {
        this.orderList = orderList;
    }

    
    public VAT getAppliedVAT() {
        return appliedVAT;
    }

    public void setAppliedVAT(VAT appliedVAT) {
        this.appliedVAT = appliedVAT;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
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
