        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import entity.Animal;
/**
 * REST Web Service
 *
 * @author Christian
 */
@Path("animal")
public class AnimalResource {
/*opmærksom på at dependency sat til  
    <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-bundle</artifactId>
            <version>1.19.4</version>
        </dependency>*/
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
   // @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello from my first web service";

    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Excercise 2 + 3 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String Ex2(){
        List<Animal> list = new ArrayList();
        list.add(new Animal("Dog", 2019, "Bark"));
        list.add(new Animal("Cat", 2019, "miav"));
        list.add(new Animal("Bird", 2019, "pip"));
        list.add(new Animal("fish", 2019, "Blob"));
       
        Random rand = new Random();
       return new Gson().toJson(list.get(rand.nextInt(3)));
      
    }
    
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Excercise 4  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // Note til tutor: Fremfor at lave et nyt projekt med customers har jeg valgt at forsætte her med animal. 
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String Ex3(){
        List<Animal> list = new ArrayList();
        list.add(new Animal("Dog", 2019, "Bark"));
        list.add(new Animal("Cat", 2019, "miav"));
        list.add(new Animal("Bird", 2019, "pip"));
        list.add(new Animal("fish", 2019, "Blob"));
       return new Gson().toJson(list);
      
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String Ex4(@PathParam("id") int id){
        List<Animal> list = new ArrayList();
        list.add(new Animal("Dog", 2019, "Bark"));
        list.add(new Animal("Cat", 2019, "miav"));
        list.add(new Animal("Bird", 2019, "pip"));
        list.add(new Animal("fish", 2019, "Blob"));
        return new Gson().toJson(list.get(id));
      
}
    
}
