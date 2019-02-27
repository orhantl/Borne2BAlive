package Account;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 3)
    private String civility;
    
     @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

     @Column(nullable = false, length = 100)
    private String lastName;
    
     @Column(nullable = false, length = 100)
    private String firstName;
    
     @Column(length = 14)
    private int tel;
     
     @Temporal(TemporalType.TIMESTAMP)
    private Date bDay;
     
     @Column(unique = true, nullable = false, length = 50)
    private String email;
     
     @Column(nullable = false, length = 30)
    private String password;
      
      @Column(unique = true, nullable = false, length = 300)
    private String Address;

      @ManyToOne 
     private AccountStatus status;
      
    public Account() {
    }

    public Account(String civility, Date joinDate, String lastName, String firstName, int tel, Date bDay, String email, String password, String Address) {
        this.civility = civility;
        this.joinDate = joinDate;
        this.lastName = lastName;
        this.firstName = firstName;
        this.tel = tel;
        this.bDay = bDay;
        this.email = email;
        this.password = password;
        this.Address = Address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }


      
        
    
}