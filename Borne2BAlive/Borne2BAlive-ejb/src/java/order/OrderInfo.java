
package order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 10)
    private String queueNumber;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfOrder;
    
    @Column(length = 10)
    private float appliedVAT;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    private Location place;
    
    @ManyToOne (cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    private OrderStatus status;
    
    @ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    private Collection <PaymentType> paymentList;
    
    @OneToMany (mappedBy = "selectedOrder")
    private Collection <Line> lineList;

    public OrderInfo() {
        this.paymentList = new ArrayList();
        this.lineList = new ArrayList();
    }

    public OrderInfo(String queueNumber, Date date, float appliedVAT) {
        this();
        this.queueNumber = queueNumber;
        this.dateOfOrder = date;
        this.appliedVAT = appliedVAT;
    }

    public Collection<Line> getLineList() {
        return lineList;
    }

    public void setLineList(Collection<Line> lineList) {
        this.lineList = lineList;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Location getPlace() {
        return place;
    }

    public void setPlace(Location place) {
        this.place = place;
    }

    public Collection<PaymentType> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Collection<PaymentType> paymentList) {
        this.paymentList = paymentList;
    }

    
    public String getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public float getAppliedVAT() {
        return appliedVAT;
    }

    public void setAppliedVAT(float appliedVAT) {
        this.appliedVAT = appliedVAT;
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
        if (!(object instanceof OrderInfo)) {
            return false;
        }
        OrderInfo other = (OrderInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return queueNumber + dateOfOrder + appliedVAT;
    }
    
}
