package tests;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import order.Location;
import order.OrderStatus;
import order.PaymentType;
import order.VAT;

public class DataTest {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Borne2BAlive-ejbPU");
        EntityManager em = emf.createEntityManager();
        
        // data test here


        // LUDIVINE
        
        // VAT 
        
        VAT normale = new VAT(10, "TVA normale");
        VAT reduite = new VAT(5.5f, "TVA réduite");
        
        // LOCATION
        Location resto = new Location ("sur place");
        Location takeAway = new Location ("à emporter");
        
        
        //PAYMENT TYPE 
        
        PaymentType cb = new PaymentType ("carte bancaire");
        PaymentType esp = new PaymentType ("espèces");
        PaymentType tresto = new PaymentType("ticket restaurant");
        
        
        //ORDER STATUS
        
        OrderStatus os01 = new OrderStatus ("en cours de préparation");
        OrderStatus os02 = new OrderStatus ("en attente de règlement");
        OrderStatus os03 = new OrderStatus ("payée");
        OrderStatus os04 = new OrderStatus ("prête");
        OrderStatus os05 = new OrderStatus ("retirée");
        
        
        //ORDER à faire plus tard

        


        //AMOS a01

        
     
 
        
    }
    
}