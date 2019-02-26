
package Product;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
   
    @Column(length = 255)
    private String description;
    
    @Column(nullable = false, length = 100)
    private String img;
    
    //####################DEPENDENCIES############################
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Allergen> allergens;
    
    //####################CONSTRUCTORS############################
    
    public Ingredient(){
        
    }
    
    public Ingredient(String name, String img){
        this.name = name;
        this.img = img;
    }
    
    public Ingredient(String name, String description, String img){
        this.name = name;
        this.description = description;
        this.img = img;        
    }
    
    //####################GETTERS & SETTERS#######################

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getImg(){
        return img;
    }
    
    public void setImg(String img){
        this.img = img;
    }
    
    //####################################################

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name+"("+id+")";
    }
    
}
