package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("quote")
public class QuoteResource {

    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    public QuoteResource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuoteById(@PathParam("id") int id) {
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(id));
        
        return Response.status(Response.Status.OK).entity(quote.toString()).build();
    }

    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomQuote() {
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(1 + new Random().nextInt(quotes.size())));
        
        return Response.status(Response.Status.OK).entity(quote.toString()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postQuote(String jsonQuote) {
        JsonParser parser = new JsonParser();
        JsonObject quote = parser.parse(jsonQuote).getAsJsonObject();
        String quoteValue = quote.get("quote").getAsString();
        int id = quotes.size() + 1;
        
        quotes.put(id, quoteValue);

        JsonObject newQuote = new JsonObject();
        newQuote.addProperty("id", id);
        newQuote.addProperty("quote", quoteValue);

        return Response.status(Response.Status.OK).entity(newQuote.toString()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putQuote(@PathParam("id") int id, String jsonQuote) {
        JsonParser parser = new JsonParser();
        JsonObject quote = parser.parse(jsonQuote).getAsJsonObject();
        String quoteValue = quote.get("quote").getAsString();

        quotes.replace(id, quoteValue);

        JsonObject newQuote = new JsonObject();
        newQuote.addProperty("id", id);
        newQuote.addProperty("quote", quoteValue);
            
        return Response.status(Response.Status.OK).entity(newQuote.toString()).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteQuote(@PathParam("id") int id) {
        JsonObject quote = new JsonObject();
        quote.addProperty("id", id);
        quote.addProperty("quote", quotes.get(id));
        
        quotes.remove(id);
        
        return Response.status(Response.Status.OK).entity(quote.toString()).build();
    }
}
