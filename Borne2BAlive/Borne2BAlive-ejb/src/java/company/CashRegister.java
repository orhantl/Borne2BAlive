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
public class CashRegister implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String refCashRegister;

    @Column(nullable = false, length = 30)
    private String password;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Restaurant restaurant;
    
    @OneToMany (mappedBy = "cashier")
    private Collection <OrderInfo> orderList;

    public CashRegister() {
        this.orderList = new ArrayList();
    }

    public CashRegister(String refCashRegister, String password) {
        this();
        this.refCashRegister = refCashRegister;
        this.password = password;
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

    public String getRefCashRegister() {
        return refCashRegister;
    }

    public void setRefCashRegister(String refCashRegister) {
        this.refCashRegister = refCashRegister;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "CashRegister{" + "id=" + id + ", refCashRegister=" + refCashRegister 
                + ", password=" + password + ", restaurant=" + restaurant + '}';
    }

}
