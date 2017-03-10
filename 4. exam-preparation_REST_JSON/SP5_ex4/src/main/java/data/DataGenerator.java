package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private String[] fnames = {"Homer", "Marge", "Bart", "Lisa", "Maggie"};
    private String[] lnames = {"Simpson", "Burns", "Flanders", "Szyslak"};
    private String[] cities = {"Springfield", "Cypress Creek", "Shelbyville"};
    private String[] streets = {"Evergreen Terrace", "Elm Street", "West Oak Street"};
    
    private Random random = new Random();

    public String getData(int amount, String args) {

        List<String> arguements = Arrays.asList(args.split("\\s*,\\s*")); 
        JsonArray people = new JsonArray();

        for (int i = 0; i < amount; i++) {
            JsonObject obj = new JsonObject();

            if (arguements.contains("fname")) {
                obj.addProperty("fname", fnames[random.nextInt(fnames.length)]);
            }
            if (arguements.contains("lname")) {
                obj.addProperty("lname", lnames[random.nextInt(lnames.length)]);
            }
            if (arguements.contains("city")) {
                obj.addProperty("city", cities[random.nextInt(cities.length)]);
            }
            if (arguements.contains("street")) {
                obj.addProperty("street", streets[random.nextInt(streets.length)]);
            }

            people.add(obj);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(people);

        return jsonStr;

    }

}
