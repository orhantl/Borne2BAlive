
package Product;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allergen implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 255)
    private String name;
    
    //####################DEPENDENCIES############################
    
    @ManyToMany(mappedBy = "allergens", fetch = FetchType.LAZY)
    private Collection<Ingredient> ingredients;
    
    //@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    
    
    //####################CONSTRUCTORS############################

    public Allergen() {
    }

    public Allergen(String name) {
        this.name = name;
    }
    
        
    //####################GETTERS & SETTERS#######################
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    //##############################################################

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Allergen)) {
            return false;
        }
        Allergen other = (Allergen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product.Allergen[ id=" + id + " ]";
    }
    
}
