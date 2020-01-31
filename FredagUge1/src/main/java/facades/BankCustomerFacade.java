package facades;

import DTO.BankCustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Assingments <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public BankCustomerDTO getCustomerByID(int id) {
        EntityManager em = getEntityManager();
        try {
            BankCustomer bc = em.find(BankCustomer.class, id);
            return new BankCustomerDTO(bc);
        } finally {
            em.close();
        }
    }

    public List<BankCustomerDTO> getCustomerByName(String name) {
        EntityManager em = getEntityManager();
        String[] Fullname = name.split(" ");
        String fName = Fullname[0].trim();
        String lName = Fullname[1].trim();
        try {
            TypedQuery<BankCustomer> query = em.createQuery("SELECT c FROM BankCustomer c WHERE c.firstName = :firstName AND c.lastName = :lastName", BankCustomer.class);
            query.setParameter("firstName", fName);
            query.setParameter("lastName", lName);
            List<BankCustomerDTO> ListOfBankCustomers = new ArrayList<>();
            for (BankCustomer bankCustomer : query.getResultList()) {
                ListOfBankCustomers.add(new BankCustomerDTO(bankCustomer));
            }
            return ListOfBankCustomers;
        } finally {
            em.close();
        }
    }
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>bank only <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<BankCustomer> query = em.createQuery("SELECT e From BankCustomer e", BankCustomer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    /////////// Testing ///////////////
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        BankCustomerFacade facade = BankCustomerFacade.getFacadeExample(emf);
        BankCustomer BC1 = new BankCustomer("bob", "boby", "X123", 50, 5, "Here for facade test");
        BankCustomer BC2 = new BankCustomer("Joe", "Lee", "X123", 50, 5, "Here for Beer");
        BankCustomer bankcus = facade.addCustomer(BC1);
        BankCustomer bankcus2 = facade.addCustomer(BC2);
        System.err.println("Test addCustomer and getCustomerByName");
        System.out.println("FinD bob body New Bank customer: " + facade.getCustomerByName(BC1.getFirstName() + " " + BC1.getLastName()));
        System.out.println("FinD Joe lee New Bank customer: " + facade.getCustomerByName(BC2.getFirstName() + " " + BC2.getLastName()));
        System.out.println("Show All bankCustomers: " + facade.getAllBankCustomers());

    }
}
