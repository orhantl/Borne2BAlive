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
import javax.persistence.OneToMany;

@Entity
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(nullable = false, length = 100)
    private String name;
     
     @Column(unique = true, nullable = false, length = 300)
    private String address;
     
     @Column(length = 13)
    private String tel;
     
      @Column(nullable = false, length = 100)
    private String RCS;
     
      @Column(unique = true, nullable = false, length = 300)
    private String SIRET;
      
       @Column(unique = true, nullable = false, length = 300)
    private String website;

        @OneToMany(mappedBy = "restaurant")
       private Collection<CashRegister> cashRegisters;
       
        @OneToMany(mappedBy = "restaurant")
       private Collection<Kiosk> kiosks;
        

    public Restaurant() {
        cashRegisters = new ArrayList ();
               kiosks = new ArrayList ();
    }

    public Restaurant(String name, String address, String tel, String RCS, String SIRET, 
            String website) {
        this();
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.RCS = RCS;
        this.SIRET = SIRET;
        this.website = website;
        
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRCS() {
        return RCS;
    }

    public void setRCS(String RCS) {
        this.RCS = RCS;
    }

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Collection<CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void setCashRegisters(Collection<CashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    public Collection<Kiosk> getKiosks() {
        return kiosks;
    }

    public void setKiosks(Collection<Kiosk> kiosks) {
        this.kiosks = kiosks;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", name=" + name + ", address=" 
                + address + ", tel=" + tel + ", RCS=" + RCS + ", SIRET=" + SIRET
                + ", website=" + website + ", cashRegisters=" + cashRegisters 
                + ", kiosks=" + kiosks + '}';
    }
        
        
}