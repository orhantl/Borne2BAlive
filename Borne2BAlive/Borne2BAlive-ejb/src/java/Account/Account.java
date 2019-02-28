package Account;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
    
    @Column(unique = true, nullable = false, length = 50)
    private String email;

     @Column(nullable = false, length = 100)
    private String lastName;
    
     @Column(nullable = false, length = 100)
    private String firstName;
        
          
    @Column(nullable = false, length = 30)
    private String password;    
    
      @Column(length = 14)    
    private String tel;

     @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

     @Temporal(TemporalType.TIMESTAMP)
    private Date bDay;
     
         @Column(length = 3)
    private String civility;

    @Column(unique = true, nullable = false, length = 300)
    private String Address;

      @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     private AccountStatus status;

    public Account() {
    }

    public Account(String email, String lastName, String firstName, String password, String tel, Date joinDate, Date bDay, String civility, String Address) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.tel = tel;
        this.joinDate = joinDate;
        this.bDay = bDay;
        this.civility = civility;
        this.Address = Address;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
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

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", lastName=" 
                + lastName + ", firstName=" + firstName + ", password=" 
                + password + ", tel=" + tel + ", joinDate=" + joinDate + ", bDay=" 
                + bDay + ", civility=" + civility + ", Address=" + Address + ", status=" + status + '}';
    }

    
    
}    