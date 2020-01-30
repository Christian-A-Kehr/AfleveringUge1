/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Christian
 */
public class CustomerFacadeTest {

    public CustomerFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    Customer cus1 = new Customer("Hinata", "Somthing");
    String lastName = "Somthing";
    int id = 1;

    /**
     * Test of findByID method, of class CustomerFacade.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int id = this.id;
        CustomerFacade instance = new CustomerFacade();
        Customer expResult = cus1;
        Customer result = instance.findByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Failed = Not Hinata.");
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @Test
    public void testFindByLastName() {
        List<Customer> cuslist = new ArrayList<Customer>();
        Customer cus1 = new Customer("Hinata", "Somthing");
        Customer cus2 = new Customer("Bob", "Somthing");
        cuslist.add(cus1);
        cuslist.add(cus2);
        
        System.out.println("findByLastName");
        String name = lastName;
        CustomerFacade instance = new CustomerFacade();
        List<Customer> expResult = cuslist;
        List<Customer> result = instance.findByLastName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        CustomerFacade instance = new CustomerFacade();
        int expResult = 2;
        int result = instance.getNumberOfCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allCustomers method, of class CustomerFacade.
     */
    @Test
    public void testAllCustomers() {
        System.out.println("allCustomers");
        CustomerFacade instance = new CustomerFacade();
        List<Customer> expResult = null;
        List<Customer> result = instance.allCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String fName = "";
        String lName = "";
        CustomerFacade instance = new CustomerFacade();
        Customer expResult = null;
        Customer result = instance.addCustomer(fName, lName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
