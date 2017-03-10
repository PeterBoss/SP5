package rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Person;
import facade.PersonFacade;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utility.JSONConverter;

@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    private static PersonFacade pf = new PersonFacade();

    public PersonResource() {
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu"));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int id) {
        Person p = pf.getPerson(id);
//        return JSONConverter.getJSONFromPerson(p);
        return Response.status(Response.Status.OK).entity(JSONConverter.getJSONFromPerson(p)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        return Response.status(Response.Status.OK).entity(JSONConverter.getJSONFromPerson(pf.getPersons())).build();
    }
    
        
    
}
