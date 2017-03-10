package rest;

import data.DataGenerator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("data")
public class DataResource {

    @Context
    private UriInfo context;

    DataGenerator dGen = new DataGenerator();
    
    public DataResource() {
    }
    
    @GET
    @Path("/{amount}/{args}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getData(@PathParam("amount") int amount, @PathParam("args") String args) {
        return dGen.getData(amount, args);
    }
    
}
