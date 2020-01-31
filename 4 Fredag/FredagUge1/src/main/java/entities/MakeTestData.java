/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Christian
 */
public class MakeTestData {
    public static void main(String[] args) {
           EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BankCustomer BCUS = new BankCustomer("Bob", "TheTester", "AX123", 500, 1, "Testing Stuff");
        BankCustomer BCUS2 = new BankCustomer("Sue", "TheTesterWife", "AX321", 1000, 2, "Testing Bob");
        try {
            em.getTransaction().begin();
            em.persist(BCUS);
            em.persist(BCUS2);
            em.getTransaction().commit();
            //Verify that BCus are managed and has been given a database id
            System.out.println(" New BankCustomer added : " + BCUS.toString());
            System.out.println(" New BankCustomer added : " + BCUS2.toString());

        } finally {
            em.close();
        }
    }
}
