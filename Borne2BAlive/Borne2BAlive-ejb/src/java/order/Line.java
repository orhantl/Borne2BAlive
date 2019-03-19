
package order;

import Product.Menu;
import Product.MenuItem;
import Product.Offer;
import Product.Optional;
import Product.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Line implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (length = 10)
    private float optionPriceApplied;
    
    @Column (length = 20)
    private int qty;
    
    @Column (length = 10)
    private float preTaxPrice;
    
    @Column (length = 10)
    private float discount;
    
    @ManyToOne (cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    private OrderInfo selectedOrder ;
    
    @ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE })
    private Collection <Optional> optionList;
    
    @ManyToOne/*(cascade = {CascadeType.PERSIST, CascadeType.MERGE })*/
    private Product product;
    
    @ManyToOne/*(cascade = {CascadeType.PERSIST, CascadeType.MERGE })*/
    private Menu menu;
    
    @OneToMany(mappedBy = "line", cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    private Collection<MenuItem> menuItems;
    
   


    public Line() {
        this.optionList = new ArrayList();
        menuItems = new ArrayList();
    }

    public Line(float optionPriceApplied, int qty, float preTaxPrice, float discount) {
        this();
        this.optionPriceApplied = optionPriceApplied;
        this.qty = qty;
        this.preTaxPrice = preTaxPrice;
        this.discount = discount;
    }

    public Collection<Optional> getOptionList() {
        return optionList;
    }

    public void setOptionList(Collection<Optional> optionList) {
        this.optionList = optionList;
    }

    public OrderInfo getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(OrderInfo selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public float getOptionPriceApplied() {
        return optionPriceApplied;
    }

    public void setOptionPriceApplied(float optionPriceApplied) {
        this.optionPriceApplied = optionPriceApplied;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPreTaxPrice() {
        return preTaxPrice;
    }

    public void setPreTaxPrice(float preTaxPrice) {
        this.preTaxPrice = preTaxPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Collection<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Collection<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Line)) {
            return false;
        }
        Line other = (Line) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - quantité : " + qty + " prix : " + preTaxPrice + " liste des options : "+ optionList;
    }
    
    public float getFullPrice(float vat) {
        return ((preTaxPrice + optionPriceApplied) * (100 + vat) / 100);
    }
    
    public float getOptionsFullPrice(float vat) {
        return ((optionPriceApplied) * (100 + vat) / 100);
    }
    
    public float getProductFullPrice(float vat) {
        return ((preTaxPrice) * (100 + vat) / 100);
    }
    
}
