/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Christian
 */
public class CustomerFacade {
    private static EntityManagerFactory emf;
    public static CustomerFacade instance;
    
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
         TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.lastName = :lastName", Customer.class).setParameter("lastName", name);
            return query.getResultList();
        } finally {
            em.close();
        }   
    }

    public int getNumberOfCustomers() {
        // 
        EntityManager em = emf.createEntityManager();
        try {
//            Query query = em.createQuery(" SELECT COUNT c FROM Customer c ");
//            return (int) query.getSingleResult();
            long customerCount = (long) em.createQuery("SELECT COUNT(c) FROM Customer c").getSingleResult();
            int count = (int) customerCount;
            return count;
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("Select c from Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

        public Customer addCustomer(String fName, String lName) {
             EntityManager em = emf.createEntityManager();
             try {
            Customer cus = new Customer(fName, lName);
            em.getTransaction().begin();
            em.persist(cus);
            em.getTransaction().commit();
            //Verify that the customer are managed and has been given a database id
            System.out.println(cus.getFirstName() + " " + cus.getLastName());
            return cus;

        } finally {
            em.close();
    }
}
        public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
       // addCustomer 
            System.err.println(">>>>>>>>>>addCustomer:<<<<<<<<<");
        Customer cus1 = facade.addCustomer("Hinata", "Somthing");
        Customer cus2 = facade.addCustomer("Bob", "Somthing");
        //Find customer by ID
            System.err.println(">>>>>>>>>>>>>Find customer by ID<<<<<<<<<");
        System.out.println("Cus1: " + facade.findByID(cus1.getId()).getFirstName());
        System.out.println("Cus2: " + facade.findByID(cus2.getId()).getFirstName());
        //find by LastName
            System.err.println(">>>>>>>Find by last name:<<<<<<<<<");
            System.out.println("Customeres is: " + facade.findByLastName("Somthing"));
        //Find all customers
            System.err.println(">>>>>>>>Find all customers<<<<<<<<");
        System.out.println("customers: " + facade.allCustomers());
        // number of customers
            System.err.println(">>>>>>number of customers:<<<<<<<");
        System.out.println("Number of customers: " + facade.getNumberOfCustomers());
        
        
    }
}