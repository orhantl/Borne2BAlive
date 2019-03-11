
package Product;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import order.Line;

@NamedQueries(
        {
           @NamedQuery(name = "Product.Optional.findAllOptionsFromProduct", query = "select o from Optional o join o.ingredient i join i.products p where p.id = :idProduct")
        }
)
@Entity
public class Optional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length= 30)
    private String name;
    
    @Column (length = 20)
    private int maxQty;
    
    @Column (length = 20)
    private float price;
    
    @ManyToMany (mappedBy="optionList")
    private Collection <Line> lineList;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Ingredient ingredient;
    
    @ManyToMany(mappedBy = "options")
    private Collection<MenuItem> items;
    

    public Optional() {
        this.lineList = new ArrayList();
        this.items = new ArrayList();
    }

    public Optional(String name, int maxQty, float price) {
        this();
        this.name = name;
        this.maxQty = maxQty;
        this.price = price;
    }

    public Collection<Line> getLineList() {
        return lineList;
    }

    public void setLineList(Collection<Line> lineList) {
        this.lineList = lineList;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(int maxQty) {
        this.maxQty = maxQty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
            
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Collection<MenuItem> getItems() {
        return items;
    }

    public void setItems(Collection<MenuItem> items) {
        this.items = items;
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
        if (!(object instanceof Optional)) {
            return false;
        }
        Optional other = (Optional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " / " + name ;
    }
    
}
