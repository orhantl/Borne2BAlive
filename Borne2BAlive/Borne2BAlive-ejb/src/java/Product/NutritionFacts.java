
package Product;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class NutritionFacts implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // All the float values are for 100 grams of product
    
    @Column()
    private float carbs; // in grams
    
    @Column()
    private float lipids; // in grams
    
    @Column()
    private float proteins; // in grams
    
    @Column()
    private float sugars; // in grams
    
    @Column()
    private float fibers; // in grams
    
    @Column()
    private float salt; // in grams
    
    @Column()
    private float kCal; 
    
    @OneToOne
    private Product product;

    public NutritionFacts() {
    }

    public NutritionFacts(float carbs, float lipids, float proteins, float sugars, float fibers, float salt, float kCal) {
        this.carbs = carbs;
        this.lipids = lipids;
        this.proteins = proteins;
        this.sugars = sugars;
        this.fibers = fibers;
        this.salt = salt;
        this.kCal = kCal;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getLipids() {
        return lipids;
    }

    public void setLipids(float lipids) {
        this.lipids = lipids;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getSugars() {
        return sugars;
    }

    public void setSugars(float sugars) {
        this.sugars = sugars;
    }

    public float getFibers() {
        return fibers;
    }

    public void setFibers(float fibers) {
        this.fibers = fibers;
    }

    public float getSalt() {
        return salt;
    }

    public void setSalt(float salt) {
        this.salt = salt;
    }

    public float getkCal() {
        return kCal;
    }

    public void setkCal(float kCal) {
        this.kCal = kCal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof NutritionFacts)) {
            return false;
        }
        NutritionFacts other = (NutritionFacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product.NutritionFacts[ id=" + id + " ]";
    }
    
}
