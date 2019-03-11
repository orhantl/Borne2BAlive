
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import order.Line;

@NamedQueries(
        {
            @NamedQuery(name = "Product.Product.findAllProducts", query = "select p from Product p"),
            @NamedQuery(name = "Product.Product.findAllergensOfProduct", query = "select distinct(a) from Allergen a join a.ingredients i join i.products p where p.id = :idProduct"),
            @NamedQuery(name = "Product.Product.findAllAvailableProductsFromCategory", query = "select p from Product p join p.categories c where c.name = :catName and p.status.name = 'Disponible' ")
        }
)
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    
    @Column()
    private String img;
        
    @Column(nullable = false)
    private float price;
    
    @Column(length = 250)
    private String description;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ProductStatus status;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private NutritionFacts facts;
    

    @ManyToMany(mappedBy = "products")
    private Collection<Category> categories;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Offer> offers;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Ingredient> ingredients;
    
    @OneToMany(mappedBy = "product")
    private Collection<Line> lines;
    
    @OneToMany(mappedBy = "product")
    private Collection<MenuItem> menuItems;
    
    public Product() {
        categories = new ArrayList<>();
        offers = new ArrayList<>();
        ingredients = new ArrayList<>();
        lines = new ArrayList<>();
        menuItems = new ArrayList<>();
    }

    public Product(String name, String img, float price, String description) {
        this();
        this.name = name;
        this.img = img;
        this.price = price;
        this.description = description;
    }
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public NutritionFacts getFacts() {
        return facts;
    }

    public void setFacts(NutritionFacts facts) {
        this.facts = facts;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Collection<Offer> offers) {
        this.offers = offers;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<Line> getLines() {
        return lines;
    }

    public void setLines(Collection<Line> lines) {
        this.lines = lines;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
