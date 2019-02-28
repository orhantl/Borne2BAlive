package company;

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
import javax.persistence.OneToMany;
import javax.persistence.criteria.Order;
import order.OrderInfo;

@Entity
public class Kiosk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String refKiosk;

    @Column(unique = true, nullable = false, length = 300)
    private String address;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Restaurant restaurant;
    
    @OneToMany (mappedBy = "kiosk")
    private Collection <OrderInfo> orderList;

    public Kiosk() {
        this.orderList = new ArrayList();
    }

    public Kiosk(String refKiosk, String address) {
        this();
        this.refKiosk = refKiosk;
        this.address = address;
    }

    public Collection<OrderInfo> getOrderList() {
        return orderList;
    }

    public void setOrderList(Collection<OrderInfo> orderList) {
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefKiosk() {
        return refKiosk;
    }

    public void setRefKiosk(String refKiosk) {
        this.refKiosk = refKiosk;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Kiosk{" + "id=" + id + ", refKiosk=" + refKiosk + ", address=" 
                + address + ", restaurant=" + restaurant + '}';
    }

}
