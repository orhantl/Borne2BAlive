
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import order.Line;

@Entity
@NamedQueries(
        {
            @NamedQuery(name="Product.Menu.FindAll", query = "select m from Menu m"),
            @NamedQuery(name="Product.Menu.FindAllAvailable", query = "select m from Menu m join m.categories c join c.products p where c.type.name = 'SandwichMenus' and p.status.name = 'Disponible' order by m.name"),
            @NamedQuery(name="Product.Menu.FindAllUnavailable", query = "select m from Menu m join m.categories c join c.products p where c.type.name = 'SandwichMenus' and p.status.name != 'Disponible' order by m.name"),
            @NamedQuery(name="Product.Menu.FindSandwich", query = "select p from Product p join p.categories c join c.menus m where c.type.name = 'SandwichMenus' and m.id = :menuId ")
        }
)
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(length = 200)
    private String description;
        
    @Column()
    private String img;
    
    @Column(nullable = false)
    private float price;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Category> categories;
    
    @OneToMany(mappedBy = "menu")
    private Collection<Line> lines;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Offer> offers;

    public Menu() {
        categories = new ArrayList<>();
        lines = new ArrayList<>();
        offers = new ArrayList<>();
    }

    public Menu(String name, String description, String img, float price) {
        this();
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Line> getLines() {
        return lines;
    }

    public void setLines(Collection<Line> lines) {
        this.lines = lines;
    }

    public Collection<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Collection<Offer> offers) {
        this.offers = offers;
    }
    
    
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product.Menu[ id=" + id + " ]";
    }
    
}
