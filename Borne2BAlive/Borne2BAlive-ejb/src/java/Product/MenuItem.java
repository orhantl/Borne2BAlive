
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
import order.Line;

@Entity
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private float optionPriceApplied;
    
    @ManyToOne
    private Product product; 
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Ingredient> ingredients;
    
    @ManyToOne
    private Line line;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Optional> options;

    public MenuItem() {
        ingredients = new ArrayList<>();
        options = new ArrayList<>();
        
    }

    
    public MenuItem(float optionPriceApplied) {
        this();
        this.optionPriceApplied = optionPriceApplied;
    }

    public float getOptionPriceApplied() {
        return optionPriceApplied;
    }

    public void setOptionPriceApplied(float optionPriceApplied) {
        this.optionPriceApplied = optionPriceApplied;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Collection<Optional> getOptions() {
        return options;
    }

    public void setOptions(Collection<Optional> options) {
        this.options = options;
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
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id + " : "  + optionPriceApplied;

    }
    
}
