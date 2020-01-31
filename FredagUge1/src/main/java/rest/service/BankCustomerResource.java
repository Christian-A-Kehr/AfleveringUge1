package rest.service;

import com.google.gson.Gson;
import entities.BankCustomer;
import facades.BankCustomerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bankcustomer")
public class BankCustomerResource {
    
    //NOTE: Change Persistence unit name according to your setup
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    BankCustomerFacade facade =  BankCustomerFacade.getFacadeExample(emf);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(BankCustomer entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
 
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String BankCustomerById(@PathParam("id") int id){
        return  new Gson().toJson(facade.getCustomerByID(id));
//        return "{\"msg\":\"succes\"}";
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String BankCustomerById(){
        return  new Gson().toJson(facade.getAllBankCustomers());
    }
    
}
